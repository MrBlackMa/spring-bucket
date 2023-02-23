package com.malixi.springgateway.springgateway;

import java.math.BigDecimal;

/**
 * @Auther: smile malixi
 * @Date: 2021/1/11 - 20:05
 * @Description: com.malixi.springgateway.springgateway
 * @version: 1.0
 */
public class MainDai {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(2.10);
        BigDecimal c=new BigDecimal(0.9);
        double b=2.10-0.9;

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.subtract(c));
    }
}
