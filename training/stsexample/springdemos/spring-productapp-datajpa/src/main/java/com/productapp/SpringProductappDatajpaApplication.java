package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}

	@Autowired
	IProductService productService;

	@Override
	public void run(String... args) throws Exception {
//		Product product=new Product("Cup",100,"milton","dailyUse");
//		productService.addProduct(product);
//		Product nproduct=productService.addProduct(product);
		// productService.getAll().forEach(System.out:: println);
		// System.out.println("added: "+nproduct);
		// productService.updateProduct(product);
//		System.out.println("All Product");
//		productService.getAll().forEach(System.out:: println);

//		Product updateproduct = productService.getById(1);
//		updateproduct.setPrice(100000);
//		productService.updateProduct(updateproduct);
		// productService.getAll().forEach(System.out:: println);
		// productService.getByCategory("Gadgets").forEach(System.out::println);
		//productService.deleteProduct(5);
//		System.out.println("*********Category*******************");
//		productService.getByCategory("dailyUse").forEach(System.out::println);
//		System.out.println("*********Brand*******************");
//		productService.getByBrand("Dell").forEach(System.out::println);
//		System.out.println("***********Less Price*******************");
//		productService.getByLessPrice(10000).forEach(System.out::println);
//		System.out.println("*********Category And Brand*******************");
//		productService.getByCategoryAndBrand("dailyUse","milton").forEach(System.out::println);
//		System.out.println("*********Category Ignore Case*******************");
//		productService.getByCategoryIgnore("gadegts").forEach(System.out::println);
//		System.out.println("*********Category And price Less than*******************");
//		productService.getByCategoryAndPrice("Lenovo", 50001).forEach(System.out::println);
	
	// By custom query
//		System.out.println("*********Category By Custom Query*******************");
//		productService.getByCategory("dailyUse").forEach(System.out::println);
//		System.out.println("*********Category And Brand By Custom Query*******************");
//		productService.getByCategoryAndBrand("dailyUse","milton").forEach(System.out::println);
//		System.out.println("*********Category And Price By Custom Query*******************");
//		productService.getByCategoryAndPrice("dailyUse",50000).forEach(System.out::println);
//		System.out.println("*********Brand Like By Custom Query*******************");
//		productService.getLikeBrand("milton").forEach(System.out::println);
	
		// projection
//		System.out.println("-------By category------");
//		productService.getByDetailsCategory("Gadegts").forEach(System.out::println);
//		
//		System.out.println("------Get brand Product Name-------");
//		System.out.println(productService.getByProductName("Laptop").getBrand());
//		
//		System.out.println("------Get price Product Name-------");
//		System.out.println(productService.getByName("Laptop").getPrice());
//		
//		System.out.println("------Get Product By brand-------");
//		productService.getByBrand("milton").forEach(System.out::println);
//		
//		productService.getByBrand("milton").stream().forEach((value) -> {
//			System.out.println(value.getProductName());
//			System.out.println(value.getCategory());
//			System.out.println(value.getPrice());
//		});
		
	}

}
