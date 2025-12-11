package com.springbootlearn.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootlearn.product.dto.CategoryDTO;
import com.springbootlearn.product.entity.Category;
import com.springbootlearn.product.mapper.CategoryMapper;
import com.springbootlearn.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toCreateEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
	}

	// get all category

	// get category by id

	// delete category
}
