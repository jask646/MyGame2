/**
 * 
 */
package ass3.mygame2;

import java.util.ArrayList;


/**
 * Write a description of class ItemCreation here.
 *
 * @author (Jaskaran Pal Kaur and Pawandeep Kaur)
 * @version (6/06/2021)
 */
public class ItemCreation
{
   
    private ArrayList<Item> allItemsInGame;
    
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
   
    public void createItems(){
        
        Item  excaliburSword, key, frontGateKey, BedroomKey, RemoteControl;
        
        
        excaliburSword = new Item("excaliburSword", "The legendary Excalibur", 100);
        key = new Item("key", "It has a shape of a heart", 100);
        frontGateKey = new Item("frontGateKey", "To open the front gate door", 100);
        BedroomKey = new Item("BedroomKey", "To enter the bedroom",100);
        RemoteControl = new Item("RemoteControl", "To turn on the theatre",100);
        
        
        allItemsInGame.add(excaliburSword);
        allItemsInGame.add(key);
        allItemsInGame.add(frontGateKey);
        allItemsInGame.add(BedroomKey);
        allItemsInGame.add(RemoteControl);
        
        
    }
   
    public Item getItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: allItemsInGame){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
  
    
}
