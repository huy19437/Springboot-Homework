package com.example.demo1.API;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.CategoriesDTO;
import com.example.demo1.CategoriesMapper;
import com.example.demo1.ProductDTO;
import com.example.demo1.ProductMapper;
import com.example.demo1.Productservice;
import com.example.demo1.entities.CartEntity;
import com.example.demo1.entities.ProductEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1")
public class CategoriesAPI {
	private final Productservice categoriesservice;
	private final CategoriesMapper categoriesMapper;
	
	@GetMapping("/categories")
    public ResponseEntity<List<CategoriesDTO>> findAll() {
		
        return ResponseEntity.ok(categoriesMapper.toCategoriesDTOs(categoriesservice.listAll1()));
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoriesDTO> create(@RequestBody CategoriesDTO categoriesDTO) {
    	
        categoriesservice.save1(categoriesMapper.toCategories(categoriesDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriesDTO);
    }

    @GetMapping("/categories{catId}")
    public ResponseEntity<CategoriesDTO> findById(@PathVariable Long id) {
        Optional<CartEntity> category = categoriesservice.findByCatIdOptional(id);

        return ResponseEntity.ok(categoriesMapper.toCategoriesDTO(category.get()));
    }

    @PutMapping("/categories{catId}")
    public ResponseEntity<CategoriesDTO> update(@PathVariable Long id, @RequestBody CategoriesDTO categoriesDTO) {
        CartEntity cartEntity = categoriesMapper.toCategories(categoriesDTO);
        cartEntity.setCatId(id);

        categoriesservice.save1(cartEntity);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriesDTO);
    }

    @DeleteMapping("/categories{catId}")
    public ResponseEntity delete(@PathVariable Long id) {
        categoriesservice.delete1(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
