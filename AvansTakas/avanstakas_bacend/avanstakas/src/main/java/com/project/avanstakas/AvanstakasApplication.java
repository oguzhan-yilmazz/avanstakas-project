package com.project.avanstakas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvanstakasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvanstakasApplication.class, args); 
		
		/* POSTMAN da test etmek için
		 * 
		 *  POST http://localhost:8080/api/avans-takas/listele
		 *  POST http://localhost:8080/api/avans-takas/borc-kapama?takasTarihi=2024-08-09
		 *  POST http://localhost:8080/api/avans-takas/cezali-borc-kapama?takasTarihi=2023-08-9
		 *  POST http://localhost:8080/api/avans-takas/alacak-dagitim?takasTarihi=2023-08-9
		 *  
		 */
		
	}

}
