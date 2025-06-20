package com.kariioke.E_commerce.repository;

import com.kariioke.E_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByNameContainingOrByDescriptionContaining(String name, String description);
}
