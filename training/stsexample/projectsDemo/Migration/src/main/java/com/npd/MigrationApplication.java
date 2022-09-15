package com.npd;

import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.npd.service.MigrationService;

@SpringBootApplication
public class MigrationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MigrationApplication.class, args);
	}
	
	@Autowired
	MigrationService migrationService;

	@Override
	public void run(String... args) throws Exception {
		
		
	
		 final String filePath = "C:\\Users\\AvinashRavat\\Documents\\Data\\Demo.xlsx";
		 FileInputStream fileInputStream = new FileInputStream(filePath);
		 migrationService.getAllDetails(fileInputStream);
		 
	}

}
