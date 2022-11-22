package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.entity.ItemSale;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleRepository extends JpaRepository<ItemSale,Long> {
	

}
