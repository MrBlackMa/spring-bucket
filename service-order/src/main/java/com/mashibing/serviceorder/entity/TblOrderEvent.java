package com.mashibing.serviceorder.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tbl_order_event
 * @author 
 */
@Data
public class TblOrderEvent implements Serializable {
    private Integer id;

    /**
     * 事件类型（支付表支付完成，订单表修改状态）
     */
    private String orderType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 事件环节（new,published,processed)
     */
    private String process;

    /**
     * 事件内容，保存事件发生时需要传递的数据
     */
    private String content;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}