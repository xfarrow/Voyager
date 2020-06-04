import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Indirizzo_DAO {
	public int setIndirizzo(Controller controller,Indirizzo newIndirizzo) {
		Connection connection = controller.getConnection();
		int ultimo_id_inserito = 0;

		String query="INSERT INTO Indirizzo(stato,regione,provincia,citta,via,civico,cap) VALUES(?,?,?,?,?,?,?) RETURNING id;";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newIndirizzo.getStato());
			statement.setString(2, newIndirizzo.getRegione());
			statement.setString(3, newIndirizzo.getProvincia());
			statement.setString(4, newIndirizzo.getCitta());
			statement.setString(5, newIndirizzo.getVia());
			statement.setString(6, newIndirizzo.getCivico());
			statement.setString(7, newIndirizzo.getCAP());
			ResultSet rs = statement.executeQuery();
			rs.next();
			ultimo_id_inserito = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ultimo_id_inserito;
	}

	public String getIndirizzoString(Controller controller, Integer id) {
		Connection connection = controller.getConnection();
		String query = "SELECT * FROM Indirizzo WHERE Indirizzo.ID="+id.toString()+";";
		System.out.println(query);
		String indirizzo="Error";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			rs.next();

			// Via Roma 12, Portici (Napoli)
			indirizzo = "Via " + rs.getString(6)+" "+rs.getString(7) + ", " + rs.getString(5) + " ("+rs.getString(4)+")";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return indirizzo;
	}

}