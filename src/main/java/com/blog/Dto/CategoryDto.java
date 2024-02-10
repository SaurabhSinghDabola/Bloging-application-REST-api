package com.blog.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	 private int CategoryId;
	
	@NotEmpty
	 private String CategoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "description must be grater than 10 chars")
	private String CategoryDescription;

}
