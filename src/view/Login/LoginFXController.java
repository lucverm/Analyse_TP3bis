package view.Login;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.StaticLogin;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFXController implements Initializable {

    private IMainController controller;

    @FXML
    private TextField user;

    @FXML
    private TextField password;

    @FXML
    private Label message;

    public LoginFXController(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void login(){
        for(int i = 0; i< controller.getUsers().size();i++){
            if(!user.getText().isEmpty() && !password.getText().isEmpty()){
                if(controller.isValid(user.getText(),password.getText(),i)){
                    StaticLogin.getLogin(user.getText(),password.getText());
                    controller.switchView("MainMenu");
                }else{
                    message.setText("UTILISATEUR ou/et MOT DE PASSE ne sont pas correct !");
                }
            }else{
                message.setText("UTILISATEUR ou/et MOT DE PASSE ne sont pas correct !");
            }
        }
    }

    public void exit(){
        controller.exit();
    }
}
