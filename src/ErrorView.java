import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErrorView extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public ErrorView(Controller TheController) {
		setBackground(new Color(255, 102, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ErrorView.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("Voyager");
		setType(Type.POPUP);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ErrorView.class.getResource("/images/logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("Error");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPane.add(lblNewLabel_1, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("OK");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheController.hideErrorFrame(ErrorView.this);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(195)
					.addComponent(btnNewButton)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	public void errorType(String error) {
		lblNewLabel_1.setText(error);
	}
}
