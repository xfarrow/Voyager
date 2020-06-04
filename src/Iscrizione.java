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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Iscrizione extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_Residenza;
	private JPasswordField passwordField;

	private Controller TheController;

	/**
	 * Create the frame.
	 */
	public Iscrizione(Controller controller) {
		setTitle("Voyager - Iscrizione");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Iscrizione.class.getResource("/images/icon.png")));
		setResizable(false);
		TheController = controller;
		setBounds(100, 100, 450, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Pannello di iscrizione");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 23));
		
		JLabel lblCittDiResidenza = new JLabel("Citt\u00E0\u00A0di residenza");
		lblCittDiResidenza.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Username.setColumns(10);
		
		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Nome.setColumns(10);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Cognome.setColumns(10);
		
		textField_Residenza = new JTextField();
		textField_Residenza.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Residenza.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btn_Conferma = new JButton("Conferma");
		btn_Conferma.setBackground(new Color(109, 175, 223));
		btn_Conferma.setForeground(Color.WHITE);
		btn_Conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean errorExists = false;
				
				if(textField_Username.getText().isBlank() || 
					textField_Nome.getText().isBlank() ||
					textField_Cognome.getText().isBlank() ||
					String.valueOf(passwordField.getPassword()).isBlank() ||
					textField_Residenza.getText().isBlank()
					) {
					controller.showErrorFrame("Compilare tutti i campi!");
				} else {
					Persona utenteDaIscrivere = new Persona();
					utenteDaIscrivere.setUsername(textField_Username.getText());
					utenteDaIscrivere.setNome(textField_Nome.getText());
					utenteDaIscrivere.setCognome(textField_Cognome.getText());
					utenteDaIscrivere.setPassword(String.valueOf(passwordField.getPassword()));
					utenteDaIscrivere.setCittaDiProvenienza(textField_Residenza.getText());
					
					TheController.iscriviPersona(utenteDaIscrivere);
				}
			}
		});
		
		JButton btn_Annulla = new JButton("Annulla");
		btn_Annulla.setBackground(SystemColor.menu);
		btn_Annulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.hideIscriviFrame();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(lblCognome, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCittDiResidenza))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Cognome, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(textField_Residenza, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(textField_Nome, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(textField_Username, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addGap(61))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addContainerGap(382, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(342, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addComponent(btn_Annulla)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_Conferma)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textField_Nome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(textField_Cognome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCittDiResidenza, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Residenza, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(206)
							.addComponent(lblCognome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Conferma)
						.addComponent(btn_Annulla))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Iscrizione.class.getResource("/images/logo.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
