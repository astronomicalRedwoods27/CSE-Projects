package Vehicles;

public class Truck extends Vehicle 
{
	public Truck()
	{
		super(15,false);
	}
	
	public int getTime()
	{
		return 15;
	}
	public boolean getIsEmergency()
	{
		return false;
	}
	
	public String toString()
	{
		return "T";
	}

}