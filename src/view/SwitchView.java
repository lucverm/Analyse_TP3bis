package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class SwitchView {

    private Stage stage1;
    private Stage stage2;

    public SwitchView(Stage stage) {
        this.stage1 = stage;
    }

    public void loadView(String pathFXML, HashMap<String, Object> controllers) {
        Parent root;
        try {
            Object controller = controllers.get(pathFXML);
            FXMLLoader chargerFXML = new FXMLLoader(getClass().getResource("../view/" + pathFXML +"/" + pathFXML + ".fxml"));
            chargerFXML.setController(controller);
            root = chargerFXML.load();
            stage1.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPopup(String pathFXML, HashMap<String, Object> controllers) {
        Parent rootPopup;
        stage2 = new Stage();
        try {
            Object controller = controllers.get(pathFXML);
            FXMLLoader chargerFXML = new FXMLLoader(getClass().getResource("../view/" + pathFXML +"/" + pathFXML + ".fxml"));
            chargerFXML.setController(controller);
            rootPopup = chargerFXML.load();

            Scene stageScene = new Scene(rootPopup, 400, 550);
            stage2.setTitle(pathFXML);
            stage2.getIcons().add(new Image("@../../img/logo.jpg"));
            stage2.setScene(stageScene);
            stage2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closePopup(){
        stage2.close();
    }
}
