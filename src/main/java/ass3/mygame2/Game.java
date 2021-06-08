/*
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * This main class hold the information of playing game and initialises all the others:
 * it provides information of the item available to the user and provides relevant information 
 * to enter into other room. It also evaluates and
 * executes the commands that the parser returns.
 * This classs game holds the information of playing game. There will be a continuous loop of items
 * available to enter into different rooms.
 * Whole information regarding help,go quit various other commands will be given in this class.

 */
package ass3.mygame2;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *The main class holds the information of playing game and initializes all the others.
 *@author Jaskaran Pal Kaur and Pawandeep Kaur
 * @version 07/06/2021
 *
 
 */

public class Game {

    private Parser parser;
    private Player player;
    private Room currentRoom;
    private RoomCreation rooms;

    private HashMap<Item, Room> roomItem;

    private HashMap<Item, Room> roomKey;

    private int timeCounter; // to count the steps

    /**
     * Create the game and initialise its internal map.
     */
    
    public Game() {
        long timeStart = System.currentTimeMillis(); // use the real time
        timeCounter = 50;
        parser = new Parser();
        player = new Player();
        rooms = new RoomCreation();
        currentRoom = rooms.getRoom("castle");  // start game outside
            }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }

    
    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            long currentTime = System.currentTimeMillis();
            Command command = parser.getCommand();         
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
  
     
     */
    
    private void printWelcome() {
        System.out.println("Welcome to the world of Text Based Adventure Game and have a fun. Let the adventure begin");
        System.out.println("The Word of zuul is a text Based Adventure Game. There are four exits in this scenery north,south,east and west"
                + "An item is required to grab in order to enter into the other room.\n You will be given commands to proceed"
                + "with the game.\n You can invent, and remove the items in the game." );
        System.out.println("This game is designed to play with the text words where the items will help to enter and \n enter a new room.");
        System.out.println("You need a particular item to enter into the other room and need to specify the direction."
                + "if u are not specifying the proper direction and item, in result the game will over.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("inventory")) {
            printInventory(); 
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("take")) {
            takeItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } else if (commandWord.equals("use")) {
            
        } else if (commandWord.equals("inspect")) {
            
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
       
        return wantToQuit;
    }

    
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("");

       
        System.out.println("you can open the door using the use command");

        System.out.println("you need to clear the ogre before you can open the kitchen door");

        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void printInventory() {
        System.out.println(player.printAllInventory());
    }

    /**
     * Try to in to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * @param Command is to be processes
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
       
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

       
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            if (currentRoom.getLockedStatus() == true)
            { 
                System.out.println("The door is locked, you need to find a way to open it");
                System.out.println(currentRoom.getLongDescription());
            } else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            
            }
        }
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord())
        {
          System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        
        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
          
            currentRoom.removeItemInRoom(currentItem);
            player.addItemInventory(currentItem);

           }
    }

    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
      

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
      
            player.removeItemInventory(currentItem);
            currentRoom.addItemInRoom(currentItem);

        }
    }

    private void useItem(Command command)
    {
        if (!command.hasSecondWord()) {
      
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't use nothing, no?");
        } else {
            
            System.out.println("You just used the " + currentItem.getName());

            
            System.out.println("You cannot use this item here");

        }

    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  
        }
    }

}

