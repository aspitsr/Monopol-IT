package Monopoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbHandler
{
	String userName = "Aspit";
    String password = "1234";
    String url = "jdbc:mysql://bb-1852-pc/monopolit";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public DbHandler()
    {
    	connect();

        
    }
    
    public void testOutput() {
    	     String own;
    	    try{st = conn.createStatement();
        	rs = st.executeQuery("SELECT * FROM players");
    	    
    	    
        	while(rs.next()) {
        		
        		if(rs.getString(5) == "")
        		{
        			own = "Ingen";
        		}
        		else
        		{
        			own = rs.getString(5);
        		} 
        		
                System.out.println(rs.getString(2)+" Har "+rs.getString(3)+" og er på plads "+rs.getString(4)+" og ejer "+own);
             	}
    	    }
    	    catch (Exception e){
    	    	System.out.println(e);
    	    }
    }
    
    public void connect() {
        try
        {
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        	conn = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server"+e);
        }
    }
    
    public void updatePlayers(String column, String value, String name){
    	try
    	{
	    	PreparedStatement update = conn.prepareStatement("UPDATE players SET "+column+"="+value+"  WHERE name='"+name+"'");
	        update.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    
    public ResultSet selectPlayer(String name){
	    try{st = conn.createStatement();
    	rs = st.executeQuery("SELECT * FROM players WHERE name ='"+name+"'");
    	int i;
    	while(rs.next()) {
			i = Integer.parseInt(rs.getString(4));
		}
	    }
	    catch (Exception e){
	    	System.out.println(e);
	    }
	    return rs;
    }
    public ResultSet selectFields(int i){
	    try{
	    	st = conn.createStatement();
    		rs = st.executeQuery("SELECT id FROM categories WHERE position ='"+ i +"' LIMIT 0,1");
	    }
	    catch (Exception e){
	    	System.out.println(e);
	    }
		try{
			if(rs.next()) {
		    	st = conn.createStatement();
				rs = st.executeQuery("SELECT * FROM fields WHERE category_id ='"+ rs.getString(1) +"' AND active=1 LIMIT 0,3");
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	    return rs;
    }
    public int checkLogin(String username, String password){
	    int id = 0;
    	try{
	    	st = conn.createStatement();
    		rs = st.executeQuery("SELECT * FROM users WHERE username ='"+ username +"'");
    		rs.first();
    		System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
    		System.out.println(rs.getString(3));
    		System.out.println(password);
    		if(password.equals(rs.getString(3))) {
    			System.out.println("Hey");
    			id = Integer.parseInt(rs.getString(1));
    		}
	    }
	    catch (Exception e){
	    	System.out.println(e);
	    }
	    return id;
    }
    
    public ResultSet selectPlayers(int i){
        Statement stPlayers = null;
        ResultSet rsPlayers = null;
    	try{
	    	stPlayers = conn.createStatement();
	    	// Select Players
    		rsPlayers = stPlayers.executeQuery("SELECT * FROM players WHERE game_id ='"+ i +"'");
	    }
	    catch (Exception e){
	    	System.out.println(e);
	    }
	    return rsPlayers;
    }
    public ResultSet selectFieldOwners(int i){
        Statement stPlayers = null;
        ResultSet rsPlayers = null;
    	try{
	    	stPlayers = conn.createStatement();
	    	// Select Field Owners
    		rsPlayers = stPlayers.executeQuery("SELECT * FROM owned_fields WHERE game_id ='"+ i +"'");
	    }
	    catch (Exception e){
	    	System.out.println(e);
	    }
	    return rsPlayers;
    }
    
    public void insertOwner(int owner, int game, int field){
    	try
    	{
	    	PreparedStatement update = conn.prepareStatement("INSERT INTO owned_fields (owner, game_id, field_id) VALUES('"+ owner +"', '"+ game +"', '"+ field +"') ");
	        update.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
}