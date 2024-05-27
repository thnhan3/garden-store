package com.nhan.demosecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyMapperBean {
    @Autowired
    private ObjectMapper objectMapper;

    public <T, U> U convertToEntity(T dto, Class<U> entityClass) {
        return objectMapper.convertValue(dto, entityClass);
    }

    public <T, U> T convertToDto(U entity, Class<T> dtoClass) {
        return objectMapper.convertValue(entity, dtoClass);
    }
}
