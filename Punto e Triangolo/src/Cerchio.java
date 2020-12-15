public class Cerchio {
    private Punto centro;
    private double raggio;

    public Cerchio(Punto centro, double raggio) {
        this.centro = centro;
        this.raggio = raggio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }
    public double perimetro(){
        return 2 * raggio * Math.PI;
    } public double area(){
        return  Math.pow(raggio,2) * Math.PI;
    }

    private boolean controllaCerchio(){
        if(raggio > 0){
            return true;
        }
        else{
            System.out.println("Il cerchio non è valido");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cerchio{" +
                "centro=" + centro +
                ", raggio=" + raggio +
                '}';
    }
}
