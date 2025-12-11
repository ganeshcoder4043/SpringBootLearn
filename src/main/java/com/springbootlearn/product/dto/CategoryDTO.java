package com.springbootlearn.product.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // in this avaiable getter setter toString etc.......
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Long id;
	private String name;
	private List<ProductDTO> products;
}
