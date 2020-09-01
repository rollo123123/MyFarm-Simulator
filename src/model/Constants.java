package model;
import java.util.*;
/**
 * Holds ENUM VALUES to be used as attributes for Crop, Item, Tile and Pricelist
 */
public class Constants{
	
    /**
     *
     */
    public enum FiniteItemType{

              /**
               *
               */
              FERTILIZER,

              /**
               *
               */
              SEED;
	  }
	  
    /**
     *
     */
    public enum TileStatus{

              /**
               *
               */
              PLANTED,

              /**
               *
               */
              EMPTY,

              /**
               *
               */
              ROCK,

              /**
               *
               */
              GRASS,

              /**
               *
               */
              NOT_ALLOWED,

              /**
               *
               */
              ALLOWED;
	  }
	  
    /**
     *
     */
    public enum CropType{

              /**
               *
               */
              VEGETABLE,

              /**
               *
               */
              FLOWER,

              /**
               *
               */
              FRUIT_TREE;
	  }
	
    /**
     *
     */
    public enum CropStatus{

              /**
               *
               */
              WAITING,

              /**
               *
               */
              READY,

              /**
               *
               */
              DEAD;
	  }
	
    /**
     *
     */
    public enum CropName{

              /**
               *
               */
              TURNIP{
	        @Override
	        public String toString() {
	          return "Turnip";
	        }
	      }, 

              /**
               *
               */
              CARROT{
	        @Override
	        public String toString() {
	          return "Carrot";
	        }
	      }, 

              /**
               *
               */
              TOMATO{
	        @Override
	        public String toString() {
	          return "Tomato";
	        }
	      },

              /**
               *
               */
              POTATO{
	        @Override
	        public String toString() {
	          return "Potato";
	        }
	      },

              /**
               *
               */
              ROSE{
	        @Override
	        public String toString() {
	          return "Rose";
	        }
	      }, 

              /**
               *
               */
              TULIP{
	        @Override
	        public String toString() {
	          return "Tulip";
	        }
	      },

              /**
               *
               */
              STARGAZER{
	        @Override
	        public String toString() {
	          return "Stargazer";
	        }
	      }, 

              /**
               *
               */
              SUNFLOWER{
	        @Override
	        public String toString() {
	          return "Sunflower";
	        }
	      }, 

              /**
               *
               */
              MANGO{
	        @Override
	        public String toString() {
	          return "Mango";
	        }
	      },

              /**
               *
               */
              APPLE{
	        @Override
	        public String toString() {
	          return "Apple";
	        }
	      }, 

              /**
               *
               */
              BANANA{
	        @Override
	        public String toString() {
	          return "Banana";
	        }
	      }, 

              /**
               *
               */
              ORANGE{
	        @Override
	        public String toString() {
	          return "Orange";
	        }
	      };
		  
	  }
	
	private static final Map<CropName, Double> priceList = 
			new EnumMap<CropName, Double>(CropName.class);
	static {
		priceList.put(CropName.TURNIP, 5.0);
		priceList.put(CropName.CARROT, 10.0);
		priceList.put(CropName.TOMATO, 20.0);
		priceList.put(CropName.POTATO, 25.0);
		priceList.put(CropName.ROSE, 5.0);
		priceList.put(CropName.TULIP, 7.0);
		priceList.put(CropName.STARGAZER, 10.0);
		priceList.put(CropName.SUNFLOWER, 20.0);
		priceList.put(CropName.MANGO, 50.0);
		priceList.put(CropName.APPLE, 55.0);
		priceList.put(CropName.BANANA, 60.0);
		priceList.put(CropName.ORANGE, 65.0);
	};
	
    /**
     *
     * @return
     */
    public static Map<CropName, Double> getPriceList() {
		return priceList;
	}
}
