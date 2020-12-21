package com.malixi.spring.dispatcher_two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients    //开启feign接口的自动注入
@EnableCircuitBreaker  //restTemplate 的hystrix feign自带的
@EnableHystrixDashboard// 开启hystrix的健康上报
public class DispatcherTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatcherTwoApplication.class, args);
	}

	/**
	 * rest协议的请求方式 交给spring
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		// 增加拦截器注入到spring 只能拦截controller 不能拦截服务之间的调用
		//	restTemplate.getInterceptors().add(new LoggingClientHttpRequestInterceptor());
		return restTemplate;
	}
}
