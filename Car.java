package Vehicles;

public class Car extends Vehicle 
{
	public Car()
	{
		super(10,false);
	}
	
	public int getTime()
	{
		return 10;
	}
	public boolean getIsEmergency()
	{
		return false;
	}
	
	public String toString()
	{
		return "C";
	}

}
