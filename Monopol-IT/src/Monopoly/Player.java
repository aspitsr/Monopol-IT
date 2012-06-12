package Monopoly;

import java.awt.Graphics;
import java.sql.ResultSet;
import java.util.ArrayList;

//Player stats
public class Player {
	int id;
	DbHandler db = new DbHandler();
	ResultSet rs;
	int money = 10000;
	String name;
	ArrayList<Integer> owned = new ArrayList<Integer>();
	ArrayList<Integer> pawned = new ArrayList<Integer>();
	Avatar avatar = new Avatar();
	int position = 0;
	boolean inGame;
	
	public Player(String s) {
		name = s;
		rs = db.selectPlayer(name);
		try{
			rs.beforeFirst();
			if(rs.next()) {
				position = Integer.parseInt(rs.getString("position"));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void buy(int lot) {
		owned.add(lot);
	}
	
	public void pawn(int lot) {
		pawned.add(lot);
	}
	
	public void trade(int lot) {
		owned.remove(lot);
	}
	
	public void payRent(int i) {	
		System.out.println(getName()+" Payed "+i);
		setMoney(money - i);
	}
	
	public void pay(int i) {	
		System.out.println(getName()+" Payed "+i);
		setMoney(money - i);
	}
	
	public void recieveRent(int i) {
		System.out.println(getName()+" Recived "+i);
		setMoney(money + i);
	}
	
	public void passedStart(int i) {
		System.out.println(getName()+" Recived "+i+" for passing Start");
		if(i>0) {
			setMoney(money + (500*i));
		}
	}
	
	public void draw(Graphics g) {
		g.drawString(""+name, Board.fields.get(position).getX(), Board.fields.get(position).getY());
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int i) {
		position = i;
		db.updatePlayers("position", ""+position, name);
	}
	
	public void setId(int i) {
		id = i;
	}
	
	public String getName() {	
		return name;
	}
	
	public void setName(String s) {	
		name = s;
	}
	
	public void setInGame(boolean b) {	
		inGame = b;
	}
	
	public boolean inGame() {	
		return inGame;
	}
	
	public int getMoney() {			
		return money;
	}
	
	public void setMoney(int i) {	
		money = i;
		System.out.println(name+" now has "+money);
		db.updatePlayers("money", ""+money, name);
	}

}
