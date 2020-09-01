package model;
import model.Constants.CropName;
import model.Constants.FiniteItemType;

/**
 * Seed class is used as an item
 */

public class Seed extends FiniteItem{
	private CropName seed;
	
    /**
     *
     * @param id id of the seed
     * @param seed name of the seed of the crop
     */
    public Seed(int id, CropName seed) { //initializing player
		super(id, FiniteItemType.SEED);
		this.seed = seed;
	}
  
    /**
     * gets the name of the seed
     * @return CropName
     */
    public CropName getSeedName() {
		return seed;
	}
	
}
