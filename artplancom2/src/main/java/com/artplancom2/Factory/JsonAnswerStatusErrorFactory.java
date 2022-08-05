package com.artplancom2.Factory;

import org.springframework.stereotype.Component;

import com.artplancom2.ViewModel.JsonAnswerStatus;

@Component
public class JsonAnswerStatusErrorFactory {

	
	public JsonAnswerStatus noData(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №1: Нет данных" + (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus notFound(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №2: Ошибка поиска" + (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus alreadyExist(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №3: В базе уже имеется запись с такими данными"
		+ (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	/*
	public JsonAnswerStatus loginWrong() {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №4: Неправильно введены логин или пароль");
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus loginWait(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №5: Дождитесь пожалуйста врмея окончания блокировки входа для данного аккаунта"
		+ (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}
	*/

	public JsonAnswerStatus addError(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №6: Не удалось добавить запись в базу данных"
		+ (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus saveError(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №7: Не удалось сохранить запись в базе данных" + (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus deleteError(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №8: Не удалось удалить запись из базы данных" 
		+ (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}

	public JsonAnswerStatus accessDenied(String description) {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("error");
		jsonAnswerStatus.setErrors("Ошибка №9: Ошибка доступа" + (description != null ? " ("+ description + ")" : ""));
		return jsonAnswerStatus;
	}
}
