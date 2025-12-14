package com.springbootlearn.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootlearn.product.dto.ProductDTO;
import com.springbootlearn.product.entity.Category;
import com.springbootlearn.product.entity.Product;
import com.springbootlearn.product.mapper.ProductMapper;
import com.springbootlearn.product.repository.CategoryRepository;
import com.springbootlearn.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	
	//Create product
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(()-> new RuntimeException("Category Not Found"));
		
		// DTO to Entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);
		
		// Entity to DTO
		return ProductMapper.toProductDTO(product);
		
		}
	
	// get all product
	public List<ProductDTO> getAllProduct(){
		return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
	}
	
	
	// get product by id
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
		return ProductMapper.toProductDTO(product);
	}
	
	
	//update product 
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		Product product = productRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Product Not Found"));
		
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(()-> new RuntimeException("Category Not Found"));
		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(category);
		productRepository.save(product);
		
		return ProductMapper.toProductDTO(product);
		
	}
	
	// delete product BY id
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product "+id+" has been deleted! ";
	}
}
