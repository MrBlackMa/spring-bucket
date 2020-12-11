package com.malixi.springboot.malixispringboot.controller;

import com.malixi.springboot.malixispringboot.domain.Person;
import com.malixi.springboot.malixispringboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/26 - 15:57
 * @Description: 基于spring boot 的mvc
 * @version: 1.0
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/getList")
    public String findAll(ModelMap map){
        List<Person> all = helloService.findAll();
        map.put("name","张老师声音太小");
        map.addAttribute("list",all);
        return "list";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute Person person){
        if(person!=null){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id",person.getId());
            map.put("name",person.getName());
            System.out.println(map);
            helloService.add(map);
        }
        return "add";
    }


}
