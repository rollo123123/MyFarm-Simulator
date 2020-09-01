package model;
import model.Constants.FiniteItemType;
/**
 * Abstract Class used for the two types of countable items
 */
public abstract class FiniteItem extends Item{
  private FiniteItemType type;
  private int quantity;

    /**
     *
     * @param id id of the finite type of item
     * @param type type of finite item
     */
    public FiniteItem(int id, FiniteItemType type){
    super(id);
    this.type = type;
    this.quantity = 0;
  }
  
    /**
     * adds the quantity of the item
     */
    public void addtoQuant() {
	  this.quantity += 1;
  }
  
    /**
     * subtracts the quantity of the item
     */
    public void subtoQuant() {
	  this.quantity -= 1;
  }
  
    /**
     * gets the quantity of the item
     * @return int
     */
    public int getQuantity(){
    return this.quantity;
  }
  
    /**
     * sets the quantity of the item
     * @param quant the value you want to set to the quantity
     */
    public void setQuantity(int quant){
    this.quantity = quant;
  }

    /**
     * gets the type of the item
     * @return FiniteItemType
     */
    public FiniteItemType getType() {
		return type;
	}

    /**
     * sets the type of the item
     * @param type type of finite item
     */
    public void setType(FiniteItemType type) {
		this.type = type;
	}

}
