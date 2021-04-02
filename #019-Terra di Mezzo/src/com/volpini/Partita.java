package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partita implements Serializable,Savable {
    private Giocatore p1;
    private Giocatore p2;
    private int endTurn = 10;
    private Matrice matrix;
    private int pauseFase;
    private int contTurno;
    private boolean p1Turn = true;
    public Partita(Giocatore p1, Giocatore p2, int endTurn, Matrice matrix, int pauseFase, int contTurno) {
        this.p1 = p1;
        this.p2 = p2;
        this.endTurn = endTurn;
        this.matrix = matrix;
        this.pauseFase = pauseFase;
        this.contTurno = contTurno;
    }
    public void start(){
        System.out.println("!! ATTENZIONE --- Il movimento dei personaggi avviene tramite i tasti WASD --- ATTENZIONE !! ");
        contTurno++;
        //while(true) , il gioco finisce quando uno dei due player perde tutti i personaggi
        System.out.println("\nTurno"+contTurno);
        System.out.println();
        if(contTurno == endTurn){
            System.out.println("Fine turno bro.\n");
        }
        if(contTurno == pauseFase){
            //fase di "pausa"
            System.out.println("Nope.\n");
        }
        else {
            int scelta = -1;
            if(p1Turn) matrix.stampaP1();
            else matrix.stampaP2();

            while (scelta != 5) {
                scelta = ConsoleInput.readInt("\nGiocatore "+ (p1Turn ? "1" : "2") +" scegli la tua mossa.\n1)Muovi personaggio\n" +
                        "2)Attiva Abilità speciale Eroe.\n3)Info su un personaggio\n4)Passa il turno.\n5)Esci e salva.\nScelta -> ");
                switch (scelta) {
                    case 1 -> {
                        Pair index;
                        do {
                            index = selection();
                        }while (index == null);
                        Movement m = new Movement();
                        boolean nEnd = true;
                        while (nEnd) {
                            m.setMuovi(ConsoleInput.readChar("Direzione -> "),p1Turn,index);
                            if (m.getMuovi() == 'W' || m.getMuovi() == 'A' || m.getMuovi() == 'S' || m.getMuovi() == 'D'){
                                char choice = ConsoleInput.readChar("Sei sicuro ? (Y/N) -> ");
                                if(choice == 'Y'){
                                    if(sposta(m)){
                                        nEnd = false;
                                        break;
                                    }
                                    else{
                                        index = selection();
                                    }
                                }
                                if(choice == 'N'){
                                    int cho = ConsoleInput.readInt("\n1)Cambia personaggio\n2)Cambia direzione\n3)Esci\nScelta -> ");
                                    switch (cho){
                                        case 1 -> index = selection();
                                        case 2 -> System.out.println("Bruh");
                                        case 3 -> nEnd = false;
                                        default -> System.out.println("Scelta non valida :/\n");
                                    }
                                }
                                else {
                                    System.out.println("Scelta non valida :/\n");
                                }
                               }
                            else {
                                System.out.println("Direzione non valida :/\n");
                            }
                         }






                        p1Turn = !p1Turn;
                    }
                    case 2 -> {
                        scelta = 3;
                        System.out.println("Not yet implemented :P\n");
                    }
                    case 3 ->{
                        int j;
                        if(p1Turn) System.out.println(p1.stampaGiocatori() + p2.stampaGiocatori());
                        else System.out.println(p2.stampaGiocatori() + p1.stampaGiocatori());
                        do{
                            j = ConsoleInput.readInt("Inserisci il valore negativo se vuoi vedere i personaggi avversari\nInserisci l'indice -> ");
                            if(p1Turn){
                                if(j > 0){
                                    j--;
                                    System.out.println(p1.getWarrior(j).toString());
                                    break;
                                }
                                else {
                                    j = Math.abs(j);
                                    j--;
                                    System.out.println(p2.getWarrior(j).toString());
                                    break;
                                }
                            }
                            else{
                                if(j > 0){
                                    j--;
                                    System.out.println(p2.getWarrior(j).toString());
                                    break;
                                }
                                else {
                                    j = Math.abs(j);
                                    j--;
                                    System.out.println(p1.getWarrior(j).toString());
                                    break;
                                }
                            }

                        } while (true);
                    }
                    case 4 -> p1Turn = !p1Turn;
                    case 5 ->{
                        System.out.println("Sei sicuro ?");
                        char yn = ConsoleInput.readChar("(Y/N) -> ");
                        if(yn != 'Y'){
                            scelta = 6;
                        }
                    }
                    default -> System.out.println("Valore errato.\n");



                }
            }
        }
    }

    public boolean sposta(Movement m){ // x e y = verso dove; il Pair invece sono le coordinate nella matriced del Personaggio
        /*if(m.getX() > 0 && m.getX() < matrix.size() && m.getY() > 0 && m.getY() < matrix.size()){
            if(matrix)
            return true;
        }
        else {
            System.out.println("Il personaggio non si può muovere in questa direzione !");
            return false;
        }

         */
        int currentX = m.getCoordinates().getUno();
        int currentY = m.getCoordinates().getDue();
        int yTOGO = currentY + m.getY();
        int xTOGO = currentX + m.getX();

        //controllo se la casella dove si vuole spostare è vuota
        if (matrix.getWarrior(yTOGO,xTOGO) == null) {
            System.out.println("Non puoi andare in questa direzione !");
            return false;
        }
        if(!matrix.getWarrior(yTOGO,xTOGO).isOccupied()){
            matrix.getRow(yTOGO).set(xTOGO, matrix.getWarrior(currentY,currentX));
            matrix.getRow(currentY).set(currentX, null);
            return true;
        }
        if(matrix.getWarrior(yTOGO,xTOGO).getFaction().equals(matrix.getWarrior(currentY,currentX).getFaction())){
            Warrior w = matrix.getWarrior(yTOGO,xTOGO);
            matrix.getRow(yTOGO).set(xTOGO,matrix.getWarrior(currentY,currentX));
            matrix.getRow(currentY).set(currentX,w);
            
            System.out.println("Scambio i due personaggi..\n");

        }
        else {
           // System.out.println("Nemico sconfitto. Oro = " + (p1Turn ? p1.getGold() : p2.getGold()) + " -> " + (p1Turn ? p1.setGold() : p2.getGold()));
            System.out.println("");
        }
        return true;
    }

    public Pair selection(){
        int index;
        do {
            if(p1Turn) System.out.println(p1.stampaGiocatori());
            else System.out.println(p2.stampaGiocatori());
            index = ConsoleInput.readInt("Inserisci l'indice del personaggio da muovere");
        } while (p1Turn && p1.getWarrior(index) != null || !p1Turn && p2.getWarrior(index) != null);
        Pair coordinates = new Pair(-1,-1);
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.getRow(i).size(); j++){
                if(matrix.getWarrior(i,j).equals(p1.getWarrior(index)) || matrix.getWarrior(i,j).equals(p2.getWarrior(index))){
                    coordinates.setBoth(j,i);
                }
            }
        }
        if(coordinates.getBoth().equals(new Pair(-1,-1))) return null;
        return coordinates;
    }
    public class Movement{
        private char muovi;
        private int x;
        private int y;
        private Pair coordinates;
        private boolean turnop1;
        public Movement(char muovi, boolean p1, Pair coordinates) {
            setMuovi(muovi, p1, coordinates);
        }

        public Movement() {
            x = -1;
            y = -1;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public char getMuovi() {
            return muovi;
        }

        public Pair getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Pair coordinates) {
            this.coordinates = coordinates;
        }

        public void setMuovi(char muovi, boolean p1, Pair coordinates) {
            this.coordinates = coordinates;
            this.muovi = muovi;
            if (p1) {
                switch (muovi) {
                    case 'W' -> {
                        x = 0;
                        y = 1;
                    }
                    case 'A' -> {
                        x = 1;
                        y = 0;
                    }
                    case 'D' -> {
                        x = -1;
                        y = 0;
                    }
                    case 'S' -> {
                        x = 0;
                        y = -1;
                    }
                }
            }
            else {
                switch (muovi) {
                    case 'W' -> {
                        x = 0;
                        y = -1;
                    }
                    case 'A' -> {
                        x = -1;
                        y = 0;
                    }
                    case 'D' -> {
                        x = 1;
                        y = 0;
                    }
                    case 'S' -> {
                        x = 0;
                        y = 1;
                    }
                }
            }
        }
    }


}
