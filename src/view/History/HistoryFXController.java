package view.History;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.IService;
import utils.StaticPassData;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryFXController implements Initializable {

    private IMainController controller;

    private List<IService> listServiceCurrentCompany;

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
    private Label nameEA;

    public HistoryFXController(IMainController controller) {
        this.controller = controller;
        listServiceCurrentCompany = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameEA.setText(controller.getListService().get(StaticPassData.getTheId()).getNameCompany());

        TableView.TableViewSelectionModel<IService> selectionModel = serviceTableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        initColumn();
        initTableView();
        refreshTable();
    }

    private void initTableView(){
        listServiceCurrentCompany.clear();
        for(IService item : controller.getListService()){
            if(item.getNameCompany().equals(controller.getListService().get(StaticPassData.getTheId()).getNameCompany())){
                listServiceCurrentCompany.add(item);
            }else{
                listServiceCurrentCompany.remove(item);
            }
        }

        System.out.println(listServiceCurrentCompany.size());
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

    private void refreshTable(){
        dataService.clear();
        dataService.addAll(listServiceCurrentCompany);
        serviceTableView.setItems(dataService);
    }

    public void backServices(){
        controller.switchView("Services");
    }
}
