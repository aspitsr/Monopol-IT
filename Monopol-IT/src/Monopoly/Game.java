package Monopoly;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Game {
	ArrayList<Player> players = new ArrayList(); 
	Dice dice = new Dice();
	
	public Game() {
		
		players.add(new Player("Magnus"));
		players.add(new Player("Henrik"));
		int rounds = 5;
		for(int i=0;i<rounds;i++)	{
			
			
			for(int x=0;x<players.size();x++)	{	
				round(players.get(x));
			}
			
			
			
		}
		
		

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < players.size(); i++) {
			g.drawString(players.get(i).getName(), Board.fields.get(players.get(i).getPosition()).getX() + 5, Board.fields.get(players.get(i).getPosition()).getY() + 60 + (i * 20));
			System.out.println(players.get(i).getPosition() + " " + Board.fields.get(players.get(i).getPosition()).getX());
		}
		dice.draw(g);
	}
	
	public void moveAvatar(int i, Player p){
		int position = Screen.board.newPosition(i, p.getPosition());
		p.setPosition(position);
	}

	public void round(Player p) {
		dice.reset();
		moveAvatar(dice.roll(2), p);
		/*System.out.println(p.getName()+"("+p.getMoney()+") moved from:"+p.getPosition());
		
		
		p.setMoney(p.getMoney()-dice.roll(10));
		
		System.out.println(p.getName()+"("+p.getMoney()+") moved to:"+p.getPosition());
		
		*/
	}
}
