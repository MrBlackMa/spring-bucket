package com.malixi.spring.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MyZuulApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(MyZuulApplication2.class, args);
	}

}
