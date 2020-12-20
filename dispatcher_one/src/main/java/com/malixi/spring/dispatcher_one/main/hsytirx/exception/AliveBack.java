package com.malixi.spring.dispatcher_one.main.hsytirx.exception;

import com.malixi.spring.dispatcher_one.api.OtherApiJar;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/20 - 19:07
 * @Description: 熔断降级的类 粒度比较粗 直接返回页面的那种 不能判断是服务异常还是网络断线
 * @version: 1.0
 */
@Component
public class AliveBack implements OtherApiJar {

    @Override
    public String getOther() {
        /**
         * 服务还可以凑合用
         *
         */
        return "降级了1";
    }


    @Override
    public String getAlive() {
        return "降级了2";
    }

    @Override
    public String getOtherById(String id) {
        return null;
    }

    @Override
    public Map<String, Object> getOtherByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getOtherByPost(Map<String, Object> map) {
        return null;
    }

}
