package com.springproject.ClothingEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.ClothingEcommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUnameAndPassword(String un, String psw);
	User findByUname(String un);
}
