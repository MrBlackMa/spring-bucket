package com.malixi.springboot.malixispringboot.dao;

import com.malixi.springboot.malixispringboot.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/27 - 19:31
 * @Description: com.malixi.springboot.malixispringboot.dao
 * @version: 1.0
 */
@Repository
public class HelloDao {

  static   Map<String,Object> map= Collections.synchronizedMap(new HashMap<String, Object>());

    public List<Person> findAll() {
         Person person=new Person();
         person.setId(Long.parseLong(map.get("id").toString()));
         person.setName(map.get("name").toString());
         List<Person> list=new ArrayList<>();
         list.add(person);
         return list;
    }

    public void add(Map<String, Object> map1) {
        map.put("id",map1.get("id"));
        map.put("name",map1.get("name"));
    }
}
