package Monopoly;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;


public class DiceGUI extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RoundRectangle2D dice2 = new RoundRectangle2D.Double(160, 75, 100, 100, 30, 30);
	int dices;
	private ArrayList<Integer> rolls = new ArrayList<Integer>();

	public DiceGUI(ArrayList<Integer> a) {
		rolls = a;
	}

	public void paint(Graphics g) {
			int i;
		  Graphics2D graph = (Graphics2D)g;
		  graph.setPaint(Color.black);
		  int left = 30;
		  for(i=0;i<rolls.size();i++) {
				graph.draw(new RoundRectangle2D.Double(left, 75, 100, 100, 30, 30));
				graph.drawString(""+rolls.get(i),left+45,130);
				left = left + 130;
			}
		  
		  }
	
}
