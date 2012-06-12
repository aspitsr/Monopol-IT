package Monopoly;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Game {
	public static int playerCount;
	public static int round = 1;
	public static int playingPlayer;
	public static int loggedPlayer;
	
	public static Player turn;
	
	public static boolean rolled;
	public static boolean playing = false;
	
	public static ArrayList<Player> players = new ArrayList(); 
	public static Dice dice = new Dice();
	private DbHandler db = new DbHandler();
	
	public Game() {
		define();
	}
	
	public void define() {
		// Get Players From DB
		ResultSet rsPlayers = db.selectPlayers(1);
		try {
			rsPlayers.beforeFirst();
			while(rsPlayers.next()) {
				Player player = new Player(rsPlayers.getString("name"));

				player.setMoney(Integer.parseInt(rsPlayers.getString("money")));
				player.setPosition(Integer.parseInt(rsPlayers.getString("position")));
				if(player.getMoney() > 0) {
					player.setInGame(true);
				} else {
					player.setInGame(false);
				}
				players.add(player);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setId(i);
		}
		// Get Field owners From DB
		ResultSet rsOwners = db.selectFieldOwners(1);
		try {
			rsOwners.beforeFirst();
			while(rsOwners.next()) {
				int fieldID = Integer.parseInt(rsOwners.getString("field_id"));
				Player player = players.get(Integer.parseInt(rsOwners.getString("owner")));
				
				Board.fields.get(fieldID).setOwner(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void round() {
		turn = players.get(playingPlayer);
	}
	
	public static void startTurn(int i) {
		if(!players.get(playingPlayer).inGame()) {
			Game.endTurn(Game.playingPlayer);
		}
		System.out.println("Turn started");
		dice.reset();
		rolled = false;
		playing = true;
		turn = players.get(i);
	}
	
	public static void endTurn(int i) {
		if(players.get(playingPlayer).getMoney()<0) {
			players.get(playingPlayer).setInGame(false);
		}
		playing = false;
		rolled = false;
		playingPlayer++;
		if(playingPlayer>=players.size()) {
			playingPlayer = 0;
			round++;
		}
		Game.startTurn(Game.playingPlayer);
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < players.size(); i++) {
			if(players.get(i).getMoney() > 0) {
				g.drawString(players.get(i).getName(), Board.fields.get(players.get(i).getPosition()).getX() + 5, Board.fields.get(players.get(i).getPosition()).getY() + 60 + (i * 20));
			}
			//System.out.println(players.get(i).getPosition() + " " + Board.fields.get(players.get(i).getPosition()).getX());
		}
		dice.draw(g);
	}

}
