package com.malixi.springboot.malixispringboot.eureka;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


/**
 * 手动上下线服务
 */
@Component
public class HealthStatusService implements HealthIndicator {

	private Boolean status = true;

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		if (status)
			return new Health.Builder().up().build();
		return new Health.Builder().down().build();
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return this.status.toString();
	}
}