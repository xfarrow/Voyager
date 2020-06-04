import java.sql.*;
import java.util.ArrayList;

public class Recensione_DAO {
	
	public int inserisciRecensione(Controller controller, Recensione recensione) {
		Connection connection = controller.getConnection();
		
		String query = "INSERT INTO Recensione( esercizioid, utente, titolo, descrizione, stelle, tipo ) VALUES (?, ?, ?, ?, ?, ?::tiporecensione)";
		query+= " RETURNING id;";
		
		int id_recensione=0;
		
		System.out.println(query);
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, recensione.getEsercizioID());
			statement.setString(2, recensione.getUtente());
			statement.setString(3, recensione.getTitolo());
			statement.setString(4, recensione.getDescrizione());
			statement.setInt(5, recensione.getStelle());
			statement.setString(6, recensione.getTipoRecensione());
			
			ResultSet res = statement.executeQuery();
			res.next();
			id_recensione = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_recensione;
	}
	
	public void inserisciRecensione(Controller controller, RecensioneRistorante recensioneRistoranteSpeciale, int id_recensione) {
		Connection connection = controller.getConnection();
		String query = "INSERT INTO recensioneristorante(recensioneid,valutazionecucina,valutazioneservizio,valutazioneconto) VALUES(?,?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id_recensione);
			statement.setInt(2, recensioneRistoranteSpeciale.getValutazioneCucina());
			statement.setInt(3, recensioneRistoranteSpeciale.getValutazioneServizio());
			statement.setInt(4, recensioneRistoranteSpeciale.getValutazioneConto());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciRecensione(Controller controller, RecensioneAlloggio recensioneAlloggioSpeciale, int id_recensione) {
		Connection connection = controller.getConnection();
		String query = "INSERT INTO recensionealloggio(recensioneid,valutazionepulizia, valutazioneservizio, valutazioneposizione) VALUES(?,?,?,?);";
		 try {
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1, id_recensione);
             statement.setInt(2, recensioneAlloggioSpeciale.getValutazionePulizia());
             statement.setInt(3, recensioneAlloggioSpeciale.getValutazioneServizio());
             statement.setInt(4, recensioneAlloggioSpeciale.getValutazionePosizione());
             statement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
	}
		
	
	public ArrayList<Recensione> getRecensioni(Controller controller, Esercizio esercizio){
		Connection connection = controller.getConnection();
		
		ArrayList<Recensione> listaRecensioni = new ArrayList<Recensione>();
		
		String query = "SELECT * FROM Recensione WHERE esercizioid = "+esercizio.getId()+";";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Recensione currRecensione = new Recensione();
				currRecensione.setId(rs.getInt(1));
				currRecensione.setEsercizioID(rs.getInt(2));
				currRecensione.setUtente(rs.getString(3));
				currRecensione.setTitolo(rs.getString(4));
				currRecensione.setDescrizione(rs.getString(5));
				currRecensione.setStelle(rs.getInt(6));
				currRecensione.setTipoRecensione(rs.getString(7));
				listaRecensioni.add(currRecensione);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaRecensioni;
	}
	
	public boolean checkReviewAlreadyExists(Controller controller, String username, int id_esercizio) {
		boolean exists = false;
		Connection connection = controller.getConnection();
		
		String query = "SELECT utente FROM recensione WHERE utente = ? AND esercizioid = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setInt(2, id_esercizio);
			ResultSet rs = statement.executeQuery();
			
			if (!rs.next() ) {
			    System.out.println("");
			} else {
				controller.showErrorFrame("Hai gi� recensito questo esercizio!");
				exists = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}
	
	public String getLastReviewTitle(Controller controller, Esercizio esercizio) {
		String title = "";
		Connection connection = controller.getConnection();
		
		String query = "SELECT titolo FROM recensione WHERE esercizioid ="+esercizio.getId()+"ORDER BY id DESC LIMIT 1;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			if (!rs.next() ) {
				title = "Ancora nessuna recensione...";
			} else {
				title = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return title;
	}

}
