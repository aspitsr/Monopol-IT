package Monopoly;




import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

// Board controls Player positions
// Board contains Fields
public class Board extends JPanel {
	private	DbHandler db = new DbHandler();
	private ResultSet top; 
	private ResultSet left; 
	private ResultSet right; 
	private ResultSet bottom; 
	//public static Field[][] fields;
	public static ArrayList<Field> fields;
	public static int[][] validFields = {{Value.fieldStart,Value.fieldField,Value.fieldField,Value.fieldField,Value.fieldCorner}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldCorner,Value.fieldField,Value.fieldField,Value.fieldField,Value.fieldCorner}}; 
	
	
	public Board() {
		 define();
	}
	
	public void define(){
		// Board.fields = new Field[5][5];
		top = db.selectFields(1);
		left = db.selectFields(2);
		right = db.selectFields(3);
		bottom = db.selectFields(4);
		getFields();
		for (int i = 0; i <fields.size(); i++) {
			System.out.println(i + " " + fields.get(i).getName());
		}
	}
	
	public int newPosition(int roll, int position) {
		int i = 0;
		int size = fields.size();
		i = position + roll;
		// might be incorrect RTFM
		while(i>=size) {
			i = i-size;
		}
		return i;
	}
	
	public void draw(Graphics g){
		g.setFont(new Font("Verdana", Font.PLAIN, 15));
		g.setColor(new Color(255,0,0));
		g.fillRect(0, 0, Screen.myWidth, Screen.myHeight);
		g.setColor(new Color(255,255,255));
		g.fillRoundRect(9, 9, 750, 750, 30, 30);
		g.setColor(new Color(0,0,0));
		
		
		
		
		
		
		for (int i = 0; i <fields.size(); i++) {
			String debugXY;
			if(Screen.isDebug){
				debugXY = fields.get(i).getX()+" "+fields.get(i).getY()+" : ";
			}
			else{
				debugXY = "";
			}
			g.drawRect(fields.get(i).getX(), fields.get(i).getY(), 140, 140);
			g.drawString(debugXY+fields.get(i).getName(),fields.get(i).getX()+5, fields.get(i).getY()+20);
			if (fields.get(i).getPrice()>0) {
				g.drawString(debugXY + fields.get(i).getPrice(),
						fields.get(i).getX() + 5, fields.get(i).getY() + 40);
			}
		}
		
		
		
		/*
		for(int y=0;y<validFields.length;y++) {
			for(int x=0;x<validFields[0].length;x++) {
				//fields[y][x].setPositions(x, y);
				if(validFields[y][x]>Value.fieldAir){
					String debugXY;
					if(Screen.isDebug){
						debugXY = validFields.getX()+" "+Board.fields[y][x].getY()+" : ";
					}
					else{
						debugXY = "";
					}
					g.drawRect(34 + (x * 140), 34 + (y * 140), 140, 140);
					g.drawString(debugXY+Board.fields[y][x].getName(), 34 + (x * 140)+5, 34 + (y * 140)+20);
					if (validFields[y][x]==Value.fieldField) {
						g.drawString(debugXY + Board.fields[y][x].getPrice(),
								34 + (x * 140) + 5, 34 + (y * 140) + 40);
					}
				}
			}
		}
		*/
		
		
		
		
	}

	public void getFields()
	{
		
		fields = new ArrayList<Field>();
		fields.add(new Field(34 + (0 * 140), 34 + (0 * 140), "Start", 0, 0));
		if (Screen.isDebug) {
			System.out.println("" + fields.get(0).getName());
		}
		for(int y=0;y<validFields.length;y++) {
			for(int x=0;x<validFields[0].length;x++) {
				if(y == 0 && x > 0) {
					try {
						top.next();
						fields.add(new Field(34 + (x * 140), 34 + (y * 140), top.getString(2), Integer.parseInt(top.getString(3)), Integer.parseInt(top.getString(4))));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		fields.add(new Field(34 + (4 * 140), 34 + (0 * 140), "Corner", 0, 0));
		if (Screen.isDebug) {
			System.out.println("" + fields.get(4).getName());
		}
		for(int y=0;y<validFields.length;y++) {
			for(int x=0;x<validFields[0].length;x++) {
				if(x == 4 && y > 0 && y < 4) {
					try {
						right.next();
						fields.add(new Field(34 + (x * 140), 34 + (y * 140), right.getString(2), Integer.parseInt(right.getString(3)), Integer.parseInt(right.getString(4))));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		fields.add(new Field(34 + (4 * 140), 34 + (4 * 140), "Corner", 0, 0));
		if (Screen.isDebug) {
			System.out.println("" + fields.get(8).getName());
		}
		for(int y=0;y<validFields.length;y++) {
			for(int x=validFields[0].length-2;x>0;x--) {
				if(y == 4) {
					try {
						bottom.next();
						fields.add(new Field(34 + (x * 140), 34 + (y * 140), bottom.getString(2), Integer.parseInt(bottom.getString(3)), Integer.parseInt(bottom.getString(4))));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		fields.add(new Field(34 + (0 * 140), 34 + (4 * 140), "Corner", 0, 0));
		if (Screen.isDebug) {
			System.out.println("" + fields.get(12).getName());
		}
		for(int y=validFields.length;y>0;y--) {
			for(int x=0;x<validFields[0].length;x++) {
				if(x == 0 && y > 0 && y < 4) {
					try {
						left.next();
						fields.add(new Field(34 + (x * 140), 34 + (y * 140), left.getString(2), Integer.parseInt(left.getString(3)), Integer.parseInt(left.getString(4))));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}			
				
				
				
				
		/*		
				if(validFields[y][x]==0){
					fields.add(new Field(34 + (x * 140), 34 + (y * 140), "Start", 0, 0));
					System.out.println(""+Board.fields[y][x].getName());
				} else if(validFields[y][x]==Value.fieldCorner){
					Board.fields[y][x] = new Field(34 + (x * 140), 34 + (y * 140), "Corner", 0, 0);
				} else if(validFields[y][x]==Value.fieldField){
					if(y == 0) {
						try {
							top.next();
							Board.fields[y][x] = new Field(34 + (x * 140), 34 + (y * 140), top.getString(2), Integer.parseInt(top.getString(3)), Integer.parseInt(top.getString(4)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(x == 0 && y > 0 && y < 4) {
						try {
							left.next();
							Board.fields[y][x] = new Field(34 + (x * 140), 34 + (y * 140), left.getString(2), Integer.parseInt(left.getString(3)), Integer.parseInt(left.getString(4)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(x == 4 && y > 0 && y < 4) {
						try {
							right.next();
							Board.fields[y][x] = new Field(34 + (x * 140), 34 + (y * 140), right.getString(2), Integer.parseInt(right.getString(3)), Integer.parseInt(right.getString(4)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(y == 4) {
						try {
							bottom.next();
							Board.fields[y][x] = new Field(34 + (x * 140), 34 + (y * 140), bottom.getString(2), Integer.parseInt(bottom.getString(3)), Integer.parseInt(bottom.getString(4)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						Board.fields[y][x] = new Field(x, y, "Field", 0, 0);
					}
					System.out.println(""+Board.fields[y][x].getName());
				}
			}
		}
	}	
		
		
		*/
	}	
		
		
		
		
		
		
		
		

}
