import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JLayeredPane;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class Homepage extends JFrame {
	private Controller TheController;
	
	private JPanel contentPane;
	private JButton btn_apriProfilo;
	private JButton btn_Iscriviti;
	private JButton btn_Login;
	/**
	 * Create the frame.
	 */
	

	String btnPremuto = null;
	private JTextField txtLocalita;
	
	public Homepage(Controller controller) {
		setTitle("Voyager");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage.class.getResource("/images/icon.png")));
		setMinimumSize(new Dimension(720, 392));
		setBackground(new Color(255, 255, 255));
		TheController = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(20, 20));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 102, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		btn_Iscriviti = new JButton("Iscriviti");
		btn_Iscriviti.setFocusable(false);
		btn_Iscriviti.setForeground(new Color(255, 255, 255));
		btn_Iscriviti.setBackground(new Color(255, 102, 0));
		btn_Iscriviti.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_Iscriviti.setBorder(null);
		btn_Iscriviti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btn_Login = new JButton("Accedi");
		btn_Login.setFocusable(false);
		btn_Login.setBorder(null);
		btn_Login.setForeground(new Color(255, 255, 255));
		btn_Login.setBackground(new Color(255, 102, 0));
		btn_Login.setBorderPainted(false);
		btn_Login.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btn_Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
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
		
		btn_apriProfilo.setVisible(false);
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
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setIcon(new ImageIcon(Homepage.class.getResource("/images/logo.png")));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
					.addComponent(btn_Iscriviti, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_Login, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_apriProfilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_Login)
								.addComponent(btn_Iscriviti)
								.addComponent(btn_apriProfilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Cosa vuoi scoprire?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(new Color(46, 46, 46));
		lblNewLabel.setFont(new Font("COCOGOOSE", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1 = new JLabel("a...");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAutoscrolls(true);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setForeground(new Color(46, 46, 46));
		lblNewLabel_1.setFont(new Font("COCOGOOSE", Font.PLAIN, 40));
		
		JButton btn_Ristoranti = new JButton("Ristoranti");
		btn_Ristoranti.setMaximumSize(new Dimension(188, 63));
		btn_Ristoranti.setFocusable(false);
		btn_Ristoranti.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
		btn_Ristoranti.setBackground(new Color(255, 217, 59));
		btn_Ristoranti.setForeground(new Color(255, 255, 255));
		btn_Ristoranti.setFont(new Font("Open Sans Semibold", Font.PLAIN, 28));
		btn_Ristoranti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btn_Alloggi = new JButton("Alloggi");
		btn_Alloggi.setMaximumSize(new Dimension(188, 63));
		btn_Alloggi.setFocusable(false);
		btn_Alloggi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Alloggi.setFont(new Font("Open Sans Semibold", Font.PLAIN, 28));
		btn_Alloggi.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
		btn_Alloggi.setBackground(new Color(255, 217, 59));
		btn_Alloggi.setForeground(new Color(255, 255, 255));
		
		JButton btn_Attrazioni = new JButton("Attrazioni");
		btn_Attrazioni.setMaximumSize(new Dimension(188, 63));
		btn_Attrazioni.setFocusable(false);
		btn_Attrazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Attrazioni.setFont(new Font("Open Sans Semibold", Font.PLAIN, 28));
		btn_Attrazioni.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
		btn_Attrazioni.setBackground(new Color(255, 217, 59));
		btn_Attrazioni.setForeground(new Color(255, 255, 255));
		
		btn_Ristoranti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Ristoranti.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Ristoranti.setBackground(new Color(255, 153, 51));
				
				btn_Alloggi.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Alloggi.setBackground(new Color(255, 217, 59));
				btn_Alloggi.setForeground(new Color(255, 255, 255));
				
				btn_Attrazioni.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Attrazioni.setBackground(new Color(255, 217, 59));
				btn_Attrazioni.setForeground(new Color(255, 255, 255));
				
				btnPremuto = "Ristorante";
			}
		});
		
		btn_Alloggi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Alloggi.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Alloggi.setBackground(new Color(255, 153, 51));
				
				btn_Ristoranti.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Ristoranti.setBackground(new Color(255, 217, 59));
				btn_Ristoranti.setForeground(new Color(255, 255, 255));
				
				btn_Attrazioni.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Attrazioni.setBackground(new Color(255, 217, 59));
				btn_Attrazioni.setForeground(new Color(255, 255, 255));
				
				btnPremuto = "Alloggio";
			}
		});
		
		btn_Attrazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Attrazioni.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Attrazioni.setBackground(new Color(255, 153, 51));
				
				btn_Ristoranti.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Ristoranti.setBackground(new Color(255, 217, 59));
				btn_Ristoranti.setForeground(new Color(255, 255, 255));
				
				btn_Alloggi.setBorder(new LineBorder(new Color(233, 176, 44), 1, true));
				btn_Alloggi.setBackground(new Color(255, 217, 59));
				btn_Alloggi.setForeground(new Color(255, 255, 255));
				
				btnPremuto = "Attrazione";
			}
		});
		
		txtLocalita = new JTextField();
		txtLocalita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					if(TheController.checkSeSonoLoggato()) {
						System.out.println("Cerco "+btnPremuto+" a "+txtLocalita.getText()+"...");
						if(btnPremuto!=null) {
							if(txtLocalita.getText().equals("Località...")) {
								TheController.showErrorFrame("Indicare Località! Esempio: Napoli");
							} else {
								TheController.visualizzaEsercizi(btnPremuto, txtLocalita.getText());
							}
						} else {
							TheController.showErrorFrame("Selezionare tipologia! Esempio: Ristorante");
						}
					} else {
						TheController.showErrorFrame("Devi effettuare prima il login!");
					}
				}
			}
		});
		txtLocalita.setMaximumSize(new Dimension(510, 38));
		txtLocalita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLocalita.setText("");
			}
		});
		txtLocalita.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtLocalita.setCaretColor(new Color(255, 102, 0));
		txtLocalita.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocalita.setText("Localit\u00E0...");
		txtLocalita.setSelectionColor(new Color(255, 102, 0));
		txtLocalita.setToolTipText("");
		txtLocalita.setFont(new Font("Open Sans", Font.PLAIN, 20));
		txtLocalita.setColumns(10);
		
		JButton btnEsplora = new JButton("Esplora");
		btnEsplora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(TheController.checkSeSonoLoggato()) {
					System.out.println("Cerco "+btnPremuto+" a "+txtLocalita.getText()+"...");
					if(btnPremuto!=null) {
						if(txtLocalita.getText().equals("Località...") || txtLocalita.getText().isBlank()) {
							TheController.showErrorFrame("Indicare Località! Esempio: Napoli");
						} else {
							TheController.visualizzaEsercizi(btnPremuto, txtLocalita.getText());
						}
					} else {
						TheController.showErrorFrame("Selezionare tipologia! Esempio: Ristorante");
					}
				} else {
					TheController.showErrorFrame("Devi effettuare prima il login!");
				}
			}
		});
		btnEsplora.setMaximumSize(new Dimension(260, 61));
		btnEsplora.setBackground(new Color(109, 175, 223));
		btnEsplora.setBorder(new LineBorder(new Color(102, 164, 209), 1, true));
		btnEsplora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEsplora.setFocusable(false);
		btnEsplora.setForeground(new Color(255, 255, 255));
		btnEsplora.setFont(new Font("Open Sans Semibold", Font.PLAIN, 42));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addComponent(btn_Ristoranti, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn_Alloggi, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn_Attrazioni, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(52))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(182)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addGap(181))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(97)
					.addComponent(txtLocalita, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addGap(97))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(222)
					.addComponent(btnEsplora, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
					.addGap(222))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Alloggi, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Attrazioni, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Ristoranti, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(txtLocalita, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnEsplora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
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