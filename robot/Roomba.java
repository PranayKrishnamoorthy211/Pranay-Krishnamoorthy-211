package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setSize(20, 20);
		World.setDelay(1);

		Robot roomba = new Robot(7, 7, East, 0);
		int totalBeepers = 0;

		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		roomba.move();
		roomba.turnLeft();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.turnLeft();
		roomba.move();
		roomba.move();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		roomba.move();
		roomba.move();
		roomba.move();
		roomba.turnLeft();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.turnLeft();
		roomba.move();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}
		roomba.move();
		roomba.move();



		return totalBeepers;
	}
	
}
