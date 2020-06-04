import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PaginaEsercizio extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	
	private JLabel lbl_nome_esercizio;
	private JLabel lbl_indirizzo;
	JTextPane textPane_descrizione;
	JLabel lbl_telefono;
	JLabel lbl_email;
	JLabel lbl_sito;
	
	private JLabel label_orario_apertura_static;
	private JLabel label_orario_apertura_dynamic;
	private JLabel lblOrarioChiusura_static;
	private JLabel label_orario_chiusura_dynamic;
	private JLabel lblSenzaGlutine;
	private JLabel lblVeganFriendly;
	private JLabel lblWifi;
	private JLabel lblPostiASedere;
	private JLabel lblDaAsporto;
	private JLabel lblServito;
	private JLabel lblPizzeria;
	private JLabel lblBraceria;
	private JLabel lblPub;
	private JLabel lblRistorante;
	private JLabel labelSenzaGlutineDynamic;
	private JLabel labelVeganFriendlyDynamic;
	private JLabel labelWiFiDynamic;
	private JLabel labelPostiASedereDynamic;
	private JLabel labelDaAsportoDynamic;
	private JLabel labelServitoDynamic;
	private JLabel labelPizzeriaDynamic;
	private JLabel labelBraceriaDynamic;
	private JLabel labelPubDynamic;
	private JLabel labelRistoranteDynamic;

	private JLabel labelPizzaFritta;
	private JLabel lblSoloCena;
	private JLabel lblFornoElettrico;
	private JLabel lblFornoALegna;
	private JLabel labelSoloCenaDynamic;
	private JLabel labelPizzaFrittaDynamic;
	private JLabel labelFornoElettricoDynamic;
	private JLabel labelFornoLegnaDynamic;
	
	private JLabel labelBirreria;
	private JLabel labelBirreriaDynamic;
	
	private JLabel labelCarne;
	private JLabel labelPesce;
	private JLabel labelPesceDynamic;
	private JLabel labelCarneDynamic;
	
	private JLabel labelStanze;
	private JLabel labelStanzeDynamic;
	private JLabel labelBagni;
	private JLabel labelBagniDynamic;
	private JLabel labelTV;
	private JLabel labelTVDynamic;
	private JLabel labelParcheggio;
	private JLabel labelParcheggioDynamic;
	private JLabel labelWiFi_alloggio;
	private JLabel labelWiFiDynamic_alloggio;
	private JLabel labelPiscina;
	private JLabel labelPiscinaDynamic;
	private JLabel labelCondizionamento;
	private JLabel labelCondizionamentoDynamic;
	private JLabel labelAnimaliAmmessi;
	private JLabel labelAnimaliAmmessiDynamic;
	private JLabel lblReception;
	private JLabel lblVietatoFumare;
	private JLabel lblServizioBiancheria;
	private JLabel lblLavatrice;
	private JLabel lblLavastoviglie;
	private JLabel lblTipoLetti;
	private JLabel labelReceptionDynamic;
	private JLabel labelVietatoFumareDynamic;
	private JLabel labelServizioBiancheriaDynamic;
	private JLabel labelLavatriceDynamic;
	private JLabel labelLavastoviglieDynamic;
	private JLabel labelTipoLettiDynamic;
	private JLabel lblTipologia;
	private JLabel lblMetriQuadri;
	private JLabel lblTipoEsterno;
	private JLabel lblVietatoFumareCasa;
	private JLabel lblServizioBiancheriaCasa;
	private JLabel lblLavatriceCasa;
	private JLabel lblTipoLetto;
	private JLabel labelTipologiaDynamic;
	private JLabel labelMetriQuadriDynamic;
	private JLabel labelTipoEsterno;
	private JLabel labelVietatoFumareCasaDynamic;
	private JLabel lblServizioBiancheriaCasaDynamic;
	private JLabel labelLavatriceCasaDynamic;
	private JLabel labelLavastoviglieCasaDynamic;
	private JLabel labelTipoLettoDynamic;
	private JLabel lblDiscoteca;
	private JLabel lblNotturno;
	private JLabel lblSalaBallo;
	private JLabel lblSalaEventi;
	private JLabel labelDiscotecaDynamic;
	private JLabel labelNotturnoDynamic;
	private JLabel labelSalaBalloDynamic;
	private JLabel labelSalaEventiDynamic;
	private JLabel lblTematico;
	private JLabel lblDivertimenti;
	private JLabel labelTematicoDynamic;
	private JLabel labelDivertimentiDynamic;
	private JLabel lblArcheologico;
	private JLabel lblArtistico;
	private JLabel lblMarino;
	private JLabel lblMilitare;
	private JLabel lblScientifico;
	private JLabel lblStorico;
	private JLabel lblNaturale;
	private JLabel lblArcheologico_1;
	private JLabel labelArcheologicoDynamic;
	private JLabel labelArtisticoDynamic;
	private JLabel labelMarinoDynamic;
	private JLabel labelMilitareDynamic;
	private JLabel labelScientificoDynamic;
	private JLabel labelStoricoDynamic;
	private JLabel labelNaturaleDynamic;
	private JLabel labelVirtualeDynamic;
	private JPanel panel;
	private JButton btn_apriProfilo;
	private JPanel panel_1;
	private JLabel val_total_star;
	private JLabel profile_photo_frame;
	private JLabel icon_tipologia;
	private JLabel lbl_tipologia;
	private JLabel icon_indirizzo;
	private JLabel icon_telefono;
	private JLabel icon_email;
	private JLabel icon_website;
	private JPanel panel_2;
	private JLabel lblValutazioni;
	private JSeparator separator;
	private JLabel lblVal_1;
	private JLabel val_1_2;
	private JLabel val_1_1;
	private JLabel val_1_3;
	private JLabel val_1_4;
	private JLabel val_1_5;
	private JLabel val_2_5;
	private JLabel val_2_4;
	private JLabel val_2_3;
	private JLabel val_2_2;
	private JLabel val_2_1;
	private JLabel lblVal_2;
	private JLabel lblVal_3;
	private JLabel val_3_1;
	private JLabel val_3_2;
	private JLabel val_3_3;
	private JLabel val_3_4;
	private JLabel val_3_5;
	private JPanel panel_3;
	private JLabel lblComplessive;
	private JLabel lblNewLabel;
	private JLabel valTotCount_5;
	private JLabel valTotCount_4;
	private JLabel valTotCount_3;
	private JLabel valTotCount_2;
	private JLabel valTotCount_1;
	private JLabel valTotale;
	private JButton btn_Iscriviti;
	private JButton btn_Login;
	private JPanel panel_4;
	private JLabel reviews_frame_left;
	private JLabel reviews_frame_right;
	private JLayeredPane layeredPane;
	private JList<String> list;
	private JButton btnRecensisci;
	private ArrayList<Recensione> listaRecensioni;
	private JScrollPane scrollPane;
	
	public PaginaEsercizio(Controller controller, Esercizio esercizio) {
		setMinimumSize(new Dimension(1025, 768));
		TheController = controller;
		
		setTitle("Voyager - "+esercizio.getDenominazione());
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaEsercizio.class.getResource("/images/icon.png")));
		
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		printEsercizio(esercizio);/*
		 if(esercizio.getTipologia().equals("Ristorante")) {
			PuntoRistoro currPuntoRistoro = new PuntoRistoro(controller.getPuntoRistoroById(esercizio.getId()));
			printPuntoRistoro(currPuntoRistoro);
		 
			if(currPuntoRistoro.getPizzeria()==true) {
				Pizzeria currPizzeria = new Pizzeria(controller.getPizzeriaById(esercizio.getId()));
				printPizzeria(currPizzeria);
			}
			
			if(currPuntoRistoro.getPub()==true) {
				Pub currPub = new Pub(controller.getPubById(esercizio.getId()));
				printPub(currPub);
			}
			
			if(currPuntoRistoro.getRistorante()==true) {
				
			}if(currPuntoRistoro.getBraceria()==true) {
				Braceria currBraceria = new Braceria(controller.getBraceriaById(esercizio.getId()));
				printBraceria(currBraceria);
			}
			
		}
		 else if(esercizio.getTipologia().equals("Alloggio")) {
			Alloggio currAlloggio = new Alloggio(controller.getAlloggioById(esercizio.getId()));
			printAlloggio(currAlloggio);
			if(currAlloggio.getTipoAlloggio().equals("Hotel")) {
				Hotel currHotel = new Hotel(controller.getHotelById(esercizio.getId()));
				printHotel(currHotel);
			}else if(currAlloggio.getTipoAlloggio().equals("Casa")) {
				Casa currCasa = new Casa(controller.getCasaById(esercizio.getId()));
				printCasa(currCasa);
			}else if(currAlloggio.getTipoAlloggio().equals("BedAndBreakfast")) {
				BedAndBreakfast currBedAndBreakfast = new BedAndBreakfast(controller.getBedAndBreakfastById(esercizio.getId()));
				printBedAndBreakfast(currBedAndBreakfast);
			}
			
		}else if(esercizio.getTipologia().equals("Attrazione")) {
			Attrazione currAttrazione = new Attrazione(controller.getAttrazioneById(esercizio.getId()));
			printAttrazione(currAttrazione);
			if(currAttrazione.getTipoAttrazione().equals("Locale")) {
				Locale currLocale = new Locale(controller.getLocaleById(esercizio.getId()));
				printLocale(currLocale);
			}else if(currAttrazione.getTipoAttrazione().equals("Parco")) {
				System.out.println("Cerco per ID: "+esercizio.getId());
				Parco currParco = new Parco(controller.getParcoById(esercizio.getId()));
				printParco(currParco);
			}else if(currAttrazione.getTipoAttrazione().equals("Museo")) {
				Museo currMuseo = new Museo(controller.getMuseoById(esercizio.getId()));
				printMuseo(currMuseo);
			}
		}*/
		
	}
	
	private void printEsercizio(Esercizio esercizio) {
		ArrayList<String> valutazioni = new ArrayList<String>();
		
		valutazioni = TheController.getValutazioniEsercizio(esercizio.id);
		String indirizzo = TheController.getIndirizzoString(esercizio.getIdIndirizzo());
		
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 24));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 102, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		btn_apriProfilo = new JButton("Username");
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
		btn_apriProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_apriProfilo.setBorderPainted(false);
		btn_apriProfilo.setRequestFocusEnabled(false);
		btn_apriProfilo.setForeground(Color.WHITE);
		btn_apriProfilo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_apriProfilo.setFocusable(false);
		btn_apriProfilo.setBorder(null);
		btn_apriProfilo.setBackground(new Color(255, 102, 0));
		btn_apriProfilo.setVisible(false);
		
		JButton btnIndietro = new JButton("");
		btnIndietro.setBorder(null);
		btnIndietro.setHorizontalTextPosition(SwingConstants.LEFT);
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.setBackground(new Color(255, 102, 0));
		btnIndietro.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/back_button.png")));
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.hidePaginaEsercizio();
			}
		});
		
		btn_Iscriviti = new JButton("Iscriviti");
		btn_Iscriviti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Iscriviti.setBackground(new Color(255, 102, 0));
				//Se il frame non e' istanziato o non e' visibile allora visualizza
				if(!TheController.controllaIscrizioneVisibile()) { 
					TheController.iscriviFrame();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Iscriviti.setBackground(new Color(255, 148, 79));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Iscriviti.setBackground(new Color(255, 102, 0));
			}
		});
		btn_Iscriviti.setForeground(Color.WHITE);
		btn_Iscriviti.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_Iscriviti.setFocusable(false);
		btn_Iscriviti.setBorder(null);
		btn_Iscriviti.setBackground(new Color(255, 102, 0));
		
		btn_Login = new JButton("Accedi");
		btn_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Login.setBackground(new Color(255, 102, 0));
				//Se il frame non e' istanziato o non e' visibile allora visualizza
				if(!TheController.controllaLoginVisibile()) { 
					TheController.loginFrame();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Login.setBackground(new Color(255, 148, 79));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Login.setBackground(new Color(255, 102, 0));
			}
		});
		btn_Login.setForeground(Color.WHITE);
		btn_Login.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_Login.setFocusable(false);
		btn_Login.setBorderPainted(false);
		btn_Login.setBorder(null);
		btn_Login.setBackground(new Color(255, 102, 0));
		
		btnRecensisci = new JButton("Recensisci");
		btnRecensisci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecensisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRecensisci.setBackground(new Color(255, 102, 0));
				//Se il frame non e' istanziato o non e' visibile allora visualizza
				if(!TheController.controllaIscrizioneVisibile() && !TheController.checkReviewAlreadyExists(TheController.current_user.getUsername(), esercizio.getId())) {
					TheController.recensioneFrame(esercizio);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRecensisci.setBackground(new Color(255, 148, 79));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnRecensisci.setBackground(new Color(255, 102, 0));
			}
		});
		btnRecensisci.setForeground(Color.WHITE);
		btnRecensisci.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btnRecensisci.setFocusable(false);
		btnRecensisci.setBorder(null);
		btnRecensisci.setBackground(new Color(255, 102, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(btnIndietro, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnRecensisci, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 534, Short.MAX_VALUE)
					.addComponent(btn_Iscriviti, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_Login, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_apriProfilo)
					.addGap(19))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(btnIndietro, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_apriProfilo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Login, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Iscriviti, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRecensisci, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(10, 674));
		panel_1.setPreferredSize(new Dimension(10, 674));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		lbl_nome_esercizio = new JLabel("nome_esercizio");
		lbl_nome_esercizio.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_nome_esercizio.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_nome_esercizio.setFont(new Font("Open Sans", Font.PLAIN, 29));
		lbl_nome_esercizio.setText(esercizio.getDenominazione());
		
		textPane_descrizione = new JTextPane();
		textPane_descrizione.setAlignmentX(Component.LEFT_ALIGNMENT);
		textPane_descrizione.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textPane_descrizione.setSelectionColor(new Color(255, 102, 0));
		textPane_descrizione.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(204, 204, 204)));
		textPane_descrizione.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textPane_descrizione.setFont(new Font("Open Sans", Font.PLAIN, 17));
		textPane_descrizione.setEditable(false);
		textPane_descrizione.setText(esercizio.getDescrizione());
		

		lbl_tipologia = new JLabel("Ristorante");
		lbl_tipologia.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tipologia.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_tipologia.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lbl_tipologia.setText(TheController.getSubCategoryString(esercizio.getId(), esercizio.getTipologia()));
		
		lbl_indirizzo = new JLabel("Indirizzo");
		lbl_indirizzo.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lbl_indirizzo.setText(indirizzo);
		
		lbl_sito = new JLabel("www.sito.it");
		lbl_sito.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lbl_sito.setText(esercizio.getSitoWeb());
		
		lbl_email = new JLabel("esercizio@myprovider.com");
		lbl_email.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lbl_email.setText(esercizio.getEmail());
		
		lbl_telefono = new JLabel("+39 333 333 3333");
		lbl_telefono.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_telefono.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_telefono.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lbl_telefono.setText(esercizio.getTelefono());
		
		String pathStar; //Path icona recensioni		
		if(valutazioni.get(5).toString().equalsIgnoreCase("0")) { 
			pathStar = "/images/icons/val_total_0.png";
		} else { //Altrimenti icona stella "recensione presente"
			pathStar = "/images/icons/val_total.png";
		}
		val_total_star = new JLabel("");
		val_total_star.setAlignmentY(Component.TOP_ALIGNMENT);
		val_total_star.setIcon(new ImageIcon(ListaEsercizi.class.getResource(pathStar)));
		
		profile_photo_frame = new JLabel("");
		profile_photo_frame.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/profile_photo_frame.png")));
		
		String pathType; //Path icona tipologia
		if(esercizio.getTipologia().equals("Ristorante")) {
			pathType = "/images/icons/restaurant_type.png";
		} else if(esercizio.getTipologia().equals("Alloggio")) {
			pathType = "/images/icons/alloggio_type.png";
		} else {
			pathType = "/images/icons/attrazione_type.png";
		}
		
		icon_tipologia = new JLabel("");
		icon_tipologia.setHorizontalAlignment(SwingConstants.CENTER);
		icon_tipologia.setHorizontalTextPosition(SwingConstants.CENTER);
		icon_tipologia.setAlignmentY(Component.TOP_ALIGNMENT);
		icon_tipologia.setIcon(new ImageIcon(PaginaEsercizio.class.getResource(pathType)));
		
		icon_indirizzo = new JLabel("");
		icon_indirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		icon_indirizzo.setHorizontalTextPosition(SwingConstants.CENTER);
		icon_indirizzo.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/icons/location.png")));
		
		icon_telefono = new JLabel("");
		icon_telefono.setAlignmentY(Component.TOP_ALIGNMENT);
		icon_telefono.setHorizontalTextPosition(SwingConstants.CENTER);
		icon_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		icon_telefono.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/icons/phone.png")));
		
		icon_email = new JLabel("");
		icon_email.setAlignmentY(Component.TOP_ALIGNMENT);
		icon_email.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/icons/email.png")));
		icon_email.setHorizontalTextPosition(SwingConstants.CENTER);
		icon_email.setHorizontalAlignment(SwingConstants.CENTER);
		
		icon_website = new JLabel("");
		icon_website.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/icons/website.png")));
		
		panel_2 = new JPanel();
		if(esercizio.getTipologia().equals("Attrazione")) {
			panel_2.setVisible(false);
		}
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		
		valTotale = new JLabel("0,0");
		valTotale.setFont(new Font("Open Sans", Font.PLAIN, 29));
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(97)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane_descrizione, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(profile_photo_frame)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(val_total_star))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(icon_tipologia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(icon_indirizzo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(icon_telefono, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(4)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_indirizzo)
										.addComponent(lbl_tipologia)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lbl_telefono)
											.addGap(18)
											.addComponent(icon_email, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lbl_email)
											.addGap(18)
											.addComponent(icon_website)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lbl_sito))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(valTotale)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_nome_esercizio))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(profile_photo_frame)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(val_total_star)
									.addGap(17)
									.addComponent(icon_tipologia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(valTotale, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_nome_esercizio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(separator, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_tipologia)))
							.addGap(9)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(icon_indirizzo)
								.addComponent(lbl_indirizzo))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(icon_telefono, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lbl_telefono)
									.addComponent(lbl_email)
									.addComponent(icon_email, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(icon_website)
									.addComponent(lbl_sito)))))
					.addGap(18)
					.addComponent(textPane_descrizione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(38))
		);
		
		reviews_frame_left = new JLabel("");
		reviews_frame_left.setBorder(null);
		//reviews_frame_left.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/reviews_frame_left.png")));
		reviews_frame_left.setHorizontalAlignment(SwingConstants.LEFT);
		
		reviews_frame_right = new JLabel("");
		//reviews_frame_right.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/reviews_frame_right.png")));
		reviews_frame_right.setHorizontalTextPosition(SwingConstants.RIGHT);
		reviews_frame_right.setHorizontalAlignment(SwingConstants.RIGHT);
		reviews_frame_right.setBorder(null);
		
		layeredPane = new JLayeredPane();
		
		listaRecensioni = TheController.visualizzaRecensioni(esercizio);
		
		scrollPane = new JScrollPane();
		
		list = new JList<String>(new DefaultListModel<String>());
		scrollPane.setViewportView(list);
		list.setBackground(Color.WHITE);
		
		for(Recensione recensione: listaRecensioni) {
			((DefaultListModel<String>)list.getModel()).addElement(""
					+"<html>"
					+"<h3 style='margin:0 0 0 0;'>Recensione di "
					+recensione.getUtente()
					+"</h3><div style='margin-left:3em;'>"
					+"<font style='font-family:Open Sans;font-size:2em;padding:0;margin:0 0 0 0'>"
					+"<img src='"+ListaEsercizi.class.getResource("/images/val_button_star_active.png")+"'></img>&nbsp;"
					+recensione.getStelle()
					+"</font>&nbsp;&nbsp;&nbsp;<font style='font-family:Open Sans;font-size:1.5em;padding:0;margin:0 0 0 0'>"
					+recensione.getTitolo()
					+"</font>"
					+"<br>&nbsp;&nbsp;"
					+"<font style='font-family:Open Sans;font-size:1.2em;font-weight:normal;padding:0;'>"
					+recensione.getDescrizione()
					+"</font></div><br>"
					);
		}
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(reviews_frame_left, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(210)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reviews_frame_right, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(reviews_frame_left)
						.addComponent(reviews_frame_right))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		lblComplessive = new JLabel("Complessive");
		lblComplessive.setHorizontalTextPosition(SwingConstants.CENTER);
		lblComplessive.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplessive.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblComplessive.setAlignmentY(0.0f);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/tabella_valutazioni.png")));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		NumberFormat formatter = new DecimalFormat("#0.0");   
		double valutazione = Double.valueOf(valutazioni.get(5));
		valTotale.setText(formatter.format(valutazione).toString());
		
		valTotCount_5 = new JLabel("( "+valutazioni.get(4)+" )");
		valTotCount_5.setFont(new Font("Open Sans", Font.PLAIN, 13));
		valTotCount_5.setAlignmentY(Component.TOP_ALIGNMENT);
		
		valTotCount_4 = new JLabel("( "+valutazioni.get(3)+" )");
		valTotCount_4.setFont(new Font("Open Sans", Font.PLAIN, 13));
		valTotCount_4.setAlignmentY(Component.TOP_ALIGNMENT);
		
		valTotCount_3 = new JLabel("( "+valutazioni.get(2)+" )");
		valTotCount_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		valTotCount_3.setAlignmentY(Component.TOP_ALIGNMENT);
		
		valTotCount_2 = new JLabel("( "+valutazioni.get(1)+" )");
		valTotCount_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
		valTotCount_2.setAlignmentY(Component.TOP_ALIGNMENT);
		
		valTotCount_1 = new JLabel("( "+valutazioni.get(0)+" )");
		valTotCount_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
		valTotCount_1.setAlignmentY(Component.TOP_ALIGNMENT);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(valTotCount_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(valTotCount_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(valTotCount_5, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(valTotCount_4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(valTotCount_3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(61)
							.addComponent(lblComplessive)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblComplessive, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(15)
							.addComponent(valTotCount_5)
							.addGap(14)
							.addComponent(valTotCount_4)
							.addGap(12)
							.addComponent(valTotCount_3)
							.addGap(14)
							.addComponent(valTotCount_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(valTotCount_1)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		lblValutazioni = new JLabel("Valutazioni");
		lblValutazioni.setHorizontalTextPosition(SwingConstants.CENTER);
		lblValutazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblValutazioni.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblValutazioni.setAlignmentY(Component.TOP_ALIGNMENT);
		
		lblVal_1 = new JLabel("Cucina");
		lblVal_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblVal_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
		if(esercizio.getTipologia().equals("Ristorante")) {
			lblVal_1.setText("Cucina");
		} else {
			lblVal_1.setText("Pulizia");
		}
		
		val_1_2 = new JLabel("");
		val_1_2.setAlignmentY(Component.TOP_ALIGNMENT);
		val_1_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		val_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_1_1 = new JLabel("");
		val_1_1.setAlignmentY(Component.TOP_ALIGNMENT);
		val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		val_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_1_3 = new JLabel("");
		val_1_3.setAlignmentY(Component.TOP_ALIGNMENT);
		val_1_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_1_3.setHorizontalTextPosition(SwingConstants.CENTER);
		val_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_1_4 = new JLabel("");
		val_1_4.setAlignmentY(Component.TOP_ALIGNMENT);
		val_1_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_1_4.setHorizontalTextPosition(SwingConstants.CENTER);
		val_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_1_5 = new JLabel("");
		val_1_5.setAlignmentY(Component.TOP_ALIGNMENT);
		val_1_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_1_5.setHorizontalTextPosition(SwingConstants.CENTER);
		val_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		int val_1 = TheController.getValutazioneSpeciale_1_Value(esercizio);
		if(val_1==1) {
			val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_1==2) {
			val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_1==3) {
			val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_1==4) {
			val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_1==5) {
			val_1_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_1_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		}
		
		val_2_5 = new JLabel("");
		val_2_5.setAlignmentY(Component.TOP_ALIGNMENT);
		val_2_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_2_5.setHorizontalTextPosition(SwingConstants.CENTER);
		val_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_2_4 = new JLabel("");
		val_2_4.setAlignmentY(Component.TOP_ALIGNMENT);
		val_2_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_2_4.setHorizontalTextPosition(SwingConstants.CENTER);
		val_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_2_3 = new JLabel("");
		val_2_3.setAlignmentY(Component.TOP_ALIGNMENT);
		val_2_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_2_3.setHorizontalTextPosition(SwingConstants.CENTER);
		val_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_2_2 = new JLabel("");
		val_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		val_2_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
		val_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_2_1 = new JLabel("");
		val_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		val_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		int val_2 = TheController.getValutazioneSpeciale_2_Value(esercizio);
		if(val_2==1) {
			val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_2==2) {
			val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_2==3) {
			val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_2==4) {
			val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_2==5) {
			val_2_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_2_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		}
		
		lblVal_2 = new JLabel("Servizio");
		lblVal_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblVal_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		lblVal_3 = new JLabel("Prezzo");
		lblVal_3.setAlignmentY(Component.TOP_ALIGNMENT);
		lblVal_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		if(esercizio.getTipologia().equals("Ristorante")) {
			lblVal_3.setText("Prezzo");
		} else {
			lblVal_3.setText("Posizione");
		}
		
		val_3_1 = new JLabel("");
		val_3_1.setAlignmentY(Component.TOP_ALIGNMENT);
		val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		val_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_3_2 = new JLabel("");
		val_3_2.setAlignmentY(Component.TOP_ALIGNMENT);
		val_3_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
		val_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_3_3 = new JLabel("");
		val_3_3.setAlignmentY(Component.TOP_ALIGNMENT);
		val_3_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_3_3.setHorizontalTextPosition(SwingConstants.CENTER);
		val_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_3_4 = new JLabel("");
		val_3_4.setAlignmentY(Component.TOP_ALIGNMENT);
		val_3_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_3_4.setHorizontalTextPosition(SwingConstants.CENTER);
		val_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		val_3_5 = new JLabel("");
		val_3_5.setAlignmentY(Component.TOP_ALIGNMENT);
		val_3_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star.png")));
		val_3_5.setHorizontalTextPosition(SwingConstants.CENTER);
		val_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		int val_3 = TheController.getValutazioneSpeciale_3_Value(esercizio);
		if(val_3==1) {
			val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_3==2) {
			val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_3==3) {
			val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_3==4) {
			val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		} else if(val_3==5) {
			val_3_1.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_2.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_3.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_4.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
			val_3_5.setIcon(new ImageIcon(PaginaEsercizio.class.getResource("/images/val_button_star_active.png")));
		}
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVal_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(lblVal_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(lblVal_3, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(24)
							.addComponent(val_3_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(val_3_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(val_3_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(val_3_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(val_3_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(val_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(val_1_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(val_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(val_1_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(val_1_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(val_2_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(val_2_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(val_2_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(val_2_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(val_2_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblValutazioni, Alignment.LEADING))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblValutazioni)
							.addGap(11)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(val_1_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(val_1_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(val_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(val_1_2)
								.addComponent(val_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblVal_1))
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(val_2_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_2_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_2_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_2_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_2_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVal_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(val_3_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_3_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_3_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_3_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(val_3_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVal_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(98))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
	}
	
	private void printPuntoRistoro(PuntoRistoro puntoristoro) {
		
		label_orario_apertura_static = new JLabel("Orario Apertura:");
		label_orario_apertura_static.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_orario_apertura_static.setBounds(110, 223, 137, 35);
		contentPane.add(label_orario_apertura_static);
		
		label_orario_apertura_dynamic = new JLabel("<dynamic>");
		label_orario_apertura_dynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_orario_apertura_dynamic.setBounds(235, 223, 137, 35);
		contentPane.add(label_orario_apertura_dynamic);
		
		lblOrarioChiusura_static = new JLabel("Orario Chiusura");
		lblOrarioChiusura_static.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrarioChiusura_static.setBounds(398, 223, 137, 35);
		contentPane.add(lblOrarioChiusura_static);
		
		label_orario_chiusura_dynamic = new JLabel("<dynamic>");
		label_orario_chiusura_dynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_orario_chiusura_dynamic.setBounds(524, 223, 137, 35);
		contentPane.add(label_orario_chiusura_dynamic);
		
		lblSenzaGlutine = new JLabel("Senza Glutine");
		lblSenzaGlutine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenzaGlutine.setBounds(110, 269, 108, 35);
		contentPane.add(lblSenzaGlutine);
		
		lblVeganFriendly = new JLabel("Vegan Friendly");
		lblVeganFriendly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVeganFriendly.setBounds(110, 315, 108, 35);
		contentPane.add(lblVeganFriendly);
		
		lblWifi = new JLabel("WiFi :");
		lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWifi.setBounds(110, 361, 108, 35);
		contentPane.add(lblWifi);
		
		lblPostiASedere = new JLabel("Posti a sedere");
		lblPostiASedere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPostiASedere.setBounds(110, 407, 108, 35);
		contentPane.add(lblPostiASedere);
		
		lblDaAsporto = new JLabel("Da asporto");
		lblDaAsporto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaAsporto.setBounds(110, 453, 108, 35);
		contentPane.add(lblDaAsporto);
		
		lblServito = new JLabel("Servito");
		lblServito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblServito.setBounds(110, 499, 108, 35);
		contentPane.add(lblServito);
		
		lblPizzeria = new JLabel("Pizzeria");
		lblPizzeria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPizzeria.setBounds(110, 545, 108, 35);
		contentPane.add(lblPizzeria);
		
		lblBraceria = new JLabel("Braceria");
		lblBraceria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBraceria.setBounds(110, 591, 108, 35);
		contentPane.add(lblBraceria);
		
		lblPub = new JLabel("Pub");
		lblPub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPub.setBounds(110, 637, 108, 35);
		contentPane.add(lblPub);
		
		lblRistorante = new JLabel("Ristorante");
		lblRistorante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRistorante.setBounds(110, 683, 108, 35);
		contentPane.add(lblRistorante);
		
		labelSenzaGlutineDynamic = new JLabel("<dynamic>");
		labelSenzaGlutineDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSenzaGlutineDynamic.setBounds(235, 269, 108, 35);
		contentPane.add(labelSenzaGlutineDynamic);
		
		labelVeganFriendlyDynamic = new JLabel("<dynamic>");
		labelVeganFriendlyDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVeganFriendlyDynamic.setBounds(235, 315, 108, 35);
		contentPane.add(labelVeganFriendlyDynamic);
		
		labelWiFiDynamic = new JLabel("<dynamic>");
		labelWiFiDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelWiFiDynamic.setBounds(235, 369, 76, 19);
		contentPane.add(labelWiFiDynamic);
		
		labelPostiASedereDynamic = new JLabel("<dynamic>");
		labelPostiASedereDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPostiASedereDynamic.setBounds(235, 407, 108, 35);
		contentPane.add(labelPostiASedereDynamic);
		
		labelDaAsportoDynamic = new JLabel("<dynamic>");
		labelDaAsportoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelDaAsportoDynamic.setBounds(235, 453, 108, 35);
		contentPane.add(labelDaAsportoDynamic);
		
		labelServitoDynamic = new JLabel("<dynamic>");
		labelServitoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelServitoDynamic.setBounds(235, 499, 108, 35);
		contentPane.add(labelServitoDynamic);
		
		labelPizzeriaDynamic = new JLabel("<dynamic>");
		labelPizzeriaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPizzeriaDynamic.setBounds(235, 545, 108, 35);
		contentPane.add(labelPizzeriaDynamic);
		
		labelBraceriaDynamic = new JLabel("<dynamic>");
		labelBraceriaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBraceriaDynamic.setBounds(235, 591, 108, 35);
		contentPane.add(labelBraceriaDynamic);
		
		labelPubDynamic = new JLabel("<dynamic>");
		labelPubDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPubDynamic.setBounds(235, 637, 108, 35);
		contentPane.add(labelPubDynamic);
		
		labelRistoranteDynamic = new JLabel("<dynamic>");
		labelRistoranteDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelRistoranteDynamic.setBounds(235, 683, 108, 35);
		contentPane.add(labelRistoranteDynamic);
		
	    label_orario_apertura_dynamic.setText(String.valueOf(puntoristoro.getOrarioApertura()));
	    label_orario_chiusura_dynamic.setText(String.valueOf(String.valueOf(puntoristoro.getOrarioChiusura())));
	    labelSenzaGlutineDynamic.setText(String.valueOf(puntoristoro.getSenzaGlutine()));
	    labelVeganFriendlyDynamic.setText(String.valueOf(puntoristoro.getVeganFriendly()));
	    labelWiFiDynamic.setText(String.valueOf(puntoristoro.getWiFi()));
	    labelPostiASedereDynamic.setText(String.valueOf(puntoristoro.getPostiASedere()));
	    labelDaAsportoDynamic.setText(String.valueOf(puntoristoro.getDaAsporto()));
	    labelServitoDynamic.setText(String.valueOf(puntoristoro.getServito()));
	    labelPizzeriaDynamic.setText(String.valueOf(puntoristoro.getPizzeria()));
	    labelBraceriaDynamic.setText(String.valueOf(puntoristoro.getBraceria()));
	    labelPubDynamic.setText(String.valueOf(puntoristoro.getPub()));
	    labelRistoranteDynamic.setText(String.valueOf(puntoristoro.getRistorante()));
	    
	}
	
	private void printPizzeria(Pizzeria pizzeria) {
	
		labelPizzaFritta = new JLabel("Pizza Fritta:");
		labelPizzaFritta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPizzaFritta.setBounds(398, 273, 108, 26);
		contentPane.add(labelPizzaFritta);
		
		lblSoloCena = new JLabel("Solo cena");
		lblSoloCena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoloCena.setBounds(398, 319, 108, 26);
		contentPane.add(lblSoloCena);
		
		lblFornoElettrico = new JLabel("Forno Elettrico");
		lblFornoElettrico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornoElettrico.setBounds(398, 365, 108, 26);
		contentPane.add(lblFornoElettrico);
		
		lblFornoALegna = new JLabel("Forno a Legna");
		lblFornoALegna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornoALegna.setBounds(398, 407, 108, 26);
		contentPane.add(lblFornoALegna);
		
		labelSoloCenaDynamic = new JLabel("<dynamic>");
		labelSoloCenaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSoloCenaDynamic.setBounds(524, 319, 108, 26);
		contentPane.add(labelSoloCenaDynamic);
		
		labelPizzaFrittaDynamic = new JLabel("<dynamic>");
		labelPizzaFrittaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPizzaFrittaDynamic.setBounds(524, 269, 108, 26);
		contentPane.add(labelPizzaFrittaDynamic);
		
		labelFornoElettricoDynamic = new JLabel("<dynamic>");
		labelFornoElettricoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFornoElettricoDynamic.setBounds(524, 361, 108, 26);
		contentPane.add(labelFornoElettricoDynamic);
		
		labelFornoLegnaDynamic = new JLabel("<dynamic>");
		labelFornoLegnaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFornoLegnaDynamic.setBounds(524, 407, 108, 26);
		contentPane.add(labelFornoLegnaDynamic);
		
		labelSoloCenaDynamic.setText(String.valueOf(pizzeria.getSoloCena()));
		labelPizzaFrittaDynamic.setText(String.valueOf(pizzeria.getPizzaFritta()));
		labelFornoElettricoDynamic.setText(String.valueOf(pizzeria.getFornoElettrico()));
		labelFornoLegnaDynamic.setText(String.valueOf(pizzeria.getFornoLegna()));
	}

	private void printPub(Pub pub) {
		
		labelBirreria = new JLabel("Birreria");
		labelBirreria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBirreria.setBounds(398, 459, 108, 23);
		contentPane.add(labelBirreria);
		
		labelBirreriaDynamic = new JLabel("<dynamic>");
		labelBirreriaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBirreriaDynamic.setBounds(524, 459, 108, 23);
		contentPane.add(labelBirreriaDynamic);
		
		labelBirreriaDynamic.setText(String.valueOf(pub.getBirreria()));
	}
	
	private void printBraceria(Braceria braceria) {
		
		labelCarne = new JLabel("Carne");
		labelCarne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCarne.setBounds(398, 503, 108, 26);
		contentPane.add(labelCarne);
		
		labelPesce = new JLabel("Pesce");
		labelPesce.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPesce.setBounds(398, 549, 108, 26);
		contentPane.add(labelPesce);
		
		labelPesceDynamic = new JLabel("<dynamic>");
		labelPesceDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPesceDynamic.setBounds(524, 545, 108, 26);
		contentPane.add(labelPesceDynamic);
		
		labelCarneDynamic = new JLabel("<dynamic>");
		labelCarneDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCarneDynamic.setBounds(524, 499, 108, 26);
		contentPane.add(labelCarneDynamic);
		
		labelPesceDynamic.setText(String.valueOf(braceria.getPesce()));
		labelCarneDynamic.setText(String.valueOf(braceria.getCarne()));
	}
	
	private void printAlloggio(Alloggio alloggio) {
		
		labelStanze = new JLabel("Stanze");
		labelStanze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStanze.setBounds(110, 223, 137, 35);
		contentPane.add(labelStanze);
		
		labelStanzeDynamic = new JLabel("<dynamic>");
		labelStanzeDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStanzeDynamic.setBounds(274, 223, 137, 35);
		contentPane.add(labelStanzeDynamic);
		
		labelBagni = new JLabel("Bagni");
		labelBagni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBagni.setBounds(110, 269, 108, 35);
		contentPane.add(labelBagni);
		
		labelBagniDynamic = new JLabel("<dynamic>");
		labelBagniDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBagniDynamic.setBounds(274, 269, 108, 35);
		contentPane.add(labelBagniDynamic);
		
		labelTV = new JLabel("Televisione");
		labelTV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTV.setBounds(110, 315, 108, 35);
		contentPane.add(labelTV);
		
		labelTVDynamic = new JLabel("<dynamic>");
		labelTVDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTVDynamic.setBounds(274, 315, 108, 35);
		contentPane.add(labelTVDynamic);
		
		labelParcheggio = new JLabel("Parcheggio");
		labelParcheggio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelParcheggio.setBounds(110, 361, 108, 35);
		contentPane.add(labelParcheggio);
		
		labelParcheggioDynamic = new JLabel("<dynamic>");
		labelParcheggioDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelParcheggioDynamic.setBounds(274, 361, 108, 35);
		contentPane.add(labelParcheggioDynamic);
		
		labelWiFi_alloggio = new JLabel("WiFi");
		labelWiFi_alloggio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelWiFi_alloggio.setBounds(110, 407, 108, 35);
		contentPane.add(labelWiFi_alloggio);
		
		labelWiFiDynamic_alloggio = new JLabel("<dynamic>");
		labelWiFiDynamic_alloggio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelWiFiDynamic_alloggio.setBounds(274, 407, 108, 35);
		contentPane.add(labelWiFiDynamic_alloggio);
		
		labelPiscina = new JLabel("Piscina");
		labelPiscina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPiscina.setBounds(110, 453, 108, 35);
		contentPane.add(labelPiscina);
		
		labelPiscinaDynamic = new JLabel("<dynamic>");
		labelPiscinaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPiscinaDynamic.setBounds(274, 453, 108, 35);
		contentPane.add(labelPiscinaDynamic);
		
		labelCondizionamento = new JLabel("Condizionamento");
		labelCondizionamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCondizionamento.setBounds(110, 499, 137, 35);
		contentPane.add(labelCondizionamento);
		
		labelCondizionamentoDynamic = new JLabel("<dynamic>");
		labelCondizionamentoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCondizionamentoDynamic.setBounds(274, 499, 108, 35);
		contentPane.add(labelCondizionamentoDynamic);
		
		labelAnimaliAmmessi = new JLabel("Animali Ammessi");
		labelAnimaliAmmessi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAnimaliAmmessi.setBounds(110, 545, 137, 35);
		contentPane.add(labelAnimaliAmmessi);
		
		labelAnimaliAmmessiDynamic = new JLabel("<dynamic>");
		labelAnimaliAmmessiDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAnimaliAmmessiDynamic.setBounds(274, 545, 108, 35);
		contentPane.add(labelAnimaliAmmessiDynamic);
		
		labelStanzeDynamic.setText(String.valueOf(alloggio.getStanze()));
		labelBagniDynamic.setText(String.valueOf(alloggio.getBagni()));
		labelTVDynamic.setText(String.valueOf(alloggio.getTV()));
		labelParcheggioDynamic.setText(String.valueOf(alloggio.getParcheggio()));
		labelWiFiDynamic_alloggio.setText(String.valueOf(alloggio.getWifi()));
		labelPiscinaDynamic.setText(String.valueOf(alloggio.getPiscina()));
		labelCondizionamentoDynamic.setText(String.valueOf(alloggio.getCondizionamento()));
		labelAnimaliAmmessiDynamic.setText(String.valueOf(alloggio.getAnimaliAmmessi()));
	}
	
	private void printHotel(Hotel hotel) {
		JLabel lblRistorante_hotel = new JLabel("Ristorante");
		lblRistorante_hotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRistorante_hotel.setBounds(461, 223, 137, 35);
		contentPane.add(lblRistorante_hotel);
		
		JLabel lblStelleHotel = new JLabel("Stelle");
		lblStelleHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStelleHotel.setBounds(461, 269, 137, 35);
		contentPane.add(lblStelleHotel);
		
		JLabel lblTipopensione = new JLabel("TipoPensione");
		lblTipopensione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipopensione.setBounds(461, 315, 137, 35);
		contentPane.add(lblTipopensione);
		
		JLabel labelRistoranteHotelDynamic = new JLabel("<dynamic>");
		labelRistoranteHotelDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelRistoranteHotelDynamic.setBounds(603, 223, 137, 35);
		contentPane.add(labelRistoranteHotelDynamic);
		
		JLabel labelStelleHotelDynamic = new JLabel("<dynamic>");
		labelStelleHotelDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStelleHotelDynamic.setBounds(603, 269, 137, 35);
		contentPane.add(labelStelleHotelDynamic);
		
		JLabel labelTipoPensioneDynamic = new JLabel("<dynamic>");
		labelTipoPensioneDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTipoPensioneDynamic.setBounds(603, 315, 137, 35);
		contentPane.add(labelTipoPensioneDynamic);
		
		labelRistoranteHotelDynamic.setText(String.valueOf(hotel.getRistorante()));
		labelStelleHotelDynamic.setText(String.valueOf(hotel.getStelle()));
		labelTipoPensioneDynamic.setText(hotel.getPensione());
		
	}
	
	private void printBedAndBreakfast(BedAndBreakfast bedandbreakfast) {
		
		lblReception = new JLabel("Reception");
		lblReception.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReception.setBounds(461, 223, 137, 35);
		contentPane.add(lblReception);
		
		lblVietatoFumare = new JLabel("Vietato fumare");
		lblVietatoFumare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVietatoFumare.setBounds(461, 269, 137, 35);
		contentPane.add(lblVietatoFumare);
		
		lblServizioBiancheria = new JLabel("Servizio biancheria");
		lblServizioBiancheria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblServizioBiancheria.setBounds(461, 315, 137, 35);
		contentPane.add(lblServizioBiancheria);
		
		lblLavatrice = new JLabel("Lavatrice");
		lblLavatrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLavatrice.setBounds(461, 361, 137, 35);
		contentPane.add(lblLavatrice);
		
		lblLavastoviglie = new JLabel("Lavastoviglie");
		lblLavastoviglie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLavastoviglie.setBounds(461, 407, 137, 35);
		contentPane.add(lblLavastoviglie);
		
		lblTipoLetti = new JLabel("Tipo letti");
		lblTipoLetti.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoLetti.setBounds(461, 453, 137, 35);
		contentPane.add(lblTipoLetti);
		
		labelReceptionDynamic = new JLabel("<dynamic>");
		labelReceptionDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelReceptionDynamic.setBounds(616, 223, 137, 35);
		contentPane.add(labelReceptionDynamic);
		
		labelVietatoFumareDynamic = new JLabel("<dynamic>");
		labelVietatoFumareDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVietatoFumareDynamic.setBounds(616, 269, 137, 35);
		contentPane.add(labelVietatoFumareDynamic);
		
		labelServizioBiancheriaDynamic = new JLabel("<dynamic>");
		labelServizioBiancheriaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelServizioBiancheriaDynamic.setBounds(616, 315, 137, 35);
		contentPane.add(labelServizioBiancheriaDynamic);
		
		labelLavatriceDynamic = new JLabel("<dynamic>");
		labelLavatriceDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLavatriceDynamic.setBounds(616, 361, 137, 35);
		contentPane.add(labelLavatriceDynamic);
		
		labelLavastoviglieDynamic = new JLabel("<dynamic>");
		labelLavastoviglieDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLavastoviglieDynamic.setBounds(616, 407, 137, 35);
		contentPane.add(labelLavastoviglieDynamic);
		
		labelTipoLettiDynamic = new JLabel("<dynamic>");
		labelTipoLettiDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTipoLettiDynamic.setBounds(616, 453, 137, 35);
		contentPane.add(labelTipoLettiDynamic);
		
		labelReceptionDynamic.setText(String.valueOf(bedandbreakfast.getReception()));
		labelVietatoFumareDynamic.setText(String.valueOf(bedandbreakfast.getVietatoFumare()));
		labelServizioBiancheriaDynamic.setText(String.valueOf(bedandbreakfast.getServizioBiancheria()));
		labelLavatriceDynamic.setText(String.valueOf(bedandbreakfast.getLavatrice()));
		labelLavastoviglieDynamic.setText(String.valueOf(bedandbreakfast.getLavastoviglie()));
		labelTipoLettiDynamic.setText(bedandbreakfast.getTipoLetto());
		
	}
	
	private void printCasa(Casa casa) {
		lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipologia.setBounds(461, 223, 137, 35);
		contentPane.add(lblTipologia);
		
		lblMetriQuadri = new JLabel("Metri quadri");
		lblMetriQuadri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMetriQuadri.setBounds(461, 269, 137, 35);
		contentPane.add(lblMetriQuadri);
		
		lblTipoEsterno = new JLabel("Tipo esterno");
		lblTipoEsterno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoEsterno.setBounds(461, 315, 137, 35);
		contentPane.add(lblTipoEsterno);
		
		lblVietatoFumareCasa = new JLabel("Vietato fumare");
		lblVietatoFumareCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVietatoFumareCasa.setBounds(461, 361, 137, 35);
		contentPane.add(lblVietatoFumareCasa);
		
		lblServizioBiancheriaCasa = new JLabel("Servizio biancheria");
		lblServizioBiancheriaCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblServizioBiancheriaCasa.setBounds(461, 407, 137, 35);
		contentPane.add(lblServizioBiancheriaCasa);
		
		lblLavatriceCasa = new JLabel("Lavatrice");
		lblLavatriceCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLavatriceCasa.setBounds(461, 453, 137, 35);
		contentPane.add(lblLavatriceCasa);
		
		JLabel lblLavastoviglieCasa = new JLabel("Lavastoviglie");
		lblLavastoviglieCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLavastoviglieCasa.setBounds(461, 499, 137, 35);
		contentPane.add(lblLavastoviglieCasa);
		
		lblTipoLetto = new JLabel("Tipo letto");
		lblTipoLetto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoLetto.setBounds(461, 545, 137, 35);
		contentPane.add(lblTipoLetto);
		
		labelTipologiaDynamic = new JLabel("<dynamic>");
		labelTipologiaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTipologiaDynamic.setBounds(632, 223, 137, 35);
		contentPane.add(labelTipologiaDynamic);
		
		labelMetriQuadriDynamic = new JLabel("<dynamic>");
		labelMetriQuadriDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelMetriQuadriDynamic.setBounds(632, 269, 137, 35);
		contentPane.add(labelMetriQuadriDynamic);
		
		labelTipoEsterno = new JLabel("<dynamic>");
		labelTipoEsterno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTipoEsterno.setBounds(632, 315, 137, 35);
		contentPane.add(labelTipoEsterno);
		
		labelVietatoFumareCasaDynamic = new JLabel("<dynamic>");
		labelVietatoFumareCasaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVietatoFumareCasaDynamic.setBounds(632, 361, 137, 35);
		contentPane.add(labelVietatoFumareCasaDynamic);
		
		lblServizioBiancheriaCasaDynamic = new JLabel("<dynamic>");
		lblServizioBiancheriaCasaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblServizioBiancheriaCasaDynamic.setBounds(632, 407, 137, 35);
		contentPane.add(lblServizioBiancheriaCasaDynamic);
		
		labelLavatriceCasaDynamic = new JLabel("<dynamic>");
		labelLavatriceCasaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLavatriceCasaDynamic.setBounds(632, 453, 137, 35);
		contentPane.add(labelLavatriceCasaDynamic);
		
		labelLavastoviglieCasaDynamic = new JLabel("<dynamic>");
		labelLavastoviglieCasaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLavastoviglieCasaDynamic.setBounds(632, 499, 137, 35);
		contentPane.add(labelLavastoviglieCasaDynamic);
		
		labelTipoLettoDynamic = new JLabel("<dynamic>");
		labelTipoLettoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTipoLettoDynamic.setBounds(632, 545, 137, 35);
		contentPane.add(labelTipoLettoDynamic);
		
		labelTipologiaDynamic.setText(casa.getTipoCasa());
		labelMetriQuadriDynamic.setText(String.valueOf(casa.getMetriQuadri()));
		labelTipoEsterno.setText(casa.getTipoEsterno());
		labelVietatoFumareCasaDynamic.setText(String.valueOf(casa.getVietatoFumare()));
		lblServizioBiancheriaCasaDynamic.setText(String.valueOf(casa.getServizioBiancheria()));
		labelLavatriceCasaDynamic.setText(String.valueOf(casa.getLavatrice()));
		labelLavastoviglieCasaDynamic.setText(String.valueOf(casa.getLavastoviglie()));
		labelTipoLettoDynamic.setText(casa.getTipoLetto());
		
		
	}

	private void printAttrazione(Attrazione attrazione) {
		JLabel lblOrarioApertura = new JLabel("Orario apertura");
		lblOrarioApertura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrarioApertura.setBounds(110, 214, 149, 26);
		contentPane.add(lblOrarioApertura);
		
		JLabel labelOrarioAperturaAttrazioneDynamic = new JLabel("<dynamic>");
		labelOrarioAperturaAttrazioneDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelOrarioAperturaAttrazioneDynamic.setBounds(269, 214, 178, 26);
		contentPane.add(labelOrarioAperturaAttrazioneDynamic);
		
		JLabel lblOrarioChiususraAttrazione = new JLabel("Orario chiususra");
		lblOrarioChiususraAttrazione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrarioChiususraAttrazione.setBounds(391, 214, 149, 26);
		contentPane.add(lblOrarioChiususraAttrazione);
		
		JLabel labelOrarioChiusuraAttrazioneDynamic = new JLabel("<dynamic>");
		labelOrarioChiusuraAttrazioneDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelOrarioChiusuraAttrazioneDynamic.setBounds(526, 214, 178, 26);
		contentPane.add(labelOrarioChiusuraAttrazioneDynamic);
		
		JLabel lblAdattoAiBambini = new JLabel("Adatto ai più piccoli");
		lblAdattoAiBambini.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdattoAiBambini.setBounds(110, 268, 149, 26);
		contentPane.add(lblAdattoAiBambini);
		
		JLabel labelAdattoAiBambiniDynamic = new JLabel("<dynamic>");
		labelAdattoAiBambiniDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAdattoAiBambiniDynamic.setBounds(269, 268, 178, 26);
		contentPane.add(labelAdattoAiBambiniDynamic);
		
		labelOrarioAperturaAttrazioneDynamic.setText(String.valueOf(attrazione.getOrarioApertura()));
		labelOrarioChiusuraAttrazioneDynamic.setText(String.valueOf(attrazione.getOrarioChiusura()));
		labelAdattoAiBambiniDynamic.setText(String.valueOf(attrazione.getPerBambini()));
		
		
	}
	
	private void printLocale(Locale locale) {
		lblDiscoteca = new JLabel("Discoteca");
		lblDiscoteca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiscoteca.setBounds(110, 305, 89, 26);
		contentPane.add(lblDiscoteca);
		
		lblNotturno = new JLabel("Notturno");
		lblNotturno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotturno.setBounds(110, 342, 89, 26);
		contentPane.add(lblNotturno);
		
		lblSalaBallo = new JLabel("Sala ballo");
		lblSalaBallo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalaBallo.setBounds(110, 379, 89, 26);
		contentPane.add(lblSalaBallo);
		
		lblSalaEventi = new JLabel("Sala eventi");
		lblSalaEventi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalaEventi.setBounds(110, 416, 102, 26);
		contentPane.add(lblSalaEventi);
		
		labelDiscotecaDynamic = new JLabel("<dynamic>");
		labelDiscotecaDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDiscotecaDynamic.setBounds(269, 305, 178, 26);
		contentPane.add(labelDiscotecaDynamic);
		
		labelNotturnoDynamic = new JLabel("<dynamic>");
		labelNotturnoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNotturnoDynamic.setBounds(269, 342, 178, 26);
		contentPane.add(labelNotturnoDynamic);
		
		labelSalaBalloDynamic = new JLabel("<dynamic>");
		labelSalaBalloDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSalaBalloDynamic.setBounds(269, 379, 178, 26);
		contentPane.add(labelSalaBalloDynamic);
		
		labelSalaEventiDynamic = new JLabel("<dynamic>");
		labelSalaEventiDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSalaEventiDynamic.setBounds(269, 416, 178, 26);
		contentPane.add(labelSalaEventiDynamic);
		
		labelDiscotecaDynamic.setText(String.valueOf(locale.getDiscoteca()));
		labelNotturnoDynamic.setText(String.valueOf(locale.getNotturno()));
		labelSalaBalloDynamic.setText(String.valueOf(locale.getSalaBallo()));
		labelSalaEventiDynamic.setText(String.valueOf(locale.getSalaEventi()));
		
	}

	private void printParco(Parco parco) {
		lblTematico = new JLabel("Tematico");
		lblTematico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTematico.setBounds(110, 305, 113, 26);
		contentPane.add(lblTematico);
		
		lblDivertimenti = new JLabel("Divertimenti");
		lblDivertimenti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDivertimenti.setBounds(110, 342, 113, 26);
		contentPane.add(lblDivertimenti);
		
		labelTematicoDynamic = new JLabel("<dynamic>");
		labelTematicoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTematicoDynamic.setBounds(269, 305, 178, 26);
		contentPane.add(labelTematicoDynamic);
		
		labelDivertimentiDynamic = new JLabel("<dynamic>");
		labelDivertimentiDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDivertimentiDynamic.setBounds(269, 342, 178, 26);
		contentPane.add(labelDivertimentiDynamic);
		
		labelTematicoDynamic.setText(String.valueOf(parco.getTematico()));
		labelDivertimentiDynamic.setText(String.valueOf(parco.getDivertimenti()));
	}

	private void printMuseo(Museo museo) {

		lblArcheologico = new JLabel("Archeologico");
		lblArcheologico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArcheologico.setBounds(110, 325, 149, 26);
		contentPane.add(lblArcheologico);
		
		lblArtistico = new JLabel("Artistico");
		lblArtistico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArtistico.setBounds(110, 362, 149, 26);
		contentPane.add(lblArtistico);
		
		lblMarino = new JLabel("Marino");
		lblMarino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarino.setBounds(110, 399, 149, 26);
		contentPane.add(lblMarino);
		
		lblMilitare = new JLabel("Militare");
		lblMilitare.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMilitare.setBounds(110, 436, 149, 26);
		contentPane.add(lblMilitare);
		
		lblScientifico = new JLabel("Scientifico");
		lblScientifico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblScientifico.setBounds(391, 325, 149, 26);
		contentPane.add(lblScientifico);
		
		lblStorico = new JLabel("Storico");
		lblStorico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStorico.setBounds(391, 362, 149, 26);
		contentPane.add(lblStorico);
		
		lblNaturale = new JLabel("Naturale");
		lblNaturale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNaturale.setBounds(391, 399, 149, 26);
		contentPane.add(lblNaturale);
		
		lblArcheologico_1 = new JLabel("Virtuale");
		lblArcheologico_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArcheologico_1.setBounds(391, 436, 149, 26);
		contentPane.add(lblArcheologico_1);
		
		labelArcheologicoDynamic = new JLabel("<dynamic>");
		labelArcheologicoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelArcheologicoDynamic.setBounds(269, 325, 95, 26);
		contentPane.add(labelArcheologicoDynamic);
		
		labelArtisticoDynamic = new JLabel("<dynamic>");
		labelArtisticoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelArtisticoDynamic.setBounds(269, 362, 93, 26);
		contentPane.add(labelArtisticoDynamic);
		
		labelMarinoDynamic = new JLabel("<dynamic>");
		labelMarinoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMarinoDynamic.setBounds(269, 399, 105, 26);
		contentPane.add(labelMarinoDynamic);
		
		labelMilitareDynamic = new JLabel("<dynamic>");
		labelMilitareDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMilitareDynamic.setBounds(269, 436, 93, 26);
		contentPane.add(labelMilitareDynamic);
		
		labelScientificoDynamic = new JLabel("<dynamic>");
		labelScientificoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelScientificoDynamic.setBounds(550, 325, 95, 26);
		contentPane.add(labelScientificoDynamic);
		
		labelStoricoDynamic = new JLabel("<dynamic>");
		labelStoricoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelStoricoDynamic.setBounds(550, 362, 95, 26);
		contentPane.add(labelStoricoDynamic);
		
		labelNaturaleDynamic = new JLabel("<dynamic>");
		labelNaturaleDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNaturaleDynamic.setBounds(550, 399, 95, 26);
		contentPane.add(labelNaturaleDynamic);
		
		labelVirtualeDynamic = new JLabel("<dynamic>");
		labelVirtualeDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelVirtualeDynamic.setBounds(550, 436, 95, 26);
		contentPane.add(labelVirtualeDynamic);
		
		labelArcheologicoDynamic.setText(String.valueOf(museo.getArcheologico()));
		labelArtisticoDynamic.setText(String.valueOf(museo.getArtistico()));
		labelMarinoDynamic.setText(String.valueOf(museo.getMarino()));
		labelMilitareDynamic.setText(String.valueOf(museo.getMilitare()));
		labelScientificoDynamic.setText(String.valueOf(museo.getScientifico()));
		labelStoricoDynamic.setText(String.valueOf(museo.getStorico()));
		labelNaturaleDynamic.setText(String.valueOf(museo.getNaturale()));
		labelVirtualeDynamic.setText(String.valueOf(museo.getVirtuale()));
	}
	
	public void isLoggedUpdate(String username) {
		if(TheController.checkSeSonoLoggato()){
			btn_Iscriviti.setVisible(false);
			btn_Login.setVisible(false);
			btn_apriProfilo.setText(username);
			btn_apriProfilo.setVisible(true);
		}
	}
}

