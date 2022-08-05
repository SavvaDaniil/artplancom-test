package com.artplancom2.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artplancom2.Entity.AnimalType;
import com.artplancom2.Factory.JsonAnswerStatusErrorFactory;
import com.artplancom2.Service.AnimalTypeService;
import com.artplancom2.ViewModel.JsonAnswerStatus;
import com.artplancom2.ViewModel.AnimalType.AnimalTypeLiteViewModel;
import com.artplancom2.ViewModel.AnimalType.AnimalTypeLitesViewModel;

@Component
public class AnimalTypeFacade {


	@Autowired
	AnimalTypeService animalTypeService;
	
	@Autowired
	JsonAnswerStatusErrorFactory jsonAnswerStatusErrorFactory;
	
	
	public JsonAnswerStatus add(String name) {
		AnimalType animalTypeAlreadyExist = animalTypeService.findByName(name);
		if(animalTypeAlreadyExist != null)return jsonAnswerStatusErrorFactory.alreadyExist("name_already_exist");
		
		AnimalType animalType = animalTypeService.add(name);
		if(animalType == null)return jsonAnswerStatusErrorFactory.addError("try add");
		return new JsonAnswerStatus("success");
	}
	
	public JsonAnswerStatus getLite(int animalTypeId) {
		AnimalType animalType = animalTypeService.findById(animalTypeId);
		if(animalType == null)return jsonAnswerStatusErrorFactory.notFound("вид животного не найден");
		
		return new JsonAnswerStatus("success", null, new AnimalTypeLiteViewModel(animalType.getId(), animalType.getTitle()));
	}
	
	public JsonAnswerStatus listAllLite() {
		List<AnimalType> animalTypes = animalTypeService.listAll();
		ArrayList<AnimalTypeLiteViewModel> animalTypeViewModels = new ArrayList<AnimalTypeLiteViewModel>();
		
		if(animalTypes != null) {
			animalTypes.stream().forEach(animalType -> animalTypeViewModels.add(new AnimalTypeLiteViewModel(animalType.getId(), animalType.getTitle())));
		}
		
		return new JsonAnswerStatus("success", null, new AnimalTypeLitesViewModel(animalTypeViewModels));
	}
	
	public JsonAnswerStatus update(int animalTypeId, String name) {
		AnimalType animalType = animalTypeService.findById(animalTypeId);
		if(animalType == null)return jsonAnswerStatusErrorFactory.notFound("вид животного не найден");

		AnimalType animalTypeAlreadyExistByName = animalTypeService.findByNameExceptId(animalTypeId, name);
		if(animalTypeAlreadyExistByName != null)return jsonAnswerStatusErrorFactory.alreadyExist("наименование вида уже используется");
		
		animalType.setTitle(name);
		if(!animalTypeService.update(animalType))return jsonAnswerStatusErrorFactory.saveError("try_update");

		return new JsonAnswerStatus("success");
	}
	
	public JsonAnswerStatus delete(int animalTypeId) {
		AnimalType animalType = animalTypeService.findById(animalTypeId);
		if(animalType == null)return jsonAnswerStatusErrorFactory.notFound("вид животного не найден");
		
		return animalTypeService.delete(animalType)
			? new JsonAnswerStatus("success")
					: jsonAnswerStatusErrorFactory.deleteError(null);
	}
	
	
	
}
