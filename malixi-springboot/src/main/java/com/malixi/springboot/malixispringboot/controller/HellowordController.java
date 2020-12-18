package com.malixi.springboot.malixispringboot.controller;

import com.malixi.springboot.malixispringboot.entity.Person;
import com.malixi.springboot.malixispringboot.eureka.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    HealthStatusService healthStatusService;

    @Autowired
    private Person person;
    /**
     * rest获取string结果
     * @return
     */
    @GetMapping("/sayHi")
    public String sayHi(){
        return "hi";
    }

    /**
     * rest获取map结果
     * @return
     */
    @GetMapping("/getMap")
    public Map<String,Object> getMap(){
        return Collections.singletonMap("id","100");
    }

    /**
     * rest获取对象结果
     * @return
     */
    @GetMapping("/getPerson")
    public Object getPerson(){
        return person;
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

    /**
     * 设置服务的上下线
     * @param status
     * @return
     */
    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }
}
