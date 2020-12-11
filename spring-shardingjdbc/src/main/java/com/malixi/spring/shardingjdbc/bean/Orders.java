package com.malixi.spring.shardingjdbc.bean;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/9 - 16:10
 * @Description: com.malixi.spring.shardingjdbc.bean
 * @version: 1.0
 */
public class Orders {
    private Integer id;
    private Integer orderType;
    private Integer customerId;
    private double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
