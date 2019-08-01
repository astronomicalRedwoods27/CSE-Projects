package LightNSim;

import java.util.*;
import LightNSim.TrafficLight;

public class TrafficSimulation 
{
	public static void main(String[] args) 
	{
		TrafficLight sim = new TrafficLight();
		sim.printIntersection();
		Scanner scan = new Scanner(System.in); 
		
		while(sim.getRunning() == true)
		{
			sim.runLight();
			sim.printIntersection();
			scan.nextLine();
		}
		
		scan.close();
	}

}
