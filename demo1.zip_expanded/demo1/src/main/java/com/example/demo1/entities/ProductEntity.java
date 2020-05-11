package com.example.demo1.entities;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String name;
	
	private Double price;

	
	@ManyToOne()
	@JoinColumn(name = "cart_entity_cat_id", nullable = false, foreignKey = @ForeignKey(name = "fk_productentity_cartentity"))
	private CartEntity cartEntity;
}
