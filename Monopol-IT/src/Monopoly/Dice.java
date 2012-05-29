package Monopoly;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class Dice{
	public int value;
	
	
	public Dice() {
		
	}
	
	public int roll(int n)
	  {
		ArrayList<Integer> rolls = new ArrayList();
		int i;	
		for(i=1;i<=n;i++) {
			int roll;
			double number = Math.random();
			roll = (int) (number * 6) + 1;
			rolls.add(roll);
			value = value + roll;
			System.out.println("Dice "+i+":"+roll);
		}
		Frame frame = new DiceGUI(rolls);
		  frame.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		  System.exit(0);
		 }
		  });
		  frame.setSize((n*130)+30, 250);
		  frame.setVisible(true);
		return value;
	  }
		  
		 
}

