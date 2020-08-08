package model;

public class Service implements IService {

    private String activity;
    private Customer customer;
    private String date;
    private int duration;
    private String status;
    private Provider provider;
    private Company company;
    private String nameProvider;
    private String nameCompany;
    private String nameCustomer;
    private int id;

    public Service(int id,String activity, Company company,Customer customer,Provider provider, String date, int duration, String status) {
        this.id = id;
        this.activity = activity;
        this.customer = customer;
        this.date = date;
        this.duration = duration;
        this.status = status;
        this.provider = provider;
        this.company = company;
    }

    @Override
    public String getActivity() {
        return activity;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status){ this.status = status; }

    @Override
    public Provider getProvider() {
        return provider;
    }

    @Override
    public String getNameProvider(){ return provider.getName();}

    @Override
    public String getNameCompany(){ return company.getName();}

    @Override
    public String getNameCustomer(){ return customer.getFirstName() +" "+ customer.getLastName();}

    @Override
    public int getId(){
        return id;
    }

    @Override
    public Company getCompany() {
        return company;
    }
}
