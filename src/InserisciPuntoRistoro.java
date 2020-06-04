import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class InserisciPuntoRistoro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_apertura_ore;
	private JTextField textField_apertura_minuti;
	private JTextField textField_chiusura_ore;
	private JTextField textField_chiusura_minuti;
	private Controller TheController;
	
	public InserisciPuntoRistoro(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciPuntoRistoro.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Punto Ristoro");
		setResizable(false);
		TheController = controller;
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblInserisciPuntoRistoro = new JLabel("Inserisci Punto Ristoro");
		lblInserisciPuntoRistoro.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciPuntoRistoro.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblOrarioApertura = new JLabel("Orario Apertura: ");
		lblOrarioApertura.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		textField_apertura_ore = new JTextField();
		textField_apertura_ore.setColumns(10);
		
		textField_apertura_minuti = new JTextField();
		textField_apertura_minuti.setColumns(10);
		
		JLabel lblOrarioChiusura = new JLabel("Orario chiusura:");
		lblOrarioChiusura.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		textField_chiusura_ore = new JTextField();
		textField_chiusura_ore.setColumns(10);
		
		textField_chiusura_minuti = new JTextField();
		textField_chiusura_minuti.setColumns(10);
		
		JLabel lblSenzaGlutine = new JLabel("Senza Glutine");
		lblSenzaGlutine.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblVeganFriendly = new JLabel("Vegan Friendly");
		lblVeganFriendly.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblWifi = new JLabel("WiFi");
		lblWifi.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblPostiASedere = new JLabel("Posti a sedere");
		lblPostiASedere.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblDaAsporto = new JLabel("Da asporto");
		lblDaAsporto.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblServito = new JLabel("Servito");
		lblServito.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblPizzeria = new JLabel("Pizzeria");
		lblPizzeria.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblBraceria = new JLabel("Braceria");
		lblBraceria.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblPub = new JLabel("Pub");
		lblPub.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JLabel lblRistorante = new JLabel("Ristorante");
		lblRistorante.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JCheckBox chckbx_senzaGlutine = new JCheckBox("");
		
		JCheckBox checkBox_vegan = new JCheckBox("");
		
		JCheckBox checkBox_wifi = new JCheckBox("");
		
		JCheckBox checkBox_posti = new JCheckBox("");
		
		JCheckBox checkBox_asporto = new JCheckBox("");
		
		JCheckBox checkBox_servito = new JCheckBox("");
		
		JCheckBox checkBox_pizzeria = new JCheckBox("");
		
		JCheckBox checkBox_pub = new JCheckBox("");
		
		JCheckBox checkBox_ristorante = new JCheckBox("");
		
		JCheckBox checkBox_braceria = new JCheckBox("");
		
		JButton btn_avanti = new JButton("Avanti");
		btn_avanti.setBackground(new Color(109, 175, 223));
		btn_avanti.setForeground(Color.WHITE);
		btn_avanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean validInput = true;
				
				String orarioAperturaString = textField_apertura_ore.getText()+":"+textField_apertura_minuti.getText()+":00";
				String orarioChiusuraString = textField_chiusura_ore.getText()+":"+textField_chiusura_minuti.getText()+":00";
				
				PuntoRistoro newPuntoRistoro = new PuntoRistoro();
				LocalTime orarioApertura=null;
				LocalTime orarioChiusura=null;
				try {
					orarioApertura = LocalTime.parse(orarioAperturaString);
					orarioChiusura = LocalTime.parse(orarioChiusuraString);
					
				}catch(java.time.format.DateTimeParseException exc) {
					validInput = false;
					TheController.showErrorFrame("Formato ora non valido. Riprovare");
				}
				
				if(!(checkBox_braceria.isSelected() || checkBox_pizzeria.isSelected() || checkBox_pub.isSelected() || checkBox_ristorante.isSelected() )) {
					validInput = false;
					TheController.showErrorFrame("Devi selezionare almeno una sotto-specializzazione.");
				}
				
				newPuntoRistoro.setOrarioApertura(orarioApertura);
				newPuntoRistoro.setOrarioChiusura(orarioChiusura);
				newPuntoRistoro.setBraceria(checkBox_braceria.isSelected());
				newPuntoRistoro.setDaAsporto(checkBox_asporto.isSelected());
				newPuntoRistoro.setPizzeria(checkBox_pizzeria.isSelected());
				newPuntoRistoro.setPostiASedere(checkBox_posti.isSelected());
				newPuntoRistoro.setPub(checkBox_pub.isSelected());
				newPuntoRistoro.setRistorante(checkBox_ristorante.isSelected());
				newPuntoRistoro.setSenzaGlutine(chckbx_senzaGlutine.isSelected());
				newPuntoRistoro.setServito(checkBox_servito.isSelected());
				newPuntoRistoro.setVeganFriendly(checkBox_vegan.isSelected());
				newPuntoRistoro.setWiFi(checkBox_wifi.isSelected());
				if(validInput)
					TheController.inserisciPuntoRistoro(newPuntoRistoro);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSenzaGlutine, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbx_senzaGlutine, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblServito, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(checkBox_servito, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblVeganFriendly, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(checkBox_vegan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
												.addComponent(lblPizzeria, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
												.addGap(18))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPostiASedere, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(checkBox_posti, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addGap(60)
												.addComponent(lblPub, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
												.addGap(30))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblDaAsporto, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(checkBox_asporto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(btn_avanti)
													.addComponent(lblRistorante, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblWifi, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(checkBox_wifi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addGap(60)
											.addComponent(lblBraceria, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addGap(21)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(checkBox_braceria, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_ristorante, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_pub, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_pizzeria, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
									.addGap(11))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblOrarioChiusura, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_chiusura_ore, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblOrarioApertura)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_apertura_ore, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_apertura_minuti, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_chiusura_minuti, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
							.addGap(57))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblInserisciPuntoRistoro, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(79))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInserisciPuntoRistoro)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrarioApertura)
						.addComponent(textField_apertura_minuti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_apertura_ore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrarioChiusura, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_chiusura_ore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_chiusura_minuti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSenzaGlutine, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblVeganFriendly, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_vegan, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblWifi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_wifi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPostiASedere, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_posti, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDaAsporto, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_asporto, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblServito, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_servito, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPizzeria, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_pizzeria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblBraceria, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_braceria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPub, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_pub, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(16)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblRistorante, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox_ristorante, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(btn_avanti))))
						.addComponent(chckbx_senzaGlutine))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
