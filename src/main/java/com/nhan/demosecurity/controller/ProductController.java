package com.nhan.demosecurity.controller;

import com.nhan.demosecurity.domain.Product;
import com.nhan.demosecurity.dto.ProductDto;
import com.nhan.demosecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(productService.createProduct(productDto));
    }

//        @GetMapping("/{productId}")
//        public ResponseEntity<ProductDto> getProduct(@PathVariable String productId) {
//            Product product = productService.getProductById(productId);
//            return ResponseEntity.ok(.(product));
//        }

//        @PutMapping("/{productId}")
//        public ResponseEntity<ProductDto> updateProduct(@PathVariable String productId, @RequestBody ProductDto productDto) {
//            Product product = productService.updateProduct(productId, productDto);
//            return ResponseEntity.ok(productService.convertProductToDto(product));
//        }
//
//        @DeleteMapping("/{productId}")
//        public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
//            productService.deleteProduct(productId);
//            return ResponseEntity.noContent().build();
//        }
//
//        @GetMapping
//        public List<ProductDto> getProducts() {
//            return productService.getAllProducts();
//        }
//
//        @GetMapping("/byName/{name}")
//        public List<ProductDto> getProductsByName(@PathVariable String name) {
//            return productService.getProductByName(name);
//        }
}
