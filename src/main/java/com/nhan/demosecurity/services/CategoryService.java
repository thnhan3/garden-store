package com.nhan.demosecurity.services;

import com.nhan.demosecurity.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(String id);

    CategoryDto updateCategory(String id, CategoryDto categoryDto);

    void deleteCategory(String id);
}