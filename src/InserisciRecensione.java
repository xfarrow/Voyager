import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class InserisciRecensione extends JFrame {

	private Controller TheController;
	private JPanel contentPane;
	private JButton btn_apriProfilo;
	private JPanel panel_1;
	private JLabel profile_photo_frame;
	private JLabel val_total_star;
	private JLabel valTotale;
	private JPanel panel_2;
	private JButton btnStella1;
	private JButton btnStella2;
	private JButton btnStella3;
	private JButton btnStella4;
	private JButton btnStella5;
	private JTextField txtTitoloRecensione;
	private JButton btnInviaRecensione;
	private int stelle;
	private String titolo;
	private String descrizione;
	private JLabel lbl_denominazione;
	private JLabel lbl_indirizzo;
	private JLabel tipologia_icon;
	private JLabel lbl_tipologia;
	private JLabel indirizzo_icon;
	private JLabel lblNewLabel;
	private JButton btnIndietro;
	private JLabel lblValutazioni;
	private JLabel val_1;
	private JSpinner spinner_1;
	private JLabel val_2;
	private JSpinner spinner_2;
	private JLabel val_3;
	private JSpinner spinner_3;
	/**
	 * Create the frame.
	 */
	public InserisciRecensione(Esercizio esercizio, Controller controller) {
		setResizable(false);
		TheController = controller;
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciRecensione.class.getResource("/images/icon.png")));
		setTitle("Voyager - Recensisci");
		setBounds(100, 100, 720, 604);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(20, 20));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 102, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		btn_apriProfilo = new JButton("Username");
		btn_apriProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_apriProfilo.setMinimumSize(new Dimension(20, 23));
		btn_apriProfilo.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_apriProfilo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn_apriProfilo.setMaximumSize(new Dimension(103, 23));
		btn_apriProfilo.setForeground(Color.WHITE);
		btn_apriProfilo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_apriProfilo.setFocusable(false);
		btn_apriProfilo.setBorderPainted(false);
		btn_apriProfilo.setBorder(null);
		btn_apriProfilo.setBackground(new Color(255, 102, 0));
		
		btn_apriProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!TheController.controllaProfiloVisibile()) { 
					TheController.apriProfilo();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_apriProfilo.setBackground(new Color(255, 148, 79));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_apriProfilo.setBackground(new Color(255, 102, 0));
			}
		});
		
		btnIndietro = new JButton("");
		btnIndietro.setBorder(null);
		btnIndietro.setHorizontalTextPosition(SwingConstants.LEFT);
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.setBackground(new Color(255, 102, 0));
		btnIndietro.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/back_button.png")));
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.hidePaginaRecensione();
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnIndietro, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
					.addComponent(btn_apriProfilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnIndietro, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_apriProfilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		ArrayList<String> valutazioni = new ArrayList<String>();
		valutazioni = TheController.getValutazioniEsercizio(esercizio.id);
		
		String pathStar; //Path icona recensioni		
		if(valutazioni.get(5).toString().equalsIgnoreCase("0")) { 
			pathStar = "/images/icons/val_total_0.png";
		} else { //Altrimenti icona stella "recensione presente"
			pathStar = "/images/icons/val_total.png";
		}
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		
		stelle = 1;//DEFAULT VALUE
		
		btnStella1 = new JButton("");
		btnStella1.setFocusable(false);
		btnStella1.setRequestFocusEnabled(false);
		btnStella1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnStella1.setContentAreaFilled(false);
		btnStella1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStella1.setBorder(null);
		btnStella1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStella1.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
		
		btnStella2 = new JButton("");
		btnStella2.setFocusable(false);
		btnStella2.setRequestFocusEnabled(false);
		btnStella2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnStella2.setContentAreaFilled(false);
		btnStella2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStella2.setBorder(null);
		btnStella2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
		
		btnStella3 = new JButton("");
		btnStella3.setFocusable(false);
		btnStella3.setRequestFocusEnabled(false);
		btnStella3.setContentAreaFilled(false);
		btnStella3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStella3.setBorder(null);
		btnStella3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
		
		btnStella4 = new JButton("");
		btnStella4.setFocusable(false);
		btnStella4.setRequestFocusEnabled(false);
		btnStella4.setContentAreaFilled(false);
		btnStella4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStella4.setBorder(null);
		btnStella4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
		
		btnStella5 = new JButton("");
		btnStella5.setFocusable(false);
		btnStella5.setRequestFocusEnabled(false);
		btnStella5.setContentAreaFilled(false);
		btnStella5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStella5.setBorder(null);
		btnStella5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
		
		btnStella1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stelle = 1;
				
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
			}
		});
		
		btnStella2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stelle = 2;
				
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(stelle<2) {
					btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
			}
		});
		
		btnStella3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stelle = 3;
				
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(stelle<2) {
					btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<3) {
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<4) {
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
			}
		});
		
		btnStella4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stelle = 4;
				
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(stelle<2) {
					btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<3) {
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<4) {
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
			}
		});
		
		btnStella5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stelle = 5;
				
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
				btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star_active.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(stelle<2) {
					btnStella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<3) {
					btnStella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<4) {
					btnStella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
					btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
				if(stelle<5) {
					btnStella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/val_button_star.png")));
				}
			}
		});
		
		txtTitoloRecensione = new JTextField();
		txtTitoloRecensione.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		txtTitoloRecensione.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtTitoloRecensione.setText("Titolo recensione...");
		txtTitoloRecensione.setSelectedTextColor(Color.WHITE);
		txtTitoloRecensione.setToolTipText("");
		txtTitoloRecensione.setColumns(10);
		
		JTextPane txtpnDescrizioneRecensione = new JTextPane();
		txtpnDescrizioneRecensione.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtpnDescrizioneRecensione.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		txtpnDescrizioneRecensione.setText("Descrizione recensione...");
		
		btnInviaRecensione = new JButton("Invia recensione");
		btnInviaRecensione.setFont(new Font("Open Sans", Font.PLAIN, 15));
		btnInviaRecensione.setBackground(new Color(109, 175, 223));
		btnInviaRecensione.setBorder(new LineBorder(new Color(102, 164, 209), 1, true));
		btnInviaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInviaRecensione.setFocusable(false);
		btnInviaRecensione.setForeground(new Color(255, 255, 255));
		
		lblNewLabel = new JLabel("Giudizio Complessivo");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
		
		ArrayList<String> nomeValutazione = new ArrayList<String>();
		if(esercizio.getTipologia().equals("Ristorante")) {

			nomeValutazione.add("Cucina");
			nomeValutazione.add("Servizio");
			nomeValutazione.add("Prezzo");
		} else if(esercizio.getTipologia().equals("Alloggio")) {
			nomeValutazione.add("Pulizia");
			nomeValutazione.add("Servizio");
			nomeValutazione.add("Posizione");
		} else if(esercizio.getTipologia().equals("Attrazione")) {
			nomeValutazione.add("");
			nomeValutazione.add("");
			nomeValutazione.add("");
		}
		
		val_1 = new JLabel("Valutazione 1");
		val_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
		val_1.setText(nomeValutazione.get(0));
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		lblValutazioni = new JLabel("Valutazioni");
		lblValutazioni.setForeground(Color.WHITE);
		lblValutazioni.setFont(new Font("Open Sans", Font.BOLD, 17));
		
		val_2 = new JLabel("Valutazione 1");
		val_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
		val_2.setText(nomeValutazione.get(1));
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		val_3 = new JLabel("Valutazione 1");
		val_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		val_3.setText(nomeValutazione.get(2));
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		if(esercizio.getTipologia().equals("Attrazione")) {
			lblValutazioni.setForeground(Color.WHITE);
			spinner_1.setVisible(false);
			spinner_2.setVisible(false);
			spinner_3.setVisible(false);
		}
		
		btnInviaRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(esercizio.getTipologia().equals("Ristorante")) {
					RecensioneRistorante nuovaRecensioneRistorante = new RecensioneRistorante();
					nuovaRecensioneRistorante.setEsercizioID(esercizio.getId());
					nuovaRecensioneRistorante.setUtente(TheController.current_user.getUsername());
					nuovaRecensioneRistorante.setTitolo(txtTitoloRecensione.getText());
					nuovaRecensioneRistorante.setDescrizione(txtpnDescrizioneRecensione.getText());
					nuovaRecensioneRistorante.setStelle(stelle);
					nuovaRecensioneRistorante.setTipoRecensione(esercizio.getTipologia());
					nuovaRecensioneRistorante.setValutazioneCucina((Integer)spinner_1.getValue());
					nuovaRecensioneRistorante.setValutazioneServizio((Integer)spinner_2.getValue());
					nuovaRecensioneRistorante.setValutazioneConto((Integer)spinner_3.getValue());
					TheController.inserisciRecensione(nuovaRecensioneRistorante);
				}else if(esercizio.getTipologia().equals("Alloggio")) {
					RecensioneAlloggio nuovaRecensioneAlloggio = new RecensioneAlloggio();
					nuovaRecensioneAlloggio.setEsercizioID(esercizio.getId());
					nuovaRecensioneAlloggio.setUtente(TheController.current_user.getUsername());
					nuovaRecensioneAlloggio.setTitolo(txtTitoloRecensione.getText());
					nuovaRecensioneAlloggio.setDescrizione(txtpnDescrizioneRecensione.getText());
					nuovaRecensioneAlloggio.setStelle(stelle);
					nuovaRecensioneAlloggio.setTipoRecensione(esercizio.getTipologia());
					nuovaRecensioneAlloggio.setValutazionePulizia((Integer)spinner_1.getValue());
					nuovaRecensioneAlloggio.setValutazioneServizio((Integer)spinner_2.getValue());
					nuovaRecensioneAlloggio.setValutazionePosizione((Integer)spinner_3.getValue());
					TheController.inserisciRecensione(nuovaRecensioneAlloggio);
				}else {
					Recensione recensione = new Recensione();
					recensione.setEsercizioID(esercizio.getId());
					recensione.setUtente(TheController.current_user.getUsername());
					recensione.setTitolo(txtTitoloRecensione.getText());
					recensione.setDescrizione(txtpnDescrizioneRecensione.getText());
					recensione.setStelle(stelle);
					recensione.setTipoRecensione(esercizio.getTipologia());
					TheController.inserisciRecensione(recensione);
				}
				TheController.hidePaginaRecensione();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(294)
					.addComponent(btnInviaRecensione, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(83)
					.addComponent(lblValutazioni)
					.addGap(580))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(val_3)
							.addGap(44)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnDescrizioneRecensione, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
								.addComponent(txtTitoloRecensione, Alignment.LEADING, 282, 318, Short.MAX_VALUE))
							.addGap(216))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(val_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(117)
									.addComponent(lblNewLabel))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(96)
									.addComponent(btnStella1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStella2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStella3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStella4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStella5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
							.addGap(254))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
							.addGap(56))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(val_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblValutazioni)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnStella5)
											.addComponent(btnStella4))
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnStella2)
											.addComponent(btnStella3)
											.addComponent(btnStella1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)
									.addComponent(txtTitoloRecensione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtpnDescrizioneRecensione, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnInviaRecensione))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(val_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(val_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(val_3)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(221)
							.addComponent(lblNewLabel)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		profile_photo_frame = new JLabel("");
		profile_photo_frame.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/profile_photo_frame.png")));
		profile_photo_frame.setHorizontalAlignment(SwingConstants.CENTER);
		profile_photo_frame.setHorizontalTextPosition(SwingConstants.CENTER);
		
		valTotale = new JLabel("0,0");
		valTotale.setFont(new Font("Open Sans", Font.PLAIN, 29));
		
		NumberFormat formatter = new DecimalFormat("#0.0");   
		double valutazione = Double.valueOf(valutazioni.get(5));
		valTotale.setText(formatter.format(valutazione).toString());
		
		val_total_star = new JLabel("");
		val_total_star.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/icons/val_total.png")));
		
				val_total_star.setHorizontalTextPosition(SwingConstants.CENTER);
				val_total_star.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_denominazione = new JLabel("NomeEsercizio");
		lbl_denominazione.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_denominazione.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_denominazione.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lbl_denominazione.setText(esercizio.getDenominazione());
		
		lbl_indirizzo = new JLabel("Indirizzo");
		lbl_indirizzo.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_indirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_indirizzo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lbl_indirizzo.setText(TheController.getIndirizzoString(esercizio.getIdIndirizzo()));
		
		String pathType; //Path icona tipologia
		
		if(esercizio.getTipologia().equals("Ristorante")) {
			pathType = "/images/icons/restaurant_type.png";
		} else if(esercizio.getTipologia().equals("Alloggio")) {
			pathType = "/images/icons/alloggio_type.png";
		} else {
			pathType = "/images/icons/attrazione_type.png";
		}
		tipologia_icon = new JLabel("");
		tipologia_icon.setHorizontalAlignment(SwingConstants.CENTER);
		tipologia_icon.setHorizontalTextPosition(SwingConstants.CENTER);
		tipologia_icon.setIcon(new ImageIcon(PaginaEsercizio.class.getResource(pathType)));
		
		lbl_tipologia = new JLabel("Tipologia");
		lbl_tipologia.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_tipologia.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tipologia.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lbl_tipologia.setText(TheController.getSubCategoryString(esercizio.getId(), esercizio.getTipologia()));
		
		indirizzo_icon = new JLabel("");
		indirizzo_icon.setHorizontalAlignment(SwingConstants.CENTER);
		indirizzo_icon.setHorizontalTextPosition(SwingConstants.CENTER);
		indirizzo_icon.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/images/icons/location.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addComponent(profile_photo_frame, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(val_total_star)
							.addGap(8)
							.addComponent(valTotale))
						.addComponent(lbl_denominazione)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(tipologia_icon)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_tipologia))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(indirizzo_icon)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_indirizzo)))
					.addGap(102))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(val_total_star)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lbl_denominazione)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addComponent(indirizzo_icon)
										.addComponent(lbl_indirizzo))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addComponent(tipologia_icon)
										.addComponent(lbl_tipologia)))
								.addComponent(profile_photo_frame)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(26)
							.addComponent(valTotale)))
					.addGap(55))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
	}
}
