package model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Provider> listProvider;
    private String name;
    private int id;

    public Company(int id,String name){
        this.name =name;
        listProvider = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Provider> getListProvider() {
        return listProvider;
    }

    public int getId(){
        return id;
    }
}
