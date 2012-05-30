package Monopoly;


import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	
	public static int myWidth, myHeight;
	
	public static boolean isFirst = true;
	
	public static Point mse = new Point(0, 0);
	
	public static Board board;
	
	public Screen(Frame frame) {
		
		thread.start();
	}
	
	
	public void define() {
		board = new Board();	
	}
	
	public void paintComponent(Graphics g) {
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			
			isFirst = false;
		}
		board.draw(g);
	
	}
	
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(1);
			} catch (Exception e) {}
		}
	}
}
