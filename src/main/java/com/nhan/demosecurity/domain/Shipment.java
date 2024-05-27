package com.nhan.demosecurity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shipmentId;

    @Column
    private LocalDate shipmentDate;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String ward;

    @Column
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "shipment")
    private Set<Order> orders;

}