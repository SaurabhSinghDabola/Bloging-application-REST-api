package com.blog.Service;

import java.util.List;

import com.blog.Dto.UserDto;
import com.blog.Model.User;

public interface UserService {
	
    UserDto addUser(UserDto  userDto);
	UserDto getUser(int id);
	List<UserDto> getAllUser();
	UserDto updateUser(UserDto userDto, int id);
	void deleteUser(int id);
	
	
	}


