package com.malixi.spring.shardingjdbc.bean;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/10 - 14:13
 * @Description: com.malixi.spring.shardingjdbc.bean
 * @version: 1.0
 */
public class DictOrderType {
    private  int id;
    private String OrderType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }
}
