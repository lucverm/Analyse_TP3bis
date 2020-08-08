package view.Orders;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.IOrder;
import model.Order;
import utils.StaticPassData;

import java.net.URL;
import java.util.ResourceBundle;

public class OrdersFXController implements Initializable {
    private IMainController controller;
    final ObservableList<IOrder> dataOrder = FXCollections.observableArrayList();

    @FXML
    private Label nbrTotalTS;

    @FXML
    private Label nbrTSNormal;

    @FXML
    private Label nbrTSDixEuros;

    @FXML
    private TableView<IOrder> tableViewOrders;

    @FXML
    private TableColumn<String, IOrder> column1;

    @FXML
    private TableColumn<String, IOrder> column2;

    @FXML
    private TableColumn<String, IOrder> column3;

    @FXML
    private TableColumn<String, IOrder> column4;

    @FXML
    private TableColumn<String, IOrder> column5;

    public OrdersFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nbrTotalTS.setText(controller.getTSRemaining());

        TableView.TableViewSelectionModel<IOrder> selectionModel = tableViewOrders.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        initColumn();
        refreshTable();
        showDetails();

    }

    private void showDetails(){
        tableViewOrders.setRowFactory(param -> {
            TableRow<IOrder> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    IOrder rowData = row.getItem();
                    StaticPassData.assignIdObject(rowData.getId());
                    controller.loadPopup("Details");
                }
            });
            return row ;
        });
    }

    private void refreshTable(){
        dataOrder.clear();
        dataOrder.addAll(controller.getListOrder());
        tableViewOrders.setItems(dataOrder);
    }

    private void initColumn(){
        column1.setCellValueFactory(new PropertyValueFactory<>("quantityTS"));
        column2.setCellValueFactory(new PropertyValueFactory<>("format"));
        column3.setCellValueFactory(new PropertyValueFactory<>("datePayment"));
        column4.setCellValueFactory(new PropertyValueFactory<>("totalTS"));
        column5.setCellValueFactory(new PropertyValueFactory<>("status"));
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
