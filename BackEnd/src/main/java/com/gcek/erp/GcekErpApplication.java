package com.gcek.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GcekErpApplication {
	public static void main(String[] args) {
		SpringApplication.run(GcekErpApplication.class, args);
		System.out.println("==========================================");
		System.out.println("GCEK ERP System Started Successfully!");
		System.out.println("H2 Console: http://localhost:8080/api/h2-console");
		System.out.println("JDBC URL: jdbc:h2:mem:gcekerp");
		System.out.println("Username: sa | Password: (empty)");
		System.out.println("==========================================");
	}
}