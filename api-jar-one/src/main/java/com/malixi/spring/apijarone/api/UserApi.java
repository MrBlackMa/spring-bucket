package com.malixi.spring.apijarone.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 17:09
 * @Description: com.malixi.spring.jar.api
 * @version: 1.0
 */

public interface UserApi {

    /**
     * 测试抽离userpai
     * 查看当前服务
     * @return test
     */
    @RequestMapping("/user/getUserInfo")
    public String getUserInfo();
}
