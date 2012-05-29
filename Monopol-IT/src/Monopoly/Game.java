package Monopoly;

import java.util.ArrayList;


public class Game {
	DbHandler db = new DbHandler();
	Board board;
	ArrayList<Player> players = new ArrayList(); 
	
	public Game() {
		board = new Board();
		players.add(new Player("Magnus"));
		players.add(new Player("Henrik"));
		System.out.println("");
		int rounds = 5;
		for(int i=0;i<rounds;i++)	{
			
			
			for(int x=0;x<players.size();x++)	{	
				round(players.get(x));
			}
			
			
			
		}
		
		db.testOutput();

	}

	public void round(Player p) {
		Dice dice = new Dice();
		
		//System.out.println(p.getName()+"("+p.getMoney()+") moved from:"+p.getPosition());
		board.moveAvatar(dice.roll(5), p);
		
		//p.setMoney(p.getMoney()-dice.roll(10));
		
		//System.out.println(p.getName()+"("+p.getMoney()+") moved to:"+p.getPosition());
		
		
	}
}
