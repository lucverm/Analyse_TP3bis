package utils;

public class StaticPassData {

    private static int currentOrder;

    public static void assignIdObject(int id){
        currentOrder = id;
    }

    public static int getTheId(){
        return currentOrder;
    }
}
