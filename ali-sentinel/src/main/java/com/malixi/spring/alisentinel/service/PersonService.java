package com.malixi.spring.alisentinel.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@Service
public class PersonService {


	/**
	 * 限流可以加在任何地 可以加在service里面
	 * 也可以加在controller里面
	 * @return
	 */
	@SentinelResource(value = "malixi",blockHandler = "back")
	public String getBody() {
		// 真正的业务逻辑
		// 被保护的资源
		return "给你我的肉体";
	}

	/**
	 * 基于平滑窗口
	 * @param e
	 * @return
	 */
	public String back(BlockException e) {
		return "降级了....";
	}

}
