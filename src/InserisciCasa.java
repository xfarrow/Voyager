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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class InserisciCasa extends JFrame {

	private JPanel contentPane;
	private JTextField textField_metriQuadri;
	private Controller TheController;
	
	public InserisciCasa(Controller controller) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciCasa.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Casa");
		TheController = controller;
		setBounds(100, 100, 539, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Casa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Tipologia");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblMetriQuadri = new JLabel("Metri quadri");
		lblMetriQuadri.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipoEsterno = new JLabel("Tipo esterno");
		lblTipoEsterno.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblVietatoFumare = new JLabel("Vietato fumare");
		lblVietatoFumare.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblServiziBiancheria = new JLabel("Servizi biancheria");
		lblServiziBiancheria.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblLavatrice = new JLabel("Lavatrice");
		lblLavatrice.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblLavastoviglie = new JLabel("Lavastoviglie");
		lblLavastoviglie.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipoLetto = new JLabel("Tipo letto");
		lblTipoLetto.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JCheckBox checkBox_vietatoFumare = new JCheckBox("");
		
		JCheckBox checkBox_lavastoviglie = new JCheckBox("");
		
		JCheckBox checkBox_biancheria = new JCheckBox("");
		
		JCheckBox checkBox_lavatrice = new JCheckBox("");
		
		JComboBox<String> comboBox_tipologia = new JComboBox<String>();
		comboBox_tipologia.addItem("Appartamento");
		comboBox_tipologia.addItem("Villa");
		comboBox_tipologia.addItem("Mansarda");
		comboBox_tipologia.addItem("Trullo");
		
		
		JComboBox<String> comboBox_tipoEsterno = new JComboBox<String>();
		comboBox_tipoEsterno.addItem("Giardino");
		comboBox_tipoEsterno.addItem("Terrazzo");
		
		JComboBox<String> comboBox_tipoLetto = new JComboBox<String>();
		comboBox_tipoLetto.addItem("Singolo");
		comboBox_tipoLetto.addItem("Matrimoniale");
		comboBox_tipoLetto.addItem("Singolo&Matrimoniale");
		
		textField_metriQuadri = new JTextField();
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Casa newCasa = new Casa();
				newCasa.setLavastoviglie(checkBox_lavastoviglie.isSelected());
				newCasa.setLavatrice(checkBox_lavatrice.isSelected());
				newCasa.setMetriQuadri(Double.valueOf(textField_metriQuadri.getText()));
				newCasa.setServizioBiancheria(checkBox_biancheria.isSelected());
				newCasa.setTipoCasa(comboBox_tipologia.getSelectedItem().toString());
				newCasa.setTipoEsterno(comboBox_tipoEsterno.getSelectedItem().toString());
				newCasa.setTipoLetto(comboBox_tipoLetto.getSelectedItem().toString());
				newCasa.setVietatoFumare(checkBox_vietatoFumare.isSelected());
				
				TheController.inserisciCasa(newCasa);
				
				
			}
		});
		
		textField_metriQuadri.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblVietatoFumare, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(checkBox_vietatoFumare))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipoEsterno, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMetriQuadri, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_metriQuadri, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
								.addComponent(comboBox_tipoEsterno, 0, 77, Short.MAX_VALUE)
								.addComponent(comboBox_tipologia, 0, 77, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 7, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLavatrice, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
							.addComponent(checkBox_lavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoLetto, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServiziBiancheria, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLavastoviglie, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(checkBox_biancheria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBox_tipoLetto, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addComponent(checkBox_lavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addGap(138))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(222)
					.addComponent(btn_conferma)
					.addContainerGap(298, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(229)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkBox_biancheria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(checkBox_lavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_1)
									.addComponent(comboBox_tipologia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblServiziBiancheria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTipoEsterno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBox_tipoEsterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblLavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGap(15)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblMetriQuadri, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_metriQuadri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(lblVietatoFumare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(checkBox_lavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblLavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTipoLetto, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addComponent(comboBox_tipoLetto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addComponent(checkBox_vietatoFumare)))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
