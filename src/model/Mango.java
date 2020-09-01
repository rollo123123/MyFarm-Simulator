package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;


/**
 * Mango Crop Entity serves as the crop to be planted on Tile
 */

public class Mango extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */

  public Mango(){
    super(CropName.MANGO, CropType.FRUIT_TREE, CropStatus.WAITING, 420, 3, 7, 7, 4, 4, 5, 10, 4);

  }

}
