package com.springbootlearn.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearn.product.dto.CategoryDTO;
import com.springbootlearn.product.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	
	private CategoryService categoryService;
	//create categories 
	
	@PostMapping
	public ResponseEntity<CategoryDTO> careteCategory(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<>( categoryService.createCategory(categoryDTO),HttpStatus.CREATED);
	}

}
