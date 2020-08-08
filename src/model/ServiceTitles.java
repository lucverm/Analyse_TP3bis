package model;

public class ServiceTitles {

    private String dateOut;
    private int duration;
    private double price;
    private  int quantity;
    private int totalQuantityInEuros;
    private int id;

    public ServiceTitles(int id,String dateOut, int duration, double price, int quantity){
        this.id = id;
        this.dateOut = dateOut;
        this.duration = duration;
        this.price = price;
        this.quantity = quantity;
        this.totalQuantityInEuros = quantity*9;
    }

    public int getId(){
        return this.id;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String newDate){ this.dateOut = newDate;}

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTotalQuantityInEuros(){
        return totalQuantityInEuros + ",00 EUR";
    }
}
