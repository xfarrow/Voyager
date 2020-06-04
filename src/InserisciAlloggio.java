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
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class InserisciAlloggio extends JFrame {

	private JPanel contentPane;
	private JTextField textField_stanze;
	private JTextField textField_bagni;
	private Controller TheController;
	
	public InserisciAlloggio(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciAlloggio.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Alloggio");
		setResizable(false);
		TheController = controller;
		setBounds(100, 100, 522, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Alloggio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Stanze");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblBagni = new JLabel("Bagni");
		lblBagni.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTelevisione = new JLabel("Televisione");
		lblTelevisione.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblParcheggio = new JLabel("Parcheggio");
		lblParcheggio.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblWifi = new JLabel("WiFi");
		lblWifi.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblPiscina = new JLabel("Piscina");
		lblPiscina.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblCondizionamento = new JLabel("Condizionamento");
		lblCondizionamento.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblAnimaliAmmessi = new JLabel("Animali ammessi");
		lblAnimaliAmmessi.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		textField_stanze = new JTextField();
		textField_stanze.setColumns(10);
		
		textField_bagni = new JTextField();
		textField_bagni.setColumns(10);
		
		JCheckBox checkBox_tv = new JCheckBox("");
		
		JCheckBox checkBox_parcheggio = new JCheckBox("");
		
		JCheckBox checkBox_condizionamento = new JCheckBox("");
		
		JCheckBox checkBox_animaliAmmessi = new JCheckBox("");
		
		JCheckBox checkBox_piscina = new JCheckBox("");
		
		JCheckBox checkBox_wifi = new JCheckBox("");
		
		JComboBox<String> comboBox_tipo = new JComboBox<String>();
		comboBox_tipo.addItem("Hotel");
		comboBox_tipo.addItem("BedAndBreakfast");
		comboBox_tipo.addItem("Casa");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Alloggio newAlloggio = new Alloggio();
				newAlloggio.setAnimaliAmmessi(checkBox_animaliAmmessi.isSelected());
				newAlloggio.setBagni(Integer.valueOf(textField_bagni.getText()));
				newAlloggio.setCondizionamento(checkBox_condizionamento.isSelected());
				newAlloggio.setParcheggio(checkBox_parcheggio.isSelected());
				newAlloggio.setPiscina(checkBox_piscina.isSelected());
				newAlloggio.setStanze(Integer.valueOf(textField_stanze.getText()));
				newAlloggio.setTV(checkBox_tv.isSelected());
				newAlloggio.setWifi(checkBox_wifi.isSelected());
				newAlloggio.setTipoAlloggio(comboBox_tipo.getSelectedItem().toString());
				TheController.inserisciAlloggio(newAlloggio);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_tipo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBagni, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTelevisione, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblParcheggio, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(checkBox_tv)
										.addComponent(textField_stanze, 0, 0, Short.MAX_VALUE)
										.addComponent(checkBox_parcheggio, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_bagni, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
									.addGap(46)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAnimaliAmmessi, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCondizionamento, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPiscina, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addComponent(lblWifi, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox_condizionamento, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_animaliAmmessi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_piscina, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_wifi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(105))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_conferma)
							.addGap(208))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(195))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblWifi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_stanze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkBox_wifi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBagni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPiscina, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_bagni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkBox_piscina, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTelevisione, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkBox_tv))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCondizionamento, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkBox_condizionamento, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblParcheggio, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_parcheggio, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAnimaliAmmessi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkBox_animaliAmmessi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
