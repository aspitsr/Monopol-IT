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
	private ResultSet rs; 
	Field[][] fields;
	public static int[][] validFields = {{1,1,1,1,1}, {1,0,0,0,1}, {1,0,0,0,1}, {1,0,0,0,1}, {1,1,1,1,1}}; 

	
	
	public Board() {
		 define();
	}
	
	public void define(){
		fields = new Field[5][5];

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
				if(validFields[y][x]==1){
					g.drawRect(34 + (x * 140), 34 + (y * 140), 140, 140);
					
				}
				System.out.println(y+"");
			}
		}
	}

	public void getFields(int n
			)
	{
		for(int y=0;y<fields.length;y++) {
			for(int x=0;x<fields[0].length;x++) {
				
				if(validFields[y][x]==1){
					fields[y][x] = new Field();
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
}
