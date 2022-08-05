package com.artplancom2.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artplancom2.Facade.UserFacade;
import com.artplancom2.DTO.User.UserEditProfileDTO;
import com.artplancom2.DTO.User.UserLoginDTO;
import com.artplancom2.DTO.User.UserRegistrationDTO;
import com.artplancom2.Middleware.UserMiddleware;
import com.artplancom2.ViewModel.JsonAnswerStatus;
import com.artplancom2.ViewModel.User.UserLoginResultViewModel;
import com.artplancom2.ViewModel.User.UserProfileViewModel;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

	@Autowired
	UserFacade userFacade;
	
	@PostMapping("/profile")
	public JsonAnswerStatus profile() {
		UserMiddleware userMiddleware = new UserMiddleware();
		UserProfileViewModel userLoginResultViewModel = userFacade.getProfile(userMiddleware.getCurrentUserId());
		return (userLoginResultViewModel != null
			? new JsonAnswerStatus("success", null, userLoginResultViewModel)
			: new JsonAnswerStatus("error", null)
		);
	}
	
	@PostMapping("/login")
	public UserLoginResultViewModel login(@RequestBody UserLoginDTO userLoginDTO) {
		if(!userLoginDTO.isValid())return new UserLoginResultViewModel("error", "no_data");
		return userFacade.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
	}
	
	@PostMapping("/registration")
	public UserLoginResultViewModel registration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
		if(!userRegistrationDTO.isValid())return new UserLoginResultViewModel("error", "no_data");
		return userFacade.registration(userRegistrationDTO.getUsername(), userRegistrationDTO.getPassword());
	}

	@PostMapping("/update")
	public UserLoginResultViewModel update(@RequestBody UserEditProfileDTO userEditProfileDTO) {
		if(!userEditProfileDTO.isValid())return new UserLoginResultViewModel("error", "no_data");
		UserMiddleware userMiddleware = new UserMiddleware();
		
		return userFacade.update(userMiddleware.getCurrentUserId(), userEditProfileDTO.getUsername(), userEditProfileDTO.getPasswordNew());
	}
	
	@RequestMapping("/secret")
	public JsonAnswerStatus secret() {
		return new JsonAnswerStatus("success");
	}
	
}
