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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class InserisciAttrazione extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	private JTextField textField_apertura_ore;
	private JTextField textField_apertura_minuti;
	private JTextField textField_chiusura_ore;
	private JTextField textField_chiusura_minuti;
	public InserisciAttrazione(Controller controller) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciAttrazione.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Attrazione");
		TheController = controller;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Attrazione");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Orario Apertura");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblOrarioChiusura = new JLabel("Orario Chiusura");
		lblOrarioChiusura.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblPerBambini = new JLabel("Adatto ai bambini");
		lblPerBambini.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipoAttrazione = new JLabel("Tipo Attrazione");
		lblTipoAttrazione.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		textField_apertura_ore = new JTextField();
		textField_apertura_ore.setColumns(10);
		
		textField_apertura_minuti = new JTextField();
		textField_apertura_minuti.setColumns(10);
		
		JCheckBox checkBox_adatto_ai_bambini = new JCheckBox("");
		
		textField_chiusura_ore = new JTextField();
		textField_chiusura_ore.setColumns(10);
		
		textField_chiusura_minuti = new JTextField();
		textField_chiusura_minuti.setColumns(10);
		
		JComboBox<String> comboBox_tipo_attrazione = new JComboBox<String>();
		comboBox_tipo_attrazione.addItem("Museo");
		comboBox_tipo_attrazione.addItem("Parco");
		comboBox_tipo_attrazione.addItem("Locale");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String orarioAperturaString = textField_apertura_ore.getText()+":"+textField_apertura_minuti.getText()+":00";
				String orarioChiusuraString = textField_chiusura_ore.getText()+":"+textField_chiusura_minuti.getText()+":00";
				LocalTime orarioApertura = LocalTime.parse(orarioAperturaString);
				LocalTime orarioChiusura = LocalTime.parse(orarioChiusuraString);
				
				Attrazione newAttrazione = new Attrazione();
				newAttrazione.setOrarioApertura(orarioApertura);
				newAttrazione.setOrarioChiusura(orarioChiusura);
				newAttrazione.setPerBambini(checkBox_adatto_ai_bambini.isSelected());
				newAttrazione.setTipoAttrazione(comboBox_tipo_attrazione.getSelectedItem().toString());
				
				TheController.inserisciAttrazione(newAttrazione);
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPerBambini, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrarioChiusura, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoAttrazione, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_chiusura_ore, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_chiusura_minuti, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_apertura_ore, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_apertura_minuti, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkBox_adatto_ai_bambini)
						.addComponent(comboBox_tipo_attrazione, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(29)
					.addComponent(btn_conferma)
					.addContainerGap(58, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(152))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblOrarioChiusura, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_apertura_ore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_apertura_minuti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_chiusura_ore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_chiusura_minuti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPerBambini, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_adatto_ai_bambini))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoAttrazione, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_tipo_attrazione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_conferma))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
