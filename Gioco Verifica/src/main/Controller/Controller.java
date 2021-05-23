package main.Controller;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;

import main.Model.Partita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;



public class Controller {
    @FXML
    public ImageView card1;

    public Label turn;

    public Label result;

    public ImageView card2;

    public Button go;
    public Label infoc1;
    public Label infoc2;
    public AnchorPane anchorpan;
    public ImageView deck;
    Partita p;
    //Ho inserito delle immagini dentro il package Controller perchè altrimenti avrebbe fallito a trovare l'url
    @FXML private void initialize() {
        //Comincia la partita,inizializza la scena
        p = new Partita();
        refresh();
        refresh();
        deck.setImage(new Image("/main/Controller/deck.jpg"));
        //anchorpan.setBackground(new Background(""));
    }
    //Azione eseguita quando viene premuto il pulsante,Da output all'utente sull'esito della battaglia
    public void goNext(ActionEvent actionEvent) {
        if(result.getText().contains("La partita è")) {
           result.setText(result.getText()+(result.getText().contains("La partita è già") ? "" :"\nLa partita è già finita!"));
        }
        else {
            //Output quando la partita finisce
            String output = p.goNextTurn();
            if (output.equals("")) {
                result.setText("La partita è finita.\n" + (p.calculateWinner() == 0 ? "Vincono entrambi i giocatori per pareggio!" +
                        "\nP1: " + p.getGiocatore(0).getPunt() + "\tP2: " + p.getGiocatore(1).getPunt() : "Vince il giocatore"
                        + (p.calculateWinner() > 0 ? " 1" : " 2") + " con " + Math.abs(p.calculateWinner()) + " pt. di differenza!"));
                deck.setImage(new Image("/main/Controller/white.png"));
            } else {
                //Output nel caso in cui la partita non sia finita
                result.setText(output);
                result.autosize();
            }

            refresh();
        }
    }


    public void refresh(){
        //Aggiorna le immagini e le informazioni sullo schermo
        card1.setImage(p.getPCard(0).getImage());
        card2.setImage(p.getPCard(1).getImage());
        infoc1.setText("Giocatore 1:\nCard:"+p.getPCard(0).getP().toString()+"\nPunti: "+ p.getGiocatore(0).getPunt());
        infoc2.setText("Giocatore 2:\nCard:"+p.getPCard(1).getP().toString()+"\nPunti: "+ p.getGiocatore(1).getPunt());
        turn.setText("Turn: "+p.getTurn());

    }


}
