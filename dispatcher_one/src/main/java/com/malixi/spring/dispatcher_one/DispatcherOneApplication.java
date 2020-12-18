package com.malixi.spring.dispatcher_one;

import com.malixi.spring.dispatcher_one.config.LoggingClientHttpRequestInterceptor;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DispatcherOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatcherOneApplication.class, args);
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
		restTemplate.getInterceptors().add(new LoggingClientHttpRequestInterceptor());
		return restTemplate;
	}


	/**
	 * 自定义负载均衡策略
	 * @return
	 */
//	@Bean
//	public IRule myRule() {
//		//return new RoundRobinRule();
//		//return new RandomRule();
//		return new RetryRule();
//
//	}
}
