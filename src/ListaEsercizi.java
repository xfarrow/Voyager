import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Insets;

public class ListaEsercizi extends JFrame {
	Controller TheController;
	private JPanel contentPane;
	public ListaEsercizi(Controller controller, ArrayList<Esercizio> listaEsercizi) {
		setResizable(false);
		TheController = controller;
		setBounds(100, 100, 798, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setTitle("Voyager - Esplora");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Profilo.class.getResource("/images/icon.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lbl_titolo = new JLabel("- - -");
		lbl_titolo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lbl_titolo.setText(listaEsercizi.size()+" esercizi commerciali trovati");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_titolo)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 704, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(114, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbl_titolo)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btn_indietro = new JButton("");
		btn_indietro.setFocusPainted(false);
		btn_indietro.setPreferredSize(new Dimension(70, 9));
		btn_indietro.setBorder(null);
		btn_indietro.setBackground(new Color(255, 102, 0));
		btn_indietro.setFont(new Font("Open Sans", Font.PLAIN, 15));
		btn_indietro.setForeground(new Color(255, 255, 255));
		btn_indietro.setIcon(new ImageIcon(ListaEsercizi.class.getResource("/images/back_button.png")));
		panel.add(btn_indietro, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 102, 0));
		lblNewLabel.setIcon(new ImageIcon(ListaEsercizi.class.getResource("/images/logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btn_apriProfilo = new JButton("Username");
		btn_apriProfilo.setHorizontalAlignment(SwingConstants.LEFT);
		btn_apriProfilo.setMaximumSize(new Dimension(115, 23));
		btn_apriProfilo.setPreferredSize(new Dimension(115, 23));
		btn_apriProfilo.setMinimumSize(new Dimension(115, 23));
		btn_apriProfilo.setMargin(new Insets(2, 14, 2, 30));
		btn_apriProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_apriProfilo.setBorder(null);
		btn_apriProfilo.setHorizontalTextPosition(SwingConstants.LEFT);
		btn_apriProfilo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_apriProfilo.setForeground(new Color(255, 255, 255));
		btn_apriProfilo.setContentAreaFilled(false);
		btn_apriProfilo.setText(TheController.current_user.getUsername());
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
		
		panel.add(btn_apriProfilo, BorderLayout.EAST);
		btn_indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.hidePaginaListaEsercizi();
			}
		});
		
		String indirizzo;
		String pathStar; //Path icona recensioni
		String pathType; //Path icona tipologia
		
		JList<String> list = new JList<String>(new DefaultListModel<String>());
		ArrayList<String> valutazioni = new ArrayList<String>();
		
		for(Esercizio esercizio: listaEsercizi) {
			indirizzo = controller.getIndirizzoString(esercizio.getIdIndirizzo());
			valutazioni = TheController.getValutazioniEsercizio(esercizio.getId());
			
			//Se non esistono valutazioni dell'esercizio visualizzo l'icona stella "nessuna recensione"
			if(valutazioni.get(5).toString().equalsIgnoreCase("0")) { 
				pathStar = ListaEsercizi.class.getResource("/images/val_button_star.png").toString();
			} else { //Altrimenti icona stella "recensione presente"
				pathStar = ListaEsercizi.class.getResource("/images/val_button_star_active.png").toString();
			}
			
			if(esercizio.getTipologia().equals("Ristorante")) {
				pathType = ListaEsercizi.class.getResource("/images/icons/restaurant_type_small.png").toString();
			} else if(esercizio.getTipologia().equals("Alloggio")) {
				pathType = ListaEsercizi.class.getResource("/images/icons/alloggio_type_small.png").toString();
			} else {
				pathType = ListaEsercizi.class.getResource("/images/icons/attrazione_type_small.png").toString();
			}
			
			NumberFormat formatter = new DecimalFormat("#0.0");   
			double valutazione = Double.valueOf(valutazioni.get(5));
			((DefaultListModel<String>)list.getModel()).addElement(""
					+"<html><h1 style='font-family:Open Sans;padding:0;margin:14px 0 0 0'>"
					+"<img src='"+pathStar+"'></img>&nbsp;"
					+formatter.format(valutazione).toString()+"&nbsp;&nbsp;"
					+esercizio.getDenominazione()
					+"</h1>"
					+"&nbsp;&nbsp;<img style='margin-left:4px;' src='"+pathType+"'></img>&nbsp;"
					+TheController.getSubCategoryString(esercizio.getId(), esercizio.getTipologia())
					+"<br>&nbsp;&nbsp;<img src='"+ListaEsercizi.class.getResource("/images/icons/location_small.png").toString()+"'></img>&nbsp;"
					+indirizzo
					+"<br>&nbsp;&nbsp;<img src='"+ListaEsercizi.class.getResource("/images/icons/review_small.png").toString()+"'></img>&nbsp;"
					+"Ultima recensione:&nbsp;&nbsp;\""+TheController.getLastReviewTitle(esercizio)+"\""
					);
		}
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//doppio click
				if (e.getClickCount() == 2) {
					  int index = list.getSelectedIndex(); 
					  if(index!=-1) {
		              controller.visualizzaPaginaEsercizio(listaEsercizi.get(index));
					  }
					 }
			}
		});
		
		scrollPane.setViewportView(list);
		/*
		JList list = new JList(listaLuoghi.toArray());
		scrollPane.setViewportView(list);
		*/
		contentPane.setLayout(gl_contentPane);
	}
}
