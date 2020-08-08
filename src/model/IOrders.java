package model;

import java.util.List;

public interface IOrders {
    List<IOrder> getListOrder();
    void addOrder(IOrder newOrder);
    void removeOrder(IOrder order);
    int getTotalTS();
    String getTSRemaining();
}
