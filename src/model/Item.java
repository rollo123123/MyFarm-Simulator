package model;

/**
 * Abstract class Item used for FiniteItem
 */

public abstract class Item{
	private int id;
	
    /**
     *
     * @param id the id of the item
     */
    public Item(int id){
    this.id = id;
  }
  
    /**
     * gets the ID of the item
     * @return int
     */
    public int getID(){
    return this.id;
  }
  
  

}
