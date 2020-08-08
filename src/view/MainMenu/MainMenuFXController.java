package view.MainMenu;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utils.StaticLogin;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuFXController implements Initializable {

    private IMainController controller;

    @FXML
    private Button buttonWallet;

    @FXML
    private Button buttonOrders;

    @FXML
    private Button buttonServices;

    public MainMenuFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch (StaticLogin.getUser()) {
            case "prestataire1":
            case "prestataire2":
                buttonWallet.setDisable(true);
                buttonOrders.setDisable(true);
                break;
        }
    }

    @FXML
    public void myWallet(){
        controller.switchView("Wallet");
    }

    @FXML
    public void myOrders(){
        controller.switchView("Orders");
    }

    @FXML
    public void myServices(){
        controller.switchView("Services");
    }

    @FXML
    public void disconnect(){
        controller.switchView("Login");
    }
}
