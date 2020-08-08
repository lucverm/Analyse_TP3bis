package model;

public interface IService {
    String getActivity();
    Customer getCustomer();
    String getDate();
    int getDuration();
    String getStatus();
    void setStatus(String status);
    Provider getProvider();
    String getNameProvider();
    String getNameCompany();
    String getNameCustomer();
    int getId();
    Company getCompany();
}
