package Monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Gui extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=170,-1
	 */
	private final JSplitPane splitPane = new JSplitPane();
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//labelSuccess.setText("Success");
			}
		});
		btnNewButton.setBounds(335, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		username = new JTextField();
		username.setBounds(26, 32, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(26, 64, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel labelSuccess = new JLabel("");
		labelSuccess.setLabelFor(password);
		labelSuccess.setBounds(26, 95, 86, 23);
		contentPane.add(labelSuccess);
	}
}
