package com.example.demo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entities.CartEntity;
import com.example.demo1.entities.ProductEntity;
import com.example.demo1.repository.CartRepository;
import com.example.demo1.repository.ProductRepository;

import com.example.demo1.entities.*;

@Service
public class Productservice {

	@Autowired
	private ProductRepository repo;
	@Autowired
	private CartRepository repo1;
	
	public List<ProductEntity> listAll(){
		return repo.findAll();
	}
	
	public List<CartEntity> listAll1(){
		return repo1.findAll();
	}
	
	public void save(ProductEntity product) {
		repo.save(product);
	}
	
	public void save1(CartEntity cartEntity) {
		repo1.save(cartEntity);
	}
	
	public ProductEntity get(Long id) {
		return repo.findById(id).get();
	}
	
	public CartEntity get1(Long id) {
		return repo1.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void delete1(Long id) {
		repo1.deleteById(id);
	}
	public Optional<ProductEntity> findByProductId(Long id) {
        return repo.findById(id);
    }

	public List<ProductEntity> findbyCatId(Integer catid) {
		// TODO Auto-generated method stub
		return repo1.findByCartId((long)catid);
	}

	public Optional<CartEntity> findByCatIdOptional(Long id) {
		// TODO Auto-generated method stub
		return repo1.findById(id);

	}
}
