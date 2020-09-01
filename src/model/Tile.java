package model;
import model.Constants.CropStatus;
import model.Constants.TileStatus;

/**
 * Tile class that is used for the player
 */

public class Tile{

  private TileStatus status;
  private int yield;
  private Crop crop;
  private int water;
  private int fertilizer;
  private boolean fruitTreePlantable;
  private boolean seedPlantable;
  
    /**
     *
     */
    public Tile(){
    this.water = 0;
    this.fertilizer = 0;
    this.crop = null;
    this.yield = 0;
    this.status = TileStatus.GRASS;
    this.fruitTreePlantable = true;
    this.seedPlantable = true;
  }

    /**
     * sets the number of yield in a tile
     * @param yield the value of yield being set to a tile
     */
    public void setYield(int yield){
    this.yield = yield;
  }

    /**
     * sets the status of a tile
     * @param status the status being set to a tile
     */
    public void setStatus(TileStatus status){
    this.status = status;
  }

    /**
     * sets a crop to the tile
     * @param crop the crop being set to a tile
     */
    public void setCrop(Crop crop){
    this.crop = crop;
  }

    /**
     * gets the status of the tile
     * @return TileStatus
     */
    public TileStatus getStatus(){
    return this.status;
  }
  
    /**
     * sets the number of water in a tile
     * @param water the value being set to the number of water in a tile
     */
    public void setWater(int water) {
	  this.water = water;
  }
  
    /**
     * sets the number of fertilizer in a tile
     * @param fert the value being set to the number of fertilizers in a tile
     */
    public void setFertilizer(int fert) {
	  this.fertilizer = fert;
  }
  
    /**
     * gets the number of yield of a given crop in the tile
     * @return int
     */
    public int getYield(){
    return this.yield;
  }

    /**
     * gets the crop that is planted in a tile
     * @return Crop
     */
    public Crop getCrop(){
    return this.crop;
  }

    /**
     * gets the number of water in a tile
     * @return int
     */
    public int getWater(){
    return this.water;
  }

    /**
     * gets the number of fertilizer in a tile
     * @return int
     */
    public int getFertilizer(){
    return this.fertilizer;
  }

    /**
     * adds water to a tile
     */
    public void addWater() {
	  this.water += 1;
  }
  
    /**
     * adds fertilizer to a tile
     */
    public void addFertilizer() {
	  this.fertilizer += 1;
  }

    /**
     * displays the status of a tile
     * @return String
     */
    public String displayTileStatus() {
	  String crop = " Crop Planted: None";
	  String yield = "";
			  
	 
		  
	  if(this.crop!=null) {
		  crop = " Crop Planted: " + this.crop.getName().toString();
		  
		  if(this.crop.getStatus().equals(CropStatus.READY))
			  yield = Integer.toString(this.getYield());
	  }
		 
	  
	  if(this.crop!=null && this.status.equals(TileStatus.PLANTED) && this.crop.getStatus().equals(CropStatus.READY))
	  return "Tile Status: "  + this.status + "  " + crop + "   Water: " + this.getWater()
	  + "   Fertilizer: " + this.getFertilizer() + "   SOLD " + yield + " CROP(S)!"; 
	  
	  if(this.crop!=null && this.status.equals(TileStatus.PLANTED) && this.crop.getStatus().equals(CropStatus.DEAD))
		  return crop + " is dead..";
	  
	  else if(this.crop!=null && this.crop.getStatus().equals(CropStatus.WAITING))
		  return "Tile Status: "  + this.status + "  " + crop + "   Water: " + this.getWater()+ "/" + this.getCrop().getWaterMax()
		  + "   Fertilizer: " + this.getFertilizer() + "/" + this.getCrop().getFertMax();
	  else if(this.crop == null && this.water == 0 && this.fertilizer == 0)
			  return "Tile Status: "  + this.status + "  " + crop;
	  
	  else if(this.fertilizer>0 && this.water == 0)
		  return "Tile Status: "  + this.status + "  " + crop + "   Fertilizer: " + this.getFertilizer();
	  else if(this.water>0 && this.fertilizer == 0)
		  return "Tile Status: "  + this.status + "  " + crop + "   Water: " + this.getWater();
	  
	  else
		  return "Tile Status: "  + this.status + "  " + crop + "   Water: " + this.getWater()
		  + "   Fertilizer: " + this.getFertilizer();
	  
	  
  }

    /**
     * checks whether the tile is plantable by a normal seed or not
     * @return boolean
     */
    public boolean isTreePlantable() {
	  return this.fruitTreePlantable;
  }

    /**
     * sets an condition to a tile
     * @param weeee the boolean expression being set to the condition whether a fruit tree is plantable to a tile or not
     */
    public void setTreePlantable(boolean weeee) {
	  this.fruitTreePlantable = weeee;
  }

    /**
     * checks whether the tile is plantable by a normal seed or not
     * @return boolean
     */
    public boolean isSeedPlantable() {
	  return this.seedPlantable;
  }

    /**
     * sets an condition to a tile
     * @param weeee the boolean expression being set to the condition whether a seed is plantable to a tile or not
     */
    public void setSeedPlantable(boolean weeee) {
	  this.seedPlantable = weeee;
  }
  
}
