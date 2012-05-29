package Monopoly;

import java.sql.ResultSet;
import java.util.ArrayList;

//Player stats
public class Player {
	DbHandler db = new DbHandler();
	ResultSet rs;
	int money;
	String name;
	ArrayList<Integer> owned = new ArrayList<Integer>();
	ArrayList<Integer> pawned = new ArrayList<Integer>();
	Avatar avatar = new Avatar();
	private int position = 0;
	
	public Player(String s) {
		name = s;
		rs = db.selectPlayer(name);
		try{
			rs.beforeFirst();
			if(rs.next()) {
				position = Integer.parseInt(rs.getString(4));
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
	
	public void endTurn() {
		
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int i) {
		position = i;
		db.updatePlayers("position", ""+position, name);
	}
	
	public String getName() {	
		return name+"("+getMoney()+")";
	}
	
	public void setName(String s) {	
		name = s;
	}
	
	public int getMoney() {	
		int money = 0;
		try{
			if(rs.first()) {
				money = Integer.parseInt(rs.getString(3));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return money;
	}
	
	public void setMoney(int i) {	
		money = i;
		System.out.println(name+" now has "+money);
		db.updatePlayers("money", ""+money, name);
	}

}
