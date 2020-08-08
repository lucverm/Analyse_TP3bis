package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Orders implements IOrders{

    private List<IOrder> listOrder;
    private final int totalTSYear = 500;

    public Orders (){
        this.listOrder = new ArrayList<>();

        this.listOrder.add(new Order(
                1,
                LocalDate.of(2020,6,25).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                "Electrique",
                PaymentMode.Bancontact.toString(),
                30,
                "270",
                "Reçue"));

        this.listOrder.add(new Order(
                2,
                LocalDate.of(2020,4,17).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                "Papier",
                PaymentMode.Bancontact.toString(),
                10,
                "90",
                "En attente"));
    }

    @Override
    public List<IOrder> getListOrder(){
        return listOrder;
    }

    @Override
    public void addOrder(IOrder newOrder){
        listOrder.add(newOrder);
    }

    @Override
    public void removeOrder(IOrder order){
        listOrder.remove(order);
    }

    @Override
    public int getTotalTS(){
        int cpt = 0;

        for(IOrder item : listOrder){
           cpt += item.getQuantityTS();
        }
        return cpt;
    }

    @Override
    public String getTSRemaining(){
        return String.valueOf(totalTSYear - getTotalTS());
    }
}