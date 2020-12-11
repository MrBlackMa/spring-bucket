package com.malixi.spring.shardingjdbc.bean;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/10 - 14:52
 * @Description: com.malixi.spring.shardingjdbc.bean
 * @version: 1.0
 */
public class Address {
    private int id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
