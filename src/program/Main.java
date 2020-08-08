package program;

import controller.IMainController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.Login.LoginFXController;
import view.MainMenu.MainMenuFXController;
import view.SwitchView;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        try {
            FXMLLoader chargerFXML = new FXMLLoader (getClass().getResource("/view/Login/Login.fxml"));
            IMainController control = new MainController(new SwitchView(primaryStage));
            LoginFXController FXMLControl = new LoginFXController(control);

            chargerFXML.setController(FXMLControl);
            root = chargerFXML.load();

            primaryStage.setTitle("Titres-services électroniques");
            primaryStage.getIcons().add(new Image("@../../img/logo.jpg"));
            Scene scene = new Scene(root,800,600);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch(IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[]args) {
        launch(args);
    }
}
