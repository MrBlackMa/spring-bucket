package com.malixi.spring.service2.dao;

import com.malixi.spring.service2.model.Model;
import org.springframework.stereotype.Repository;


@Repository
public class MyRepository {
 
    public void doSomething() {
        System.out.println("here's dosomething");
    }
 
    public Model findById(Long id) {
        System.out.println("我是MyRepository");
        return new Model(id, "Real Repository");
    }
}
