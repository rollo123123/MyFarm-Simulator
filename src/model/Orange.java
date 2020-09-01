package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Orange Crop Entity serves as the crop to be planted on Tile
 */

public class Orange extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */

	public Orange(){
    super(CropName.ORANGE, CropType.FRUIT_TREE, CropStatus.WAITING, 480, 3, 8, 8, 6, 6, 13, 15, 4.5);
	}
	
}
