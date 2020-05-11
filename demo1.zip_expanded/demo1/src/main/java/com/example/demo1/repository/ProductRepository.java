package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
