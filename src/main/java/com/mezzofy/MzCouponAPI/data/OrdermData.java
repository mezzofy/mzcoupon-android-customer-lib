package com.mezzofy.MzCouponAPI.data;



import java.util.List;

/**
 * Created by aruna on 9/19/17.
 */

public class OrdermData {
    private OrderData order;
    private List<OrderItemDataModel> orderitems;

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }

    public List<OrderItemDataModel> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<OrderItemDataModel> orderitems) {
        this.orderitems = orderitems;
    }
}
