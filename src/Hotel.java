
public class Hotel {
	private boolean ristorante;
	private int stelle;
	private String pensione;
	
	public Hotel() {};
	
	public Hotel (Hotel h) {
		ristorante = h.getRistorante();
		stelle = h.getStelle();
		pensione = h.getPensione();
	}
	
	public boolean getRistorante() {
		return ristorante;
	}
	public void setRistorante(boolean ristorante) {
		this.ristorante = ristorante;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		if(stelle>=1 && stelle<=5)
			this.stelle = stelle;
		else
			this.stelle=-1;
	}
	public String getPensione() {
		return pensione;
	}
	public void setPensione(String pensione) {
		this.pensione = pensione;
	}
	
}
