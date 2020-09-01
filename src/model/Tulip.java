package model;
import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Turnip Crop Entity serves as the crop to be planted on Tile
 */
public class Tulip extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Tulip(){
    super(CropName.TULIP, CropType.FLOWER, CropStatus.WAITING, 90, 2, 2, 3, 0, 1, 1, 1, 7);
  }
}
