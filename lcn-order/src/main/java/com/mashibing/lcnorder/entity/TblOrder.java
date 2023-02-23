package com.mashibing.lcnorder.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_order
 * @author 
 */
@Data
public class TblOrder implements Serializable {
    private Integer id;

    private String orderName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    private static final long serialVersionUID = 1L;
}