package Monopoly;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	public static int height = 768;
	public static int width = 1024;
	public static String title = "Monopol-IT";
	public static Dimension size = new Dimension(width, height);
	
	public Frame() {
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	public void init() {		
		Screen login = new Screen(this);
		add(login);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		Frame frame = new Frame();
	}
}
