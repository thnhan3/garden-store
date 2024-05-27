package com.nhan.demosecurity.repository;

import com.nhan.demosecurity.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE lower(concat('%', :name, '%' ))")
    List<Product> getProductByName(@Param("name") String name);

}
