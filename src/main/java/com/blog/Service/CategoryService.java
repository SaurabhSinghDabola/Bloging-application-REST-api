package com.blog.Service;

import java.util.List;

import com.blog.Dto.CategoryDto;

public interface CategoryService {
	
	   // create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	   // update
	CategoryDto updateCategory(CategoryDto categoryDto, int CategoryId);
	
	  // Get
	CategoryDto getCategory(int CategoryId);
	
	 // GetAll 
	
	List<CategoryDto> getAllCategory();
	
	 // delete
	void deleteCategory(int  CategoryId);
	
	

}
