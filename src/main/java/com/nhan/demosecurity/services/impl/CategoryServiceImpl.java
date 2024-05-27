package com.nhan.demosecurity.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhan.demosecurity.config.MyMapperBean;
import com.nhan.demosecurity.domain.Category;
import com.nhan.demosecurity.dto.CategoryDto;
import com.nhan.demosecurity.repository.CategoryRepository;
import com.nhan.demosecurity.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MyMapperBean myMapperBean;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
       Category category =  myMapperBean.convertToEntity(categoryDto, Category.class);
       category.setCategoryId(UUID.randomUUID().toString());
        categoryRepository.save(category);
        return myMapperBean.convertToDto(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> myMapperBean.convertToDto(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return category != null ? myMapperBean.convertToDto(category, CategoryDto.class) : null;
    }

    @Override
    public CategoryDto updateCategory(String id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return myMapperBean.convertToDto(category, CategoryDto.class);
        }
        return null;
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
