package com.example.demo1;

import java.util.List;

import com.example.demo1.entities.ProductEntity;

public interface ProductMapper {
	 ProductDTO toProductDTO(ProductEntity productEntity);

	    List<ProductDTO> toProductDTOs(List<ProductEntity> products);

	    ProductEntity toProduct(ProductDTO productDTO);
}
