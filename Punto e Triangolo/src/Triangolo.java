
public class Triangolo {

    private Punto a;
    private Punto b;
    private Punto c;


    public Triangolo(Punto a, Punto b, Punto c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Punto getA() {
        return a;
    }
    public void setA(Punto a) {
        this.a = a;
    }
    public Punto getB() {
        return b;
    }
    public void setB(Punto b) {
        this.b = b;
    }
    public Punto getC() {
        return c;
    }
    public void setC(Punto c) {
        this.c = c;
    }
    @Override
    public String toString() {
        return "Triangolo [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

    public double area() {
        return (a.distanza(b)*a.distanza(c))/2;
        //return  ((Math.abs(a.getX()) * Math.abs(b.getY())) + (Math.abs(a.getY()) * Math.abs(c.getX())) + (Math.abs(b.getX()) * Math.abs(c.getY())) - (Math.abs(c.getX()) * Math.abs(b.getY())) - (Math.abs(c.getY()) * Math.abs(a.getX())) - (Math.abs(b.getX())* Math.abs(a.getY()))) /2;
    }

    public double perimetro() {
        return a.distanza(b)+b.distanza(c)+a.distanza(c);
    }

    private boolean controllaTriangolo() {

        if((c.getY() - a.getY()) /(b.getY()-a.getY()) == (c.getX() - a.getX()) /(b.getX()-a.getX())){
            return true;
        }
        else{
            return false;
        }
    }








}
