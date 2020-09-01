package model;
import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Turnip Crop Entity serves as the crop to be planted on Tile
 */

public class Turnip extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//int ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Turnip(){
    super(CropName.TURNIP, CropType.VEGETABLE, CropStatus.WAITING, 60, 1, 1, 2, 0, 1, 1, 1, 6);
  }
}
