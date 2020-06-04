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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class InserisciBedAndBreakfast extends JFrame {

	private JPanel contentPane;
	Controller TheController;
	
	public InserisciBedAndBreakfast(Controller controller) {
		setTitle("Voyager - Inserimento B&B");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciBedAndBreakfast.class.getResource("/images/icon.png")));
		TheController = controller;
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bed & Breakfast");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Reception");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblVietatoFumare = new JLabel("Vietato fumare");
		lblVietatoFumare.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblServizioBiancheria = new JLabel("Servizio biancheria");
		lblServizioBiancheria.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblLavatrice = new JLabel("Lavatrice");
		lblLavatrice.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblLavastoviglie = new JLabel("Lavastoviglie");
		lblLavastoviglie.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblTipoLetti = new JLabel("Tipo letti");
		lblTipoLetti.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JCheckBox checkBox_biancheria = new JCheckBox("");
		
		JCheckBox checkBox_vietatoFumare = new JCheckBox("");
		
		JCheckBox checkBox_reception = new JCheckBox("");
		
		JCheckBox checkBox_lavatrice = new JCheckBox("");
		
		JCheckBox checkBox_lavastoviglie = new JCheckBox("");
		
		JComboBox<String> comboBox_tipoLetti = new JComboBox<String>();
		comboBox_tipoLetti.addItem("Singolo");
		comboBox_tipoLetti.addItem("Matrimoniale");
		comboBox_tipoLetti.addItem("Singolo&Matrimoniale");
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBackground(new Color(109, 175, 223));
		btnConferma.setForeground(Color.WHITE);
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BedAndBreakfast newBedAndBreakfast =  new BedAndBreakfast();
				newBedAndBreakfast.setLavastoviglie(checkBox_lavastoviglie.isSelected());
				newBedAndBreakfast.setLavatrice(checkBox_lavatrice.isSelected());
				newBedAndBreakfast.setReception(checkBox_lavastoviglie.isSelected());
				newBedAndBreakfast.setServizioBiancheria(checkBox_biancheria.isSelected());
				newBedAndBreakfast.setVietatoFumare(checkBox_vietatoFumare.isSelected());
				newBedAndBreakfast.setTipoLetto(comboBox_tipoLetti.getSelectedItem().toString());
				TheController.inserisciBedAndBreakfast(newBedAndBreakfast);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLavastoviglie, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(checkBox_lavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTipoLetti, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_tipoLetti, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServizioBiancheria, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVietatoFumare, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLavatrice, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox_lavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_reception, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_vietatoFumare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_biancheria))))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(139, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addComponent(btnConferma)
					.addGap(167))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(checkBox_reception, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVietatoFumare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_vietatoFumare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblServizioBiancheria, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkBox_biancheria))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_lavatrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_lavastoviglie, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTipoLetti, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_tipoLetti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnConferma)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
