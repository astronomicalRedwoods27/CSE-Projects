package LightNSim;

import java.util.*;
import Vehicles.*;

public class TrafficLight 
{
	private Vehicle[] North = new Vehicle[5];
	private Vehicle[] South = new Vehicle[5];
	private Vehicle[] West = new Vehicle[5];
	private Vehicle[] East = new Vehicle[5];
	
	private boolean running;
	private boolean nsGreen;
	private boolean ewGreen;
	private final int time = 20;
	
	public TrafficLight()
	{
		for (int i = 0; i < 4; i++)// fills all directs
		{
			if (i == 0) // North
			{
				Random x = new Random();
				int rand =x.nextInt(5);
				for (int j = 0; j < rand; j++)
				{
					int type = x.nextInt(3);
					if (type == 0)
					{
						Car c = new Car();
						North[j] = c;
					}
					if (type == 1)
					{
						Truck t = new Truck();
						North[j] = t;
					}
					if (type == 2)
					{
						Semi s = new Semi();
						North[j] = s;
					}
				}
			}
			else if (i == 1) // South
			{
				Random x = new Random();
				int rand =x.nextInt(5);
				for (int j = 0; j < rand; j++)
				{
					int type = x.nextInt(3);
					if (type == 0)
					{
						Car c = new Car();
						South[j] = c;
					}
					if (type == 1)
					{
						Truck t = new Truck();
						South[j] = t;
					}
					if (type == 2)
					{
						Semi s = new Semi();
						South[j] = s;
					}
				}
			}
			else if (i == 2) // West
			{
				Random x = new Random();
				int rand =x.nextInt(5);
				for (int j = 0; j < rand; j++)
				{
					int type = x.nextInt(3);
					if (type == 0)
					{
						Car c = new Car();
						West[j] = c;
					}
					if (type == 1)
					{
						Truck t = new Truck();
						West[j] = t;
					}
					if (type == 2)
					{
						Semi s = new Semi();
						West[j] = s;
					}
				}
			}
			else if (i == 3) // East
			{
				Random x = new Random();
				int rand =x.nextInt(5);
				for (int j = 0; j < rand; j++)
				{
					int type = x.nextInt(3);
					if (type == 0)
					{
						Car c = new Car();
						East[j] = c;
					}
					if (type == 1)
					{
						Truck t = new Truck();
						East[j] = t;
					}
					if (type == 2)
					{
						Semi s = new Semi();
						East[j] = s;
					}
				}
			}
		}
		running = true;
	}

	public boolean getRunning()
	{
		return running;
	}
	
	public void printIntersection()
	{
		System.out.println("\t\t\t   ");
		for(int i = 5; i >= 0; i--) // prints north and sides
		{
			if (North[i] == null)
			{
				System.out.println("|     |" );
			}
			else
			{
				System.out.println("|  " + North[i] + "  |");
			}
		}
		System.out.println("---------------     ---------------");
		for(int i = 5; i >= 0; i--)
		{
			if (West[i] == null)
			{
				System.out.print(" ");
			}
			else
			{
				System.out.print(" " + West[i] + " ");
			}
		}
		System.out.println("\t ");
		for(int i = 5; i >= 0; i--)
		{
			if (East[i] == null)
			{
				System.out.print(" ");
			}
			else
			{
				System.out.print(" " + East[i] + " ");
			}
		}
		System.out.println("---------------     ---------------");
		
		System.out.println("\t\t\t   ");
		for(int i = 0; i < 5; i++)
		{
			if (South[i] == null)
			{
				System.out.println("|     |" );
			}
			else
			{
				System.out.println("|  " + South[i] + "  |");
			}
		}
	}
	
	public void addVehicle(boolean emergency, Vehicle[] direction)
	{
		for (int i = 0; i < 5; i++)
		{
			if (direction[i] != null)
			{
				break;
			}
			else
			{
				Random x = new Random();
				if (emergency == false)
				{
					int type = x.nextInt(3);
					if (type == 0)
					{
						Car c = new Car();
						direction[i] = c;
					}
					if (type == 1)
					{
						Truck t = new Truck();
						direction[i] = t;
					}
					if (type == 2)
					{
						Semi s = new Semi();
						direction[i] = s;
					}
				}
				else
				{
					Emergency e = new Emergency();
					direction[i] = e;
				}
			}
		}
	}
	
	public boolean checkNoVehicles()
	{
		for (int i = 0; i < North.length; i++)
		{
			if (North[i] != null)
			{
				return false;
			}
		}
		for (int i = 0; i < South.length; i++)
		{
			if (South[i] != null)
			{
				return false;
			}
		}
		for (int i = 0; i < East.length; i++)
		{
			if (East[i] != null)
			{
				return false;
			}
		}
		for (int i = 0; i < West.length; i++)
		{
			if (West[i] != null)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean checkAllEmergency()
	{
		for (int i = 0; i < North.length; i++)
		{
			if (North[i] instanceof Emergency)
			{
				return true;
			}
		}
		for (int i = 0; i < South.length; i++)
		{
			if (South[i] instanceof Emergency)
			{
				return true;
			}
		}
		for (int i = 0; i < East.length; i++)
		{
			if (East[i] instanceof Emergency)
			{
				return true;
			}
		}
		for (int i = 0; i < West.length; i++)
		{
			if (West[i] instanceof Emergency)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkEmergency (Vehicle[] direction)
	{
		for (int i = 0; i < direction.length; i++)
		{
			if (direction[i] instanceof Emergency)
			{
				return true;
			}
		}
		return false;
	}
	
	public void shiftUp(Vehicle[] direction)
	{
		direction[0] = null;
		for (int i = 0; i < direction.length; i++)
		{
			direction[i] = direction[i+1];
		}
		direction[direction.length - 1] = null;
	}
	
	public void emergencyFront()
	{
		for (int i = 0; i < North.length; i++)
		{
			if (checkEmergency(North) == true)
			{
				North[i] = null;
				for (int j = North.length - 1; j > 0; j--)
				{
					North[j] = North[j - 1];	
				}
				North[0] = new Emergency();
			}
			else
			{
				break;
			}
		}
		for (int i = 0; i < South.length; i++)
		{
			if (checkEmergency(South) == true)
			{
				South[i] = null;
				for (int j = South.length - 1; j > 0; j--)
				{
					South[j] = South[j - 1];	
				}
				South[0] = new Emergency();
			}
			else
			{
				break;
			}
			nsGreen = true;
		}
		for (int i = 0; i < East.length; i++)
		{
			if (checkEmergency(East) == true)
			{
				East[i] = null;
				for (int j = East.length - 1; j > 0; j--)
				{
					East[j] = East[j - 1];	
				}
				East[0] = new Emergency();
			}
			else
			{
				break;
			}
			ewGreen = true;
		}
		for (int i = 0; i < West.length; i++)
		{
			if (checkEmergency(West) == true)
			{
				West[i] = null;
				for (int j = West.length - 1; j > 0; j--)
				{
					West[j] = West[j - 1];	
				}
				West[0] = new Emergency();
			}
			else
			{
				break;
			}
			ewGreen = true;
		}
	}

	public void placeRandomVehicle()
	{
		Random x = new Random();
		int type = x.nextInt(4);
		switch(type)
		{
		case 0:
			
		}
				
	}
	
	public void runVehicles(Vehicle[] arr1, Vehicle[] arr2)
	{
		int timeLeft = time;
		if(arr1[0] != null && arr2[0] != null && (arr1[0].getTime() < timeLeft))
		{
			arr1[0] = null;
			shiftUp(arr1);
		}
		if(arr1[0] != null && arr2[0] != null && (arr2[0].getTime() < timeLeft))
		{
			arr2[0] = null;
			shiftUp(arr2);
		}
		if(arr1[0] != null && arr2[0] != null && (arr1[0].getTime() >= arr2[0].getTime()))
		{
			timeLeft = timeLeft - arr1[0].getTime();
			arr1[0] = null;
			shiftUp(arr1);
		}
		if(arr1[0] != null && arr2[0] != null && (arr2[0].getTime() >= arr1[0].getTime()))
		{
			timeLeft = timeLeft - arr2[0].getTime();
			arr2[0] = null;
			shiftUp(arr1);
		}
		if (arr1[0] != null && arr2[0] != null)
		{
			timeLeft = 0;
		}
		
		else
		{
			timeLeft = 0;
		}
	}
	
	public void runLight()
	{
		int timeLeft = time;
		while (timeLeft > 0)
		{
			if (nsGreen == true)
			{
				if(checkAllEmergency() == true)
				{
					emergencyFront();
				}
				runVehicles(North, South);
				nsGreen = false;
				ewGreen = true;
			}
			if (ewGreen == true)
			{
				runVehicles(East, West);
			}
		}
		
	}
	
	
}
