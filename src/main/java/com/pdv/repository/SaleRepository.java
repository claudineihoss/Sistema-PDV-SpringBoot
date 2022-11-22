package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.entity.Sale;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
