package com.malixi.springboot.malixispringboot.service.impl;

import com.malixi.springboot.malixispringboot.dao.HelloDao;
import com.malixi.springboot.malixispringboot.domain.Person;
import com.malixi.springboot.malixispringboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/27 - 19:30
 * @Description: com.malixi.springboot.malixispringboot.service
 * @version: 1.0
 */
@Service
public class HelloServiceImpl  implements HelloService {

    @Autowired
    private HelloDao helloDao;


    @Override
    public List<Person> findAll() {
       return helloDao.findAll();
    }

    @Override
    public void add(Map<String, Object> map) {
        helloDao.add(map);
    }
}
