package sample;

public class Partita {
    public static void nuova() {
        Giocatore[] pl = new Giocatore[2];
        Personaggio[] pg = new Personaggio[10];
        int[] usati = new int[10];
        int arrivati = 0;

        pg[0] = new Personaggio("Brodo", 4, 5);
        pg[1] = new Personaggio("Bulbo", 4, 8);
        pg[2] = new Personaggio("Fandalf", 10, 10);
        pg[3] = new Personaggio("Rollum", 7, 8);
        pg[4] = new Personaggio("Legoland", 8, 8);
        pg[5] = new Personaggio("Faruman", 8, 10);
        pg[6] = new Personaggio("Mauron", 9, 10);
        pg[7] = new Personaggio("Garbalbero", 7, 10);
        pg[8] = new Personaggio("Gerry", 5, 6);
        pg[9] = new Personaggio("Tipino", 5, 5);


        pl[0] = new Giocatore(ConsoleInput.readline("inserire nome Giocatore 1"), 0, 5);
        pl[1] = new Giocatore(ConsoleInput.readline("inserire nome Giocatore 2"), 0, 5);


        pl[0].setPg(pg[0], 0);//"random"
        pl[1].setPg(pg[1], 0);//"random"
        usati[0] = 1;

        pl[0].setPg(pg[2], 1);//"random"
        pl[1].setPg(pg[3], 1);//"random"
        usati[1] = 1;
        arrivati = 1;

        int ret = 0, app = 0;

        for (int i = 0; i < 3; i++) {
            do {
                ret = 0;
                app = ConsoleInput.readInt("inserire personaggio da giocare");//pointe exp da correggere
                if (app >= 0 && app < 5 && usati[app] == 0) {
                    ret = 1;
                    usati[app] = 1;
                } else {
                    System.out.println("\nERRORE NUMERO GIA INSERITO");
                }
            } while (ret == 0);

            pl[0].setPunt(pl[0].getPg(app).sfida(pl[1].getPg(app)));
            pl[1].setPunt(pl[1].getPg(app).sfida(pl[0].getPg(app)));
            //pl[0].setPg(pg[RANDOM COMPRESO TRA ARRIVATI E 5],i+1);
            //arrivati++;s
        }

        if (pl[0].getPunt() > pl[1].getPunt()) {
            System.out.println(pl[0].toString() + " vince e " + pl[1].toString() + "perde");
        } else if (pl[0].getPunt() < pl[1].getPunt()) {
            System.out.println(pl[1].toString() + " vince e " + pl[0].toString() + "perde");
        } else {
            System.out.println(pl[0].toString() + " e " + pl[1].toString() + " sono in parità");
        }
    }
}
