package Monopoly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;

public class Splash{
	
	int red = 0;
	int alpha = 0;
	int bgAlpha = 254;
	int finalX = 0;
	public static Frame frame;
	
	public Splash(Frame frame) {
		this.frame = frame;
		/*
		TextField textField_1 = new TextField();
		textField_1.setCaretPosition(10);
		textField_1.setEchoChar('*');
		textField_1.setBounds(10, 39, 188, 22);
		frame.add(textField_1);
		*/
	}
	
	public int moveFrame = 0, moveSpeed = 1;
	public int aniFrame = 0, aniSpeed = 1;
	public void draw(Graphics g) {
		if(aniFrame >= aniSpeed && alpha < 255) {
			alpha += 1;
			red += 1;
			aniFrame = 0;
		} else {
			aniFrame += 1;
		}
		if(moveFrame >= moveSpeed && finalX <= 300 && alpha > 254) {
			finalX += 1;
			moveFrame = 0;
		} else {
			moveFrame += 1;
		}
		if(finalX >= 300 && bgAlpha >= 1) {
			bgAlpha -= 1;
			moveFrame = 0;
		} else {
			moveFrame += 1;
		}
		g.setColor(new Color(26, 139, 211, bgAlpha));
		g.fillRect(0, 0, Frame.width, Frame.height);
		g.setFont(new Font("Verdana", Font.PLAIN, 70));
		g.setColor(new Color(255, 255, 255, alpha));
		printSimpleString("Monopol-IT", 0, Frame.width/2, Frame.height/2-finalX, g);
		if(bgAlpha == 0) {
			Screen.isLogin = true;
		}
	}
	
	public void printSimpleString(String s, int width, int XPos, int YPos, Graphics g){  
        int stringLen = (int)
        g.getFontMetrics().getStringBounds(s, g).getWidth();  
        int start = width/2 - stringLen/2;  
        g.drawString(s, start + XPos, YPos);  
	}  
}
