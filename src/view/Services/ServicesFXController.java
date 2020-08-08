package view.Services;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.IService;
import model.Service;
import utils.SelectService;
import utils.StaticLogin;
import utils.StaticPassData;

import java.net.URL;
import java.util.ResourceBundle;

public class ServicesFXController implements Initializable {

    private IMainController controller;
    final ObservableList<IService> dataService = FXCollections.observableArrayList();

    @FXML
    private TableView<IService> serviceTableView;

    @FXML
    private TableColumn<String, IService> column1;

    @FXML
    private TableColumn<String, IService> column2;

    @FXML
    private TableColumn<String, IService> column3;

    @FXML
    private TableColumn<String, IService> column4;

    @FXML
    private TableColumn<String, IService> column5;

    @FXML
    private TableColumn<String, IService> column6;

    @FXML
    private TableColumn<String, IService> column7;

    @FXML
    private Label dateService;

    @FXML
    private Label nameProvider;

    @FXML
    private Label nameCompany;

    @FXML
    private Label activityService;

    @FXML
    private Label durationService;

    @FXML
    private Button buttonConfirm;

    @FXML
    private Button buttonContested;

    @FXML
    private Button encodeButton;

    @FXML
    private Button buttonHistory;

    @FXML
    private Label status;


    public ServicesFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableView.TableViewSelectionModel<IService> selectionModel = serviceTableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        initColumn();
        initTableView();
        refreshTable();
        showCurrentService();

        if(StaticLogin.getUser().equals("user1") ||StaticLogin.getUser().equals("user2")){
            encodeButton.setDisable(true);
        }
    }

    private void refreshTable(){
        dataService.clear();
        dataService.addAll(controller.getListService());
        serviceTableView.setItems(dataService);
    }

    private void showCurrentService(){
        serviceTableView.setRowFactory(param -> {
            TableRow<IService> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    IService rowData = row.getItem();
                    SelectService service = new SelectService(controller,dateService, nameProvider,nameCompany, activityService, durationService,status);
                    service.setLabelServiceCurrent(rowData.getId()-1);

                    if(StaticLogin.getUser().equals("user1") ||StaticLogin.getUser().equals("user2")){
                        if(rowData.getStatus().equals("En attente")){
                            buttonConfirm.setDisable(false);
                            buttonContested.setDisable(false);
                        }else{
                            buttonConfirm.setDisable(true);
                            buttonContested.setDisable(true);
                        }
                    }else if(StaticLogin.getUser().equals("super user")){
                        if(rowData.getStatus().equals("En attente")){
                            buttonConfirm.setDisable(false);
                            buttonContested.setDisable(false);
                        }else if(rowData.getStatus().equals("Contestée")){
                            buttonConfirm.setDisable(false);
                        } else{
                            buttonConfirm.setDisable(true);
                            buttonContested.setDisable(true);
                        }
                        encodeButton.setDisable(false);
                        buttonHistory.setDisable(false);
                    }
                    StaticPassData.assignIdObject(rowData.getId()-1);
                }
            });
            return row ;
        });
    }

    private void isWaiting(){

    }

    private void initTableView(){
        serviceTableView.getItems().add(controller.getListService().get(0));
        serviceTableView.getItems().add(controller.getListService().get(1));
    }

    private void initColumn(){
        setCellFactoryColumn(column1, column2, column3, column4, column5, column6, column7);
    }

    public static void setCellFactoryColumn(TableColumn<String, IService> column1, TableColumn<String, IService> column2, TableColumn<String, IService> column3, TableColumn<String, IService> column4, TableColumn<String, IService> column5, TableColumn<String, IService> column6, TableColumn<String, IService> column7) {
        column1.setCellValueFactory(new PropertyValueFactory<>("date"));
        column2.setCellValueFactory(new PropertyValueFactory<>("activity"));
        column3.setCellValueFactory(new PropertyValueFactory<>("duration"));
        column4.setCellValueFactory(new PropertyValueFactory<>("nameCompany"));
        column5.setCellValueFactory(new PropertyValueFactory<>("nameProvider"));
        column6.setCellValueFactory(new PropertyValueFactory<>("nameCustomer"));
        column7.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    public void backToMenu(){
        controller.switchView("MainMenu");
    }

    @FXML
    public void contested(){
        controller.loadPopup("Contested");
    }

    @FXML
    public void encodeService(){
        controller.loadPopup("Service");
    }

    @FXML
    public void confirmService(){
        int duration =  controller.getListService().get(StaticPassData.getTheId()).getDuration();
        controller.getListService().get(StaticPassData.getTheId()).setStatus(duration + " titres prélevés");
        refreshTable();
        showCurrentService();
        buttonConfirm.setDisable(true);
    }

    @FXML
    public void getServicesInProvider(){
        controller.switchView("History");
    }
}
