package com.nhan.demosecurity.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    @Column(name ="name")
    private String name;

    @Column
    private String sku;

    @Column
    private String imageUrl;

    @Column(name = "\"description\"")
    private String description;

    @Column
    private Double price;

    @Column
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Cart> carts;

    @Override
    public String toString() {
        return String.format(
                "Product-category: %s", category.getName(  )
        );
    }

}