package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.entities.ProductEntity;
import com.example.demo1.repository.CartRepository;
import com.example.demo1.entities.*;

@Controller
public class ControllerClass {
	
	@Autowired
	private Productservice service;
	@Autowired
	private CartRepository cartRepository;

	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<CartEntity> listProducts2 = service.listAll1();
		model.addAttribute("listProducts2", listProducts2);
		
		return "index2";
	}
	
	
	@RequestMapping("/newpro")
	public String showNewProductForm(Model model) {
		ProductEntity product = new ProductEntity();
		model.addAttribute("product", product);
		model.addAttribute("listCat", cartRepository.findAll());
		return "new_product";
	}
	
	@RequestMapping("/newcat")
	public String showNewCategoryForm(Model model) {
		CartEntity cartEntity = new CartEntity();
		model.addAttribute("cartEntity", cartEntity);
		return "new_cartEntity";
	}
	
	@RequestMapping(value = "/savepro" , method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") ProductEntity product) {
		service.save(product);
		 
		return "redirect:/showlistpro";
	}
	
	@RequestMapping(value = "/savecat" , method = RequestMethod.POST)
	public String saveCartEntity(@ModelAttribute("cartEntity") CartEntity cartEntity) {
		service.save1(cartEntity);
		 
		return "redirect:/";
	}
	
	@RequestMapping("/editpro/{productId}")
	public ModelAndView showEditProductForm(@PathVariable(name = "productId")Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		ProductEntity product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping("/editcat/{catId}")
	public ModelAndView showEditCartEntityForm(@PathVariable(name = "catId")Long catId) {
		ModelAndView mav = new ModelAndView("edit_carEntity");
		CartEntity cartEntity = service.get1(catId);
		mav.addObject("cartEntity", cartEntity);
		return mav;
	}
	
	@RequestMapping("/deletepro/{productId}")
	public String deleteProduct(@PathVariable(name = "productId")Long id){
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/deletecat/{catId}")
	public String deleteCategory(@PathVariable(name = "catId")Long catId){
		
		service.delete1(catId);
		return "redirect:/";
	}
	
	@RequestMapping("/showlistpro")
	public String showListPro(Model model,
			@RequestParam(name = "catid", required = false, defaultValue = "-1")
			Integer catid){
		System.out.println(catid);
		
		List<ProductEntity> listProducts1;
		if(catid==-1) {
			listProducts1= service.listAll();
		} else {
			listProducts1 = service.findbyCatId(catid);
		}
		model.addAttribute("listProducts1", listProducts1);
		
		return "index1";
	}

}
