package view.Contested;

import controller.IMainController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Activity;
import model.IService;
import model.Service;
import utils.StaticPassData;

import java.net.URL;
import java.util.ResourceBundle;

public class ContestedFXController implements Initializable {

    private IMainController controller;

    @FXML
    private ChoiceBox<String> activityBox;

    @FXML
    private Label date;

    @FXML
    private Label name;

    @FXML
    private TextField duration;

    @FXML
    private CheckBox isDone;

    @FXML
    private Button confirmButton;


    public ContestedFXController(IMainController controller){
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activityBox.setItems(FXCollections.observableArrayList(Activity.Nettoyage.toString(), Activity.Repassage.toString(), Activity.Course.toString(), Activity.Transport.toString()));
        activityBox.getSelectionModel().selectFirst();

        System.out.println(StaticPassData.getTheId());

        for(int i=0; i<controller.getListService().size();i++) {
            if (String.valueOf(controller.getListService().get(i).getId()).equals(String.valueOf(StaticPassData.getTheId()+1))) {
                IService current = controller.getListService().get(i);
                date.setText(current.getDate());
                name.setText(current.getNameProvider());
            }
        }
    }

    @FXML
    public void cancel(){
        controller.closePopup();
    }

    @FXML
    public void confirm(){
        controller.getListService().get(StaticPassData.getTheId()).setStatus("Contestée");
        controller.closePopup();
        controller.switchView("Services");
    }
}
