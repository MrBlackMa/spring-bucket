package com.malixi.spring.dispatcher_two.hsytirx.exception;


import com.malixi.spring.dispatcher_two.api.OrderApiJar;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/20 - 19:59
 * @Description: 粒度比较细,可以判断服务的状态 是服务异常还是服务网络断线等
 * @version: 1.0
 */
@Component
public class OrderBackFactory implements FallbackFactory<OrderApiJar> {
    @Override
    public OrderApiJar create(Throwable t) {
        return new OrderApiJar() {
            @Override
            public String getZuulTest() {
                return null;
            }
            @Override
            public String getOrderInfo() {
                System.out.println(t);
                if(t instanceof FeignException.InternalServerError){
                    return "服务方异常:500"+t.getLocalizedMessage();
                }
                System.out.println(ToStringBuilder.reflectionToString(t));
                return "细粒度降级";
            }
        };
    }
}
