package mezzofy.com.libmzcoupon.data;

import java.util.List;

/**
 * Created by aruna on 9/19/17.
 */

public class OrderListDataModel {
    private List<OrdermData> orders;
    private SizeDataModel size;

    public List<OrdermData> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdermData> orders) {
        this.orders = orders;
    }

    public SizeDataModel getSize() {
        return size;
    }

    public void setSize(SizeDataModel size) {
        this.size = size;
    }
}
