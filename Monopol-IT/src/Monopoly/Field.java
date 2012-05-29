package Monopoly;

public class Field {
	int id = 1;
	String name = "IT-Factory";
	int value = 10000;
	int property = 0;
	int category = 1;
	int rent;
	String owner;
	
	
	public Field() {
		
	}
	
	public void setOwner(String s) {
		owner = s;
	}
	
	public void setName(String s)	{
		name = s;
	}
	
	public void setValue(int i)	{
		value = i;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRent()	{
		rent = (value / 10) * property;
		return rent;
	}
	
	public String getOwner() {
		return owner; 
	}
	public int getValue() { 
		return value;
	}
	
	public int getPrice() {
		return value; 
	}
	
	public int getHousePrice() {
		int price;
		price = value / 5;
		return price;
	}

}
