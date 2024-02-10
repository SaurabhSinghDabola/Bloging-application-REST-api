package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Dto.UserDto;
import com.blog.Model.User;
import com.blog.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blog")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<UserDto> addUserHandler(@Valid @RequestBody UserDto userDto){
		UserDto savedUser = userService.addUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		}
//}
	
     @GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserHandler(@Valid @PathVariable int id){
		  UserDto getUserDto = userService.getUser(id);
		  return ResponseEntity.ok(getUserDto);
	}
     
     @GetMapping("/")
     public ResponseEntity<List<UserDto>> getAllUserHandler(){
		  List<UserDto> users = userService.getAllUser();
		  return ResponseEntity.ok(users);
	}
     
     @PutMapping("/{id}")
     public ResponseEntity<UserDto> updateUserHandler(@Valid  @RequestBody UserDto userDto,  @PathVariable int id){
		  UserDto updatedUserDto  = userService.updateUser(userDto, id);
		  return ResponseEntity.ok(updatedUserDto);
	}
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteUserHandler(@PathVariable int id){
		     userService.deleteUser(id);
		  return ResponseEntity.ok("user deleted Sucessfully");
	}
     
     
     
     
}
