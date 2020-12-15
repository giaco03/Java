
public class Punto {
    //La classe Punto non è il main e serve a descrivere le caratteristiche e i metodi di un punto.
    //Gli attributi in genere sono privati mentre i metodi e i costruttori sono pubblci.

    private double x;
    private double y;

    //costruttori
    public Punto(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public Punto(double x) {
        this.x=x;
    }

    // get e set
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x=x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y=y;
    }


    //toString
    //La concatenazione tra stringhe in Java è semplice : con il + non bisogna preoccuparsi del tipo
    public String toString() {
        String app;
        app="x: "+x+"\ty: "+y;
        return app;

    }
    public double distanza(Punto p){
        return Math.sqrt(((p.x - this.x) * (p.x - this.x)) + ((p.y - this.y) * (p.y - this.y)));

    }

}
