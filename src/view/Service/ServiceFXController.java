package view.Service;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import utils.StaticPassData;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ServiceFXController implements Initializable {

    private IMainController controller;
    private ObservableList<String> dataService = FXCollections.observableArrayList("David Jeas","Michelle Smith","Sam Vandera","Julie Williaume","Vincent André");

    @FXML
    private ComboBox<String> activity;

    @FXML
    private ComboBox<String> providers;

    @FXML
    private TextField customerLastName;

    @FXML
    private TextField customerFirstName;

    @FXML
    private TextField provider;

    @FXML
    private TextField companyText;

    @FXML
    private DatePicker date;

    @FXML
    private TextField duration;

    public ServiceFXController(IMainController controller){ this.controller = controller;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activity.setItems(FXCollections.observableArrayList(Activity.Nettoyage.toString(), Activity.Repassage.toString(), Activity.Course.toString(), Activity.Transport.toString()));
        activity.getSelectionModel().selectFirst();

        providers.setItems(dataService);
        providers.getSelectionModel().selectFirst();
    }

    public void addService(){

        int indexCompany = controller.getListService().get(StaticPassData.getTheId()).getCompany().getId()+1;

        Company company = new Company(indexCompany,companyText.getText());

        controller.addCompany(company);

        int indexCustomer = controller.getListService().get(StaticPassData.getTheId()).getCustomer().getId()+1;

        Customer client = new Customer(indexCustomer, customerFirstName.getText(),customerLastName.getText(), new Wallet());

        int indexProvider = controller.getListService().get(StaticPassData.getTheId()).getProvider().getId()+1;

        Provider prestataire = new Provider(indexProvider,providers.getValue());

        int index = controller.getListService().size()-1;

        Service service = new Service(controller.getListService().get(index).getId()+1,
                activity.getValue(),company,client,prestataire,date.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), Integer.parseInt(duration.getText()),"En attente"
        );
        controller.addService(service);

        controller.closePopup();
        controller.switchView("Services");
    }
}
