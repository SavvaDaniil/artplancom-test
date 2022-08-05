package com.artplancom2.Factory;

import org.springframework.stereotype.Component;

import com.artplancom2.ViewModel.User.UserLoginResultViewModel;

@Component
public class UserLoginResultErrorViewModelFactory {

	public UserLoginResultViewModel noData(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №1: Нет данных" + (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}

	public UserLoginResultViewModel notFound(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №2: Ошибка поиска" + (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}

	public UserLoginResultViewModel alreadyExist(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №3: Нет данных" + (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}

	public UserLoginResultViewModel loginWrong() {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №4: Неправильно введены логин или пароль");
		return userLoginResultViewModel;
	}

	public UserLoginResultViewModel loginWait(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №5: Дождитесь пожалуйста врмея окончания блокировки входа для данного аккаунта"
		+ (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}
	
	public UserLoginResultViewModel addError(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №6: Не удалось добавить запись в базу данных"
		+ (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}

	public UserLoginResultViewModel saveError(String description) {
		UserLoginResultViewModel userLoginResultViewModel = new UserLoginResultViewModel("error");
		userLoginResultViewModel.setErrors("Ошибка №7: Не удалось сохранить запись в базе данных" + (description != null ? " ("+ description + ")" : ""));
		return userLoginResultViewModel;
	}
	
	
}
