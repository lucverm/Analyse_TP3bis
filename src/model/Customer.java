package model;

public class Customer implements ICustomer {

    private int id ;
    private String firstName;
    private String lastName;
    private Wallet wallet;

    public Customer(int id, String firstName, String lastName, Wallet wallet){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Wallet getWallet(){
        return wallet;
    }

}
