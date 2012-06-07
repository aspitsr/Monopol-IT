package Monopoly;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Login extends JPanel implements ActionListener
{
	JButton SUBMIT;
	DbHandler db =  new DbHandler();
	JLabel label1,label2;
	JTextField  text1,text2;
	JSeparator separator;
	Frame frame;
	
	Login(Frame frame) {
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);
		this.frame = frame;
		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);
		 
		SUBMIT=new JButton("Login");
		
		
		
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(510, 200, 2, 400);
		frame.add(separator);
		setLayout(null);
		frame.setBackground(new Color(26, 139, 211));
		label1.setBounds(150, 311, 188, 20);
		label1.setForeground(Color.WHITE);
		frame.add(label1);
		text1.setBounds(150, 331, 188, 20);
		frame.add(text1);
		label2.setBounds(150, 351, 188, 20);
		label2.setForeground(Color.WHITE);
		frame.add(label2);
		text2.setBounds(150, 371, 188, 20);
		frame.add(text2);
		SUBMIT.setBounds(150, 401, 188, 20);
		frame.add(SUBMIT);
		
		SUBMIT.addActionListener(this);
		
	}
	
	public void init() {
		
	}
	
	public void release() {
		frame.remove(separator);
		setLayout(null);
		frame.remove(label1);
		frame.remove(text1);
		frame.remove(label2);
		frame.remove(text2);
		frame.remove(SUBMIT);
	}

	public void actionPerformed(ActionEvent ae) {
		String value1=text1.getText();
		String value2=text2.getText();
		System.out.println(value1+value2);
		System.out.println(""+db.checkLogin(value1, value2));
		if (db.checkLogin(value1, value2) != 0) {
			Screen.isGame = true;
			Screen.isLogin = false;
			release();
			validate();
			Screen.define();
			repaint();
		} else {
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password",
			"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}