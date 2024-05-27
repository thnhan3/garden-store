package com.nhan.demosecurity.repository;

import com.nhan.demosecurity.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByEmail(String email);
}
