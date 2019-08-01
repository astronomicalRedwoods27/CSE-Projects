package Vehicles;

public class Semi extends Vehicle 
{
	public Semi()
	{
		super(20,false);
	}
	
	public int getTime()
	{
		return 20;
	}
	public boolean getIsEmergency()
	{
		return false;
	}
	
	public String toString()
	{
		return "S";
	}

}
