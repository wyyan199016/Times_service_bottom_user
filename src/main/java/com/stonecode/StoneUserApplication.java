package com.stonecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StoneUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoneUserApplication.class, args);
	}
}
