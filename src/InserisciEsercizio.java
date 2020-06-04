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
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class InserisciEsercizio extends JFrame {

	private JPanel contentPane_descrizione;
	private JTextField textField_denominazione;
	private JTextField textField_telefono;
	private JTextField textField_email;
	private JTextField textField_sito;
	private Controller TheController;
	public InserisciEsercizio(Controller controller) {
		setResizable(false);
		setTitle("Voyager - Inserimento Esercizio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciEsercizio.class.getResource("/images/icon.png")));
		TheController = controller;
		setBounds(100, 100, 420, 468);
		contentPane_descrizione = new JPanel();
		contentPane_descrizione.setBackground(Color.WHITE);
		contentPane_descrizione.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_descrizione);
		
		JLabel lblNome = new JLabel("Denominazione");
		lblNome.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		textField_denominazione = new JTextField();
		textField_denominazione.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textField_denominazione.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JComboBox<String> comboBox_tipologia = new JComboBox<String>();
		comboBox_tipologia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		comboBox_tipologia.addItem("Ristorante");
		comboBox_tipologia.addItem("Alloggio");
		comboBox_tipologia.addItem("Attrazione");
		
		JTextPane txtpnDescrizione = new JTextPane();
		txtpnDescrizione.setDropMode(DropMode.INSERT);
		txtpnDescrizione.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		txtpnDescrizione.setFont(new Font("Open Sans", Font.PLAIN, 14));
		txtpnDescrizione.setText("Descrizione...");
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		textField_telefono = new JTextField();
		textField_telefono.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textField_telefono.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblSitoWeb = new JLabel("Sito web");
		lblSitoWeb.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textField_email.setColumns(10);
		
		textField_sito = new JTextField();
		textField_sito.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textField_sito.setColumns(10);
		
		JButton btn_avanti = new JButton("Avanti");
		btn_avanti.setBackground(new Color(109, 175, 223));
		btn_avanti.setForeground(Color.WHITE);
		btn_avanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Esercizio newEsercizio = new Esercizio();
				newEsercizio.setDenominazione(textField_denominazione.getText());
				newEsercizio.setDescrizione(txtpnDescrizione.getText());
				newEsercizio.setTipologia(comboBox_tipologia.getSelectedItem().toString());
				newEsercizio.setEmail(textField_email.getText());
				newEsercizio.setSitoWeb(textField_sito.getText());
				newEsercizio.setTelefono(textField_telefono.getText());
				newEsercizio.setProprietario(controller.getCurrentUser().getUsername());
				
				if(newEsercizio.getDenominazione().isEmpty() || newEsercizio.getDescrizione().isEmpty()) {
					TheController.showErrorFrame("Compila tutti i campi!");
				} else {
					TheController.inserisciEsercizio(newEsercizio);			
				}
			}
		});
		btn_avanti.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		GroupLayout gl_contentPane_descrizione = new GroupLayout(contentPane_descrizione);
		gl_contentPane_descrizione.setHorizontalGroup(
			gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_descrizione.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane_descrizione.createSequentialGroup()
								.addComponent(lblNome)
								.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
								.addComponent(textField_denominazione, 157, 157, 157))
							.addGroup(gl_contentPane_descrizione.createSequentialGroup()
								.addComponent(lblDescrizione, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtpnDescrizione, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane_descrizione.createSequentialGroup()
								.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTipologia, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField_telefono, 157, 157, 157)
									.addComponent(comboBox_tipologia, 0, 157, Short.MAX_VALUE))))
						.addGroup(gl_contentPane_descrizione.createSequentialGroup()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane_descrizione.createSequentialGroup()
							.addComponent(lblSitoWeb, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_sito, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
					.addGap(224))
				.addGroup(gl_contentPane_descrizione.createSequentialGroup()
					.addGap(163)
					.addComponent(btn_avanti)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_contentPane_descrizione.setVerticalGroup(
			gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_descrizione.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textField_denominazione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescrizione, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnDescrizione, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_descrizione.createSequentialGroup()
							.addGap(14)
							.addComponent(lblTipologia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane_descrizione.createSequentialGroup()
							.addGap(18)
							.addComponent(comboBox_tipologia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane_descrizione.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSitoWeb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_sito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(btn_avanti)
					.addGap(34))
		);
		contentPane_descrizione.setLayout(gl_contentPane_descrizione);
	}
}
