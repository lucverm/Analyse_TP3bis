package view.Wallet;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ServiceTitles;

import java.net.URL;
import java.util.ResourceBundle;

public class WalletFXController implements Initializable {

    private IMainController controller;
    final ObservableList<ServiceTitles> dataTS = FXCollections.observableArrayList();

    @FXML
    private Label nbrTS1;

    @FXML
    private Label nbrTS2;

    @FXML
    private Label nbrMonthsOut;

    @FXML
    private TableView<ServiceTitles> tableViewWallet;

    @FXML
    private TableColumn<String, ServiceTitles> column1;

    @FXML
    private TableColumn<String, ServiceTitles> column2;

    public WalletFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableView.TableViewSelectionModel<ServiceTitles> selectionModel = tableViewWallet.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        nbrTS1.setText(controller.getNbrTS());
        nbrTS2.setText(controller.getNbrTS());

        initColumn();
        refreshTable();
    }

    private void refreshTable(){
        dataTS.clear();
        dataTS.addAll(controller.getListTS());
        tableViewWallet.setItems(dataTS);
    }

    private void initColumn(){
        column1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        column2.setCellValueFactory(new PropertyValueFactory<>("dateOut"));
    }

    @FXML
    public void backToMenu(){
        controller.switchView("MainMenu");
    }

    @FXML
    public void commandTS(){
        controller.loadPopup("Order");
    }

    @FXML
    public void payback(){
        controller.loadPopup("Payback");
    }

    @FXML
    public void echange(){
        controller.loadPopup("Echange");
    }

}
