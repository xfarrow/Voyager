import java.util.ArrayList;
import java.sql.Connection;

public class Controller {
	ConnessioneDatabase gestisciConnessione;
	Connection connection;
	Homepage frameHomepage;
	ListaEsercizi visualizzaListaEsercizi;
	Esercizio_DAO DAOEsercizio;
	Recensione_DAO DAORecensione;
	InserisciRecensione frameRecensione;
	Persona current_user;
	Iscrizione frameIscrizione;
	Login frameLogin;
	Profilo frameProfilo;
	Utente_DAO DAOUtente;
	InserisciEsercizio frameInserisciEsercizio;
	InserisciIndirizzo frameInserisciIndirizzo;
	Indirizzo_DAO DAOIndirizzo;
	InserisciPuntoRistoro InserisciPuntoRistoroframe;
	InserisciPizzeria inserisciPizzeriaFrame;
	InserisciBraceria inserisciBraceriaFrame;
	InserisciPub inserisciPubFrame;
	InserisciAlloggio inserisciAlloggioFrame;
	InserisciHotel inserisciHotelFrame;
	InserisciBedAndBreakfast inserisciBedAndBreakfastFrame;
	InserisciCasa inserisciCasaFrame;
	InserisciAttrazione inserisciAttrazioneFrame;
	InserisciMuseo inserisciMuseoFrame;
	InserisciParco inserisciParcoFrame;
	InserisciLocale inserisciLocaleFrame;
	PaginaEsercizio paginaEsercizioFrame;
	
	int ultimoIDEsercizioInserito;
	int ultimoID_IndirizzoInserito;
	int id_recensione;
	
	public static void main(String[] args) {
		Controller TheController = new Controller();
		
		TheController.inizializza();
		
		TheController.frameHomepage = new Homepage(TheController);
		TheController.frameHomepage.setVisible(true);
	}
	
	private void inizializza() {
		gestisciConnessione = new ConnessioneDatabase();
		connection = gestisciConnessione.connetti();
		current_user = new Persona();
		DAOUtente = new Utente_DAO();
		DAOEsercizio = new Esercizio_DAO();
		DAOIndirizzo = new Indirizzo_DAO();
		DAORecensione = new Recensione_DAO();
	}
	
	Persona getCurrentUser() {
		return current_user;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	public void loginFrame() {
		frameLogin = new Login(this);
		frameLogin.setVisible(true);
	}
	
	public void accedi(String username, String password) {		
		//Rimuovi spazi bianchi
		username = String.valueOf(username.replaceAll("\\s+",""));
		password = String.valueOf(password.replaceAll("\\s+",""));
		
		if(username.isBlank() || password.isBlank()) {
			showErrorFrame("Compilare tutti i campi!");
		} else {
			Persona p = DAOUtente.accedi(this, username, password);
		
			if(p==null) {
				showErrorFrame("Username o Password errati!");
			}else {
				current_user.setUsername(p.getUsername());
				current_user.setNome(p.getNome());
				current_user.setCognome(p.getCognome());
				current_user.setCittaDiProvenienza(p.getCittaDiProvenienza());
				System.out.println(current_user.getUsername()+" loggato");
				frameLogin.setVisible(false);
				frameHomepage.isLoggedUpdate(username);
			}
		}
	}
	
	boolean checkSeSonoLoggato() {
		if(current_user.getUsername()==null) return false;
		else return true;
	}
	
	public void iscriviFrame() {
		frameIscrizione = new Iscrizione(this);
		frameIscrizione.setVisible(true);
	}


	public void iscriviPersona(Persona utenteDaIscrivere) {
		if(utenteDaIscrivere.getUsername().isBlank() || utenteDaIscrivere.getNome().isBlank() || utenteDaIscrivere.getCognome().isBlank() || utenteDaIscrivere.getPassword().isBlank() || utenteDaIscrivere.getCittaDiProvenienza().isBlank()) {
			showErrorFrame("Impossibile iscrivere.");
		}else {	
			DAOUtente.iscrivi(this,utenteDaIscrivere);
			frameIscrizione.setVisible(false);
		}
	}
	
	public void apriProfilo() {
		if(checkSeSonoLoggato()) {
			frameProfilo = new Profilo(this);
			frameProfilo.setVisible(true);
		}else {
			System.out.println("Non sei loggato");
		}
	}
	
	/*
	 * METODI RECENSIONI
	 */
	
	//Rende visibile il frame delle Recensioni
	public void recensioneFrame(Esercizio esercizio) {
		frameRecensione = new InserisciRecensione(esercizio, this);
		frameRecensione.setVisible(true);
	}
	
	//Inserimento Recensione
	public void inserisciRecensione(Recensione recensione) {
		id_recensione = DAORecensione.inserisciRecensione(this, recensione);
	}
	
	public void inserisciRecensione(RecensioneRistorante recensioneRistoranteSpeciale) {
		id_recensione = DAORecensione.inserisciRecensione(this, (Recensione)recensioneRistoranteSpeciale);
		DAORecensione.inserisciRecensione(this,recensioneRistoranteSpeciale,id_recensione);
	}
	
	public void inserisciRecensione(RecensioneAlloggio recensioneAlloggioSpeciale) {
		id_recensione = DAORecensione.inserisciRecensione(this, (Recensione)recensioneAlloggioSpeciale);
		DAORecensione.inserisciRecensione(this,recensioneAlloggioSpeciale,id_recensione);
	}
	
	
	
	public boolean checkReviewAlreadyExists(String username, int id_esercizio) {
		boolean exists = DAORecensione.checkReviewAlreadyExists(this, username, id_esercizio);
		return exists;
	}
	//Metodo per la visualizzazione di Recensioni
	public ArrayList<Recensione> visualizzaRecensioni(Esercizio esercizio) {
		ArrayList<Recensione> listaRecensioni = DAORecensione.getRecensioni(this, esercizio);
		
		return listaRecensioni;
	}
	public String getLastReviewTitle(Esercizio esercizio) {
		String titolo = DAORecensione.getLastReviewTitle(this, esercizio);
		return titolo;
	}
	/*
	 *  METODI MENU VISUALIZZAZIONE ESERCIZI COMMERCIALI
	 */
	public void visualizzaEsercizi(String tipologia, String localita) {
		ArrayList<Esercizio> listaEsercizi = DAOEsercizio.getEsercizi(this, tipologia, localita);
		visualizzaListaEsercizi = new ListaEsercizi(this, listaEsercizi);
		visualizzaListaEsercizi.setVisible(true);
	}
	
	//Ritorna un indirizzo in forma Via nome_via,civico Città(Provincia)
	public String getIndirizzoString(int id) {
		String indirizzo = DAOIndirizzo.getIndirizzoString(this, id);
		return indirizzo;
	}
	
	public void visualizzaPaginaEsercizio(Esercizio esercizio) {
		paginaEsercizioFrame = new PaginaEsercizio(this,esercizio);
		paginaEsercizioFrame.setVisible(true);
		paginaEsercizioFrame.isLoggedUpdate(current_user.getUsername());
	}
	
	public ArrayList<String> getValutazioniEsercizio(int id) {
		ArrayList<String> valutazioniEsercizio = DAOEsercizio.getValutazioniComplessive(this, id);
		return valutazioniEsercizio;
	}
	
	public int getValutazioneSpeciale_1_Value(Esercizio esercizio) {
		int value = 0;
		value = DAOEsercizio.getValutazioneSpeciale_1_Value(this, esercizio);
		return value;
	}
	
	public int getValutazioneSpeciale_2_Value(Esercizio esercizio) {
		int value = 0;
		value = DAOEsercizio.getValutazioneSpeciale_2_Value(this, esercizio);
		return value;
	}
	
	public int getValutazioneSpeciale_3_Value(Esercizio esercizio) {
		int value = 0;
		value = DAOEsercizio.getValutazioneSpeciale_3_Value(this, esercizio);
		return value;
	}
	
	public String getSubCategoryString(int id, String tipologiaEsercizio) {
		String subCategoryString = DAOEsercizio.getSubCategoryString(this, id, tipologiaEsercizio);
		return subCategoryString;
	}
	
	public PuntoRistoro getPuntoRistoroById(int id) {
		PuntoRistoro newPuntoRistoro = DAOEsercizio.getPuntoRistoroById(this, id);
		return newPuntoRistoro;
	}
	
	public Pizzeria getPizzeriaById(int id) {
		Pizzeria newPizzeria = DAOEsercizio.getPizzeriaById(this,id);
		return newPizzeria;
	}
	
	public Pub getPubById(int id) {
		Pub newPub = DAOEsercizio.getPubById(this,id);
		return newPub;
	}
	
	public Braceria getBraceriaById(int id) {
		Braceria newBraceria = DAOEsercizio.getBraceriaById(this,id);
		return newBraceria;
	}
	
	public Alloggio getAlloggioById(int id) {
		Alloggio newAlloggio = DAOEsercizio.getAlloggioById(this,id);
		return newAlloggio;
	}
	
	public Hotel getHotelById(int id) {
		Hotel newHotel = DAOEsercizio.getHotelById(this,id);
		return newHotel;
	}
	
	public Casa getCasaById(int id) {
		Casa newCasa = DAOEsercizio.getCasaById(this,id);
		return newCasa;
	}
	
	public BedAndBreakfast getBedAndBreakfastById(int id) {
		BedAndBreakfast newBedAndBreakfast = DAOEsercizio.getBedAndBreakfastById(this,id);
		return newBedAndBreakfast;
	}
	
	public Attrazione getAttrazioneById(int id) {
		Attrazione newAttrazione = DAOEsercizio.getAttrazioneById(this,id);
		return newAttrazione;
	}
	
	public Locale getLocaleById(int id) {
		Locale newLocale = DAOEsercizio.getLocaleById(this,id);
		return newLocale;
	}
	
	public Parco getParcoById(int id) {
		Parco newParco = DAOEsercizio.getParcoById(this,id);
		return newParco;
	}
	
	public Museo getMuseoById(int id) {
		Museo newMuseo = DAOEsercizio.getMuseoById(this,id);
		return newMuseo;
	}
	
	
	/*
	 *  FINE METODI VISUALIZZAZIONE ESERCIZI COMMERCIALI
	 */
	
	
	/*
	 *  	METODI DI INSERIMENTO ESERCIZI ALL'
	 *  	
	 *  	INTERNO DEL DATABASE
	 */
	
	public void indirizzo() {
		frameInserisciIndirizzo = new InserisciIndirizzo(this);
		frameInserisciIndirizzo.setVisible(true);
	}
	
	public void inserisciIndirizzo(Indirizzo newIndirizzo) {
		ultimoID_IndirizzoInserito = DAOIndirizzo.setIndirizzo(this,newIndirizzo);
		frameInserisciIndirizzo.setVisible(false);
		inserisciEsercizio();
	}
	
	public void inserisciEsercizio() {
		frameInserisciEsercizio = new InserisciEsercizio(this);
		frameInserisciEsercizio.setVisible(true);
	}
	
	/*
	 *  Questo metodo e' necessario per tutte le specializzazioni di "Esercizio" in quanto
	 *  dovranno conoscere l'identificativo dell'esercizio inserito a cui puntare la 
	 *  propria foreign key.
	 */
	public int getUltimoIdentificativoEsercizioInserito() {
		return ultimoIDEsercizioInserito;
	}
	
	public int getUltimoIdentificativoIndirizzoInserito() {
		return ultimoID_IndirizzoInserito;
	}
	
	/*
	* metodo richiamato dal frame "InserisciEsercizio" per inserire un esercizio 
	* all'interno dal database. Controlla inoltre quale sottoclasse andare a specializzare
	*/
	public void inserisciEsercizio(Esercizio newEsercizio) {
		frameInserisciEsercizio.setVisible(false);
		ultimoIDEsercizioInserito = DAOEsercizio.setEsercizio(this,newEsercizio);
		
		if(newEsercizio.getTipologia().equals("Ristorante")) {
			InserisciPuntoRistoroframe = new InserisciPuntoRistoro(this);
			InserisciPuntoRistoroframe.setVisible(true);
		}else if(newEsercizio.getTipologia().equals("Alloggio")) {
			inserisciAlloggioFrame = new InserisciAlloggio(this);
			inserisciAlloggioFrame.setVisible(true);
		}else if(newEsercizio.getTipologia().equals("Attrazione")){
			inserisciAttrazioneFrame = new InserisciAttrazione(this);
			inserisciAttrazioneFrame.setVisible(true);
		}
		
	}
	
	/*
	 *  Metodo per l'inserimento di un punto ristoro richiamato dal frame
	 *  "InserisciPuntoRistoro". Controlla inoltre quale specializzazione di
	 *  secondo livello livello andare a specializzare.
	 */	
	public void inserisciPuntoRistoro(PuntoRistoro newPuntoRistoro) {
		DAOEsercizio.inserisciPuntoRistoro(this,newPuntoRistoro);
		InserisciPuntoRistoroframe.setVisible(false);
		if(newPuntoRistoro.getPizzeria()) {
			inserisciPizzeriaFrame = new InserisciPizzeria(this);
			inserisciPizzeriaFrame.setVisible(true);
		}
		if(newPuntoRistoro.getBraceria()) {
			inserisciBraceriaFrame = new InserisciBraceria(this);
			inserisciBraceriaFrame.setVisible(true);
		}
		if(newPuntoRistoro.getPub()) {
			inserisciPubFrame = new InserisciPub(this);
			inserisciPubFrame.setVisible(true);
		}
		// Non c'è il controllo del ristorante perchè non ha attributi diversi
		// da puntoRistoro, dunque non ha bisogno di un'interfaccia grafica
	}
	
	//Metodo richiamato dal frame InserisciPizzeria
	public void inserisciPizzeria(Pizzeria newPizzeria) {
		DAOEsercizio.inserisciPizzeria(this,newPizzeria);
		inserisciPizzeriaFrame.setVisible(false);
		
	}
	
	//Metodo richiamato dal frame InserisciBraceria
	public void inserisciBraceria(Braceria newBraceria) {
		DAOEsercizio.inserisciBraceria(this,newBraceria);
		inserisciBraceriaFrame.setVisible(false);
	}
	
	//Metodo richiamato dal frame InserisciPub
	public void inserisciPub(Pub newPub) {
		DAOEsercizio.inserisciPub(this,newPub);
		inserisciPubFrame.setVisible(false);
	}
	
	
	/*
	 *  Metodo per l'inserimento di un alloggio richiamato dal frame
	 *  "InserisciAlloggio". Controlla inoltre quale specializzazione di
	 *  secondo livello livello andare a specializzare.
	 */	
	public void inserisciAlloggio(Alloggio newAlloggio) {
		DAOEsercizio.inserisciAlloggio(this,newAlloggio);
		if(newAlloggio.getTipoAlloggio().equals("Hotel")) {
			inserisciHotelFrame = new InserisciHotel(this);
			inserisciHotelFrame.setVisible(true);
		}
		else if(newAlloggio.getTipoAlloggio().equals("BedAndBreakfast")) {
			inserisciBedAndBreakfastFrame = new InserisciBedAndBreakfast(this);
			inserisciBedAndBreakfastFrame.setVisible(true);
		}
		else if(newAlloggio.getTipoAlloggio().equals("Casa")) {
			inserisciCasaFrame = new InserisciCasa(this);
			inserisciCasaFrame.setVisible(true);
		}
		inserisciAlloggioFrame.setVisible(false);
	}
	
	public void inserisciCasa(Casa newCasa) {
		DAOEsercizio.inserisciCasa(this,newCasa);
		inserisciCasaFrame.setVisible(false);
	}
	
	public void inserisciBedAndBreakfast(BedAndBreakfast newBedAndBreakfast) {
		DAOEsercizio.inserisciBedAndBreakfast(this, newBedAndBreakfast);
		inserisciBedAndBreakfastFrame.setVisible(false);
	}
	
	public void inserisciHotel(Hotel newHotel) {
		DAOEsercizio.inserisciHotel(this,newHotel);
		inserisciHotelFrame.setVisible(false);
	}
	
	/*
	 *  Metodo per l'inserimento di un' attrazione richiamato dal frame
	 *  "InserisciAttrazione". Controlla inoltre quale specializzazione di
	 *  secondo livello livello andare a specializzare.
	 */	
	public void inserisciAttrazione(Attrazione newAttrazione) {
		DAOEsercizio.inserisciAttrazione(this,newAttrazione);
		inserisciAttrazioneFrame.setVisible(false);
		
		if(newAttrazione.getTipoAttrazione().equals("Museo")) {
			inserisciMuseoFrame = new InserisciMuseo(this);
			inserisciMuseoFrame.setVisible(true);
		}else if(newAttrazione.getTipoAttrazione().equals("Parco")) {
			inserisciParcoFrame = new InserisciParco(this);
			inserisciParcoFrame.setVisible(true);
		}else if(newAttrazione.getTipoAttrazione().equals("Locale")) {
			inserisciLocaleFrame = new InserisciLocale(this);
			inserisciLocaleFrame.setVisible(true);
		}
		
	}
	
	public void inserisciLocale(Locale newLocale) {
		DAOEsercizio.inserisciLocale(this,newLocale);
		inserisciLocaleFrame.setVisible(false);
	}
	
	public void inserisciParco(Parco newParco) {
		DAOEsercizio.inserisciParco(this,newParco);
		inserisciParcoFrame.setVisible(false);
	}
	
	public void inserisciMuseo(Museo newMuseo) {
		DAOEsercizio.inserisciMuseo(this,newMuseo);
		inserisciMuseoFrame.setVisible(false);
	}
	
	/*
	 *  FINE METODI DI INSERIMENTO
	 *  
	 *  DEGLI ESERCIZI COMMERCIALI ALL'INTERNO DEL
	 *  
	 *  DATABASE
	 * 
	 */
	
	//metodo che controlla se il frame "Login" e' aperto
	public boolean controllaLoginVisibile() {
		if(frameLogin==null || !frameLogin.isVisible()) return false;
		else return true;
	}
	
	//metodo che controlla se il frame "Iscrizione" e' aperto
	public boolean controllaIscrizioneVisibile() {
		if(frameIscrizione == null || !frameIscrizione.isVisible()) return false;
		else return true;
	}
	
	public boolean controllaProfiloVisibile() {
		if(frameProfilo==null || !frameProfilo.isVisible()) return false;
		else return true;
	}
	/*
	 *  METODI HIDE
	 */
	
	public void hideIscriviFrame() {
		frameIscrizione.setVisible(false);
	}
	
	public void hideLoginFrame() {
		frameLogin.setVisible(false);
	}

	public void hideProfilo() {
		frameProfilo.setVisible(false);
	}
	
	public void hidePaginaListaEsercizi() {
		visualizzaListaEsercizi.setVisible(false);
	}
	
	public void hidePaginaEsercizio() {
		paginaEsercizioFrame.setVisible(false);
	}
	
	public void hidePaginaRecensione() {
		frameRecensione.setVisible(false);
	}
	
	public void showErrorFrame(String error) {
		ErrorView frameError;
		frameError = new ErrorView(this);
		frameError.setVisible(true);
		frameError.errorType(error);
	}
	
	public void hideErrorFrame(ErrorView e) {
		e.setVisible(false);
	}
	/*
	 *  FINE METODI HIDE
	 */
	public int getIdUltimaRecensione() {
		return id_recensione;
	}
	
}
