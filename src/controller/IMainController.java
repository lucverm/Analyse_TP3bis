package controller;

import model.*;

import java.util.List;

public interface IMainController {
    void switchView(String fileFXML);

    void exit();

    void loadPopup(String fileFXML);

    void closePopup();

    void removeOrder(Order newOrder);

    void addOrder(Order newOrder);

    void addTs(ServiceTitles ts);

    String getTSRemaining();

    List<IOrder> getListOrder();

    List<ServiceTitles> getListTS();

    String getNbrTS();

    List<IService> getListService();

    void addService(Service service);
    boolean isValid(String user, String password, int index);
    List<String> getUsers();
    List<String> getPasswords();

    List<Company> getListCompany();
    void addCompany(Company company);
}