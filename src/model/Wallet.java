package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Wallet implements IWallet {

    private List<ServiceTitles> listTS ;
    private IOrders orders;

    public Wallet (){
        this.orders = new Orders();

        this.listTS = new ArrayList<>();

        int index = 0;

        for (IOrder order : orders.getListOrder()) {
            final DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
            LocalDate date = LocalDate.parse(order.getDatePayment(),dtf);
            listTS.add(new ServiceTitles(index,date.plusMonths(6).format(dtf), 1, 9.00,order.getQuantityTS()));
            index++;
        }
    }

    @Override
    public void addTS(ServiceTitles ts){
        listTS.add(ts);
    }

    @Override
    public void removeTS(ServiceTitles ts){listTS.remove(ts);}

    @Override
    public List<ServiceTitles> getListTS() {
        return listTS;
    }

    @Override
    public IOrders getOrders(){
        return orders;
    }
}
