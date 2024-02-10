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

import com.blog.Dto.CategoryDto;
import com.blog.Service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cat")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Operation(summary = "add new Category api")
	@PostMapping("/add")
	public ResponseEntity<CategoryDto> addCategoryHandler(@Valid @RequestBody CategoryDto categoryDto){
		 CategoryDto createdCat = categoryService.createCategory(categoryDto);
		 return new ResponseEntity<>(createdCat, HttpStatus.CREATED);
		}
	
	@Operation(summary = "update category by CategoryId")
	@PutMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> updateCategoryHandler(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int CategoryId){
		 CategoryDto updatedCat = categoryService.updateCategory(categoryDto, CategoryId);		 
				 
		 return ResponseEntity.ok(updatedCat);
		 }
	@Operation(summary = "get Category by id")
	@GetMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> getCategoryHandler(@PathVariable int CategoryId){
		 CategoryDto  categoryDto  = categoryService.getCategory(CategoryId);
		 return ResponseEntity.ok(categoryDto);
		 
		}
	
	@Operation(summary = "get all categories")
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> ListCategoryHandler(){
		  List<CategoryDto> categories   = categoryService.getAllCategory();
		 return ResponseEntity.ok(categories);
	}
	
	@Operation(summary = "Delete Category by Id")
	@DeleteMapping("/{CategoryId}")
	public ResponseEntity<String> deleteCategoryHandler(@PathVariable int CategoryId){
		 categoryService.deleteCategory(CategoryId);
		 return ResponseEntity.ok("Category deleted sucessfulyy..");
		 
}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
