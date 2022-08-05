package com.artplancom2.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artplancom2.DTO.Pet.PetEditDTO;
import com.artplancom2.DTO.Pet.PetIdDTO;
import com.artplancom2.DTO.Pet.PetNewDTO;
import com.artplancom2.Facade.PetFacade;
import com.artplancom2.Middleware.UserMiddleware;
import com.artplancom2.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("api/pet")
public class ApiPetController {

	@Autowired
	PetFacade petFacade;
	

	@PostMapping("/add")
	public JsonAnswerStatus add(@RequestBody PetNewDTO petNewDTO) {
		if(!petNewDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		UserMiddleware userMiddleware = new UserMiddleware();
		return petFacade.add(
			userMiddleware.getCurrentUserId(),
			petNewDTO.getName(),
			petNewDTO.getSex(),
			petNewDTO.getDatebirthday(),
			petNewDTO.getAnimalTypeId()
		);
	}

	@PostMapping("/delete")
	public JsonAnswerStatus delete(@RequestBody PetIdDTO petIdDTO) {
		if(!petIdDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		return petFacade.delete(petIdDTO.getPetId());
	}

	@PostMapping("/update")
	public JsonAnswerStatus update(@RequestBody PetEditDTO petEditDTO) {
		if(!petEditDTO.isValid())return new JsonAnswerStatus("error", "no_data");
		UserMiddleware userMiddleware = new UserMiddleware();
		return petFacade.update(
				userMiddleware.getCurrentUserId(), 
				petEditDTO.getPetId(), 
				petEditDTO.getName(), 
				petEditDTO.getSex(),
				petEditDTO.getDatebirthday(), 
				petEditDTO.getAnimalTypeId()
			);
	}
	
	@PostMapping("/get")
	public JsonAnswerStatus get(@RequestBody PetIdDTO petIdDTO) {
		return petFacade.getLite(petIdDTO.getPetId());
	}
	
	
	@PostMapping("/my_list")
	public JsonAnswerStatus listAllOwnedByUser() {
		UserMiddleware userMiddleware = new UserMiddleware();
		return petFacade.listAllOfUser(userMiddleware.getCurrentUserId());
	}
}
