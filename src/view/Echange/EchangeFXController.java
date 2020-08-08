package view.Echange;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.IOrder;
import model.ServiceTitles;
import utils.StaticPassData;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.ResourceBundle;

public class EchangeFXController implements Initializable {

    private IMainController controller;
    final ObservableList<ServiceTitles> dataTS = FXCollections.observableArrayList();

    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private RadioButton radioButton3;

    @FXML
    private RadioButton radioButton4;

    @FXML
    private ListView<String> titles;

    @FXML
    private ListView<Date> dateListView;

    @FXML
    private ListView<String> listViewEuros;

    @FXML
    private Button confirmEchange;

    @FXML
    private Button validRadioButton;

    @FXML
    private TableView<ServiceTitles> tableViewEchange;

    @FXML
    private TableColumn<String, ServiceTitles> column1;

    @FXML
    private TableColumn<String, ServiceTitles> column2;

    @FXML
    private TableColumn<String, ServiceTitles> column3;

    @FXML
    private Label messageError;


    public EchangeFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableView.TableViewSelectionModel<ServiceTitles> selectionModel = tableViewEchange.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        initColumn();
        refreshTable();
        showCurrentService();
    }

    private void refreshTable(){
        dataTS.clear();
        dataTS.addAll(controller.getListTS());
        tableViewEchange.setItems(dataTS);
    }

    private void initColumn(){
        column1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        column2.setCellValueFactory(new PropertyValueFactory<>("dateOut"));
        column3.setCellValueFactory(new PropertyValueFactory<>("totalQuantityInEuros"));
    }

    public void validRadioButton(){
        if(radioButton1.isSelected() != radioButton2.isSelected() && radioButton3.isSelected() != radioButton4.isSelected()) {
            if (radioButton1.isSelected()) {
                VerifyRadioButton(radioButton2, radioButton3, radioButton4);
            } else if (radioButton2.isSelected()) {
                VerifyRadioButton(radioButton1, radioButton4, radioButton3);
            }
            confirmEchange.setDisable(false);
            messageError.setText("");
        }else{
            messageError.setText("Erreur dans le formulaire !");
        }
    }

    private void VerifyRadioButton(RadioButton radioButton1, RadioButton radioButton4, RadioButton radioButton3) {
        radioButton1.setSelected(false);
        radioButton1.setDisable(true);
        if (radioButton4.isSelected()) {
            radioButton3.setSelected(false);
            radioButton3.setDisable(true);
        }else  if (radioButton3.isSelected()) {
            radioButton4.setSelected(false);
            radioButton4.setDisable(true);
        }
    }

    private void showCurrentService(){
        tableViewEchange.setRowFactory(param -> {
            TableRow<ServiceTitles> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    ServiceTitles rowData = row.getItem();
                    StaticPassData.assignIdObject(rowData.getId());
                }
            });
            return row ;
        });
    }

    public void confirmEchange(){
        final DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalDate date = LocalDate.parse(controller.getListTS().get(StaticPassData.getTheId()).getDateOut(),dtf);
        
        controller.getListTS().get(StaticPassData.getTheId()).setDateOut(date.plusMonths(6).format(dtf));
        controller.closePopup();
        controller.switchView("Wallet");
    }
}
