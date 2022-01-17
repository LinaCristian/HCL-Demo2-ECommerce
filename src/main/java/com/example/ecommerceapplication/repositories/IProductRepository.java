package com.example.ecommerceapplication.repositories;

import com.example.ecommerceapplication.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByNameContains(String name);
}
