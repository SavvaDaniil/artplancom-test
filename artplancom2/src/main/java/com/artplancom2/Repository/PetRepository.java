package com.artplancom2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artplancom2.Entity.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	Pet findById(int id);
}
