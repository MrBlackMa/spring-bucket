package com.mashibing.lcnpay.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_pay
 * @author 
 */
@Data
public class TblPay implements Serializable {
    private Integer id;

    private String payName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    private static final long serialVersionUID = 1L;
}