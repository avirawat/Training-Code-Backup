package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.exception.IdNotFoundException;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	IProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Product>productList=productService.getAll();
		model.addAttribute("productList", productList);
		return "home";
	}
	@RequestMapping("home")
	public String homePage(Model model) {
	
		return "redirect:/";
	}
	@RequestMapping("/search")
	public String searchProduct(@RequestParam("choice") String category,Model model) {
		List<Product>productList=productService.getByCategory(category);
		model.addAttribute("productList", productList);
		return "home";
	}
	 @RequestMapping("/addProduct")
	 public String addProduct(Product product,BindingResult result,Model model) {
		 
		 if(result.hasErrors()) {
			 model.addAttribute("message","please enter proper value");
			 return "addform";
		 }
		 //call service layer to add product
		 productService.addProduct(product);
		 model.addAttribute("message","product added successfully");
		 return "admin";
	 }
	 @RequestMapping("/editProduct")
	 public String editProduct(@RequestParam("productId")int productId,Model model) {
		Product product=productService.getById(productId);
		 model.addAttribute("product",product);
		return "updateform";
	 }
	 @RequestMapping("/updateProduct")
	 public String updateProduct(Product product,Model model) {
	int productId=product.getProductId();
	double price=product.getPrice();
	productService.updateProduct(productId, price);
		 model.addAttribute("message","product updated successfully");
		return "admin";
	 }
	 @RequestMapping("/deleteProduct")
	 public String deleteProduct(@RequestParam("productId")int productId,Model model) {
		 productService.deleteProduct(productId);
		 model.addAttribute("message", "deleted succssfully");
		 return "admin";
	 }
	 @ExceptionHandler(ProductNotFoundException.class)
	 public String handleProductNotFound(ProductNotFoundException e,Model model) {
		 model.addAttribute("message",e.getMessage());
		 System.out.println(e.getMessage());
		 return "redirect:/";
	 }
	 @ExceptionHandler(IdNotFoundException.class)
	 public String handleIdNotFound(IdNotFoundException e,Model model) {
		 model.addAttribute("message",e.getMessage());
		 System.out.println(e.getMessage());
		 return "editform";
	 }
	 
}
