package model;
import java.util.*;
import model.Constants.CropName;
import model.Constants.TileStatus;

/**
 * Player Object contains what the player has
 */
public class Player{
  private double coins;
  private String title;
  private double xp;
  private double xpTillnext;
  private int level;
  private ArrayList<Tile> tiles;
  private ArrayList<Seed> seeds;
  private Fertilizer fertilizer;
  
    /**
     *
     */
    public Player(){
    this.coins = 1000.00;
    this.xp = 0.00;
    this.level = 1;
    this.title = "Farmer";
    this.xpTillnext = 100;
    
    this.tiles = new ArrayList<Tile>(); //initializes the 50 tiles owned by the player c:
    for(int i=0;i<50;i++) {
    	Tile tile = new Tile();
    	this.tiles.add(tile);
    }
    
    Random rand = new Random();
    int n = rand.nextInt(15) + 5; //random num of rocks from 5-15
    
    for(int j=0;j<n;j++) {
    	int i = rand.nextInt(49) + 0; //random tile
    	this.tiles.get(i).setStatus(TileStatus.ROCK);
    }
    
    this.seeds = new ArrayList<Seed>(); //instantiates seeds
    this.fertilizer = new Fertilizer(4); //instantiates fertilizer with id num 4

    
    Seed turnipSeed = new Seed(5, CropName.TURNIP);	turnipSeed.setQuantity(3); //to start off c:
    this.seeds.add(turnipSeed);
    
    Seed carrotSeed = new Seed(6, CropName.CARROT); 
    this.seeds.add(carrotSeed);
    
    Seed tomatoSeed = new Seed(7, CropName.TOMATO); 
    this.seeds.add(tomatoSeed);
    
    Seed potatoSeed = new Seed(8, CropName.POTATO); 
    this.seeds.add(potatoSeed);
    
    Seed roseSeed = new Seed(9, CropName.ROSE); 
    this.seeds.add(roseSeed);
    
    Seed tulipSeed = new Seed(10, CropName.TULIP); 
    this.seeds.add(tulipSeed);
    
    Seed stargazerSeed = new Seed(11, CropName.STARGAZER); 
    this.seeds.add(stargazerSeed);
    
    Seed sunflowerSeed = new Seed(12, CropName.SUNFLOWER); 
    this.seeds.add(sunflowerSeed);
    
    Seed mangoSeed = new Seed(13, CropName.MANGO); 
    this.seeds.add(mangoSeed);
    
    Seed appleSeed = new Seed(14, CropName.APPLE); 
    this.seeds.add(appleSeed);
    
    Seed bananaSeed = new Seed(15, CropName.BANANA); 
    this.seeds.add(bananaSeed);
    
    Seed orangeSeed = new Seed(16, CropName.ORANGE);
    this.seeds.add(orangeSeed);
    
  }
  
    /**
     * gets the number of XP before leveling up
     * @return double
     */
    public double getXPtillNext() {
	 return this.xpTillnext;
  }

    /**
     * sets the number of XP before leveling up
     * @param xp the value being set
     */
    public void setXPtillNext(double xp) {
	  this.xpTillnext = xp;
  }

    /**
     * adds the xp of the player
     * @param xp the value being added
     */
    public void addXP(double xp){
    this.xp += xp;
  }

    /**
     * adds the coins of the player
     * @param val the value being added
     */
    public void addCoins(double val){
    this.coins += val;
  }

    /**
     * subtracts the coins of the player
     * @param val the value being subtracted
     */
    public void subCoins(double val){
    this.coins -= val;
  }

    /**
     * Updates the level of the player
     */
    public void updateLevel(){
    this.level += 1;
  }
  
    /**
     * sets the title of the farmer
     * @param title the string being set as a title
     */
    public void setTitle(String title) {
	  this.title = title;
  }

    /**
     * gets the title of the farmer
     * @return String
     */
    public String getTitle() {
	  return this.title;
  }
  
    /**
     * gets the number of coins of the player
     * @return double
     */
    public double getCoins(){
    return this.coins;
  }

    /**
     * gets the level of the player
     * @return int
     */
    public int getLevel(){
    return this.level;
  }

    /**
     * gets the XP of the player
     * @return double
     */
    public double getXP(){
    return this.xp;
  }
  
    /**
     * sets the XP of the player
     * @param xp the value being set to the xp of the player
     */
    public void setXP(double xp) {
	  this.xp = xp;
  }

    /**
     * gets the tile of the player
     * @return Tiles
     */
    public ArrayList<Tile> getTiles(){
    return this.tiles;
  }
  
    /**
     * gets the seeds in the inventory of the player
     * @return Seeds
     */
    public ArrayList<Seed> getSeeds(){
	    return this.seeds;
  }
  
    /**
     * gets the fertilizers in the inventory of the player
     * @return Fertilizer
     */
    public Fertilizer getFertilizer() {
	  	return this.fertilizer;
  }
  
}
