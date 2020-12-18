package com.malixi.spring.service2.controller;

import com.malixi.spring.service2.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/17 - 17:36
 * @Description: com.malixi.springboot.malixispringboot.controller
 * @version: 1.0
 */
@RestController
public class HellowordController {

    @GetMapping("/sayHi")
    public String sayHi(){
        return "hi2";
    }

    @GetMapping("/getMap")
    public Map<String,Object> getMap(){
        return Collections.singletonMap("id","101");
    }


    /**
     * rest获取对象结果
     * @return
     */
    @GetMapping("/getPerson")
    public Object getPerson(){
        return new Person(1,"malixi","男","湖北武汉");
    }


    /**
     * 传递参数 然后返回值
     * @param map
     * @return
     */
    @RequestMapping("/getMap2")
    public Map<String,Object> getMap2(@RequestBody Map<String,Object> map){
        System.out.println(map.get("name"));
        return map;
    }



    /**
     * 重定向
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/postForLocation")
    public URI postForLocation(@RequestBody Map<String,Object> map, HttpServletResponse response) throws Exception {
        URI uri = new URI("https://www.baidu.com/");
        response.addHeader("Location", uri.toString());
        return uri;
    }
}
