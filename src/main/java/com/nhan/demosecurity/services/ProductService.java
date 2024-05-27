package com.nhan.demosecurity.services;

import com.nhan.demosecurity.domain.Product;
import com.nhan.demosecurity.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(String productId);
    ProductDto updateProduct(String productId, ProductDto productDto);
    ProductDto getProductById(String productId);
    List<ProductDto> getProductByName(String name);
    Iterable<ProductDto> getAllProducts();

}
