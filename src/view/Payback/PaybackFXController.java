package view.Payback;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PaybackFXController implements Initializable {
    private IMainController controller;

    @FXML
    private RadioButton radioButtonE;

    @FXML
    private RadioButton radioButtonP;

    @FXML
    private Spinner<Integer> nbrTSSpinner;

    @FXML
    private Label totalPriceTS1;

    @FXML
    private Label totalPriceTS2;


    @FXML
    private Label nbrTs;

    @FXML
    private ChoiceBox<String> accountBank;

    @FXML
    private Button payBackConfirm;

    @FXML
    private Button validateButton;

     @FXML
     private Label messageError;

    public PaybackFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountBank.setItems(FXCollections.observableArrayList("BE 41 0630 1234 5610","BE 21 1456 9345 0200","BE 11 9989 0092 1223"));
        accountBank.getSelectionModel().selectFirst();
    }

    @FXML
    public void refresh() {
        if(radioButtonP.isSelected() != radioButtonE.isSelected()){
            if(radioButtonE.isSelected()){
                radioButtonP.setSelected(false);
                radioButtonP.setDisable(true);
            }else if(radioButtonP.isSelected()){
                radioButtonE.setSelected(false);
                radioButtonE.setDisable(true);
            }
            double priceTSDouble = Math.round((double) nbrTSSpinner.getValue());
            nbrTs.setText(String.valueOf(nbrTSSpinner.getValue()));
            totalPriceTS1.setText(String.valueOf(priceTSDouble*9));
            totalPriceTS2.setText(String.valueOf(priceTSDouble*9));
            payBackConfirm.setDisable(false);
            messageError.setText("");
        }else{
            messageError.setText("Il y a une erreur dans le formulaire !");
        }
    }

    @FXML
    public void validatePayback(){
        controller.closePopup();
    }
}
