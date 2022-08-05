package com.artplancom2.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artplancom2.DTO.AnimalType.AnimalTypeEditDTO;
import com.artplancom2.DTO.AnimalType.AnimalTypeIdDTO;
import com.artplancom2.DTO.AnimalType.AnimalTypeNewDTO;
import com.artplancom2.Facade.AnimalTypeFacade;
import com.artplancom2.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("api/animal_type")
public class ApiAnimalTypeController {

	@Autowired
	AnimalTypeFacade animalTypeFacade;
	
	@PostMapping("/add")
	public JsonAnswerStatus add(@RequestBody AnimalTypeNewDTO animalTypeNewDTO) {
		if(!animalTypeNewDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		return animalTypeFacade.add(animalTypeNewDTO.getName());
	}


	@PostMapping("/delete")
	public JsonAnswerStatus delete(@RequestBody AnimalTypeIdDTO animalTypeIdDTO) {
		if(!animalTypeIdDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		return animalTypeFacade.delete(animalTypeIdDTO.getAnimalTypeId());
	}

	@PostMapping("/update")
	public JsonAnswerStatus update(@RequestBody AnimalTypeEditDTO animalTypeEditDTO) {
		if(!animalTypeEditDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		return animalTypeFacade.update(animalTypeEditDTO.getAnimalTypeId(), animalTypeEditDTO.getName());
	}
	
	@PostMapping("/get")
	public JsonAnswerStatus get(@RequestBody AnimalTypeIdDTO animalTypeIdDTO) {
		return animalTypeFacade.getLite(animalTypeIdDTO.getAnimalTypeId());
	}
	
	@PostMapping("/list_all")
	public JsonAnswerStatus listAll() {
		return animalTypeFacade.listAllLite();
	}
	
}
