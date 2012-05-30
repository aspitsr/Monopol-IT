package Monopoly;




import java.awt.Color;
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
	public static Field[][] fields;
	public static int[][] validFields = {{Value.fieldStart,Value.fieldField,Value.fieldField,Value.fieldField,Value.fieldCorner}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldField,Value.fieldAir,Value.fieldAir,Value.fieldAir,Value.fieldField}, 
										 {Value.fieldCorner,Value.fieldField,Value.fieldField,Value.fieldField,Value.fieldCorner}}; 
	
	
	public Board() {
		 define();
		
	}
	
	public void define(){
		Board.fields = new Field[5][5];
		top = db.selectFields(1);
		left = db.selectFields(2);
		right = db.selectFields(3);
		bottom = db.selectFields(4);
		getFields();
	}
	/*
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
	*/
	public void draw(Graphics g){
		g.setColor(new Color(255,0,0));
		g.fillRect(0, 0, Screen.myWidth, Screen.myHeight);
		g.setColor(new Color(255,255,255));
		g.fillRect(9, 9, 750, 750);
		g.setColor(new Color(0,0,0));
		for(int y=0;y<fields.length;y++) {
			for(int x=0;x<fields[0].length;x++) {
				//fields[y][x].setPositions(x, y);
				if(validFields[y][x]>Value.fieldAir){
					g.drawRect(34 + (x * 140), 34 + (y * 140), 140, 140);
					g.drawString(x+" "+y+" : "+Board.fields[y][x].getName(), 34 + (x * 140) + (140/2), 34 + (y * 140)+ (140/2));
					g.drawString(x+" "+y+" : "+Board.fields[y][x].getPrice(), 34 + (x * 140) + (140/2), 34 + (y * 140)+ (140/2) + 20);
				}
			}
		}
	}

	public void getFields()
	{
		for(int y=0;y<Board.fields.length;y++) {
			for(int x=0;x<Board.fields[0].length;x++) {
				
				if(validFields[y][x]==0){
					Board.fields[y][x] = new Field(x, y, "Start", 0, 0);
					System.out.println(""+Board.fields[y][x].getName());
				} else if(validFields[y][x]==Value.fieldCorner){
					Board.fields[y][x] = new Field(x, y, "Corner", 0, 0);
				} else if(validFields[y][x]==Value.fieldField){
					if(y == 0) {
						try {
							top.next();
							Board.fields[y][x] = new Field(x, y, top.getString(2), Integer.parseInt(top.getString(3)), Integer.parseInt(top.getString(4)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(x == 0 && y > 0 && y < 4) {
						try {
							left.next();
							Board.fields[y][x] = new Field(x, y, left.getString(2), 0, 0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(x == 4 && y > 0 && y < 4) {
						try {
							right.next();
							Board.fields[y][x] = new Field(x, y, right.getString(2), 0, 0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if(y == 4) {
						try {
							bottom.next();
							Board.fields[y][x] = new Field(x, y, bottom.getString(2), 0, 0);
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
		
		
		
		
		
		
		
		
		
		
		
		
	/*
		Field fieldStart = new Field();
		fieldStart.setName("Start");
		fieldStart.setValue(0);
		fields.add(fieldStart);
		for(i=1;i<=n;i++) {
			rs = db.selectFields(i);
			try {
				while(rs.next())	{
					Field field = new Field();
					field.setName(rs.getString(2));
					field.setValue(Integer.parseInt(rs.getString(3)));
					fields.add(field);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
		public void moveAvatar(int roll, Player p) {
		int position = p.getPosition();
		System.out.print(p.getName()+" moved from "+fields.get(position).getName()+"("+fields.get(position).getValue()+")");
		position = newPosition(roll, p.getPosition());
		System.out.println(" to "+fields.get(position).getName()+"("+position+")");
		p.setPosition(position);
	}*/
	
}
