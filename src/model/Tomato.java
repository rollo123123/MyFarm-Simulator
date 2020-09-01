package model;
import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;

/**
 * Tomato Crop Entity serves as the crop to be planted on Tile
 */
public class Tomato extends Crop{
//public Crop(CropName name, CropType type, CropStatus status,
//int ht, double hc, int wmin, int wmax, int fermin, int fermax, int ymin, int ymax)

    /**
     *
     */
  public Tomato(){
    super(CropName.TOMATO, CropType.VEGETABLE, CropStatus.WAITING, 10, 1, 3, 4, 1, 2, 1, 3, 15);
  }
}
