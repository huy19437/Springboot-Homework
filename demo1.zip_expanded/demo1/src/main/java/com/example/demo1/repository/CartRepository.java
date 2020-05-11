package com.example.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo1.entities.CartEntity;
import com.example.demo1.entities.ProductEntity;
public interface CartRepository extends JpaRepository<CartEntity, Long>{

	
	@Query("FROM ProductEntity P WHERE P.cartEntity.catId=:id ")
	List<ProductEntity> findByCartId(@Param("id") Long catid);


}
