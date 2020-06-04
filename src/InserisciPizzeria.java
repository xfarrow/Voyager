import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class InserisciPizzeria extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	
	public InserisciPizzeria(Controller controller) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciPizzeria.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Pizzeria");
		TheController = controller;
		setBounds(100, 100, 343, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Pizzeria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Pizza fritta");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblSoloCena = new JLabel("Solo cena");
		lblSoloCena.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblFornoElettrico = new JLabel("Forno Elettrico");
		lblFornoElettrico.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblFornoALegna = new JLabel("Forno a legna");
		lblFornoALegna.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JCheckBox checkbox_pizzaFritta = new JCheckBox("");
		
		JCheckBox checkBox_soloCena = new JCheckBox("");
		
		JCheckBox checkBox_fornoElettrico = new JCheckBox("");
		
		JCheckBox checkBox_fornoLegna = new JCheckBox("");
		
		JButton btnFine = new JButton("Fine");
		btnFine.setBackground(new Color(109, 175, 223));
		btnFine.setForeground(Color.WHITE);
		btnFine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pizzeria newPizzeria = new Pizzeria();
				newPizzeria.setFornoElettrico(checkBox_fornoElettrico.isSelected());
				newPizzeria.setFornoLegna(checkBox_fornoLegna.isSelected());
				newPizzeria.setPizzaFritta(checkbox_pizzaFritta.isSelected());
				newPizzeria.setSoloCena(checkBox_soloCena.isSelected());
				TheController.inserisciPizzeria(newPizzeria);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFornoALegna, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(checkBox_fornoLegna, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblSoloCena, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFornoElettrico))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox_fornoElettrico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_soloCena, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkbox_pizzaFritta))))
					.addContainerGap(152, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(136, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(127))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(btnFine)
					.addGap(132))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(checkbox_pizzaFritta))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSoloCena, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_soloCena, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFornoElettrico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_fornoElettrico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFornoALegna, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_fornoLegna, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnFine)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
