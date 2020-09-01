package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Potato Crop Entity serves as the crop to be planted on Tile
 */

public class Potato extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Potato(){
    super(CropName.POTATO, CropType.VEGETABLE, CropStatus.WAITING, 300, 1, 4, 5, 2, 3, 1, 6, 13);
  }
}
