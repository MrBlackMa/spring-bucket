package com.malixi.springboot.malixispringboot.ioc.controller;

import com.malixi.springboot.malixispringboot.ioc.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 17:04
 * @Description: com.malixi.springboot.malixispringboot.ioc.controller
 * @version: 1.0
 */
@RestController
@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping("/list")
    public String list(){
        return  iPersonService.list();
    }
}
