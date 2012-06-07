package Monopoly;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Game {
	public static int playerCount;
	public static int round = 1;
	public static int playingPlayer;
	
	public static Player turn;
	
	public static boolean rolled;
	public static boolean playing = false;	
	
	public static ArrayList<Player> players = new ArrayList(); 
	public static Dice dice = new Dice();
	
	//public static Image sprite;
	
	public Game() {
		players.add(new Player("Magnus"));
		players.add(new Player("Henrik"));
		players.add(new Player("Thomas"));
		players.add(new Player("Benjamin"));
		
		/*try {
			URL url = Thread.currentThread().getContextClassLoader().getResource("res/mouse.png");
			if (url == null) {
				System.err.println("Unable to find sprite: res/mouse.png");
				System.exit(0);
			}
			sprite = ImageIO.read(url);
		} catch (IOException e) {
			System.err.println("Unable to load sprite: res/mouse.png");
			System.exit(0);
		}*/
	}
	
	public void round() {
		turn = players.get(playingPlayer);
	}
	
	public static void startTurn(int i) {
		System.out.println("Turn started");
		dice.reset();
		rolled = false;
		playing = true;
		turn = players.get(i);
	}
	
	public static void endTurn(int i) {
		playing = false;
		rolled = false;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < players.size(); i++) {
			g.drawString(players.get(i).getName(), Board.fields.get(players.get(i).getPosition()).getX() + 5, Board.fields.get(players.get(i).getPosition()).getY() + 60 + (i * 20));
			//System.out.println(players.get(i).getPosition() + " " + Board.fields.get(players.get(i).getPosition()).getX());
		}
		dice.draw(g);
	}

}
