package me.christ9979.jpawebapp.domain;

import me.christ9979.jpawebapp.entity.OrderStatus;

public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
