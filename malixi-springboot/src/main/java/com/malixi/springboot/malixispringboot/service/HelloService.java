package com.malixi.springboot.malixispringboot.service;

import com.malixi.springboot.malixispringboot.domain.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/27 - 19:38
 * @Description: com.malixi.springboot.malixispringboot.service.impl
 * @version: 1.0
 */
public interface HelloService {
    List<Person> findAll();

    void add(Map<String, Object> map);
}
