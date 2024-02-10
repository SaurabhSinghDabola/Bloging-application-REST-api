package com.blog.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private int Id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email( message = "email address is not valid..")
	private String email;
	
    
	@NotEmpty
	@Size(min = 5 , max = 10, message = "Password must be minimum 5 chars to 10 chars")
	private String password;
	

}
