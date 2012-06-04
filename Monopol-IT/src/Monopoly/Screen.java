package Monopoly;


import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	
	public static int myWidth, myHeight;
	
	public static boolean isFirst = true;
	public static boolean isGame = false;
	public static boolean isLogin = false;
	public static boolean loginOnce = false;
	
	public static Point mse = new Point(0, 0);
	
	public static Board board;
	public static Login login;
	public static Splash splash;
	public static Frame frame;
	
	public Screen(Frame frame) {
		this.frame = frame;
		splash = new Splash(frame);
		thread.start();
	}
	
	
	public static void define() {
		board = new Board();
		
	}
	
	public static void setLogin() {
		login = new Login(frame);
	}
	
	
	public void paintComponent(Graphics g) {
		if(isGame) {
			if(isFirst) {
				myWidth = getWidth();
				myHeight = getHeight();
				define();
				
				isFirst = false;
			}
			board.draw(g);
		} else {
			splash.draw(g);
		}
	}
	
	public void run() {
		while(true) {
			if(!isLogin) {
				repaint();
			}
			if(isLogin && !loginOnce) {
				setLogin();
				loginOnce = true;
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {}
		}
	}
}
