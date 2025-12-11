package com.springbootlearn.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootlearn.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
