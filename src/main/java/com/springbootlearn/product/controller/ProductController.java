package com.springbootlearn.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.springbootlearn.product.dto.ProductDTO;
import com.springbootlearn.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "Product REST APIs CRUD Operations",
		description = "CREATE, READ, UPDATE and DELETE Operations for Product REST APIs"
		)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	
	private ProductService productService;
	
	// create product
	@ApiResponse(
			responseCode = "201",
			description = "CREATED")
	@Operation(
			summary = "Create Products",
			description = "REST APIs for Create Products")
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO createProduct = productService.createProduct(productDTO);
		return new ResponseEntity<ProductDTO>(createProduct, HttpStatus.CREATED);
		//return new ResponseEntity<>(productService.createProduct(productDTO),HttpStatus.CREATED);
	}
	
	
	// get all product
	@Operation(
			summary = "Fetch All Products",
			description = "REST APIs for Fetch All Products")
	@GetMapping
	public List<ProductDTO> getAllProduct(){
		return productService.getAllProduct();
	}
	
	// get product by id
	@Operation(
			summary = "Fetch Products By Product id",
			description = "REST APIs For Fetch Products By Product id")
	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	// update product
	@Operation(
			summary = "Update Products By Product id",
			description = "REST APIs For Update Products By Product id")
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}
	
	// delete product
	@Operation(
			summary = "Delete Products By Product id",
			description = "REST APIs For Delete Products By Product id")
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "Product "+id+" has been deleted! ";
	}
}
