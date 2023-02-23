package com.malixi.spring.alisentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AliSentinelApplication {

	public static void main(String[] args) {
		// 不会被注册到 dashboard上
		//	initFlowRules();
		SpringApplication.run(AliSentinelApplication.class, args);
	}


	/**
	 * 服务 、方法的限流规则
	 */
	private static void initFlowRules() {
		List<FlowRule> rules = new ArrayList<>();

		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(1);
		rules.add(rule);


		FlowRuleManager.loadRules(rules);
	}

}
