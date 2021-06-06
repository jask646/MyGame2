package ass3.mygame2;


import java.util.ArrayList;


/**
 * Write a description of class Player here.
 *
 * @author (Jaskaran Pal Kaur and Pawandeep Kaur)
 * @version (06/06/2021)
 */
public class Player
{
    
    private ArrayList<Item> playerItem;
    
    public Player()
    {
        playerItem = new ArrayList();
    }
    
    /**
     * This method is used to add items to the player's inventory in form of array list
     * @param item adds item from item class to the inventory 
     * 
     */
    
    public void addItemInventory(Item item){
        playerItem.add(item);
        System.out.println(item.getDescription() + " was taken ");
        //System.out.println(item.getDescription() + " was removed from the room"); // add extra information to inform user that the item has been taken
    }
    /**
     * Removes Item
     * @param item removes item
     */
    public void removeItemInventory(Item item){
        playerItem.remove(item);
        System.out.println(item.getName() + " was removed from your inventory");
    }
    
    /**
     * This method is used to get the item name picked up by the player
     * @param stringItem 
     * @return name of the item the player has picked
     */
    public Item getPlayerItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: playerItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    /**
     * This method prints all the items present in the inventory
     * @return returnString returns the list of items in the inventory
     */
    public String printAllInventory(){

        String returnString = "Items:";
        for(Item item : playerItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    
}
