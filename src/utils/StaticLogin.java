package utils;

public class StaticLogin {

    private static String user;
    private static String password;

    public static void getLogin(String newUser, String newPassword){
        user = newUser;
        password = newPassword;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
