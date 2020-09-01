package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;
/**
 * Banana Crop Entity serves as the crop to be planted on Tile
 */
public class Banana extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */

	public Banana(){
    super(CropName.BANANA, CropType.FRUIT_TREE, CropStatus.WAITING, 480, 3, 8, 8, 5, 5, 10, 15, 3.5);
	}
}
