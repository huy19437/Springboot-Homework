package com.example.demo1;

import java.util.List;

import com.example.demo1.entities.CartEntity;
import com.example.demo1.entities.ProductEntity;

public interface CategoriesMapper {
	 CategoriesDTO toCategoriesDTO(CartEntity cartEntity);

	    List<CategoriesDTO> toCategoriesDTOs(List<CartEntity> cartEntities);

	    CartEntity toCategories(CategoriesDTO categoriesDTO);
}
