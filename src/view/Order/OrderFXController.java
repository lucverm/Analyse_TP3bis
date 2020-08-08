package view.Order;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import model.Order;
import model.PaymentMode;
import model.ServiceTitles;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class OrderFXController implements Initializable {
    private IMainController controller;

    @FXML
    private Label nbrTS;

    @FXML
    private Label nameProduct;

    @FXML
    private Label quantityTS;

    @FXML
    private Label priceTS;

    @FXML
    private Label totalPrice;

    @FXML
    private Label formatTS;

    @FXML
    private Button buttonRefresh;

    @FXML
    private Button addOrderButton;

    @FXML
    private Spinner<Integer> quantityTSSpinner;

    public OrderFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void addOrder(){
        Order order = new Order(3, LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),formatTS.getText(), PaymentMode.Bancontact.toString(),
                quantityTSSpinner.getValue(),String.valueOf(quantityTSSpinner.getValue()*9),"En attente");
        controller.addOrder(order);

        int indexTS = controller.getListTS().size()-1;

        ServiceTitles serviceTitles = new ServiceTitles(indexTS,order.getDatePayment(),1,9.00,order.getQuantityTS());
        controller.addTs(serviceTitles);

        controller.closePopup();
        controller.switchView("Orders");
    }

    @FXML
    public void refreshOrder(){
        double priceTSDouble = Math.round((double) quantityTSSpinner.getValue());
        quantityTS.setText(String.valueOf( quantityTSSpinner.getValue()));
        priceTS.setText(String.valueOf(priceTSDouble*9));
        totalPrice.setText(String.valueOf(priceTSDouble*9));
        addOrderButton.setDisable(false);
    }
}
