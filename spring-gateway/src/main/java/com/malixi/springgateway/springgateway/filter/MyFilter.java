package com.malixi.springgateway.springgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 自定义过滤器
 */

@Component
public class MyFilter implements Ordered, GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		MultiValueMap<String, String> queryParams = request.getQueryParams();
		List<String> list = queryParams.get("id");
		
		if (null == list || list.size() ==0) {
			// 非法请求
			System.out.println("不要~");
			
//			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//			
//			return exchange.getResponse().setComplete();
			DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap("xiake~!!".getBytes());
			
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			
			return exchange.getResponse().writeWith(Mono.just(dataBuffer));
			
		}
		
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}