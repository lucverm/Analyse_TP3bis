package model;

import java.util.List;

public interface IWallet {
    void addTS(ServiceTitles ts);
    void removeTS(ServiceTitles ts);
    List<ServiceTitles> getListTS();
    IOrders getOrders();
}
