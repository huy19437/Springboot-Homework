package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo1.entities.CartEntity;
import com.example.demo1.entities.ProductEntity;
import com.example.demo1.repository.CartRepository;
import com.example.demo1.repository.ProductRepository;

@ComponentScan("com.example.demo1.others")
@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		
	}
}
