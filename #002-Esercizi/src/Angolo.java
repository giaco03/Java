
public class Angolo {

	private int gradi;
	private int primi;
	private int secondi;
	
	public Angolo(int gradi,  int primi, int secondi) {
		this.gradi=gradi;
		this.primi=primi;
		this.secondi=secondi;
	}
	public String toString(int gradi, int primi, int secondi) {
		String view;
		view="%d°%d'%d\"";
		return view;
	}
	
	 public int getGradi() {
		 return gradi;
	 }
	 public void setGradi(int gradi) {
		 this.gradi=gradi;
	 }
	 public int getPrimi() {
		 return primi;
	 }
	 public void setPrimi(int primi) {
		 this.primi=primi;
	 }
	public int getSecondi() {
		return secondi;
	}
	public void setSecondi(int secondi) {
		this.secondi=secondi;
	}
	
	
	
	
	
	public int aggiungiGradi(){
		a.getGradi()=this.gradi+n;
	}
	public int aggiungiPrimi(){
		a.getPrimi()=this.primi+n;
	}
	public int aggiungiSecondi(){
		a.getSecondi()=this.secondi+n;
	}
	
	
}
