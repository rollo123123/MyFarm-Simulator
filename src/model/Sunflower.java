package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Sunflower Crop Entity serves as the crop to be planted on Tile
 */

public class Sunflower extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Sunflower(){
    super(CropName.SUNFLOWER, CropType.FLOWER, CropStatus.WAITING, 210, 2, 2, 3, 1, 2, 1, 1, 9);
  }
}
