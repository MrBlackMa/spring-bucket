package com.malixi.spring.shardingjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;



@SpringBootApplication
public class SpringShardingjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShardingjdbcApplication.class, args);
	}

}
