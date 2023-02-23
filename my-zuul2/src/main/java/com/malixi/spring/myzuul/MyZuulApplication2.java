package com.malixi.spring.myzuul;

import com.malixi.spring.myzuul.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableZuulProxy
public class MyZuulApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(MyZuulApplication2.class, args);
	}


}
