package Vehicles;

public class Emergency extends Vehicle 
{
	public Emergency()
	{
		super(15,false);
	}
	
	public int getTime()
	{
		return 15;
	}
	public boolean getIsEmergency()
	{
		return true;
	}
	
	public String toString()
	{
		return "E";
	}

}