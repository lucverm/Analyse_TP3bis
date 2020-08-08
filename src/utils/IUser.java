package utils;

import java.util.List;

public interface IUser {
    boolean isValid(int index);
    List<String> getUsers();
    List<String> getPasswords();
}
