package com.springbootlearn.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootlearn.product.dto.CategoryDTO;
import com.springbootlearn.product.entity.Category;
import com.springbootlearn.product.mapper.CategoryMapper;
import com.springbootlearn.product.repository.CategoryRepository;
import com.springbootlearn.product.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    private final ProductRepository productRepository;
    
	private CategoryRepository categoryRepository;

 

	// create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toCreateEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
	}

	// get all category
	public List<CategoryDTO> getAllCategories(){
		return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
	}

	// get category by id
	
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Not Found"));
		return CategoryMapper.toCategoryDTO(category);
	}

	// delete category
	
	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Category "+id +" has been deleted! ";
	}
}
