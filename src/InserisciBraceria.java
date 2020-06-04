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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class InserisciBraceria extends JFrame {

	private JPanel contentPane;
	Controller TheController;
	
	public InserisciBraceria(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciBraceria.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Braceria");
		setResizable(false);
		TheController = controller;
		setBounds(100, 100, 329, 226);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Braceria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Carne");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblPesce = new JLabel("Pesce");
		lblPesce.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JCheckBox checkBox_carne = new JCheckBox("");
		
		JCheckBox checkBox_pesce = new JCheckBox("");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Braceria newBraceria = new Braceria();
				newBraceria.setCarne(checkBox_carne.isSelected());
				newBraceria.setPesce(checkBox_pesce.isSelected());
				TheController.inserisciBraceria(newBraceria);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_conferma)
							.addGap(112))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(checkBox_carne))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPesce, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(checkBox_pesce, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
							.addGap(108))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(117))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(checkBox_carne))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesce, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_pesce, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btn_conferma)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
