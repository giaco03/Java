package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;



public class Partita implements Serializable,Savable {
    private Giocatore p1;
    private Giocatore p2;
    private int endTurn;
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

        //while(true) , il gioco finisce quando uno dei due player perde tutti i personaggi
        int scelta = -1;
        while (scelta != 5) {
        System.out.println("\nTurno -> "+contTurno+" <-");
        System.out.println();
        if(contTurno == endTurn){
            System.out.println("Fine partita.\nVince il giocatore "+(p1.remainingWarriors() == p2.remainingWarriors() ? "1 e 2" : p1.remainingWarriors() > p2.remainingWarriors() ? "1" : "2" )+"\n");
            break;
        }
        if(contTurno % pauseFase == 0){
            //fase di "pausa"
            //variabile utile
            int countdown = 2;
            ConsoleInput.slowPrint("Fase di Pausa.",1000);

            int scelt;
            while (countdown != 0){
                System.out.println("\nGiocatore "+ (p1Turn ? "1" : "2") +" scegli la tua mossa.\n1) Compra personaggi\n" +
                                "2) Potenzia personaggi.\n3) Passa il turno.\n"+"Oro rimanente -> "+(p1Turn ? p1 : p2).getGold());
                scelt = ConsoleInput.readInt("Scelta -> ");
                //Facile controllo per vedere se il giocatore di turno ha almeno 2 oro
                scelt = ((p1Turn ? p1 : p2).getGold() > 1 ? scelt : 3 );
                switch (scelt){
                    case 1 ->{
                        ArrayList<Warrior> shop = (p1Turn ? p1 : p2).shop();
                        Warrior w = (p1Turn ? p1 : p2).selectShop(shop);
                        if(w != null){
                            matrix.addToFirstEmpty(w, (p1Turn ? p1 : p2), p1Turn);
                            p1Turn = !p1Turn;
                            countdown--;
                        }
                    }
                    case 2 ->{
                        Warrior w = (p1Turn ? p1 : p2).selectCharacter();
                        if(w != null) {
                            Pair where = matrix.getCoordinates(w);
                            int fbefore = w.getForce();
                            System.out.println("\n"+(w instanceof Character ? ((Character) w).getRace() : ((Hero) w).getName())+" potenziato con successo !\nExp : "+w.getExp()+" -> "+w.addExp(1)+"\nForza  : "+fbefore+" -> "+w.getForce());
                            w.updateForce();
                            matrix.setWarrior(where.getDue(), where.getUno(), w);
                        }
                    }
                    case 3 ->{
                        p1Turn = !p1Turn;
                        countdown--;
                    }
                    default -> System.out.println("Scelta non valida :/\n");
                }

            }


            contTurno++;
        }
        else {
                matrix.stampaMatrice(!p1Turn);
                scelta = ConsoleInput.readInt("\n"+((p1Turn ? p1 : p2).getCooldown() != 0 ?  "\nCooldown abilità ->"+(p1Turn ? p1 : p2).getCooldown()+"\n" : "\n")
                        +"Giocatore "+ (p1Turn ? "1" : "2") +" scegli la tua mossa.\n1) Muovi personaggio\n" +
                        "2) Attiva Abilità speciale Eroe.\n3) Info su un personaggio\n4) Passa il turno.\n5) Esci e salva.\nScelta -> ");
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
                                        matrix.updateALL();
                                        p1.updateALL();
                                        p2.updateALL();
                                        p1Turn = !p1Turn;
                                        contTurno++;
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
                                        case 2 -> System.out.println("");
                                        case 3 -> nEnd = false;
                                        default -> System.out.println("Scelta non valida :/\n");
                                    }
                                }
                               }
                            else {
                                System.out.println("Direzione non valida :/\n");
                            }
                         }

                    }
                    case 2 -> {
                        int index = (p1Turn ? p1 : p2).useAbility();
                        if( index != -1){
                           Hero h = (p1Turn ? p1 : p2).getHero(index);
                           abilities(h);
                        }
                    }
                    case 3 ->{
                        int j;
                        System.out.println((p1Turn ? p1 : p2).stampaAlleati(true)+(p1Turn ? p2 : p1).stampaAlleati(false));
                        do{
                            j = ConsoleInput.readInt("Inserisci il valore negativo se vuoi vedere i personaggi avversari\nInserisci l'indice -> ");
                            if(j > 0 && (p1Turn && j <= p1.size() || !p1Turn && j <= p2.size())){
                                j--;
                                ConsoleInput.slowPrint((p1Turn ? p1 : p2).getWarrior(j).toString(),1700);
                                break;
                            }
                            if(j < 0 && (p1Turn && j >= -p1.size() || !p1Turn && j >= -p2.size())){
                                j = Math.abs(j);
                                j--;
                                ConsoleInput.slowPrint((p1Turn ? p2 : p1).getWarrior(j).toString(),1700);
                                break;
                            }
                            else {
                                System.out.println("Valore inserito errato.\n");
                            }

                        } while (true);
                    }
                    case 4 -> {
                        contTurno++;
                        matrix.updateALL();
                        p1.updateALL();
                        p2.updateALL();

                        p1Turn = !p1Turn;
                    }
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

    private void abilities(Hero h) {
        boolean hp1 = p1.isHere(h);
        switch (h.getSpecialAbility()){
            case "Maledizione dell'Occhio" ->{
                matrix.effect(h,0.5);
                (hp1 ? p2 : p1).effect(h,0.5);
                ConsoleInput.slowPrint(" - Tutti i nemici sono stati maledetti !\n - Per questo turno avranno forza ridotta e gli eroi nemici avranno 1 punto vita in meno!",600);
            }
            case "Il mio Tesssoro" ->{
                (hp1 ? p1 : p2).addGold((hp1 ? p1 : p2).getGold());
                ConsoleInput.slowPrint(" - Gollum ti offre il suo tesoro !\n - Il tuo oro sarà raddoppiato !",600);
            }
            case "Benedizione della Compagnia" ->{
                matrix.effect(h,2);
                (hp1 ? p1 : p2).effect(h,2);
                ConsoleInput.slowPrint(" - Tutti gli alleati sono stati benedetti !\n - Per questo turno avranno forza doppia !",600);
            }
            case "Allenamento dei Re" ->{
                matrix.allenamento(h);
                (hp1 ? p1 : p2).allenamento(h);
                ConsoleInput.slowPrint(" - I tuoi guerrieri si sono allenati duramente e hanno ottenuto 2 punti esperienza in piu!",600);

            }
        }
    }


    private boolean sposta(Movement m){ // x e y = verso dove; il Pair invece sono le coordinate nella matriced del Personaggio
        int currentX = m.getCoordinates().getUno();
        int currentY = m.getCoordinates().getDue();
        int yTOGO = currentY + m.getY();
        int xTOGO = currentX + m.getX();
        if(yTOGO >= matrix.size() || yTOGO < 0 || xTOGO >= matrix.size() || xTOGO < 0) {
            System.out.println("Non puoi andare in questa direzione !");
            return false;
        }
        //controllo se la casella dove si vuole spostare è vuota
        if(matrix.getWarrior(yTOGO,xTOGO) == null){
            matrix.setWarrior(yTOGO,xTOGO, matrix.getWarrior(currentY,currentX));
            matrix.setWarrior(currentY,currentX,null);
            return true;
        }
        //Scambia personaggi se alleati
        if(matrix.getWarrior(yTOGO,xTOGO).getFaction().equals(matrix.getWarrior(currentY,currentX).getFaction())){
            System.out.println("Scambio i due personaggi..\n");
            Warrior w = matrix.getWarrior(yTOGO,xTOGO);
            matrix.setWarrior(yTOGO,xTOGO,matrix.getWarrior(currentY,currentX));
            matrix.setWarrior(currentY,currentX,w);
            (p1Turn ? p1 : p2).scambia(xTOGO,currentX);
            return true;
        }
        Warrior w1 = matrix.getWarrior(currentY,currentX);
        Warrior w2 = matrix.getWarrior(yTOGO,xTOGO);
        int dmg;
        //Scontro dove il personaggio 1 è piu forte del secondo personaggio
        //I punti esperienza possono andare oltre i 10 se ottenuti tramite potenziamenti o tramite battaglia
        //Se si sconfigge un ereo nemico si guadagna ben 4 punti esperienza altrimenti 1
        if(w1.getForce() > w2.getForce()){
            dmg = dmgCalculation(w1,w2,true);
            //Scenario dove il secondo personaggio viene ucciso sul colpo indipendentemente se è un Eroe o un Personaggio
            if(w2 instanceof Character || w2 instanceof Hero && dmg >= ((Hero) w2).getEnergy()) {
                (p1.isHere(w1) ? p1 : p2).addGold(w2.getForce() / 8);
                int f = w1.getForce();
                ConsoleInput.slowPrint(" - Nemico sconfitto, Resoconto:\n - Oro guadagnato -> " + w2.getForce() / 10 + "\n - Crescita di "
                        + (w1 instanceof Character ? ((Character) w1).getRace() : ((Hero) w1).getName()) + ": "
                        + "\n - Esperienza guadagnata : " + w1.getExp() + " -> " + w1.addExp((w2 instanceof Hero ? 4 : 1)) + "\n - Forza guadagnata : " + f + " -> " + w1.getForce(),1000);
                w1.updateForce();
                (p1.isHere(w1) ? p2 : p1).rimuovi(w2);
                matrix.setWarrior(yTOGO, xTOGO, matrix.getWarrior(currentY, currentX));
                matrix.setWarrior(currentY, currentX, null);
                return true;
            }
            //Scenario dove il secondo eroe
            if(dmg < ((Hero) w2).getEnergy() ){
                (p1.isHere(w1) ? p1 : p2).addGold(w2.getForce() / 8);
                int f = w1.getForce();
                ((Hero) w2).decreaseEnergy(dmg);
                ConsoleInput.slowPrint(" - Durante la battaglia "+(w1 instanceof Character ? ((Character) w1).getRace() : ((Hero) w1).getName())+
                            " è riuscito ad infliggere danni al nemico ma non ad ucciderlo, Resoconto:\n - Crescita di "
                            + (w1 instanceof Character ? ((Character) w1).getRace() : ((Hero) w1).getName()) + ": "
                            + "\n - Esperienza guadagnata : " + w1.getExp() + " -> " + w1.addExp(1) + "\n - Forza guadagnata : " + f + " -> " + w1.getForce(),1000);
                w1.updateForce();
                }
            }
            //Scenario dove è piu debole
            if(w1.getForce() < w2.getForce()){
                dmg = dmgCalculation(w1,w2,false);
                if(w1 instanceof Character || w1 instanceof Hero && dmg >= ((Hero) w2).getEnergy()) {
                    (p1.isHere(w1) ? p2 : p1 ).addGold(w1.getForce() / 8);
                    ConsoleInput.slowPrint(" - "+(w1 instanceof Character ? ((Character) w1).getRace() : ((Hero) w1).getName())+" alleato sconfitto da "
                            +(w2 instanceof Character ? ((Character) w2).getRace() : ((Hero) w2).getName())+" nemico.\n - Differenza di forza :"+(w2.getForce()- w1.getForce()),1000);
                    (p1.isHere(w1) ? p1 : p2).rimuovi(w1);

                    matrix.setWarrior(currentY, currentX, null);
                    return true;
                }
                //Scenario dove l'eroe che attacca ha forza minore e non viene ucciso immediatamente
                if(dmg < ((Hero) w1).getEnergy() ){
                    (p1.isHere(w1) ? p2 : p1).addGold(w1.getForce() - (w1.getForce()*90) /100);
                    int f = w1.getForce();
                    ((Hero) w1).decreaseEnergy(dmg);
                    ConsoleInput.slowPrint(" - Durante la battaglia "+ ((Hero) w1).getName() +
                            " è riuscito a sopravvivere ma con gravi ferite, Resoconto:\n - Danni subiti ->  "
                            + dmg + "\n - Forza persa : " + f + " -> " + w1.getForce(),1000);
                    w1.updateForce();
                }
            }
            //Scenario dove le forze dei personaggi sono uguali
            else {
                ConsoleInput.slowPrint(" - Le forze dei guerrieri si eguagliano!\n - " + (w1 instanceof Character ? ((Character) w1).getRace() : ((Hero) w1).getClass())+ " e " +
                        (w2 instanceof Character ? ((Character) w2).getRace() : ((Hero) w2).getClass())+" hanno combattuto entrambi fino alla morte.\nOro guadagnato -> "+w2.getForce()/10 ,1000);
                p1.addGold(w2.getForce()/10);
                p2.addGold(w2.getForce()/10);
                (p1.isHere(w1) ? p1 : p2).rimuovi(w1);
                (p1.isHere(w2) ? p1 : p2).rimuovi(w2);
                matrix.setWarrior(currentY,currentX,null);
                matrix.setWarrior(yTOGO,xTOGO,null);
                return true;
            }
        return true;
    }
    //Prende due guerrieri in input e un boolean per determinare se uno dei guerrieri sta vincendo(semplifica il codice)
    //Devo calcolare se uno dei due è un eroe e quindi applicare la riduzione del 99 percento
    //Se invece combattono un eroe e un personaggio viene calcolato il danno inflitto
    public int dmgCalculation(Warrior w1, Warrior w2, boolean w1Stronger){
        int dmg = 1;
        if(w1 instanceof Hero && w2 instanceof Hero){
            dmg += (w1Stronger ? w1 : w2).getForce() - ((w1Stronger ? w1 : w2).getForce()*99)/100;
        }
        if((w1Stronger ? w2 : w1) instanceof Hero && (w1Stronger ? w1 : w2) instanceof Character){
            dmg += (w1Stronger ? w1 : w2).getForce() - ((w1Stronger ? w1 : w2).getForce()*95)/100;
        }
        return dmg;
    }
    //Ritorna le coordinate del personaggio selezionato
    public Pair selection(){
        int index;
        do {
            System.out.print((p1Turn ? p1 : p2).stampaAlleati(true));
            index = ConsoleInput.readInt("Inserisci l'indice del personaggio da muovere -> ");
            index--;
        } while ((p1Turn ? p1 : p2).getWarrior(index) == null);
        Pair coordinates = matrix.getCoordinates((p1Turn ? p1 : p2).getWarrior(index));
        if(coordinates.getBoth().equals(new Pair(-1,-1))) return null;
        return coordinates;
    }
    
    public static class Movement{
        private char muovi;
        private int x;
        private int y;
        private Pair coordinates;


        public Movement() {
            x = -1;
            y = -1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public char getMuovi() {
            return muovi;
        }

        public Pair getCoordinates() {
            return coordinates;
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
                        x = -1;
                        y = 0;
                    }
                    case 'D' -> {
                        x = 1;
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
