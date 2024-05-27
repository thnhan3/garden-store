package com.nhan.demosecurity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nhan.demosecurity.domain.Product}
 */
@Value
public class ProductDto implements Serializable {
    String productId;
    String name;
    String sku;
    String imageUrl;
    String description;

    @NotNull(message = "Price is required")
    @Size(min = 0, message = "Price must be greater than 0")
    Double price;
    Integer stock;
    String category;
}