package com.malixi.springboot.malixispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MalixiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalixiSpringbootApplication.class, args);
	}

}
