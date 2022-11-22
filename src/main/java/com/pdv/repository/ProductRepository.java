package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
