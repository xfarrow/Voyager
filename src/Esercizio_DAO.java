import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Esercizio_DAO {
	
	
	public ArrayList<Esercizio> getEsercizi(Controller controller, String tipologia, String localita){
		
		Connection connection = controller.getConnection();
		
		ArrayList<Esercizio> listaEsercizi = new ArrayList<Esercizio>();
		
		String query = "SELECT * FROM Esercizio JOIN Indirizzo ON Esercizio.id_indirizzo = Indirizzo.id";
		query += " " +"WHERE Esercizio.Tipo = ?::tipoEsercizio AND (Indirizzo.Stato = ? OR Indirizzo.Regione = ? OR Indirizzo.Provincia = ? OR Indirizzo.Citta = ?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, tipologia);
			statement.setString(2, localita);
			statement.setString(3, localita);
			statement.setString(4, localita);
			statement.setString(5, localita);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Esercizio currEsercizio = new Esercizio();
				currEsercizio.setId(rs.getInt(1));
				currEsercizio.setDenominazione(rs.getString(2));
				currEsercizio.setDescrizione(rs.getString(4));
				currEsercizio.setEmail(rs.getString(6));
				currEsercizio.setProprietario(rs.getString(3));
				currEsercizio.setSitoWeb(rs.getString(7));
				currEsercizio.setTelefono(rs.getString(5));
				currEsercizio.setTipologia(tipologia);
				currEsercizio.setIdIndirizzo(rs.getInt(9));
				
				listaEsercizi.add(currEsercizio);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaEsercizi;
	}
	
	public String getSubCategoryString(Controller TheController, int id, String tipologiaEsercizio) {
		ArrayList<String> subCategorie = new ArrayList<String>();
		
		String tipologia = "";
		boolean first = true;
		
		if(tipologiaEsercizio.equals("Ristorante")) {
			
			PuntoRistoro currPuntoRistoro = TheController.getPuntoRistoroById(id);
			
			if(currPuntoRistoro.getRistorante()) {
				subCategorie.add("Ristorante");
			}
			
			if(currPuntoRistoro.getPizzeria()) {
				subCategorie.add("Pizzeria");
			}
			
			if(currPuntoRistoro.getPub()) {
				subCategorie.add("Pub");
			}
			
			if(currPuntoRistoro.getBraceria()) {
				subCategorie.add("Braceria");
			}
		} else if(tipologiaEsercizio.equals("Alloggio")) {
			Alloggio currAlloggio = new Alloggio(TheController.getAlloggioById(id));
			
			if(currAlloggio.getTipoAlloggio().equals("Hotel")) {
				subCategorie.add("Hotel");
			}
			
			if(currAlloggio.getTipoAlloggio().equals("BedAndBreakfast")) {
				subCategorie.add("BedAndBreakfast");
			}
			
			if(currAlloggio.getTipoAlloggio().equals("Casa")) {
				subCategorie.add("Casa");
			}
		} else {
			Attrazione currAttrazione = new Attrazione(TheController.getAttrazioneById(id));
			
			if(currAttrazione.getTipoAttrazione().equals("Locale")) {
				Locale currLocale = new Locale(TheController.getLocaleById(id));
					
				if(currLocale.getDiscoteca()) {
					subCategorie.add("Discoteca");
				}
				
				if(currLocale.getNotturno()) {
					subCategorie.add("Notturno");
				}
				
				if(currLocale.getSalaBallo()) {
					subCategorie.add("Sala da Ballo");
				}
				
				if(currLocale.getSalaEventi()) {
					subCategorie.add("Sala per Eventi");
				}
			} else if(currAttrazione.getTipoAttrazione().equals("Parco")) {
				Parco currParco = new Parco(TheController.getParcoById(id));
				
				subCategorie.add("Parco");
				if(currParco.getDivertimenti()) {
					subCategorie.add("Divertimenti");
				}
				
				if(currParco.getTematico()) {
					subCategorie.add("Tematico");
				}
			} else if(currAttrazione.getTipoAttrazione().equals("Museo")) {
				Museo currMuseo = new Museo(TheController.getMuseoById(id));
				
				subCategorie.add("Museo");
				if(currMuseo.getArcheologico()) {
					subCategorie.add("Archeologico");
				}
				
				if(currMuseo.getArtistico()) {
					subCategorie.add("Artistico");
				}
				
				if(currMuseo.getMarino()) {
					subCategorie.add("Marino");
				}
				
				if(currMuseo.getMilitare()) {
					subCategorie.add("Militare");
				}
				
				if(currMuseo.getNaturale()) {
					subCategorie.add("Naturale");
				}
				
				if(currMuseo.getScientifico()) {
					subCategorie.add("Scientifico");
				}
				
				if(currMuseo.getStorico()) {
					subCategorie.add("Storico");
				}
				
				if(currMuseo.getVirtuale()) {
					subCategorie.add("Virtuale");
				}
			}
		}
		
		for(String category: subCategorie) {
			if(first) {
				tipologia = category;
				first = false;
			} else {
				tipologia = tipologia+" - "+category;
			}				
		}
		
		return tipologia;
	}
	
	public int getValutazioneSpeciale_1_Value(Controller controller, Esercizio esercizio) {
		int count = 0, somma = 0, media = 0;
		Connection connection = controller.getConnection();
		String query;
		
		/*
		 * 		if(tipologia.equals("Ristorante")) {
			query = "SELECT valutazionecucina FROM recensioneristorante;";
		} else {
			query = "SELECT valutazionepulizia FROM recensionealloggio;";
		}
		 */
		
		
		if(esercizio.getTipologia().equals("Ristorante")) {
			query = "SELECT valutazionecucina FROM recensioneristorante AS RR JOIN Recensione AS R ON RR.recensioneid = R.id WHERE R.esercizioid=?;";
		} else {
			query = "SELECT valutazionepulizia FROM recensionealloggio AS RA JOIN Recensione AS R ON RA.recensioneid = R.id WHERE R.esercizioid=?;";
		}
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, esercizio.getId());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				somma += rs.getInt(1);
				count++;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(somma!=0) {
			media = somma/count;
		} else {
			media = 0;
		}
		
		return media;
	}
	
	public int getValutazioneSpeciale_2_Value(Controller controller, Esercizio esercizio) {
		int count = 0, somma = 0, media = 0;
		Connection connection = controller.getConnection();
		String query;
		if(esercizio.getTipologia().equals("Ristorante")) {
			query = "SELECT valutazioneservizio FROM recensioneristorante AS RR JOIN Recensione AS R ON RR.recensioneid = R.id WHERE R.esercizioid=?;";
		} else {
			query = "SELECT valutazioneservizio FROM recensionealloggio AS RA JOIN Recensione AS R ON RA.recensioneid = R.id WHERE R.esercizioid=?;";
		}
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, esercizio.getId());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				somma += rs.getInt(1);
				count++;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(somma!=0) {
			media = somma/count;
		} else {
			media = 0;
		}
		
		return media;
	}
	
	public int getValutazioneSpeciale_3_Value(Controller controller, Esercizio esercizio) {
		int count = 0, somma = 0, media = 0;
		Connection connection = controller.getConnection();
		String query;
		if(esercizio.getTipologia().equals("Ristorante")) {
			query = "SELECT valutazioneconto FROM recensioneristorante AS RR JOIN Recensione AS R ON RR.recensioneid = R.id WHERE R.esercizioid=?;";
		} else {
			query = "SELECT valutazioneposizione FROM recensionealloggio AS RA JOIN Recensione AS R ON RA.recensioneid = R.id WHERE R.esercizioid=?;";
		}
		System.out.println(query);
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, esercizio.getId());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				somma += rs.getInt(1);
				count++;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(somma!=0) {
			media = somma/count;
		} else {
			media = 0;
		}
		
		return media;
	}
	
	public ArrayList<String> getValutazioniComplessive(Controller controller, int id){
		Connection connection = controller.getConnection();
		int count = 0;
		double somma = 0, mediaPonderata = 0;
		ArrayList<String> valutazioni = new ArrayList<String>();
		
		valutazioni.add("0"); //1 Stella
	    valutazioni.add("0"); //2 Stelle
	    valutazioni.add("0"); //3 Stelle
	    valutazioni.add("0"); //4 Stelle
	    valutazioni.add("0"); //5 Stelle
	    valutazioni.add("0"); //Media Ponderata
	    
		String query = "SELECT stelle FROM Recensione WHERE Recensione.esercizioid=?;";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				valutazioni.set(rs.getInt(1)-1, String.valueOf(Integer.parseInt(valutazioni.get(rs.getInt(1)-1))+1));
				count++;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*Calcolo media ponderata*/
		for(int i = 0; i < 6; i++) {
			somma += (i+1)*Double.parseDouble(valutazioni.get(i));
		}
		
		if(somma!=0) {
			mediaPonderata = somma/count;
			valutazioni.set(5, Double.toString(mediaPonderata));
		} else {
			valutazioni.set(5, "0");
		}
		
		return valutazioni;
	}
	
	public PuntoRistoro getPuntoRistoroById(Controller controller, int id) {
		PuntoRistoro newPuntoRistoro = new PuntoRistoro();
		Connection connection = controller.getConnection();
		
		String query = "SELECT * FROM PuntoRistoro WHERE PuntoRistoro.esercizioid = ? ;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newPuntoRistoro.setOrarioApertura(LocalTime.parse(rs.getString(2)));
			newPuntoRistoro.setOrarioChiusura(LocalTime.parse(rs.getString(3)));
			newPuntoRistoro.setSenzaGlutine(rs.getBoolean(4));
			newPuntoRistoro.setVeganFriendly(rs.getBoolean(5));
			newPuntoRistoro.setWiFi(rs.getBoolean(6));
			newPuntoRistoro.setPostiASedere(rs.getBoolean(7));
			newPuntoRistoro.setDaAsporto(rs.getBoolean(8));
			newPuntoRistoro.setServito(rs.getBoolean(9));
			newPuntoRistoro.setPizzeria(rs.getBoolean(10));
			newPuntoRistoro.setBraceria(rs.getBoolean(11));
			newPuntoRistoro.setPub(rs.getBoolean(12));
			newPuntoRistoro.setRistorante(rs.getBoolean(13));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newPuntoRistoro;
	}
	
	public Pizzeria getPizzeriaById(Controller controller, Integer id) {
		Pizzeria newPizzeria = new Pizzeria();
		
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Pizzeria WHERE Pizzeria.puntoristoroid = ? ;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newPizzeria.setPizzaFritta(rs.getBoolean(2));
			newPizzeria.setSoloCena(rs.getBoolean(3));
			newPizzeria.setFornoElettrico(rs.getBoolean(4));
			newPizzeria.setFornoLegna(rs.getBoolean(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newPizzeria;
	}
	
	public Pub getPubById(Controller controller, Integer id) {
		Pub newPub = new Pub();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Pub WHERE Pub.puntoristoroid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newPub.setBirreria(rs.getBoolean(2));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newPub;
		
	}
	
	public Braceria getBraceriaById(Controller controller, Integer id) {
		Braceria newBraceria = new Braceria();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Braceria WHERE Braceria.puntoristoroid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newBraceria.setCarne(rs.getBoolean(2));
			newBraceria.setPesce(rs.getBoolean(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newBraceria;
	}
	
	public Alloggio getAlloggioById(Controller controller, Integer id) {
		Alloggio newAlloggio = new Alloggio();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Alloggio WHERE Alloggio.esercizioid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newAlloggio.setStanze(rs.getInt(2));
			newAlloggio.setBagni(rs.getInt(3));
			newAlloggio.setTV(rs.getBoolean(4));
			newAlloggio.setParcheggio(rs.getBoolean(5));
			newAlloggio.setWifi(rs.getBoolean(6));
			newAlloggio.setPiscina(rs.getBoolean(7));
			newAlloggio.setCondizionamento(rs.getBoolean(8));
			newAlloggio.setAnimaliAmmessi(rs.getBoolean(9));
			newAlloggio.setTipoAlloggio(rs.getString(10));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAlloggio;
		
	}
	
	public Hotel getHotelById(Controller controller, Integer id) {
		Hotel newHotel = new Hotel();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Hotel WHERE Hotel.alloggioid=?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newHotel.setRistorante(rs.getBoolean(2));
			newHotel.setStelle(rs.getInt(3));
			newHotel.setPensione(rs.getString(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newHotel;
	}
	
	
	public Casa getCasaById(Controller controller, Integer id) {
		Casa newCasa = new Casa();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Casa WHERE Casa.alloggioid=?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newCasa.setTipoCasa(rs.getString(2));
			newCasa.setMetriQuadri(rs.getDouble(3));
			newCasa.setTipoEsterno(rs.getString(4));
			newCasa.setVietatoFumare(rs.getBoolean(5));
			newCasa.setServizioBiancheria(rs.getBoolean(6));
			newCasa.setLavatrice(rs.getBoolean(7));
			newCasa.setLavastoviglie(rs.getBoolean(8));
			newCasa.setTipoLetto(rs.getString(9));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newCasa;
	}
	
	public BedAndBreakfast getBedAndBreakfastById(Controller controller, Integer id) {
		BedAndBreakfast newBedAndBreakfast = new BedAndBreakfast();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM BedAndBreakfast WHERE BedAndBreakfast.alloggioid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newBedAndBreakfast.setReception(rs.getBoolean(2));
			newBedAndBreakfast.setVietatoFumare(rs.getBoolean(3));
			newBedAndBreakfast.setServizioBiancheria(rs.getBoolean(4));
			newBedAndBreakfast.setLavatrice(rs.getBoolean(5));
			newBedAndBreakfast.setLavastoviglie(rs.getBoolean(6));
			newBedAndBreakfast.setTipoLetto(rs.getString(7));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newBedAndBreakfast;
	}
	
	public Attrazione getAttrazioneById(Controller controller, Integer id) {
		Attrazione newAttrazione = new Attrazione();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Attrazione WHERE attrazione.esercizioid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newAttrazione.setOrarioApertura(LocalTime.parse(rs.getString(2)));
			newAttrazione.setOrarioChiusura(LocalTime.parse(rs.getString(3)));
			newAttrazione.setPerBambini(rs.getBoolean(4));
			newAttrazione.setTipoAttrazione(rs.getString(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newAttrazione;
	}
	
	public Locale getLocaleById(Controller controller, Integer id) {
		Locale newLocale = new Locale();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Locale WHERE locale.attrazioneid=?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newLocale.setDiscoteca(rs.getBoolean(2));
			newLocale.setNotturno(rs.getBoolean(3));
			newLocale.setSalaBallo(rs.getBoolean(4));
			newLocale.setSalaEventi(rs.getBoolean(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newLocale;
	}
	
	public Parco getParcoById(Controller controller, Integer id) {
		Parco newParco = new Parco();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Parco WHERE parco.attrazioneid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newParco.setTematico(rs.getBoolean(2));
			newParco.setDivertimenti(rs.getBoolean(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newParco;
	}
	
	public Museo getMuseoById(Controller controller, Integer id) {
		Museo newMuseo = new Museo();
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Museo WHERE museo.attrazioneid=?;";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			newMuseo.setArcheologico(rs.getBoolean(2));
			newMuseo.setArtistico(rs.getBoolean(3));
			newMuseo.setMarino(rs.getBoolean(4));
			newMuseo.setMilitare(rs.getBoolean(5));
			newMuseo.setScientifico(rs.getBoolean(6));
			newMuseo.setNaturale(rs.getBoolean(7));
			newMuseo.setStorico(rs.getBoolean(8));
			newMuseo.setNaturale(rs.getBoolean(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newMuseo;
	}
	
	//inserisce un esercizio
	/////
	/////
	public int setEsercizio(Controller controller, Esercizio esercizioDaAggiungere) {
		Connection connection = controller.getConnection();
		int ultimoIdentificativoIndirizzoInserito = controller.getUltimoIdentificativoIndirizzoInserito();
		String query = "INSERT INTO Esercizio(denominazione,utenteowner,descrizione,telefono,email,sitoweb,tipo,ID_indirizzo) VALUES(?,?,?,?,?,?,?::tipoEsercizio,?) RETURNING id";
		
		/*
		 *  RETURNING ID e' necessario per conoscere l'identificativo univoco dell'esercizio appena
		 *  inserito, in  modo tale che tabelle deboli possano fare riferimento ad esso
		 */
		int ultimo_id_inserito=0;
		System.out.println(query);
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, esercizioDaAggiungere.getDenominazione());
			statement.setString(2, esercizioDaAggiungere.getProprietario());
			statement.setString(3, esercizioDaAggiungere.getDescrizione());
			statement.setString(4, esercizioDaAggiungere.getTelefono());
			statement.setString(5, esercizioDaAggiungere.getEmail());
			statement.setString(6, esercizioDaAggiungere.getSitoWeb());
			statement.setString(7, esercizioDaAggiungere.getTipologia());
			statement.setInt(8, ultimoIdentificativoIndirizzoInserito);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			ultimo_id_inserito = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ultimo_id_inserito;
	}
	
	public void inserisciPuntoRistoro(Controller controller, PuntoRistoro newPuntoRistoro) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO puntoristoro VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, UltimoIdentificativoEsercizioInserito);
			statement.setTime(2, Time.valueOf(newPuntoRistoro.getOrarioApertura()));
			statement.setTime(3,Time.valueOf(newPuntoRistoro.getOrarioChiusura()));
			statement.setBoolean(4, newPuntoRistoro.getSenzaGlutine());
			statement.setBoolean(5,newPuntoRistoro.getVeganFriendly());
			statement.setBoolean(6,newPuntoRistoro.getWiFi());
			statement.setBoolean(7,newPuntoRistoro.getPostiASedere());
			statement.setBoolean(8,newPuntoRistoro.getDaAsporto());
			statement.setBoolean(9,newPuntoRistoro.getServito());
			statement.setBoolean(10,newPuntoRistoro.getPizzeria());
			statement.setBoolean(11,newPuntoRistoro.getBraceria());
			statement.setBoolean(12,newPuntoRistoro.getPub());
			statement.setBoolean(13,newPuntoRistoro.getRistorante());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciPizzeria(Controller controller, Pizzeria newPizzeria) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO Pizzeria VALUES(?,?,?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2, newPizzeria.getPizzaFritta());
			statement.setBoolean(3,newPizzeria.getSoloCena());
			statement.setBoolean(4,newPizzeria.getFornoElettrico());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciBraceria(Controller controller, Braceria newBraceria) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
	
		String query = "INSERT INTO Braceria VALUES(?,?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newBraceria.getCarne());
			statement.setBoolean(3,newBraceria.getPesce());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciPub(Controller controller, Pub newPub) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();

		String query = "INSERT INTO Pub VALUES(?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newPub.getBirreria());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciAlloggio(Controller controller, Alloggio newAlloggio) {
		Connection connection = controller.getConnection();
		Integer UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		String query = "INSERT INTO Alloggio VALUES(?,?,?,?,?,?,?,?,?,?::tipoAlloggio);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, UltimoIdentificativoEsercizioInserito);
			statement.setInt(2, newAlloggio.getStanze());
			statement.setInt(3,newAlloggio.getBagni());
			statement.setBoolean(4,newAlloggio.getTV());
			statement.setBoolean(5,newAlloggio.getParcheggio());
			statement.setBoolean(6,newAlloggio.getWifi());
			statement.setBoolean(7,newAlloggio.getPiscina());
			statement.setBoolean(8,newAlloggio.getCondizionamento());
			statement.setBoolean(9,newAlloggio.getAnimaliAmmessi());
			statement.setString(10, newAlloggio.getTipoAlloggio());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciHotel(Controller controller, Hotel newHotel) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO Hotel VALUES(?,?,?,?::tipoPensione);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newHotel.getRistorante());
			statement.setInt(3,newHotel.getStelle());
			statement.setString(4, newHotel.getPensione());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciBedAndBreakfast(Controller controller, BedAndBreakfast newBedAndBreakfast) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO BedAndBreakfast VALUES(?,?,?,?,?,?,?::tipoLetto);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newBedAndBreakfast.getReception());
			statement.setBoolean(3,newBedAndBreakfast.getVietatoFumare());
			statement.setBoolean(4,newBedAndBreakfast.getServizioBiancheria());
			statement.setBoolean(5, newBedAndBreakfast.getLavatrice());
			statement.setBoolean(6, newBedAndBreakfast.getLavastoviglie());
			statement.setString(7, newBedAndBreakfast.getTipoLetto());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciCasa(Controller controller, Casa newCasa) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO Casa VALUES(?,?::tipoCasa,?,?::tipoEsterno,?,?,?,?,?::tipoLetto);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			
			statement.setString(2, newCasa.getTipoCasa());
			
			statement.setDouble(3,newCasa.getMetriQuadri());
			
			statement.setString(4, newCasa.getTipoCasa());
			
			statement.setBoolean(5,newCasa.getVietatoFumare());
			statement.setBoolean(6, newCasa.getServizioBiancheria());
			statement.setBoolean(7, newCasa.getLavatrice());
			statement.setBoolean(8, newCasa.getLavastoviglie());
			statement.setString(9, newCasa.getTipoLetto());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciAttrazione(Controller controller, Attrazione newAttrazione) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		String query = "INSERT INTO Attrazione VALUES(?,?,?,?,?::tipoAttrazione);";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setTime(2, Time.valueOf(newAttrazione.getOrarioApertura()));
			statement.setTime(3, Time.valueOf(newAttrazione.getOrarioChiusura()));
			statement.setBoolean(4, newAttrazione.getPerBambini());
			statement.setString(5,newAttrazione.getTipoAttrazione());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserisciMuseo(Controller controller, Museo newMuseo) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		String query = "INSERT INTO Museo VALUES(?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newMuseo.getArcheologico());
			statement.setBoolean(3, newMuseo.getArtistico());
			statement.setBoolean(4, newMuseo.getMarino());
			statement.setBoolean(5, newMuseo.getMilitare());
			statement.setBoolean(6, newMuseo.getScientifico());
			statement.setBoolean(7, newMuseo.getNaturale());
			statement.setBoolean(8, newMuseo.getStorico());
			statement.setBoolean(9, newMuseo.getVirtuale());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciParco(Controller controller, Parco newParco) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		String query = "INSERT INTO Parco VALUES(?,?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2,newParco.getTematico());
			statement.setBoolean(3,newParco.getDivertimenti());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciLocale(Controller controller, Locale newLocale) {
		Connection connection = controller.getConnection();
		int UltimoIdentificativoEsercizioInserito = controller.getUltimoIdentificativoEsercizioInserito();
		
		String query = "INSERT INTO Locale VALUES(?,?,?,?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,UltimoIdentificativoEsercizioInserito);
			statement.setBoolean(2, newLocale.getDiscoteca());
			statement.setBoolean(3, newLocale.getNotturno());
			statement.setBoolean(4, newLocale.getSalaBallo());
			statement.setBoolean(5, newLocale.getSalaEventi());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
}


