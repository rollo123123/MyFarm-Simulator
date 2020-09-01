package model;
import model.Constants.FiniteItemType;
/**
 * Fertilizer class is used as an Item
 */
public class Fertilizer extends FiniteItem{
	
    /**
     *
     * @param id item id for the fertilizer
     */
    public Fertilizer(int id) {
	  super(id, FiniteItemType.FERTILIZER);
	  this.setQuantity(5);
	}
  
  

}
