package com.springbootlearn.product.mapper;

import com.springbootlearn.product.dto.CategoryDTO;
import com.springbootlearn.product.entity.Category;

public class CategoryMapper {

	// entity to DTO
	public static CategoryDTO toCategoryDTO(Category category) {
		if(category == null) {
			return null;
		}
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
		return categoryDTO;
	}
	
	// DTO to entity
	public static Category toCreateEntity(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		return category;
	}
}
