package view.Details;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import utils.SelectDetails;
import utils.StaticPassData;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsFXController implements Initializable {

    private IMainController controller;

    @FXML
    private Label quantity;

    @FXML
    private Label format;

    @FXML
    private Label paymentDate;

    @FXML
    private Label paymentDate2;

    @FXML
    private Label paymentMode;

    @FXML
    private Label idOrder;

    @FXML
    private Label nbrTS;

    @FXML
    private Label totalTS;

    @FXML
    private Label priceTS;

    @FXML
    private Label nbrTSReceived;

    @FXML
    private RadioButton status;

    public DetailsFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SelectDetails details = new SelectDetails(controller,quantity,format,paymentDate,paymentDate2,paymentMode,idOrder,nbrTS,nbrTSReceived,totalTS,priceTS);

        for(int i=0; i<controller.getListOrder().size();i++){
            if(String.valueOf(controller.getListOrder().get(i).getId()).equals(String.valueOf(StaticPassData.getTheId()))){
                if(controller.getListOrder().get(i).getStatus().equals("Reçue")){
                    status.setSelected(true);
                }
                details.setDataDetails(i);
            }
        }
    }
}