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

import com.example.demo1.ProductDTO;
import com.example.demo1.ProductMapper;
import com.example.demo1.Productservice;
import com.example.demo1.entities.ProductEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/products")
public class ProductAPI {
	private final Productservice productservice;
	private final ProductMapper productMapper;
	
	@GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
		
        return ResponseEntity.ok(productMapper.toProductDTOs(productservice.listAll()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productservice.save(productMapper.toProduct(productDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<ProductEntity> product = productservice.findByProductId(id);

        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductEntity product = productMapper.toProduct(productDTO);
        product.setProductId(id);

        productservice.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@PathVariable Long id) {
        productservice.delete(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
