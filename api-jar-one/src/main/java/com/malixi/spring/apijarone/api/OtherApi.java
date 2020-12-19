package com.malixi.spring.apijarone.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 18:30
 * @Description: com.malixi.spring.jar.api
 * @version: 1.0
 */
@RequestMapping("/other")
public interface OtherApi {
    /**
     * 测试抽离userpai
     * 查看当前服务
     * @return test
     */
    @GetMapping("/getOther")
    public String getOther();

    /**
     * 传递单个参数的
     * @return
     */
    @GetMapping("/getOtherById")
    public String getOtherById(@RequestParam String id);


    /**
     * 传递map
     * @return
     */
    @GetMapping("/getOtherByMap")
    public Map<String,Object> getOtherByMap(@RequestParam Map<String,Object> map);


    /**
     * post请求传递map
     * @param map
     * @return
     */
    @PostMapping("/getOtherByPost")
    public Map<String,Object> getOtherByPost(@RequestParam Map<String,Object> map);
}
