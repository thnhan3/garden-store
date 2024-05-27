package com.nhan.demosecurity.controller;

import com.nhan.demosecurity.dto.CategoryDto;
import com.nhan.demosecurity.services.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
   private static final Logger logger = Logger.getLogger(CategoryController.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        logger.info("Creating category");
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable String id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
