package com.acheron;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acheron.service.Model;

@SpringBootApplication
public class ComAcheronNpd3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ComAcheronNpd3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Model model=new Model();
		  
	    model.processAllSheets("C:\\Users\\AvinashRavat\\Documents\\Data\\Data.xlsx");
	   // model.processOneSheet("C:\\Users\\AvinashRavat\\Documents\\Data\\Demo.xlsx");
		
	}

}
