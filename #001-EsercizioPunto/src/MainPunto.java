
public class MainPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Punto p1,p2;
		p1 =new Punto(0,6);
		p2 =new Punto(0,10);
		System.out.println("Ordinate dei due punti: "+p1.getY()+" "+p2.getY());
		//toString() è un metodo cioè una funzione quindi gli servono le tonde anche se non passo nessuna variabile
	    System.out.println(p1.toString());
	    p2.setY(1);
	    System.out.println(p2.toString());
	 
	    Punto p3=new Punto(12);
	    System.out.println(p3.toString());
	    
	    Triangolo g;
	    g = new Triangolo(p1,p2,p3);
	    System.out.println(g.toString());
	    System.out.println("Area:");
	    System.out.println(g.area());
	    System.out.println("Perimetro");
	    System.out.println(g.perimetro());
	}

}
/*Overloading:
 * I metodi con lo stesso nome devono avere diversi tipi come parametri(si dice con diversa segnatura,cioè con diversa "firma")
 * 
 * 
*/