package com.artplancom2.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artplancom2.Entity.AnimalType;
import com.artplancom2.Entity.Pet;
import com.artplancom2.Entity.User;
import com.artplancom2.Factory.JsonAnswerStatusErrorFactory;
import com.artplancom2.Service.AnimalTypeService;
import com.artplancom2.Service.PetService;
import com.artplancom2.Service.UserService;
import com.artplancom2.ViewModel.JsonAnswerStatus;
import com.artplancom2.ViewModel.AnimalType.AnimalTypeLiteViewModel;
import com.artplancom2.ViewModel.Pet.PetLiteViewModel;
import com.artplancom2.ViewModel.Pet.PetLitesOfUserViewModel;
import com.artplancom2.ViewModel.User.UserLiteViewModel;

@Component
public class PetFacade {

	@Autowired
	PetService petService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AnimalTypeService animalTypeService;
	
	@Autowired
	JsonAnswerStatusErrorFactory jsonAnswerStatusErrorFactory;

	public JsonAnswerStatus add(int userId, String name, int sex, Date datebirthday, int animalTypeId) {
		User user = userService.findById(userId);
		if(user == null)return jsonAnswerStatusErrorFactory.notFound("not_found_user");
		
		
		Pet petAlreadyExist = petService.findByName(name);
		if(petAlreadyExist != null)
			return jsonAnswerStatusErrorFactory.alreadyExist("кличка уже используется другим пользователем для своего домашнего питомца");
		
		AnimalType animalType = animalTypeService.findById(animalTypeId);
		if(animalType == null)return jsonAnswerStatusErrorFactory.notFound("вид животного не найден");
		
		if(sex != 1 && sex != 2)sex = 0;
		Pet petNew = petService.add(name, sex, datebirthday, animalType, user);
		if(petNew == null)return jsonAnswerStatusErrorFactory.addError("ошибка при попытке добавить запись и питомце в базу данных");
		return new JsonAnswerStatus("success");
	}
	
	public JsonAnswerStatus getLite(int petId) {
		Pet pet = petService.findById(petId);
		if(pet == null)return jsonAnswerStatusErrorFactory.notFound("питомец не найден");
		
		return new JsonAnswerStatus("success", null, toLite(pet));
	}
	
	private PetLiteViewModel toLite(Pet pet) {
		PetLiteViewModel petLiteViewModel = new PetLiteViewModel(pet.getId(), pet.getName(), pet.getDatebirthday());
		if(pet.getUserOwner() != null) {
			UserLiteViewModel userLiteViewModel = new UserLiteViewModel(pet.getUserOwner().getId(), pet.getUserOwner().getUsername());
			petLiteViewModel.setUserLiteViewModel(userLiteViewModel);
		}
		
		if(pet.getAnimalType() != null) {
			AnimalTypeLiteViewModel animalTypeLiteViewModel = new AnimalTypeLiteViewModel(pet.getAnimalType().getId(), pet.getAnimalType().getTitle());
			petLiteViewModel.setAnimalTypeLiteViewModel(animalTypeLiteViewModel);
		}
		
		return petLiteViewModel;
	}
	
	
	public JsonAnswerStatus update(int userId, int petId, String name, int sex, Date datebirthday, int animalTypeId) {
		Pet pet = petService.findById(petId);
		if(pet == null)return jsonAnswerStatusErrorFactory.notFound("питомец не найден");
		if(pet.getUserOwner() == null)return jsonAnswerStatusErrorFactory.notFound("у питомца не обнаружен хозяин");
		if(pet.getUserOwner().getId() != userId)return jsonAnswerStatusErrorFactory.accessDenied("только хозяин питомца может менять данные последнего");
		
		pet.setName(name);
		pet.setDatebirthday(new java.sql.Date(datebirthday.getTime()));
		if(sex == 1 || sex == 2) {
			pet.setSex(sex);
		} else {
			pet.setSex(0);
		}
		
		boolean isNeedChangeAnimalType = false;
		if(pet.getAnimalType() != null) {
			if(pet.getAnimalType().getId() != animalTypeId) {
				isNeedChangeAnimalType = true;
			}
		} else {
			isNeedChangeAnimalType = true;
		}
		
		if(isNeedChangeAnimalType) {
			AnimalType animalType = animalTypeService.findById(animalTypeId);
			if(animalType == null)return jsonAnswerStatusErrorFactory.notFound("выбранный вид животного не найден в базе");
			pet.setAnimalType(animalType);
		}
		
		if(!petService.update(pet))return jsonAnswerStatusErrorFactory.saveError("try_update");

		return new JsonAnswerStatus("success");
	}
	
	
	public JsonAnswerStatus listAllOfUser(int userId) {
		User user = userService.findById(userId);
		if(user == null)return jsonAnswerStatusErrorFactory.notFound("пользователь не найден");
		
		List<Pet> pets = petService.listAllByUserId(userId);
		ArrayList<PetLiteViewModel> petLiteViewModels = new ArrayList<PetLiteViewModel>();
		if(pets != null) {
			pets.stream().forEach(pet -> petLiteViewModels.add(toLite(pet)));
		}
		return new JsonAnswerStatus("success", null, new PetLitesOfUserViewModel(petLiteViewModels));
	}
	
	public JsonAnswerStatus delete(int petId) {
		return petService.delete(petId)
				? new JsonAnswerStatus("success")
						: jsonAnswerStatusErrorFactory.deleteError(null);
	}
	
	
	
}
