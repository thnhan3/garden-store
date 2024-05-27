package com.nhan.demosecurity.domain;

import com.nhan.demosecurity.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer{

    @Id
    @Column(nullable = false, updatable = false)
    private Long customerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts;

    @OneToMany(mappedBy = "customer")
    private Set<Shipment> shipments;

    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

}

