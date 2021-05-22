package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    TableView<Student> table;
    Classroom classe;
    TextField nameI,surnameI,ageI,addressI;
    @Override
    public void start(Stage primaryStage) throws Exception{


        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setMinWidth(200);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        TableColumn<Student, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Student, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(200);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("home"));

        nameI = new TextField();
        nameI.setPromptText("Name");

        surnameI = new TextField();
        surnameI.setPromptText("Surname");
        ageI = new TextField();
        ageI.setPromptText("Age");
        addressI = new TextField();
        addressI.setPromptText("Address");
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,surnameColumn,ageColumn,addressColumn);
        Button addBtn = new Button("Add");
        addBtn.setOnAction(actionEvent -> aggiungi());
        Button mdfBtn = new Button("Modify");
        mdfBtn.setOnAction(actionEvent -> modify());
        Button dltBtn = new Button("Delete");
        dltBtn.setOnAction(actionEvent -> rimuovi());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(15);
        hBox.getChildren().addAll(nameI,surnameI,ageI,addressI,addBtn,dltBtn,mdfBtn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);
        Scene scene = new Scene(vBox);

        primaryStage.setTitle("Studenti");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ObservableList<Student> getProduct(){
        ObservableList<Student> classroom = FXCollections.observableArrayList();
        classe = new Classroom();
        classe = (Classroom) classe.loading();
        if( classe.size() == 0) {
            classe.addStudent(new Student("Nome", "Cognome", "Età",
                    "Indirizzo"));
        }
        for (int i = 0; i < classe.size(); i++) {
            classroom.add(classe.getStudent(i));
        }

        return classroom;
    }
    public void modify(){
        ObservableList<Student> studentSelected, allStudents;
        allStudents = table.getItems();
        int index = -1;
        studentSelected = table.getSelectionModel().getSelectedItems();
        Student s = new Student(nameI.getText(),surnameI.getText(),ageI.getText(),addressI.getText());
        for(int i = 0; i < classe.size(); i++){
            if(classe.getStudent(i).equals(studentSelected.get(0))) index = i;
        }
        if(index != -1) {
            classe.setStudent(s, index);
            classe.save();
            table.getItems().set(index,s);
            nameI.clear();
            surnameI.clear();
            ageI.clear();
            addressI.clear();
        }
    }
    public void aggiungi(){
        Student s = new Student(nameI.getText(),surnameI.getText(),ageI.getText(),addressI.getText());
        classe.addStudent(s);
        classe.save();
        table.getItems().add(s);
        nameI.clear();
        surnameI.clear();
        ageI.clear();
        addressI.clear();
    }
    public void rimuovi(){
        if(table.getItems().size() > 0) {
            ObservableList<Student> studentSelected, allStudents;
            allStudents = table.getItems();
            studentSelected = table.getSelectionModel().getSelectedItems();
            for(int i = 0; i < classe.size(); i++){
                if(classe.getStudent(i).equals(studentSelected.get(0))){
                    classe.removeStudent(i);
                    classe.save();
                }
            }
            studentSelected.forEach(allStudents::remove);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
