package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Rose Crop Entity serves as the crop to be planted on Tile
 */

public class Rose extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//int ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Rose(){
    super(CropName.ROSE, CropType.FLOWER, CropStatus.WAITING, 60, 2, 1, 2, 0, 1, 1, 1, 5);
  }
}
