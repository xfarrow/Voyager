import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class InserisciIndirizzo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_citta;
	private JTextField textField_via;
	private JTextField textField_civico;
	private JTextField textField_cap;
	private Controller TheController;
	
	public InserisciIndirizzo(Controller controller) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciIndirizzo.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Indirizzo");
		TheController = controller;
		setBounds(100, 100, 428, 449);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStato = new JLabel("Stato");
		lblStato.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JComboBox<String> comboBox_stato = new JComboBox<String>();
		comboBox_stato.addItem("Italia");
		
		JLabel lblRegione = new JLabel("Regione");
		lblRegione.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblCitta = new JLabel("Città");
		lblCitta.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblCivico = new JLabel("Civico");
		lblCivico.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblCap = new JLabel("CAP");
		lblCap.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JComboBox<String> comboBox_regione = new JComboBox<String>();
		comboBox_regione.addItem("Abruzzo");
		comboBox_regione.addItem("Basilicata");
		comboBox_regione.addItem("Calabria");
		comboBox_regione.addItem("Campania");
		comboBox_regione.addItem("Emilia-Romagna");
		comboBox_regione.addItem("Friuli Venezia Giulia");
		comboBox_regione.addItem("Lazio");
		comboBox_regione.addItem("Liguria");
		comboBox_regione.addItem("Lombardia");
		comboBox_regione.addItem("Marche");
		comboBox_regione.addItem("Molise");
		comboBox_regione.addItem("Piemonte");
		comboBox_regione.addItem("Puglia");
		comboBox_regione.addItem("Sardegna");
		comboBox_regione.addItem("Sicilia");
		comboBox_regione.addItem("Toscana");
		comboBox_regione.addItem("Trentino Alto Adige");
		comboBox_regione.addItem("Umbria");
		comboBox_regione.addItem("Valle D'Aosta");
		comboBox_regione.addItem("Veneto");
		
		JComboBox<String> comboBox_provincia = new JComboBox<String>();
		comboBox_provincia.addItem("Agrigento");
		comboBox_provincia.addItem("Alessandria");
		comboBox_provincia.addItem("Ancona");
		comboBox_provincia.addItem("Aosta");
		comboBox_provincia.addItem("Arezzo");
		comboBox_provincia.addItem("Ascoli");
		comboBox_provincia.addItem("Piceno");
		comboBox_provincia.addItem("Asti");
		comboBox_provincia.addItem("Avellino");
		comboBox_provincia.addItem("Bari");
		comboBox_provincia.addItem("Belluno");
		comboBox_provincia.addItem("Benevento");
		comboBox_provincia.addItem("Bergamo");
		comboBox_provincia.addItem("Biella");
		comboBox_provincia.addItem("Bologna");
		comboBox_provincia.addItem("Bolzano");
		comboBox_provincia.addItem("Brescia");
		comboBox_provincia.addItem("Brindisi");
		comboBox_provincia.addItem("Cagliari");
		comboBox_provincia.addItem("Caltanissetta");
		comboBox_provincia.addItem("Campobasso");
		comboBox_provincia.addItem("Carbonia-Iglesias");
		comboBox_provincia.addItem("Caserta");
		comboBox_provincia.addItem("Catania");
		comboBox_provincia.addItem("Catanzaro");
		comboBox_provincia.addItem("Chieti");
		comboBox_provincia.addItem("Como");
		comboBox_provincia.addItem("Cosenza");
		comboBox_provincia.addItem("Cremona");
		comboBox_provincia.addItem("Crotone");
		comboBox_provincia.addItem("Cuneo");
		comboBox_provincia.addItem("Enna");
		comboBox_provincia.addItem("Fermo");
		comboBox_provincia.addItem("Ferrara");
		comboBox_provincia.addItem("Firenze");
		comboBox_provincia.addItem("Foggia");
		comboBox_provincia.addItem("Forlì-Cesena");
		comboBox_provincia.addItem("Frosinone");
		comboBox_provincia.addItem("Genova");
		comboBox_provincia.addItem("Gorizia");
		comboBox_provincia.addItem("Grosseto");
		comboBox_provincia.addItem("Imperia");
		comboBox_provincia.addItem("Isernia");
		comboBox_provincia.addItem("La Spezia");
		comboBox_provincia.addItem("L'Aquila");
		comboBox_provincia.addItem("Latina");
		comboBox_provincia.addItem("Lecce");
		comboBox_provincia.addItem("Lecco");
		comboBox_provincia.addItem("Livorno");
		comboBox_provincia.addItem("Lodi");
		comboBox_provincia.addItem("Lucca");
		comboBox_provincia.addItem("Macerata");
		comboBox_provincia.addItem("Mantova");
		comboBox_provincia.addItem("Massa-Carrara");
		comboBox_provincia.addItem("Matera");
		comboBox_provincia.addItem("Messina");
		comboBox_provincia.addItem("Milano");
		comboBox_provincia.addItem("Modena");
		comboBox_provincia.addItem("Monza");
		comboBox_provincia.addItem("Napoli");
		comboBox_provincia.addItem("Novara");
		comboBox_provincia.addItem("Nuoro");
		comboBox_provincia.addItem("Olbia-Tempio");
		comboBox_provincia.addItem("Oristano");
		comboBox_provincia.addItem("Padova");
		comboBox_provincia.addItem("Palermo");
		comboBox_provincia.addItem("Parma");
		comboBox_provincia.addItem("Pavia");
		comboBox_provincia.addItem("Perugia");
		comboBox_provincia.addItem("Pesaro e Urbino");
		comboBox_provincia.addItem("Pescara");
		comboBox_provincia.addItem("Piacenza");
		comboBox_provincia.addItem("Pisa");
		comboBox_provincia.addItem("Pistoia");
		comboBox_provincia.addItem("Pordenone");
		comboBox_provincia.addItem("Potenza");
		comboBox_provincia.addItem("Prato");
		comboBox_provincia.addItem("Ragusa");
		comboBox_provincia.addItem("Ravenna");
		comboBox_provincia.addItem("Reggio");
		comboBox_provincia.addItem("Calabria");
		comboBox_provincia.addItem("Reggio");
		comboBox_provincia.addItem("Emilia");
		comboBox_provincia.addItem("Rieti");
		comboBox_provincia.addItem("Rimini");
		comboBox_provincia.addItem("Roma");
		comboBox_provincia.addItem("Rovigo");
		comboBox_provincia.addItem("Salerno");
		comboBox_provincia.addItem("Medio");
		comboBox_provincia.addItem("Campidano");
		comboBox_provincia.addItem("Sassari");
		comboBox_provincia.addItem("Savona");
		comboBox_provincia.addItem("Siena");
		comboBox_provincia.addItem("Siracusa");
		comboBox_provincia.addItem("Sondrio");
		comboBox_provincia.addItem("Taranto");
		comboBox_provincia.addItem("Teramo");
		comboBox_provincia.addItem("Terni");
		comboBox_provincia.addItem("Torino");
		comboBox_provincia.addItem("Ogliastra");
		comboBox_provincia.addItem("Trapani");
		comboBox_provincia.addItem("Trento");
		comboBox_provincia.addItem("Treviso");
		comboBox_provincia.addItem("Trieste");
		comboBox_provincia.addItem("Udine");
		comboBox_provincia.addItem("Varese");
		comboBox_provincia.addItem("Venezia");
		comboBox_provincia.addItem("Verbano-Cusio-Ossola");
		comboBox_provincia.addItem("Vercelli");
		comboBox_provincia.addItem("Verona");
		comboBox_provincia.addItem("Vibo");
		comboBox_provincia.addItem("Valentia");
		comboBox_provincia.addItem("Vicenza");
		comboBox_provincia.addItem("Viterbo");

		
		textField_citta = new JTextField();
		textField_citta.setColumns(10);
		
		textField_via = new JTextField();
		textField_via.setColumns(10);
		
		textField_civico = new JTextField();
		textField_civico.setColumns(10);
		
		textField_cap = new JTextField();
		textField_cap.setColumns(10);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBackground(new Color(109, 175, 223));
		btnConferma.setForeground(Color.WHITE);
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Indirizzo newIndirizzo = new Indirizzo();
				newIndirizzo.setStato(comboBox_stato.getSelectedItem().toString());
				newIndirizzo.setRegione(comboBox_regione.getSelectedItem().toString());
				newIndirizzo.setProvincia(comboBox_provincia.getSelectedItem().toString());
				newIndirizzo.setCitta(textField_citta.getText());
				newIndirizzo.setVia(textField_via.getText());
				newIndirizzo.setCivico(textField_civico.getText());
				newIndirizzo.setCAP(textField_cap.getText());
				
				if(newIndirizzo.getCitta().isEmpty()
				   || newIndirizzo.getVia().isEmpty() 
				   || newIndirizzo.getCivico().isEmpty()
				   || newIndirizzo.getCAP().isEmpty()
				){
					TheController.showErrorFrame("Compila tutti i campi!");
				} else {
					TheController.inserisciIndirizzo(newIndirizzo);
				}
			}
		});
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblRegione, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblStato)
													.addGap(86)))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblProvincia, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
												.addGap(40)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblCitta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblCivico, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
											.addGap(65)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblVia, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addGap(88)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCap, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(65)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_cap, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(comboBox_regione, 0, 96, Short.MAX_VALUE)
								.addComponent(textField_citta, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(textField_civico, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(textField_via, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(comboBox_stato, 0, 161, Short.MAX_VALUE)
								.addComponent(comboBox_provincia, 0, 193, Short.MAX_VALUE))
							.addContainerGap(45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConferma)
							.addGap(85))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStato)
						.addComponent(comboBox_stato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegione, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_regione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProvincia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCitta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_citta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_via, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCivico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_civico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCap, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_cap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnConferma)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


}
