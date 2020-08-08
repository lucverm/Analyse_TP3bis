package controller;

import model.*;
import utils.IUser;
import utils.User;
import view.Contested.ContestedFXController;
import view.Details.DetailsFXController;
import view.Echange.EchangeFXController;
import view.History.HistoryFXController;
import view.Login.LoginFXController;
import view.MainMenu.MainMenuFXController;
import view.Order.OrderFXController;
import view.Orders.OrdersFXController;
import view.Payback.PaybackFXController;
import view.Service.ServiceFXController;
import view.Services.ServicesFXController;
import view.SwitchView;
import view.Wallet.WalletFXController;
import java.util.HashMap;
import java.util.List;

public class MainController implements IMainController{

    private SwitchView switchView;
    private IUser user = new User("","");
    private HashMap<String, Object> controllers;
    private IOrders orders;
    private IWallet wallet = new Wallet();
    private IServices services = new Services();
    private Companys companys = new Companys();

    public MainController(SwitchView switchView){
        controllers = new HashMap<>();
        controllers.put("MainMenu", new MainMenuFXController(this));
        controllers.put("Wallet", new WalletFXController(this));
        controllers.put("Orders", new OrdersFXController(this));
        controllers.put("Order", new OrderFXController(this));
        controllers.put("Details", new DetailsFXController(this));
        controllers.put("Services", new ServicesFXController(this));
        controllers.put("Payback", new PaybackFXController(this));
        controllers.put("Echange", new EchangeFXController(this));
        controllers.put("Contested", new ContestedFXController(this));
        controllers.put("Service", new ServiceFXController(this));
        controllers.put("Login", new LoginFXController(this));
        controllers.put("History", new HistoryFXController(this));

        this.switchView = switchView;
        this.orders = wallet.getOrders();
    }

    @Override
    public void switchView(String fileFXML) {
        switchView.loadView(fileFXML,controllers);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void loadPopup(String fileFXML){
        switchView.loadPopup(fileFXML,controllers);
    }

    @Override
    public  void closePopup() { switchView.closePopup();}

    @Override
    public void addOrder(Order newOrder){
        orders.addOrder(newOrder);
    }

    @Override
    public void removeOrder(Order newOrder){
        orders.removeOrder(newOrder);
    }

    @Override
    public void addTs(ServiceTitles ts){
        wallet.addTS(ts);
    }

    @Override
    public void addService(Service service){ services.addService(service);}

    @Override
    public String getTSRemaining(){
        return orders.getTSRemaining();
    }

    @Override
    public List<IOrder> getListOrder() {
        return orders.getListOrder();
    }

    @Override
    public List<ServiceTitles> getListTS(){
        return wallet.getListTS();
    }

    @Override
    public String getNbrTS(){
        return String.valueOf(orders.getTotalTS());
    }

    @Override
    public List<Company> getListCompany(){
        return companys.getCompanyList();
    }

    @Override
    public void addCompany(Company company){
        companys.addCompany(company);
    }

    @Override
    public List<IService> getListService(){
        return services.getListService();
    }

    @Override
    public boolean isValid(String user, String password, int index){
        this.user = new User(user,password);
        return this.user.isValid(index);
    }

    @Override
    public List<String> getUsers() {
        return user.getUsers();
    }

    @Override
    public List<String> getPasswords() {
        return user.getPasswords();
    }
}
