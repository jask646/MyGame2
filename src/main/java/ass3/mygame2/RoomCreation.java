/** */
package ass3.mygame2;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game. 
 * 
 * This class holds the information about the different rooms.
 * All the rooms are given exits such as north, South , east and west in the class RoomCreation
 * There are different items required to enter different rooms.
 * An item will be required to enter in the respected room

 * @author Jaskaran Pal Kaur and Pawandeep Kaur
 * @version 06/06/2021
 * 
 */

import java.util.ArrayList;


public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
  /**
   * Rooms are initialized in the class
   * Rooms are added in the class
   * The rooms are given the exits
   * Items are added in the room
   * 
   */  
    private void createRooms() {

        Room castle, kitchen, frontGate, Bedroom, Theatre;

        castle = new Room("castle", "You are at the castle", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        Bedroom = new Room("Bedroom", "This room has a bedroom", true);
        Theatre = new Room("Theatre","There is a big projector", true);
        

        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        frontGate.setExit("south", Bedroom);
        Bedroom.setExit("north", frontGate);
        Theatre.setExit("south", Bedroom);
        

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));
        Bedroom.addItemInRoom(itemCreation.getItem("BedroomKey"));
        Theatre.addItemInRoom(itemCreation.getItem("RemoteControl"));

        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);
        allRoomInGame.add(Bedroom);
        allRoomInGame.add(Theatre);

    }

  /**
   * 
   * 
   * @param stringRoom This contains the room name
   * @return this returns the room name
   * 
   */
    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn;
    }

}
