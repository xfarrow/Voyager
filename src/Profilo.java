import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Profilo extends JFrame {

	private JPanel contentPane;
	Controller TheController;
	
	public Profilo(Controller controller) {
		setResizable(false);
		TheController = controller;
		Persona utente;
		utente = TheController.getCurrentUser();
		
		setTitle("Voyager - Profilo di "+utente.getUsername());
		setIconImage(Toolkit.getDefaultToolkit().getImage(Profilo.class.getResource("/images/icon.png")));
		
		setBounds(100, 100, 656, 341);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("Il mio profilo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 19));
		
		JLabel lbl_username = new JLabel("- - -");
		lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_username.setFont(new Font("Open Sans", Font.BOLD, 17));
		lbl_username.setText(utente.getUsername());
		
		JLabel label_CittaDiProvenienza = new JLabel("- - -");
		label_CittaDiProvenienza.setHorizontalAlignment(SwingConstants.CENTER);
		label_CittaDiProvenienza.setFont(new Font("Open Sans", Font.PLAIN, 17));
		label_CittaDiProvenienza.setText("da "+utente.getCittaDiProvenienza());
		
		JLabel label_Cognome = new JLabel("- - -");
		label_Cognome.setHorizontalAlignment(SwingConstants.LEFT);
		label_Cognome.setFont(new Font("Open Sans", Font.PLAIN, 17));
		label_Cognome.setText(utente.getCognome());
		
		JLabel label_Nome = new JLabel("- - -");
		label_Nome.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Nome.setFont(new Font("Open Sans", Font.PLAIN, 17));
		label_Nome.setText(utente.getNome());
		
		JButton btnInserisciEsercizio = new JButton("Inserisci esercizio");
		btnInserisciEsercizio.setForeground(Color.WHITE);
		btnInserisciEsercizio.setBackground(new Color(109, 175, 223));
		btnInserisciEsercizio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.indirizzo();
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btn_tornaIndietro = new JButton("Torna Indietro");
		btn_tornaIndietro.setBackground(SystemColor.menu);
		btn_tornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_tornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.hideProfilo();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(203)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_Nome, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_Cognome, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btn_tornaIndietro)
							.addGap(18)
							.addComponent(btnInserisciEsercizio)))
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(251)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(250))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(244)
					.addComponent(lbl_username, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(243, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(247)
					.addComponent(label_CittaDiProvenienza, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_username)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_Nome)
						.addComponent(label_Cognome))
					.addGap(11)
					.addComponent(label_CittaDiProvenienza)
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserisciEsercizio)
						.addComponent(btn_tornaIndietro))
					.addGap(164))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 102, 0));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JButton btnUsername = new JButton("Username");
		btnUsername.setVerifyInputWhenFocusTarget(false);
		btnUsername.setRequestFocusEnabled(false);
		btnUsername.setFocusTraversalKeysEnabled(false);
		btnUsername.setFocusPainted(false);
		btnUsername.setBorderPainted(false);
		btnUsername.setForeground(Color.WHITE);
		btnUsername.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btnUsername.setFocusable(false);
		btnUsername.setBorder(null);
		btnUsername.setBackground(new Color(255, 102, 0));
		btnUsername.setText(utente.getUsername());
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Profilo.class.getResource("/images/logo.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(99)
					.addComponent(btnUsername, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(btnUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
