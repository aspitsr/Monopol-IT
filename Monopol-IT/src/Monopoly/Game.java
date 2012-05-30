package Monopoly;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Game extends JFrame {
	public static String title = "";
	public static Dimension size = new Dimension(768, 768);
	DbHandler db = new DbHandler();
	Board board;
	ArrayList<Player> players = new ArrayList(); 
	
	public Game() {
		/*
		players.add(new Player("Magnus"));
		players.add(new Player("Henrik"));
		System.out.println("");
		int rounds = 5;
		for(int i=0;i<rounds;i++)	{
			
			
			for(int x=0;x<players.size();x++)	{	
				round(players.get(x));
			}
			
			
			
		}*/
		
		this.setTitle(title);
		this.setSize(size);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(board);
		
		setVisible(true);

	}
/*
	public void round(Player p) {
		Dice dice = new Dice();
		
		//System.out.println(p.getName()+"("+p.getMoney()+") moved from:"+p.getPosition());
		board.moveAvatar(10, p);
		
		//p.setMoney(p.getMoney()-dice.roll(10));
		
		//System.out.println(p.getName()+"("+p.getMoney()+") moved to:"+p.getPosition());
		
		
	}*/
}
