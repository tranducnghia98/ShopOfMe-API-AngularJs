package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;


public interface ProductDAO extends JpaRepository<Product, Integer>{


@Query("SELECT e FROM Product e WHERE e.category.id = ?1")
	List<Product> findByCategoryId(String cid);
}
