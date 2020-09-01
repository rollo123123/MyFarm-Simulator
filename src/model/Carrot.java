package model;

import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;
/**
 * Carrot Crop Entity serves as the crop to be planted on Tile
 */
public class Carrot extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//int ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Carrot(){
    super(CropName.CARROT, CropType.VEGETABLE, CropStatus.WAITING, 90, 1, 1, 2, 0, 1, 1, 2, 9);
  }
}
