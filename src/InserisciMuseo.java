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
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class InserisciMuseo extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	
	public InserisciMuseo(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciMuseo.class.getResource("/images/icon.png")));
		setTitle("Voyager - Inserimento Museo");
		TheController = controller;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Museo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Archeologico");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblArtistico = new JLabel("Artistico");
		lblArtistico.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblMarino = new JLabel("Marino");
		lblMarino.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblMilitare = new JLabel("Militare");
		lblMilitare.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblScientifico = new JLabel("Scientifico");
		lblScientifico.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblNaturale = new JLabel("Naturale");
		lblNaturale.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblStorico = new JLabel("Storico");
		lblStorico.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JLabel lblVirtuale = new JLabel("Virtuale");
		lblVirtuale.setFont(new Font("Open Sans", Font.PLAIN, 17));
		
		JCheckBox checkBox_archeologico = new JCheckBox("");
		
		JCheckBox checkBox_artistico = new JCheckBox("");
		
		JCheckBox checkBox_marino = new JCheckBox("");
		
		JCheckBox checkBox_militare = new JCheckBox("");
		
		JCheckBox checkBox_scientifico = new JCheckBox("");
		
		JCheckBox checkBox_naturale = new JCheckBox("");
		
		JCheckBox checkBox_storico = new JCheckBox("");
		
		JCheckBox checkBox_virtuale = new JCheckBox("");
		
		JButton btn_conferma = new JButton("Conferma");
		btn_conferma.setBackground(new Color(109, 175, 223));
		btn_conferma.setForeground(Color.WHITE);
		btn_conferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Museo newMuseo = new Museo();
				newMuseo.setArcheologico(checkBox_archeologico.isSelected());
				newMuseo.setArtistico(checkBox_artistico.isSelected());
				newMuseo.setMarino(checkBox_marino.isSelected());
				newMuseo.setMilitare(checkBox_militare.isSelected());
				newMuseo.setNaturale(checkBox_naturale.isSelected());
				newMuseo.setScientifico(checkBox_scientifico.isSelected());
				newMuseo.setStorico(checkBox_storico.isSelected());
				newMuseo.setVirtuale(checkBox_virtuale.isSelected());
				TheController.inserisciMuseo(newMuseo);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtistico, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMarino, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMilitare, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBox_archeologico)
						.addComponent(checkBox_artistico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_marino, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox_militare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblVirtuale, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBox_virtuale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStorico, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBox_storico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNaturale, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBox_naturale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScientifico, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBox_scientifico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addGap(167))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(179, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(169))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblScientifico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_scientifico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArtistico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNaturale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_artistico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_naturale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMarino, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblStorico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBox_marino, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(checkBox_storico, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMilitare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBox_militare, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblVirtuale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox_virtuale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addComponent(checkBox_archeologico))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(btn_conferma)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
