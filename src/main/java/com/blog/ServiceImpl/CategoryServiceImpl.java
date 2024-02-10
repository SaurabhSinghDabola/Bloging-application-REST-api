package com.blog.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.Dto.CategoryDto;
import com.blog.Excepiton.ResourceNotFoundException;
import com.blog.Model.Category;
import com.blog.Repository.CategoryRepo;
import com.blog.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private  CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category  addedCat = modelMapper.map(categoryDto, Category.class);
		Category newaddedCat = categoryRepo.save(addedCat);
		return modelMapper.map(newaddedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int CategoryId) {
		Category cat = categoryRepo.findById(CategoryId)
				       .orElseThrow(()-> new ResourceNotFoundException("Category not exist with id" + CategoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updateCategory = categoryRepo.save(cat);
		return  modelMapper.map(updateCategory, CategoryDto.class);
			
	}

	@Override
	public CategoryDto getCategory(int CategoryId) {
		Category cat = categoryRepo.findById(CategoryId)
				        .orElseThrow(()-> new ResourceNotFoundException("Category not exist with id "+ CategoryId));
		return modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		return categories.stream().map((category)-> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteCategory(int CategoryId) {
		Category cat = categoryRepo.findById(CategoryId)
				       .orElseThrow(()-> new ResourceNotFoundException("Category not exist with id" + CategoryId));
		categoryRepo.delete(cat);
		
		// TODO Auto-generated method stub
		
	}
	
	

}
