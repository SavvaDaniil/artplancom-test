package com.artplancom2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artplancom2.Entity.AnimalType;

@Repository
public interface AnimalTypeRepository extends CrudRepository<AnimalType, Long> {
	AnimalType findById(int id);
}
