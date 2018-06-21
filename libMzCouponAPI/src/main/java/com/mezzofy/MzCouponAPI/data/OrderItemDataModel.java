package com.mezzofy.MzCouponAPI.data;



import java.util.List;

/**
 * Created by aruna on 9/19/17.
 */

public class OrderItemDataModel {
    private OrderItemData orderitem;
    private List<OrderModifierDataModel> ordermodifiers;

    public OrderItemData getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(OrderItemData orderitem) {
        this.orderitem = orderitem;
    }

    public List<OrderModifierDataModel> getOrdermodifiers() {
        return ordermodifiers;
    }

    public void setOrdermodifiers(List<OrderModifierDataModel> ordermodifiers) {
        this.ordermodifiers = ordermodifiers;
    }
}
