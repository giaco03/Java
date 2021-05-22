package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/partita.fxml"));
        primaryStage.setTitle("YuGi-Oh");
        primaryStage.setScene(new Scene(root, 900, 675));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
