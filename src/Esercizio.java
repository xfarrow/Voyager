public class Esercizio {
	protected int id;
	protected String denominazione;
	protected String descrizione;
	protected String tipologia;
	protected String telefono;
	protected String email;
	protected String sitoWeb;
	protected String proprietario;
	protected int idIndirizzo;
	
	public Esercizio() {};
	
	public Esercizio(Esercizio e) {
		denominazione = e.getDenominazione();
		descrizione = e.getDescrizione();
		tipologia = e.getTipologia();
		telefono = e.getTelefono();
		email = e.getEmail();
		sitoWeb = e.getSitoWeb();
		proprietario = e.getProprietario();
		idIndirizzo = e.getIdIndirizzo();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSitoWeb() {
		return sitoWeb;
	}
	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public int getIdIndirizzo() {
		return idIndirizzo;
	}
	public void setIdIndirizzo(int idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}
	
}
