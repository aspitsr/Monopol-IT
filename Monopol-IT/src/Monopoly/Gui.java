package Monopoly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Gui {
	public Rectangle[] button = new Rectangle[4];
	
	public Gui() {
		define();
	}
	
	public void click(int mouseButton) {
		
		/*
		if(mouseButton == 1) {
			for(int i=0;i<button.length;i++) {
				if(button[i].contains(Screen.mse)) {
					if(buttonID[i] != Value.airAir) {
						if(buttonID[i] == Value.airTrashCan) { //Delete item
							holdsItem = false;
							heldID = -1;
						} else {
							heldID = buttonID[i];
							realID = i;
							holdsItem = true;
						}
					}
				}
			}
			if(holdsItem) {
				if(Screen.coinage >= Value.towerPrice[realID]) {
					for(int y=0;y<Screen.room.block.length;y++) {
						for(int x=0;x<Screen.room.block[0].length;x++) {
							if(Screen.room.block[y][x].contains(Screen.mse)) {
								if(Screen.room.block[y][x].groundID != Value.groundRoad && Screen.room.block[y][x].airID == Value.airAir) {
									Screen.room.block[y][x].airID = heldID;
									Screen.coinage -= Value.towerPrice[realID];
									Screen.room.block[y][x].realID = realID;
								}
							}
						}
					}
				}
			}
		}
		if(mouseButton == 3) {
			holdsItem = false;
			heldID = -1;
		}*/
	}
	
	public void define() {
		for(int i=0;i<button.length;i++) {
			button[i] = new Rectangle(768+20, 138+(i*55), 200, 50);
		}
	}
	
	public void draw(Graphics g) {
		g.setFont(new Font("Verdana", Font.PLAIN, 15));
		g.setColor(new Color(255,255,255,255));
		g.fillRoundRect(768, 118, 240, 632, 30, 30);
		
		
		for(int i=0;i<button.length;i++) {
			g.setColor(new Color(255,255,255, 255));
			g.drawRoundRect(button[i].x, button[i].y, button[i].width, button[i].height, 20, 20);
			g.setColor(new Color(0, 0, 0, 255));
			g.drawRoundRect(button[i].x, button[i].y, button[i].width, button[i].height, 20, 20);
			
			/*
			if(button[i].contains(Screen.mse)) {
				g.setColor(new Color(255,255,255, 150));
				g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
			}
			*/
			
			
			
			
			
			/*
			if(buttonID[i] != Value.airAir)g.drawImage(Screen.tileset_air[buttonID[i]], button[i].x + itemIn, button[i].y + itemIn, button[i].width - (itemIn*2), button[i].height - (itemIn*2), null);
			if(Value.towerPrice[i] > 0) {
				g.setColor(new Color(255,255,255));
				g.setFont(new Font("Courier New", Font.BOLD, 34));
				g.drawString("$"+Value.towerPrice[i], button[i].x + itemIn, button[i].y + itemIn + 25);
			}*/
		}
	}
}
