/**
 *
 */
package ass3.mygame2;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *  Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labeled north, 
 * east, south, west.  For each direction, the room stores an item to enter into the neighboring room
 * or null if there is no exit in that direction.
 * 
 * @author  Jaskaran Pal Kaur and Pawandeep Kaur
 * @version 06/06/2021
 */

public class Room 
{
    private String description;
    private String name;
    private boolean isLocked;
    private HashMap<String, Room> exits;        
    private ArrayList<Item> roomItem;
    private HashMap<Room, Item> roomHashMapItem;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name, String description, boolean isLocked) 
    {
        this.description = description;
        this.name = name;
        this.isLocked = isLocked;
        exits = new HashMap<>();
        roomItem = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getAllItems();
    }

    public String getAllItems(){

        return "You have some " + listOfItems();

    }

    private String listOfItems(){

        String returnString = "items:";
        for(Item item : roomItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Method getRoomItem
     *
     * @param stringItem taken from the command which was converted into a String
     * @return Item class according to the input String
     */
    public Item getRoomItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: roomItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }

    public void addItemInRoom(Item item){
        roomItem.add(item);
    }

    public void removeItemInRoom(Item item){
        if(roomItem.size() > 0){
            roomItem.remove(item);
        }
    }

    public void addHashMapItemInRoom(Room room, Item item){
        roomHashMapItem.put(room, item);
    }

    /**
     * Method getLockedStatus
     *
     * @return The return value
     */

    public boolean getLockedStatus(){
        return isLocked;
    }

    public void setLockedStatus(boolean newStatus){
        isLocked = newStatus;
    }
    
    public String getName(){
        return name;
    }

    
}

