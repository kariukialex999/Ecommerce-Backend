package com.kariioke.E_commerce.repository;

import com.kariioke.E_commerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
