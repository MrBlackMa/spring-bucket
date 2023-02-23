package com.malixi.spring.alisentinel;

import com.malixi.spring.alisentinel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

	@Autowired
	PersonService personSrv;
	
	@GetMapping("/get")
	public String get() {
		
		return personSrv.getBody();
	}

	@GetMapping("/get2")
	public String get2() {

		return personSrv.getBody();
	}

}
