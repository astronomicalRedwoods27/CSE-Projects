package Vehicles;

public abstract class Vehicle 
{
	public int time;
	public boolean isEmergency;
	
	public Vehicle()
	{
		time = 0;
		isEmergency = false;
	}
	public Vehicle(int t, boolean i)
	{
		this.time = t;
		this.isEmergency = i;
	}
	
	public abstract int getTime();
	public abstract boolean getIsEmergency();
}
