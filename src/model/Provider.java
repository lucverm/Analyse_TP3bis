package model;

public class Provider {

    private int id;
    private String name;

    public Provider (int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
