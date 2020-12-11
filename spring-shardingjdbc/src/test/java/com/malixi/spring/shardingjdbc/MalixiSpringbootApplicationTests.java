package com.malixi.spring.shardingjdbc;

import com.malixi.spring.shardingjdbc.bean.Address;
import com.malixi.spring.shardingjdbc.bean.DictOrderType;
import com.malixi.spring.shardingjdbc.bean.Orders;
import com.malixi.spring.shardingjdbc.bean.Person;
import com.malixi.spring.shardingjdbc.mapper.OrdersMapper;
import com.mysql.cj.xdevapi.JsonString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MalixiSpringbootApplicationTests {

	@Autowired
	private OrdersMapper ordersMapper;

	@Test
	void contextLoads() {
		for (int i = 1; i < 11; i++) {
			Orders orders=new Orders();
			orders.setId(i);
			orders.setOrderType(i);
			orders.setCustomerId(i);
			orders.setAmount(i*100.0);
			ordersMapper.insertOrders(orders);
		}
	}

	@Test
	void contextLoads2() {
		for (int i = 1; i < 11; i++) {
			Orders orders=new Orders();
			orders.setOrderType(i);
			orders.setCustomerId(i);
			orders.setAmount(i*100.0);
			ordersMapper.insertOrders2(orders);
		}
	}

	@Test
	void contextLoads3() {
		for (int i = 1; i < 11; i++) {
			DictOrderType dp=new DictOrderType();
			dp.setId(i);
		    dp.setOrderType("o"+i);
			ordersMapper.insertDictType(dp);
		}
	}

	@Test
	void contextLoads4() {
		for (int i = 1; i < 11; i++) {
			DictOrderType dp=new DictOrderType();
			dp.setOrderType("o"+i);
			ordersMapper.insertDictType2(dp);
		}
	}

	@Test
	void contextLoads5() {
		for (int i = 1; i < 11; i++) {
			Person p=new Person();
			p.setId(i);
			p.setName(i+"name");
			ordersMapper.insertPerson(p);
		}
	}

	@Test
	void contextLoads51() {
		System.out.println(ordersMapper.selectPersonById(1).getName());
	}


	@Test
	void contextLoads6() {
		for (int i = 1; i < 11; i++) {
			Address p=new Address();
			p.setId(i);
			p.setAddress(i+"address");
			ordersMapper.insertAddress(p);
		}
	}

}
