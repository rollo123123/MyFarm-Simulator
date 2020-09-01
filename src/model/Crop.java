package model;

import model.Constants.CropName;
import model.Constants.CropType;
import model.Constants.CropStatus;
/**
 * Abstract Class used for the PLANTED crop entities
 */

public abstract class Crop{
  private CropName name; //TURNIP,CARROT,TOMATO,POTATO,ROSE,TULIP,STARGAZER,SUNFLOWER,MANGO,APPLE,BANANA,ORANGE
  private CropType type; //VEGETABLE, FLOWER, FRUITTREE
  private CropStatus status; //WAITING, READY, DEAD
  private int age; //time elapsed since planted
  private int harvestTime; //max time
  private double harvestCost; //cost of each harvest
  private int waterMin; //minimum water allowed
  private int waterMax; //maximum water allowed (bonus limit)
  private int fertilizerMin; //minimum fertilizer allowed
  private int fertilizerMax; //maximum fertilizer allowed (bonus limit)
  private int yieldMin; //least possible yield
  private int yieldMax; //most
  private double basePrice;
  
    /**
     *
     * @param name name of the crop
     * @param type type of the crop
     * @param status status of the crop
     * @param ht harvest time of the crop
     * @param hc harvest cost of the crop
     * @param wmin minimum water of the crop
     * @param wmax maximum water of the crop
     * @param fermin minimum fertilizer of the crop
     * @param fermax maximum fertilizer of the crop
     * @param ymin minimum yield of the crop
     * @param ymax maximum yield of the crop
     * @param bp base price for the crop
     */
    public Crop(CropName name, CropType type, CropStatus status, 
	int ht, double hc, int wmin, int wmax, int fermin, 
	int fermax, int ymin, int ymax, double bp){
	  
    this.name = name;
    this.type = type;
    this.status = status;
    this.age = 0;
    this.harvestTime = ht;
    this.harvestCost = hc;
    this.waterMin = wmin;
    this.waterMax = wmax;
    this.fertilizerMin = fermin;
    this.fertilizerMax = fermax;
    this.yieldMin = ymin;
    this.yieldMax = ymax;
    this.basePrice = bp;
    
    if(type.equals(CropType.VEGETABLE))
    	this.harvestCost = 1;
    else if(type.equals(CropType.FLOWER))
    	this.harvestCost = 2;
    else if(type.equals(CropType.FRUIT_TREE))
    	this.harvestCost = 3;
  }
  
    /**
     * gets the base price of the crop
     * @return double
     */
    public double getBasePrice() {
	  return this.basePrice;
  }
  
    /**
     * sets the status of the crop
     * @param status status of the crop
     */
    public void setStatus(CropStatus status){
    this.status = status;
  }
  
    /**
     * doubles the number age of the crop
     * @param age the value being doubled
     */
    public void age(double age) {
	 this.age += (int)age;
  }
  
    /**
     * adds the age of the crop
     */
    public void addAge(){
    this.age += 1;
  }

    /**
     * gets the name of the crop
     * @return CropName
     */
    public CropName getName(){
    return this.name;
  }

    /**
     * adds the cap of the fertilizer of the crop
     * @param add the value being added
     */
    public void addFertMax(int add) {
	  this.fertilizerMax += add;
  }
  
    /**
     * adds the cap of the water of the crop
     * @param add the value being added
     */
    public void addWaterMax(int add) {
	  this.waterMax += add;
  }
  
    /**
     * gets the type of the crop
     * @return CropType
     */
    public CropType getType(){
    return this.type;
  }

    /**
     * gets the status of the crop
     * @return CropStatus
     */
    public CropStatus getStatus(){
    return this.status;
  }

    /**
     * gets the age of the crop
     * @return int
     */
    public int getAge(){
    return this.age;
  }

    /**
     * gets the harvest time of th crop
     * @return int
     */
    public int getHarTime(){
    return this.harvestTime;
  }

    /**
     * gets the harvest cost of the crop
     * @return double
     */
    public double getHarCost(){
    return this.harvestCost;
  }

    /**
     * gets the minimum amount of water of the crop
     * @return int
     */
    public int getWaterMin(){
    return this.waterMin;
  }

    /**
     * gets the cap of water in a crop
     * @return int
     */
    public int getWaterMax(){
    return this.waterMax;
  }

    /**
     * gets the minimum amount of fertilizer of the crop
     * @return int
     */
    public int getFertMin(){
    return this.fertilizerMin;
  }

    /**
     * gets the cap of fertilizer in a crop
     * @return int
     */
    public int getFertMax(){
    return this.fertilizerMax;
  }

    /**
     * gets the minimum yield of the crop
     * @return int
     */
    public int getYieldMin(){
    return this.yieldMin;
  }

    /**
     * gets the maximum yield of the crop
     * @return int
     */
    public int getYieldMax(){
    return this.yieldMax;
  }

}
