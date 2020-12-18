package com.malixi.springboot.malixispringboot;

import com.malixi.springboot.malixispringboot.annotation.MyAnnotation;
import com.malixi.springboot.malixispringboot.annotation.MyAnnotationClass;
import com.malixi.springboot.malixispringboot.entity.Person;
import com.malixi.springboot.malixispringboot.ioc.service.IPersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
class MalixiSpringbootApplicationTests {

	@Autowired
	 private Person person;

	@Autowired
	private IPersonService iPersonService;

	@Test
	void contextLoads() {
		//System.out.println(person);
		System.out.println(iPersonService.list());
	}


	public static String getInfo(Class<?> cs){
		String result = "";
		Field[] declaredFields = cs.getDeclaredFields();
		for (Field field : declaredFields){
			if(field.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
				String value = annotation.value();
				result += (field.getName() + ":" + value + "\n");
			}
		}
		return result;
	}

	@Test
	public void test() {
		String info = MalixiSpringbootApplicationTests.getInfo(MyAnnotationClass.class);
		System.out.println(info);
	}



}
