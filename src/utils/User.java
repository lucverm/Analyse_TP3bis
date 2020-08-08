package utils;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {

    private List<String> users;
    private List<String> passwords;

    private String user;
    private String password;

    public User(String user, String password){
        this.password = password;
        this.user = user;

        users = new ArrayList<>();
        passwords = new ArrayList<>();

        users.add("user1");
        users.add("user2");
        users.add("prestataire1");
        users.add("prestataire2");
        users.add("ea1");
        users.add("ea2");
        users.add("super user");

        passwords.add("Test1234");
        passwords.add("Test1234");
        passwords.add("Exemple123");
        passwords.add("Exemple123");
        passwords.add("Entreprise1");
        passwords.add("Entreprise2");
        passwords.add("Admin123");
    }

    @Override
    public boolean isValid(int index){
        for(int i =0; i < users.size(); i++){
            if(users.get(index).equals(user) && passwords.get(index).equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    @Override
    public List<String> getPasswords() {
        return passwords;
    }
}
