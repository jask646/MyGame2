
package ass3.mygame2;


import java.util.ArrayList;

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
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
   * @param stringRoom Contains the room name
   * @return the room name
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
