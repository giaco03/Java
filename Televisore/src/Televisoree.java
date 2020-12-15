
public class Televisoree {
	
//attributi caratteristiche apparecchio
	private int pollici;
	private String schermo;
	private String colore;
	//attributi stato apparecchio
	private int canale;
	private int volume;
	private int luminosità;
	private boolean acceso;
	//costruttore
	
	public Televisoree(int pollici, String schermo, String colore, int volume, int canale, int luminosita) {
		this.pollici = pollici;
		this.schermo = schermo;
		this.colore = colore;
		canale = 1;
		volume = 10;
		luminosità = 40;
		acceso = false;
		
		
	}
	
	
	
}
