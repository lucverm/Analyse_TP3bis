package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Services implements IServices {

    private List<IService> listService;
    private Companys companys;

    public Services (){
        listService = new ArrayList<>();

        companys = new Companys();

        listService.add(new Service(1,
                Activity.Nettoyage.toString(),
                companys.getCompanyList().get(0),
                new Customer(1,"Lucas","Vermeire", new Wallet()),
                new Provider(1,"Michelle Smith")
                ,LocalDate.of(2020, 6, 25).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                4,"Contestée"));

        listService.add(new Service(2,
                Activity.Repassage.toString(),
                companys.getCompanyList().get(1),
                new Customer(1,"Alan","Ridas",new Wallet()),
                new Provider(1,"David Jeas")
                ,LocalDate.of(2020, 6, 30).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                4,"4 titres prélevés"));

        listService.add(new Service(3,
                Activity.Course.toString(),
                companys.getCompanyList().get(1),
                new Customer(1,"John","Dicaprio",new Wallet()),
                new Provider(1,"Julie Williaume")
                ,LocalDate.of(2020, 7, 03).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                4,"En attente"));

        listService.add(new Service(4,
                Activity.Nettoyage.toString(),
                companys.getCompanyList().get(0),
                new Customer(1,"Lucas","Vermeire", new Wallet()),
                new Provider(1,"Sam Vandera")
                ,LocalDate.of(2020, 5, 31).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                2,"2 titres prélevés"));
    }

    @Override
    public void addService(Service service){
        listService.add(service);
    }

    @Override
    public List<IService> getListService(){
        return listService;
    }

}
