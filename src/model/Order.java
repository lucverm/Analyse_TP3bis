package model;

public class Order implements IOrder {

    private int id;
    private String datePayment;
    private String format;
    private String paymentMode;
    private int quantityTS;
    private String totalTS;
    private String status;

    public Order(int id, String datePayment, String format, String paymentMode, int quantityTS, String totalTS,String status) {
        this.id = id;
        this.datePayment = datePayment;
        this.format = format;
        this.paymentMode = paymentMode;
        this.quantityTS = quantityTS;
        this.totalTS = totalTS;
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDatePayment() {
        return datePayment;
    }

    @Override
    public void setDatePayment(String datePayment){
        this.datePayment = datePayment;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getPaymentMode() {
        return paymentMode;
    }

    @Override
    public int getQuantityTS() {
        return quantityTS;
    }

    @Override
    public String getTotalTS() {
        return totalTS + ",00 EUR";
    }

    @Override
    public String getStatus(){ return status;}
}
