package com.faculte.simplefaculteproduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimpleFaculteProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFaculteProduitApplication.class, args);
	}

}
