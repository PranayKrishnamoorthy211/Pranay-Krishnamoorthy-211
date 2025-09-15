package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        //System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

    }

    // declared here so it is visible in all the methods!
    private Robot roomba;

    // You will need to add many variables!!


    public int cleanRoom(String worldName, int startX, int startY) {

        // A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

        World.readWorld(worldName);
        World.setVisible(true);
        //World.setSize(20, 20);
        World.setDelay(1);

        roomba = new Robot(startX, startY, East, 0);
        int count = 0;
        int numPiles = 0; 
        boolean end = true; 
        while(end){
            while(roomba.frontIsClear()){
                roomba.move(); 
                if(roomba.nextToABeeper() == true){
                    numPiles++; 
                }
                while(roomba.nextToABeeper()){
                    roomba.pickBeeper();
                    count++; 
                }
                

            }
            if(roomba.facingEast() && !roomba.frontIsClear()){
                roomba.turnLeft();
                roomba.move(); 
                roomba.turnLeft(); 
            }
            if(roomba.facingWest() && !roomba.frontIsClear()){
                turnRight(roomba);
                roomba.move(); 
                turnRight(roomba); 
            }
            if(roomba.facingNorth() && !roomba.frontIsClear()){
                end = false; 
            }
        } 
        System.out.println("Total number of beepers: "+ count); 
        System.out.println("Total number of piles: "+numPiles); 

        return count;}
      
	public static void turnRight(Robot roomba){
	roomba.turnLeft();
	roomba.turnLeft();
	roomba.turnLeft();
	}
}