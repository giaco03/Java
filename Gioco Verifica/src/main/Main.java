package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }
    //Override di start stampa informazioni su terminale
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting GUI..");
        Parent root = FXMLLoader.load(getClass().getResource("/main/View/partita.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("yu gi ohhhh");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("Running");

    }
    //Override di stop stampa su terminale
    @Override
    public void stop() throws Exception {
        System.out.println("Closing the GUI\nGoodbye!");
    }
}
