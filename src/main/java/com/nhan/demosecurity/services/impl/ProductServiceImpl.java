package com.nhan.demosecurity.services.impl;

import com.nhan.demosecurity.config.MyMapperBean;
import com.nhan.demosecurity.domain.Category;
import com.nhan.demosecurity.domain.Product;
import com.nhan.demosecurity.dto.ProductDto;
import com.nhan.demosecurity.repository.CategoryRepository;
import com.nhan.demosecurity.repository.ProductRepository;
import com.nhan.demosecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MyMapperBean myMapperBean;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        System.out.println(categoryRepository.findCategoryByCategoryId(productDto.getCategory()));
        if (categoryRepository.findCategoryByCategoryId(productDto.getCategory()).isPresent()) {
            Category category = categoryRepository.findCategoryByCategoryId(productDto.getCategory()).get();
            product.setCategory(category);
            System.out.println(productDto.getCategory());
        } else {
            product.setCategory(null);
        }
        Product savedProduct = productRepository.save(product);
//        System.out.println(product);
//        System.out.println(savedProduct);
        return myMapperBean.convertToDto(savedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto getProductById(String productId) {
        return null;
    }

    @Override
    public List<ProductDto> getProductByName(String name) {
        return List.of();
    }

    @Override
    public Iterable<ProductDto> getAllProducts() {
        return null;
    }
}
