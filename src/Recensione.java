
public class Recensione {
	protected int id;
	protected int esercizioID;
	protected String utente;
	protected String titolo;
	protected String descrizione;
	protected int stelle;
	protected String tipoRecensione;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEsercizioID() {
		return esercizioID;
	}
	public void setEsercizioID(int esercizioID) {
		this.esercizioID = esercizioID;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}
	public String getTipoRecensione() {
		return tipoRecensione;
	}
	public void setTipoRecensione(String tipoRecensione) {
		this.tipoRecensione = tipoRecensione;
	}
	
	
}
