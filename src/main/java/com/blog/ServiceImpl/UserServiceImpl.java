package com.blog.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dto.UserDto;
import com.blog.Excepiton.ResourceNotFoundException;
import com.blog.Model.User;
import com.blog.Repository.UserRepo;
import com.blog.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto  userDto) {
		
	  // convert userdto to user object 
		
	User  user  = this.modelMapper.map(userDto, User.class);
	User savedUser = userRepo.save(user);
	
	   // convert user object to userDto
	
	UserDto savedUserDto  = this.modelMapper.map(savedUser, UserDto.class);
	return savedUserDto;
	
	}

	@Override
	public UserDto getUser(int id) {
		User user = userRepo.findById(id)
				     .orElseThrow(()->  new ResourceNotFoundException("User is not found with id " + id));
	return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepo.findAll();
		return users.stream().map((user)-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto userDto, int id) {
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not exist with id " + id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = userRepo.save(user);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(int id) {
	User user =userRepo.findById(id).orElseThrow(()->new  ResourceNotFoundException("user not exist with id " + id));
		
	    userRepo.deleteById(id);
	}


	

}
