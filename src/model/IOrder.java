package model;

public interface IOrder {
    int getId();
    String getDatePayment();
    String getFormat();
    String getPaymentMode();
    int getQuantityTS();
    String getTotalTS();
    String getStatus();
    void setDatePayment(String datePayment);
}
