package com.artplancom2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artplancom2.Entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findById(int id);
	User findByUsername(String username);
}
