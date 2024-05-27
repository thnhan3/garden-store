package com.nhan.demosecurity.repository;

import com.nhan.demosecurity.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String>{
    Optional<Category> findCategoryByCategoryId(String categoryId);
}
