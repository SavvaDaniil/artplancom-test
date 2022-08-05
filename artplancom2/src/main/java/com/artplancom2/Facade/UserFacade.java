package com.artplancom2.Facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.artplancom2.Component.JwtUtil;
import com.artplancom2.Entity.User;
import com.artplancom2.Factory.UserLoginResultErrorViewModelFactory;
import com.artplancom2.Service.UserService;
import com.artplancom2.ViewModel.User.UserLoginResultViewModel;
import com.artplancom2.ViewModel.User.UserProfileViewModel;

@Component
public class UserFacade {

	@Autowired
	UserService userService;
	
	@Autowired
	UserLoginResultErrorViewModelFactory userLoginResultErrorViewModelFactory;
	
	public UserProfileViewModel getProfile(int userId) {
		User user = userService.findById(userId);
		if(user == null)return null;
		
		return new UserProfileViewModel(
			user.getId(),
			user.getUsername()
		);
	}
	
	public UserLoginResultViewModel login(String username, String password) {

		try {
			//UserDetails userDetails = userService.loadUserByUsername(username);
			User user = userService.findByUsername(username);
			if(user == null)return userLoginResultErrorViewModelFactory.loginWrong();
			

		    Calendar calendarLastLoginTry = Calendar.getInstance();
		    calendarLastLoginTry.setTime(new Date());
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			//System.out.println("Дата попытки входа: " + dateFormat.format(calendarLastLoginTry.getTime()));

			if(user.getDateLoginLastTry() == null) {
				user.setDateLoginLastTry(calendarLastLoginTry.getTime());
				userService.update(user);
			}
			
		    Calendar calendarDateAvailableToLogin = Calendar.getInstance();
		    calendarDateAvailableToLogin.setTime(user.getDateLoginLastTry());
		    calendarDateAvailableToLogin.add(Calendar.HOUR_OF_DAY, 1);
			
			if(user.getLoginTryCount() >= 9 && calendarLastLoginTry.getTime().before(calendarDateAvailableToLogin.getTime())) {
				return userLoginResultErrorViewModelFactory.loginWait("wait to " + dateFormat.format(calendarDateAvailableToLogin.getTime()));
				//return new UserLoginResultViewModel("error", "wrong, wait to " + dateFormat.format(calendarDateAvailableToLogin.getTime()));
			}
			
			BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
			if(!passwordEcorder.matches(password, user.getPassword())) {
				
				if(user.getLoginTryCount() >= 9 && calendarLastLoginTry.getTime().after(calendarDateAvailableToLogin.getTime())) {
					user.setLoginTryCount(1);
				} else {
					user.setLoginTryCount(user.getLoginTryCount() + 1);
				}
				user.setDateLoginLastTry(calendarLastLoginTry.getTime());
				userService.update(user);
				
				return userLoginResultErrorViewModelFactory.loginWrong();
			}
			
			user.setLoginTryCount(0);
			user.setDateLoginLastTry(calendarLastLoginTry.getTime());
			userService.update(user);
			
			JwtUtil jwtUtil = new JwtUtil();
			String accessToken = jwtUtil.generateToken(userService.toUserDetails(user));
			return new UserLoginResultViewModel("success", null, accessToken);
		
		} catch(UsernameNotFoundException exception) {
			return userLoginResultErrorViewModelFactory.loginWrong();
		}
	}
	
	public UserLoginResultViewModel registration(String username, String password) {
		User user = userService.findByUsername(username);
		if(user != null)return userLoginResultErrorViewModelFactory.alreadyExist("username_already_exist");

		BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
		String passwordHash = passwordEcorder.encode(password);
		
		user = userService.add(username, passwordHash);
		if(user == null)return userLoginResultErrorViewModelFactory.addError("try_add_user");
		
		return login(username, password);
	}
	
	public UserLoginResultViewModel update(int userId, String username, String passwordNew) {
		User user = userService.findById(userId);
		if(user == null)return userLoginResultErrorViewModelFactory.notFound("user not found");
		User userAlreadyExist = userService.findByUsernameExceptId(userId, username);
		if(userAlreadyExist != null)return userLoginResultErrorViewModelFactory.alreadyExist("username_already_exist");
		
		user.setUsername(username);
		if(passwordNew != null) {
			BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
			String passwordHash = passwordEcorder.encode(passwordNew);
			user.setPassword(passwordHash);
		}
		if(!userService.update(user))return userLoginResultErrorViewModelFactory.saveError("try_save_user");
		
		if(passwordNew != null) {
			return login(username, passwordNew);
		}
		
		return new UserLoginResultViewModel("success");
	}
	
	
	
	
}
