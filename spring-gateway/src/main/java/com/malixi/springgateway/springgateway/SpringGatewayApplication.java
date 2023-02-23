package com.malixi.springgateway.springgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

	/**
	 * 自定义路由
	 * @param locatorBuilder
	 * @return
	 */
	@Bean
	public RouteLocator routeLocator (RouteLocatorBuilder locatorBuilder) {

		return locatorBuilder.routes()
				.route(p ->
						p.path("/xxoo")
								.filters(f -> f.stripPrefix(1))
								.uri("http://baidu.com")
				)

				.route(p ->
						p.path("/go")
								.filters(f -> f.stripPrefix(1))
								.uri("lb://MDB")
				)

				.build();
	}

}
