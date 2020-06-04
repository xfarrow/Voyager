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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;

public class InserisciParco extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	
	public InserisciParco(Controller controller) {
		setResizable(false);
		setTitle("Voyager - Inserimento Parco");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciParco.class.getResource("/images/icon.png")));
		TheController = controller;
		setBounds(100, 100, 287, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Parco");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Tematico");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblDivertimenti = new JLabel("Divertimenti");
		lblDivertimenti.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JCheckBox checkBox_divertimenti = new JCheckBox("");
		
		JCheckBox checkBox_tematico = new JCheckBox("");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Parco newParco = new Parco();
				newParco.setDivertimenti(checkBox_divertimenti.isSelected());
				newParco.setTematico(checkBox_tematico.isSelected());
				TheController.inserisciParco(newParco);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDivertimenti, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBox_tematico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_divertimenti))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(86))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblDivertimenti, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkBox_tematico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(checkBox_divertimenti)))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
