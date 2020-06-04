import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utente_DAO {

	public void iscrivi(Controller controller,Persona utenteDaIscrivere) {
		Connection connection = controller.getConnection();
		utenteDaIscrivere.setUsername(utenteDaIscrivere.getUsername().toLowerCase()); //username sempre minuscolo
		String query = "INSERT INTO utente(username,nome,cognome,password,comuneResidenza) VALUES(?,?,?,?,?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, utenteDaIscrivere.getUsername());
			statement.setString(2,utenteDaIscrivere.getNome());
			statement.setString(3, utenteDaIscrivere.getCognome());
			statement.setString(4, utenteDaIscrivere.getPassword());
			statement.setString(5, utenteDaIscrivere.getCittaDiProvenienza());
			statement.executeUpdate();
			
			controller.showErrorFrame(utenteDaIscrivere.getUsername()+" iscritto! Effettua il login.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Persona accedi(Controller controller, String username,String password) {
		Connection connection = controller.getConnection();
		username = username.toLowerCase();
		Persona persona;
		
		String query = "SELECT * FROM utente WHERE username = ? AND password = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			
			//Se c'è l'utente in questione
			if(rs.next()) {
				persona = new Persona();
				persona.setUsername(rs.getString(1));
				persona.setNome(rs.getString(3));
				persona.setCognome(rs.getString(4));
				persona.setCittaDiProvenienza(rs.getString(5));
				return persona;
			}else {
				return null;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
	
	Persona getInfo(Controller controller, String username) {
		Connection connection = controller.getConnection();
		
		Persona persona;
		String query = "SELECT * FROM utente WHERE username=?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,username);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				persona = new Persona();
				persona.setUsername(rs.getString(1));
				persona.setNome(rs.getString(2));
				persona.setCognome(rs.getString(3));
				persona.setCittaDiProvenienza(rs.getString(4));
				return persona;
			}else {
				return null;
			}
		
	}catch(SQLException e) {
		
	}
	return null;
}
	
}
