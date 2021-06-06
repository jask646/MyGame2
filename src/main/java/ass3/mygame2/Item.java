/**This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.\

*/
package ass3.mygame2;
/**
 * 
 *
 * @author (Jaskaran Pal kaur and Pawandeep Kaur)
 * @version (06/06/2021)
 */
public class Item
{
    private String description;
    private String name;
    private int destructivePower;
    private double healingPower;
    /**
     * COnstructor 1
     * @param name
     * @param description
     * @param destructivePower 
     */
    public Item(String name, String description, int destructivePower)
    {
        this.name = name;
        this.description = description;
        this.destructivePower = destructivePower;
    }
    
    /**
     * Constructor 2
     * @param name
     * @param description
     * @param healingPower 
     */
    public Item(String name, String description, double healingPower)
    {
        this.name = name;
        this.description = description;
        this.healingPower = healingPower;
    }
    
    /**
     * accessor
     */
      
    public String getName(){
        return name;
    }
    
    /**
     * accessor
     * @return description 
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * accessor
     *  
     */
    public int getPower(){
        return destructivePower;
    }
}
