package com.nhan.demosecurity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}