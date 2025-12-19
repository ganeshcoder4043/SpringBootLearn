package com.springbootlearn.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearn.product.dto.CategoryDTO;
import com.springbootlearn.product.exception.CategoryAlreadyExistsException;
import com.springbootlearn.product.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@Tag(
		name = "Category REST APIs CRUD Operations",
		description = "CREATE, READ, UPDATE and DELETE Operations for Category REST APIs"
		)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	
	private CategoryService categoryService;
	
//	//create categories 
//	@PostMapping
//	public ResponseEntity<CategoryDTO> careteCategory(@RequestBody CategoryDTO categoryDTO) {
//		return new ResponseEntity<>( categoryService.createCategory(categoryDTO),HttpStatus.CREATED);
//	}
	
//	//create categories 
//		@PostMapping
//		public ResponseEntity<?> careteCategory(@RequestBody CategoryDTO categoryDTO) {
//			try {
//				CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
//				return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//			} catch (CategoryAlreadyExistsException ex) {
//				return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//			}
//		}
	
	//create categories 
	@ApiResponse(
			responseCode = "201",
			description = "CREATED")
	@Operation(
			summary = "Create Category",
			description = "REST APIs For Create Category")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<?> careteCategory(@RequestBody CategoryDTO categoryDTO) {

		CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

	}
		
	
	// get all categories
	@Operation(
			summary = "Fetch All Category",
			description = "REST APIs For Fetch All Category")
	@GetMapping
	public List<CategoryDTO> getAllCategories(){
		return categoryService.getAllCategories();
	}

	// get category by id
	@Operation(
			summary = "Fetch Category By Category id",
			description = "REST APIs For Fetch Category By Category id")
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	// delete category by id
	@Operation(
			summary = "Delete Category By Category id",
			description = "REST APIs For Delete Category By Category id")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);
	}
}
