package Monopoly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Board controls Player positions
// Board contains Fields
public class Board {
	private	DbHandler db = new DbHandler();
	private ResultSet rs;
	ArrayList<Field> fields = new ArrayList(); 
	
	public Board() {
		 getFields(2);
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

	public void getFields(int n)
	{
		int i;
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
	}
}
