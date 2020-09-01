package model;
import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;
/**
 * Apple Crop Entity serves as the crop to be planted on Tile
 */
public class Apple extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//double ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */

  public Apple(){
    super(CropName.APPLE, CropType.FRUIT_TREE, CropStatus.WAITING, 420, 3, 7, 7, 5, 5, 7, 10, 3.5);
  }

}
