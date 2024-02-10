package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	

}
