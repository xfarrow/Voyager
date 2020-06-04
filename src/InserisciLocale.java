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
import java.awt.Color;
import javax.swing.SwingConstants;

public class InserisciLocale extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	
	public InserisciLocale(Controller controller) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciLocale.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Locale");
		TheController = controller;
		setBounds(100, 100, 260, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Locale");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Discoteca");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblNotturno = new JLabel("Notturno");
		lblNotturno.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblSalaDaBallo = new JLabel("Sala da ballo");
		lblSalaDaBallo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel lblSalaEventi = new JLabel("Sala eventi");
		lblSalaEventi.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JCheckBox checkBox_salaBallo = new JCheckBox("");
		
		JCheckBox checkBox_notturno = new JCheckBox("");
		
		JCheckBox checkBox_discoteca = new JCheckBox("");
		
		JCheckBox checkBox_salaEventi = new JCheckBox("");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locale newLocale = new Locale();
				newLocale.setDiscoteca(checkBox_discoteca.isSelected());
				newLocale.setNotturno(checkBox_notturno.isSelected());
				newLocale.setSalaBallo(checkBox_salaBallo.isSelected());
				newLocale.setSalaEventi(checkBox_salaEventi.isSelected());
				TheController.inserisciLocale(newLocale);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(checkBox_discoteca, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNotturno, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(checkBox_notturno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblSalaDaBallo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(checkBox_salaEventi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBox_salaBallo))))
						.addComponent(lblSalaEventi, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(79))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(77))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(checkBox_discoteca, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNotturno, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSalaDaBallo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkBox_notturno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(checkBox_salaBallo)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalaEventi, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_salaEventi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btn_conferma)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
