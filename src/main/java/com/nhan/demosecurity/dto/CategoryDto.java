package com.nhan.demosecurity.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nhan.demosecurity.domain.Category}
 */
@Value
public class CategoryDto implements Serializable {
    String categoryId;
    String name;
}