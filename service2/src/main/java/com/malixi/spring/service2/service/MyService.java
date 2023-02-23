package com.malixi.spring.service2.service;

import com.malixi.spring.service2.dao.MyRepository;
import com.malixi.spring.service2.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
 
    @Autowired
    private MyRepository myRepository;
 
    public void doSomething() {
        System.out.println("nihao");
        this.myRepository.doSomething();
    }
 
    public Model findById(Long id) {
        System.out.println("demo");
        return myRepository.findById(id);
    }
}