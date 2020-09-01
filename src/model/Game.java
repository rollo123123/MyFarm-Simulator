package model;
import model.Constants.CropName;
import model.Constants.CropStatus;
import model.Constants.CropType;
import model.Constants.TileStatus;
import java.util.Random;

import model.Constants;

/**
 * Overall Game model
 */
public class Game {
	private Player player;
	private int itemChoice;
	
    /**
     *
     */
    public Game() {
		this.player = new Player();
		this.itemChoice = 0;
	}
	
	/** handles level up of the model*/
	public void levelUP() {
		if(this.player.getXP() >= this.getPlayer().getXPtillNext()) {
			getPlayer().updateLevel();
			getPlayer().setXPtillNext(this.getPlayer().getXPtillNext() * 1.5);
			getPlayer().setXP(0);
		}
			
	}
	
	/** handles the updating of limits
     * @param index index for a tile */
	public void updateLIMITS(int index) { 
		
		if(getPlayer().getTitle() == "Distinguished Farmer") {
			if(getPlayer().getTiles().get(index).getCrop()!=null) {
				getPlayer().getTiles().get(index).getCrop().addWaterMax(1);
				getPlayer().getTiles().get(index).getCrop().addFertMax(1);
				getPlayer().getTiles().get(index).getCrop().age(getPlayer().getTiles().get(index).getCrop().getHarTime() * 0.10);
			}
			
		}
		else if(getPlayer().getTitle() == "Registered Farmer") {
			if(getPlayer().getTiles().get(index).getCrop()!=null)
			getPlayer().getTiles().get(index).getCrop().age(getPlayer().getTiles().get(index).getCrop().getHarTime() * 0.05);
		}
		else if(getPlayer().getTitle() == "Honorable Farmer") {
			if(getPlayer().getTiles().get(index).getCrop()!=null) {
				getPlayer().getTiles().get(index).getCrop().addWaterMax(2);
				getPlayer().getTiles().get(index).getCrop().addFertMax(2);
				getPlayer().getTiles().get(index).getCrop().age(getPlayer().getTiles().get(index).getCrop().getHarTime() * 0.15);
			}
			
		}
			
	}
	
	/** handles the updating of all crop status*/
	public void updateCrops() {
		for(int i=0;i<getPlayer().getTiles().size();i++) {
			if(getPlayer().getTiles().get(i).getCrop() != null && 
						getPlayer().getTiles().get(i).getStatus().equals(TileStatus.PLANTED))
				
				// add age when there is a crop on the tile, when minimum water and fertilizer is met
				getPlayer().getTiles().get(i).getCrop().addAge();
				
				
				
			if(getPlayer().getTiles().get(i).getCrop() != null && getPlayer().getTiles().get(i).getCrop().getAge() > 0) {
				// checks tile if fertilizer and water r enuff, if not plant dies :c
			
				if(getPlayer().getTiles().get(i).getCrop().getAge() == getPlayer().getTiles().get(i).getCrop().getHarTime() && 
						( getPlayer().getTiles().get(i).getFertilizer() < getPlayer().getTiles().get(i).getCrop().getFertMin() ||
						getPlayer().getTiles().get(i).getWater() < getPlayer().getTiles().get(i).getCrop().getWaterMin() )) {
						getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.DEAD);
						getPlayer().getTiles().get(i).setYield(0);
					}
						
				// if age is more than 0, check if current age is the same as crop's intended HT, then change to READY
				else if(getPlayer().getTiles().get(i).getCrop().getAge() == getPlayer().getTiles().get(i).getCrop().getHarTime()) {
					
					getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.READY);
					Random rand = new Random();
					int yield = rand.nextInt(getPlayer().getTiles().get(i).getCrop().getYieldMax())
							+ getPlayer().getTiles().get(i).getCrop().getYieldMin();
					
					getPlayer().getTiles().get(i).setYield(yield);
					}
		
				witherPlant(i);
				expirePlant(i);
				
			}
		}
	}
	
	/** handles withering of plan
     * @param i serves as index for the tile chosen*/
	public void witherPlant (int i) {
		// wither plant
		if(getPlayer().getTitle() == "Farmer") {
			if(getPlayer().getTiles().get(i).getCrop().getAge() == getPlayer().getTiles().get(i).getCrop().getHarTime()+60)	{
				getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.DEAD);
				getPlayer().getTiles().get(i).setYield(0);
				}
			}
		else if(getPlayer().getTitle() == "Registered Farmer") {
			if(getPlayer().getTiles().get(i).getCrop().getAge() == (getPlayer().getTiles().get(i).getCrop().getHarTime()*getPlayer().getTiles().get(i).getCrop().getHarTime() * 0.05)+60)	{
				getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.DEAD);
				getPlayer().getTiles().get(i).setYield(0);
				}
		}
		else if(getPlayer().getTitle() == "Distinguished Farmer") {
			if(getPlayer().getTiles().get(i).getCrop().getAge() == (getPlayer().getTiles().get(i).getCrop().getHarTime()*getPlayer().getTiles().get(i).getCrop().getHarTime() * 0.10)+60)	{
				getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.DEAD);
				getPlayer().getTiles().get(i).setYield(0);
				}
		}
		else if(getPlayer().getTitle() == "Honorable Farmer") {
			if(getPlayer().getTiles().get(i).getCrop().getAge() == (getPlayer().getTiles().get(i).getCrop().getHarTime()*getPlayer().getTiles().get(i).getCrop().getHarTime() * 0.15)+60)	{
				getPlayer().getTiles().get(i).getCrop().setStatus(CropStatus.DEAD);
				getPlayer().getTiles().get(i).setYield(0);
				}
		}
	}
	
	/** handles expiry of plan
     * @param i serves as index for the tile chosen*/
	public void expirePlant(int i) {
		// expire plant
		if(getPlayer().getTiles().get(i).getCrop().getStatus().equals(CropStatus.DEAD)) {
			if(getPlayer().getTitle().equals("Farmer"))
				if(getPlayer().getTiles().get(i).getCrop().getAge() == getPlayer().getTiles().get(i).getCrop().getHarTime()*3 + 60) 
					resetTile(i);
			
			else if(getPlayer().getTitle().equals("Registered Farmer"))
				if(getPlayer().getTiles().get(i).getCrop().getAge() == ((getPlayer().getTiles().get(i).getCrop().getHarTime()*0.05)*3) + 60) 
					resetTile(i);
			
			else if(getPlayer().getTitle().equals("Distinguished Farmer"))
				if(getPlayer().getTiles().get(i).getCrop().getAge() == ((getPlayer().getTiles().get(i).getCrop().getHarTime()*0.10)*3) + 60) 
					resetTile(i);
			
			else if(getPlayer().getTitle().equals("Honorable Farmer"))
				if(getPlayer().getTiles().get(i).getCrop().getAge() == ((getPlayer().getTiles().get(i).getCrop().getHarTime()*0.15)*3) + 60) 
					resetTile(i);
		}
	}
	
	/** handles the usage of items given the id of item, index of tile, and mode (for hoe only
     * @param itemChoice choice of item
     * @param index index for the tle
     * @param mode  mode of the item for the hoe
     * @return */
	public int useItem(int itemChoice, int index, String mode) {
		int prompt = -1;
		if(itemChoice == 0) { //HAND
			if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED) && getPlayer().getTiles().get(index).getCrop().getStatus().equals(CropStatus.READY)) {
			harvestPlant(index);
			getPlayer().addXP(5.0);
			}
		}
		else if(itemChoice == 1) { //PICKAXE
			if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.ROCK)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.GRASS);
				getPlayer().addXP(3.0);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.GRASS)) {
				System.out.println("You can't use a pick on a grass, silly"); prompt = 0; }
				
			else {
				System.out.println("You can't use a pick on that tile, silly"); prompt = 1;}
		}
		else if(itemChoice == 2) { //WATERING CAN
			if((getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY) || getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))) {
					getPlayer().getTiles().get(index).addWater();
					getPlayer().addXP(0.1);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.GRASS)) {
				System.out.println("You can't water grass, it'll only be a waste!"); prompt = 2; }
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.ROCK)) {
				System.out.println("You can't water a rock, silly"); prompt = 3; }
		}
		else if(itemChoice == 3 && mode != "right") { //PLOWING TOOL (HOE)
			if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.GRASS)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.EMPTY);
				getPlayer().addXP(5.0);	
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				System.out.println("Tile is already plowed"); prompt = 4;}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.ROCK)) {
				System.out.println("You can't use a hoe on a rock, silly"); prompt = 5;}
		
		}
		else if(itemChoice == 3 && mode == "right")
			prompt = 6;
		
		else if(itemChoice == 4) { //FERTILIZER
			if((getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY) || getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED)) && getPlayer().getFertilizer().getQuantity() > 0 && getPlayer().getTiles().get(index).getCrop()==null) {
				getPlayer().getTiles().get(index).addFertilizer();
				getPlayer().addXP(3.0);
				getPlayer().getFertilizer().subtoQuant();
			}
			else if(getPlayer().getTiles().get(index).getCrop() != null){
				 prompt = 9;
			}
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
	
		}
		
		else if(itemChoice == 5) { //TURNIP
			if(getPlayer().getTiles().get(index).isSeedPlantable()  && getPlayer().getSeeds().get(0).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)){
					getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
					getPlayer().getTiles().get(index).setCrop(new Turnip());
					updateLIMITS(index);
					getPlayer().addXP(5.0);
					getPlayer().getSeeds().get(0).subtoQuant();
					fruitTreeChanger(index);
					if(!getPlayer().getTiles().get(index).isTreePlantable())
					RESETSEEDS(index);
				}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(0).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
			}
		
		else if(itemChoice == 6) { //CARROT
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(1).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Carrot());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(1).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getSeeds().get(1).getQuantity() == 0)
				prompt = 8;
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		else if(itemChoice == 7) { //TOMATO
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(2).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Tomato());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(2).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(2).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
			if(itemChoice == 8) { //POTATO	
				if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(3).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Potato());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(3).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
				else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
					prompt = 7;
				else if(getPlayer().getSeeds().get(3).getQuantity() == 0)
					prompt = 8;
				else {
					System.out.println("You can't use that there"); prompt = 6;
				}
					
		}	
		
		
		if(itemChoice == 9) { //ROSE
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(4).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Rose());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(4).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getSeeds().get(4).getQuantity() == 0)
				prompt = 8;
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 10) { //TULIP
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(5).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Tulip());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(5).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(5).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 11) { //STARGAZER
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(6).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Stargazer());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(6).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(6).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 12) { //SUNFLOWER
			if(getPlayer().getTiles().get(index).isSeedPlantable() && getPlayer().getSeeds().get(7).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY) ) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Sunflower());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(7).subtoQuant();
				fruitTreeChanger(index);
				if(!getPlayer().getTiles().get(index).isTreePlantable())
				RESETSEEDS(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(7).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		} 
		

		if(itemChoice == 13) { //MANGO
			if(getPlayer().getTiles().get(index).isTreePlantable() && getPlayer().getSeeds().get(8).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY) ) {	
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Mango());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(8).subtoQuant();
				fruitTreeChanger(index);
				seedChanger(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(8).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 14) { //APPLE
			if(getPlayer().getTiles().get(index).isTreePlantable() && getPlayer().getSeeds().get(9).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Apple());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(9).subtoQuant();
				fruitTreeChanger(index);
				seedChanger(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(9).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 15) { //BANANA
			if(getPlayer().getTiles().get(index).isTreePlantable() && getPlayer().getSeeds().get(10).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Banana());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(10).subtoQuant();
				fruitTreeChanger(index);
				seedChanger(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(10).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		if(itemChoice == 16) { //ORANGE
			if(getPlayer().getTiles().get(index).isTreePlantable() && getPlayer().getSeeds().get(11).getQuantity()>0 && getPlayer().getTiles().get(index).getStatus().equals(TileStatus.EMPTY)) {
				getPlayer().getTiles().get(index).setStatus(TileStatus.PLANTED);
				getPlayer().getTiles().get(index).setCrop(new Orange());
				updateLIMITS(index);
				getPlayer().addXP(5.0);
				getPlayer().getSeeds().get(11).subtoQuant();
				fruitTreeChanger(index);
				seedChanger(index);
			}
			else if(getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED))
				prompt = 7;
			else if(getPlayer().getSeeds().get(11).getQuantity() == 0)
				prompt = 8;
			else {
				System.out.println("You can't use that there"); prompt = 6;
			}
				
		}
		
		return prompt;
	}
	
	/** harvests plant from model given index
     * @param index serves as index for the tile chosen*/
	public void harvestPlant(int index) {
		
		if(getPlayer().getTiles().get(index).getCrop() != null && getPlayer().getTiles().get(index).getCrop().getStatus().equals(CropStatus.READY) ) {
		
			
			double sp, flb = 0, bp, wb, fb, cb = 0;
			
			if(getPlayer().getTitle() == "Registered Farmer")
			flb = 2.0;
			else if(getPlayer().getTitle() == "Distinguished Farmer")
			flb = 3.0;
			else if(getPlayer().getTitle() == "Honorable Farmer")
			flb = 5.0;
			
			
			
			bp = getPlayer().getTiles().get(index).getCrop().getBasePrice();
			
			if(getPlayer().getTiles().get(index).getWater() >= getPlayer().getTiles().get(index).getCrop().getWaterMax()) 
				wb = getPlayer().getTiles().get(index).getCrop().getWaterMax() * (bp/4);
			else 
				wb = getPlayer().getTiles().get(index).getWater() * (bp/4);
				
			if(getPlayer().getTiles().get(index).getFertilizer() >= getPlayer().getTiles().get(index).getCrop().getFertMax()) 
				fb = getPlayer().getTiles().get(index).getCrop().getFertMax() * (bp/2);
			else
				fb = getPlayer().getTiles().get(index).getFertilizer() * (bp/2);
			
			if(getPlayer().getTiles().get(index).getCrop().getType().equals(CropType.FLOWER))
			cb = 0.05 * (bp+wb+fb);
			
			
			sp = (double)getPlayer().getTiles().get(index).getYield() * (flb + bp + wb + fb + cb);
			
			getPlayer().addCoins(sp);
			getPlayer().subCoins(getPlayer().getTiles().get(index).getCrop().getHarCost());
			resetTile(index);
			
		}
	}
	
	/** handles buying of fertilizer*/
	public void buyFertilizer() {
		double bonus = 0; //bonus
		
		if(getPlayer().getTitle() == "Registered Farmer")
			bonus = 2.0;
			else if(getPlayer().getTitle() == "Distinguished Farmer")
			bonus = 3.0;
			else if(getPlayer().getTitle() == "Honorable Farmer")
			bonus = 5.0;
		
		if(player.getCoins() >= 10.0) {
			player.getFertilizer().addtoQuant();
			player.subCoins(10.0 - bonus);
		}
	}
	
	/** handles buying of see
     * @param name serves as the name of the crop */
	public void buySeed(String name) {
		CropName e = CropName.valueOf(name);
		double bonus = 0; //bonus
		
		if(getPlayer().getTitle() == "Registered Farmer")
			bonus = 2.0;
			else if(getPlayer().getTitle() == "Distinguished Farmer")
			bonus = 3.0;
			else if(getPlayer().getTitle() == "Honorable Farmer")
			bonus = 5.0;
		
		if(player.getCoins() >= Constants.getPriceList().get(e)) { // if player has enough coins for the seed
			for(int i=0;i<player.getSeeds().size();i++) {
				if(player.getSeeds().get(i).getSeedName().equals(e)) {
					player.getSeeds().get(i).addtoQuant();
					
					player.subCoins(Constants.getPriceList().get(e) - bonus);
					
					player.addXP(0.1);
				}		
			}
		}
	}
	
	/** handles buying of title*/
	public void buyNextTitle() {
		
		if(this.player.getTitle().equals("Farmer") && this.player.getCoins() >= 200 && player.getLevel() >= 10) {
			this.player.setTitle("Registered Farmer");
			this.player.subCoins(200);
			
		}
			
		else if(this.player.getTitle().equals("Registered Farmer") && this.player.getCoins() >= 250 && this.player.getLevel() >= 15) {
			this.player.setTitle("Distinguished Farmer");
			this.player.subCoins(250);
		
		}
			
		else if(this.player.getTitle().equals("Distinguished Farmer") && this.player.getCoins() >= 350 && this.player.getLevel() >= 20) {
			this.player.setTitle("Honorable Farmer");
			this.player.subCoins(350);
		
		}
	
	}
	
	/** changes surrounding tiles given index so that fruit trees can't be planted
     * @param index serves as index for the tile chosen*/
	public void fruitTreeChanger(int index) { 
	
		
		if(index>=0&&index<=9) {
			
			if(index == 0) {
				getPlayer().getTiles().get(index+1).setTreePlantable(false);
				getPlayer().getTiles().get(index+10).setTreePlantable(false);
				getPlayer().getTiles().get(index+11).setTreePlantable(false);
			}
			else if(index == 9) {
				getPlayer().getTiles().get(index-1).setTreePlantable(false);
				getPlayer().getTiles().get(index+10).setTreePlantable(false);
				getPlayer().getTiles().get(index+11).setTreePlantable(false);

			}
			else {
				getPlayer().getTiles().get(index-1).setTreePlantable(false);
				getPlayer().getTiles().get(index+1).setTreePlantable(false);
				getPlayer().getTiles().get(index+9).setTreePlantable(false);
				getPlayer().getTiles().get(index+10).setTreePlantable(false);
				getPlayer().getTiles().get(index+11).setTreePlantable(false);

			}
			
		}
		else if(index>=10&&index<=39) {
			if(index==10){
			getPlayer().getTiles().get(0).setTreePlantable(false);
			getPlayer().getTiles().get(1).setTreePlantable(false);
			getPlayer().getTiles().get(index+1).setTreePlantable(false);
			getPlayer().getTiles().get(index+10).setTreePlantable(false);
			getPlayer().getTiles().get(index+11).setTreePlantable(false);

			}
			
			else if(index == 19) {
			getPlayer().getTiles().get(0).setTreePlantable(false);
			getPlayer().getTiles().get(1).setTreePlantable(false);
			getPlayer().getTiles().get(index+1).setTreePlantable(false);
			getPlayer().getTiles().get(index+10).setTreePlantable(false);
			getPlayer().getTiles().get(index+11).setTreePlantable(false);
	
			}
			
			else if(index == 20) {
				getPlayer().getTiles().get(10).setTreePlantable(false);
				getPlayer().getTiles().get(11).setTreePlantable(false);
				getPlayer().getTiles().get(21).setTreePlantable(false);
				getPlayer().getTiles().get(30).setTreePlantable(false);
				getPlayer().getTiles().get(31).setTreePlantable(false);

				}
			
			else if(index == 29) {
				getPlayer().getTiles().get(18).setTreePlantable(false);
				getPlayer().getTiles().get(19).setTreePlantable(false);
				getPlayer().getTiles().get(28).setTreePlantable(false);
				getPlayer().getTiles().get(38).setTreePlantable(false);
				getPlayer().getTiles().get(39).setTreePlantable(false);

				}
			else if(index == 30) {
				getPlayer().getTiles().get(20).setTreePlantable(false);
				getPlayer().getTiles().get(21).setTreePlantable(false);
				getPlayer().getTiles().get(31).setTreePlantable(false);
				getPlayer().getTiles().get(40).setTreePlantable(false);
				getPlayer().getTiles().get(41).setTreePlantable(false);

				}
			
			else if(index == 39) {
				getPlayer().getTiles().get(28).setTreePlantable(false);
				getPlayer().getTiles().get(29).setTreePlantable(false);
				getPlayer().getTiles().get(38).setTreePlantable(false);
				getPlayer().getTiles().get(48).setTreePlantable(false);
				getPlayer().getTiles().get(49).setTreePlantable(false);

				}
			
			
			else {
			getPlayer().getTiles().get(index-1).setTreePlantable(false);
			getPlayer().getTiles().get(index+1).setTreePlantable(false);
			getPlayer().getTiles().get(index+9).setTreePlantable(false);
			getPlayer().getTiles().get(index+10).setTreePlantable(false);
			getPlayer().getTiles().get(index+11).setTreePlantable(false);
			getPlayer().getTiles().get(index-9).setTreePlantable(false);
			getPlayer().getTiles().get(index-10).setTreePlantable(false);
			getPlayer().getTiles().get(index-11).setTreePlantable(false);

			}
		}
		
		
		else if(index>=40&&index<=49) {
			if(index == 40) {
				getPlayer().getTiles().get(index+1).setTreePlantable(false);
				getPlayer().getTiles().get(index-10).setTreePlantable(false);
				getPlayer().getTiles().get(index-9).setTreePlantable(false);

			}
			else if(index == 49) {
				getPlayer().getTiles().get(index-1).setTreePlantable(false);
				getPlayer().getTiles().get(index-10).setTreePlantable(false);
				getPlayer().getTiles().get(index-11).setTreePlantable(false);

			}
			else {
				getPlayer().getTiles().get(index-1).setTreePlantable(false);
				getPlayer().getTiles().get(index+1).setTreePlantable(false);
				getPlayer().getTiles().get(index-9).setTreePlantable(false);
				getPlayer().getTiles().get(index-10).setTreePlantable(false);
				getPlayer().getTiles().get(index-11).setTreePlantable(false);

			}
		}

	}
	
	/** changes surrounding tiles given index so that normal seeds can't be planted
     * @param index serves as index for the tile chosen*/
	public void seedChanger(int index) { 
		
		
		if(index>=0&&index<=9) {
					
					if(index == 0) {
						getPlayer().getTiles().get(index+1).setSeedPlantable(false);
						getPlayer().getTiles().get(index+10).setSeedPlantable(false);
						getPlayer().getTiles().get(index+11).setSeedPlantable(false);
					}
					else if(index == 9) {
						getPlayer().getTiles().get(index-1).setSeedPlantable(false);
						getPlayer().getTiles().get(index+10).setSeedPlantable(false);
						getPlayer().getTiles().get(index+11).setSeedPlantable(false);

					}
					else {
						getPlayer().getTiles().get(index-1).setSeedPlantable(false);
						getPlayer().getTiles().get(index+1).setSeedPlantable(false);
						getPlayer().getTiles().get(index+9).setSeedPlantable(false);
						getPlayer().getTiles().get(index+10).setSeedPlantable(false);
						getPlayer().getTiles().get(index+11).setSeedPlantable(false);

					}
					
				}
				else if(index>=10&&index<=39) {
					if(index==10){
					getPlayer().getTiles().get(0).setSeedPlantable(false);
					getPlayer().getTiles().get(1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+10).setSeedPlantable(false);
					getPlayer().getTiles().get(index+11).setSeedPlantable(false);

					}
					
					else if(index == 19) {
					getPlayer().getTiles().get(0).setSeedPlantable(false);
					getPlayer().getTiles().get(1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+10).setSeedPlantable(false);
					getPlayer().getTiles().get(index+11).setSeedPlantable(false);
			
					}
					
					else if(index == 20) {
						getPlayer().getTiles().get(10).setSeedPlantable(false);
						getPlayer().getTiles().get(11).setSeedPlantable(false);
						getPlayer().getTiles().get(21).setSeedPlantable(false);
						getPlayer().getTiles().get(30).setSeedPlantable(false);
						getPlayer().getTiles().get(31).setSeedPlantable(false);

						}
					
					else if(index == 29) {
						getPlayer().getTiles().get(18).setSeedPlantable(false);
						getPlayer().getTiles().get(19).setSeedPlantable(false);
						getPlayer().getTiles().get(28).setSeedPlantable(false);
						getPlayer().getTiles().get(38).setSeedPlantable(false);
						getPlayer().getTiles().get(39).setSeedPlantable(false);

						}
					else if(index == 30) {
						getPlayer().getTiles().get(20).setSeedPlantable(false);
						getPlayer().getTiles().get(21).setSeedPlantable(false);
						getPlayer().getTiles().get(31).setSeedPlantable(false);
						getPlayer().getTiles().get(40).setSeedPlantable(false);
						getPlayer().getTiles().get(41).setSeedPlantable(false);

						}
					
					else if(index == 39) {
						getPlayer().getTiles().get(28).setSeedPlantable(false);
						getPlayer().getTiles().get(29).setSeedPlantable(false);
						getPlayer().getTiles().get(38).setSeedPlantable(false);
						getPlayer().getTiles().get(48).setSeedPlantable(false);
						getPlayer().getTiles().get(49).setSeedPlantable(false);

						}
					
					
					else {
					getPlayer().getTiles().get(index-1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+1).setSeedPlantable(false);
					getPlayer().getTiles().get(index+9).setSeedPlantable(false);
					getPlayer().getTiles().get(index+10).setSeedPlantable(false);
					getPlayer().getTiles().get(index+11).setSeedPlantable(false);
					getPlayer().getTiles().get(index-9).setSeedPlantable(false);
					getPlayer().getTiles().get(index-10).setSeedPlantable(false);
					getPlayer().getTiles().get(index-11).setSeedPlantable(false);

					}
				}
				
				
				else if(index>=40&&index<=49) {
					if(index == 40) {
						getPlayer().getTiles().get(index+1).setSeedPlantable(false);
						getPlayer().getTiles().get(index-10).setSeedPlantable(false);
						getPlayer().getTiles().get(index-9).setSeedPlantable(false);

					}
					else if(index == 49) {
						getPlayer().getTiles().get(index-1).setSeedPlantable(false);
						getPlayer().getTiles().get(index-10).setSeedPlantable(false);
						getPlayer().getTiles().get(index-11).setSeedPlantable(false);

					}
					else {
						getPlayer().getTiles().get(index-1).setSeedPlantable(false);
						getPlayer().getTiles().get(index+1).setSeedPlantable(false);
						getPlayer().getTiles().get(index-9).setSeedPlantable(false);
						getPlayer().getTiles().get(index-10).setSeedPlantable(false);
						getPlayer().getTiles().get(index-11).setSeedPlantable(false);

					}
				}

			}
	
	/** resets surrounding tiles given index so that normal seeds can be plante
     * @param index serves as index for the tile chosen*/
	public void RESETSEEDS(int index) { 
		if(index>=0&&index<=9) {
					
					if(index == 0) {
						getPlayer().getTiles().get(index+1).setSeedPlantable(true);
						getPlayer().getTiles().get(index+10).setSeedPlantable(true);
						getPlayer().getTiles().get(index+11).setSeedPlantable(true);
					}
					else if(index == 9) {
						getPlayer().getTiles().get(index-1).setSeedPlantable(true);
						getPlayer().getTiles().get(index+10).setSeedPlantable(true);
						getPlayer().getTiles().get(index+11).setSeedPlantable(true);

					}
					else {
						getPlayer().getTiles().get(index-1).setSeedPlantable(true);
						getPlayer().getTiles().get(index+1).setSeedPlantable(true);
						getPlayer().getTiles().get(index+9).setSeedPlantable(true);
						getPlayer().getTiles().get(index+10).setSeedPlantable(true);
						getPlayer().getTiles().get(index+11).setSeedPlantable(true);

					}
					
				}
				else if(index>=10&&index<=39) {
					if(index==10){
					getPlayer().getTiles().get(0).setSeedPlantable(true);
					getPlayer().getTiles().get(1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+10).setSeedPlantable(true);
					getPlayer().getTiles().get(index+11).setSeedPlantable(true);

					}
					
					else if(index == 19) {
					getPlayer().getTiles().get(0).setSeedPlantable(true);
					getPlayer().getTiles().get(1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+10).setSeedPlantable(true);
					getPlayer().getTiles().get(index+11).setSeedPlantable(true);
			
					}
					
					else if(index == 20) {
						getPlayer().getTiles().get(10).setSeedPlantable(true);
						getPlayer().getTiles().get(11).setSeedPlantable(true);
						getPlayer().getTiles().get(21).setSeedPlantable(true);
						getPlayer().getTiles().get(30).setSeedPlantable(true);
						getPlayer().getTiles().get(31).setSeedPlantable(true);

						}
					
					else if(index == 29) {
						getPlayer().getTiles().get(18).setSeedPlantable(true);
						getPlayer().getTiles().get(19).setSeedPlantable(true);
						getPlayer().getTiles().get(28).setSeedPlantable(true);
						getPlayer().getTiles().get(38).setSeedPlantable(true);
						getPlayer().getTiles().get(39).setSeedPlantable(true);

						}
					else if(index == 30) {
						getPlayer().getTiles().get(20).setSeedPlantable(true);
						getPlayer().getTiles().get(21).setSeedPlantable(true);
						getPlayer().getTiles().get(31).setSeedPlantable(true);
						getPlayer().getTiles().get(40).setSeedPlantable(true);
						getPlayer().getTiles().get(41).setSeedPlantable(true);

						}
					
					else if(index == 39) {
						getPlayer().getTiles().get(28).setSeedPlantable(true);
						getPlayer().getTiles().get(29).setSeedPlantable(true);
						getPlayer().getTiles().get(38).setSeedPlantable(true);
						getPlayer().getTiles().get(48).setSeedPlantable(true);
						getPlayer().getTiles().get(49).setSeedPlantable(true);

						}
					
					
					else {
					getPlayer().getTiles().get(index-1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+1).setSeedPlantable(true);
					getPlayer().getTiles().get(index+9).setSeedPlantable(true);
					getPlayer().getTiles().get(index+10).setSeedPlantable(true);
					getPlayer().getTiles().get(index+11).setSeedPlantable(true);
					getPlayer().getTiles().get(index-9).setSeedPlantable(true);
					getPlayer().getTiles().get(index-10).setSeedPlantable(true);
					getPlayer().getTiles().get(index-11).setSeedPlantable(true);

					}
				}
				
				
				else if(index>=40&&index<=49) {
					if(index == 40) {
						getPlayer().getTiles().get(index+1).setSeedPlantable(true);
						getPlayer().getTiles().get(index-10).setSeedPlantable(true);
						getPlayer().getTiles().get(index-9).setSeedPlantable(true);

					}
					else if(index == 49) {
						getPlayer().getTiles().get(index-1).setSeedPlantable(true);
						getPlayer().getTiles().get(index-10).setSeedPlantable(true);
						getPlayer().getTiles().get(index-11).setSeedPlantable(true);

					}
					else {
						getPlayer().getTiles().get(index-1).setSeedPlantable(true);
						getPlayer().getTiles().get(index+1).setSeedPlantable(true);
						getPlayer().getTiles().get(index-9).setSeedPlantable(true);
						getPlayer().getTiles().get(index-10).setSeedPlantable(true);
						getPlayer().getTiles().get(index-11).setSeedPlantable(true);

					}
				}

			}
	
	/** resets surrounding tiles given index so that fruit trees can be plante
     * @param index serves as index for the tile chosen*/
	public void RESET(int index) {
	
		
		if(index>=0&&index<=9) {
			
			if(index == 0) {
				getPlayer().getTiles().get(index+1).setTreePlantable(true);
				getPlayer().getTiles().get(index+10).setTreePlantable(true);
				getPlayer().getTiles().get(index+11).setTreePlantable(true);
			}
			else if(index == 9) {
				getPlayer().getTiles().get(index-1).setTreePlantable(true);
				getPlayer().getTiles().get(index+10).setTreePlantable(true);
				getPlayer().getTiles().get(index+11).setTreePlantable(true);

			}
			else {
				getPlayer().getTiles().get(index-1).setTreePlantable(true);
				getPlayer().getTiles().get(index+1).setTreePlantable(true);
				getPlayer().getTiles().get(index+9).setTreePlantable(true);
				getPlayer().getTiles().get(index+10).setTreePlantable(true);
				getPlayer().getTiles().get(index+11).setTreePlantable(true);

			}
			
		}
		else if(index>=10&&index<=39) {
			if(index==10){
			getPlayer().getTiles().get(0).setTreePlantable(true);
			getPlayer().getTiles().get(1).setTreePlantable(true);
			getPlayer().getTiles().get(index+1).setTreePlantable(true);
			getPlayer().getTiles().get(index+10).setTreePlantable(true);
			getPlayer().getTiles().get(index+11).setTreePlantable(true);

			}
			
			else if(index == 19) {
			getPlayer().getTiles().get(0).setTreePlantable(true);
			getPlayer().getTiles().get(1).setTreePlantable(true);
			getPlayer().getTiles().get(index+1).setTreePlantable(true);
			getPlayer().getTiles().get(index+10).setTreePlantable(true);
			getPlayer().getTiles().get(index+11).setTreePlantable(true);
	
			}
			
			else if(index == 20) {
				getPlayer().getTiles().get(10).setTreePlantable(true);
				getPlayer().getTiles().get(11).setTreePlantable(true);
				getPlayer().getTiles().get(21).setTreePlantable(true);
				getPlayer().getTiles().get(30).setTreePlantable(true);
				getPlayer().getTiles().get(31).setTreePlantable(true);

				}
			
			else if(index == 29) {
				getPlayer().getTiles().get(18).setTreePlantable(true);
				getPlayer().getTiles().get(19).setTreePlantable(true);
				getPlayer().getTiles().get(28).setTreePlantable(true);
				getPlayer().getTiles().get(38).setTreePlantable(true);
				getPlayer().getTiles().get(39).setTreePlantable(true);

				}
			else if(index == 30) {
				getPlayer().getTiles().get(20).setTreePlantable(true);
				getPlayer().getTiles().get(21).setTreePlantable(true);
				getPlayer().getTiles().get(31).setTreePlantable(true);
				getPlayer().getTiles().get(40).setTreePlantable(true);
				getPlayer().getTiles().get(41).setTreePlantable(true);

				}
			
			else if(index == 39) {
				getPlayer().getTiles().get(28).setTreePlantable(true);
				getPlayer().getTiles().get(29).setTreePlantable(true);
				getPlayer().getTiles().get(38).setTreePlantable(true);
				getPlayer().getTiles().get(48).setTreePlantable(true);
				getPlayer().getTiles().get(49).setTreePlantable(true);

				}
			
			
			else {
			getPlayer().getTiles().get(index-1).setTreePlantable(true);
			getPlayer().getTiles().get(index+1).setTreePlantable(true);
			getPlayer().getTiles().get(index+9).setTreePlantable(true);
			getPlayer().getTiles().get(index+10).setTreePlantable(true);
			getPlayer().getTiles().get(index+11).setTreePlantable(true);
			getPlayer().getTiles().get(index-9).setTreePlantable(true);
			getPlayer().getTiles().get(index-10).setTreePlantable(true);
			getPlayer().getTiles().get(index-11).setTreePlantable(true);

			}
		}
		
		
		else if(index>=40&&index<=49) {
			if(index == 40) {
				getPlayer().getTiles().get(index+1).setTreePlantable(true);
				getPlayer().getTiles().get(index-10).setTreePlantable(true);
				getPlayer().getTiles().get(index-9).setTreePlantable(true);

			}
			else if(index == 49) {
				getPlayer().getTiles().get(index-1).setTreePlantable(true);
				getPlayer().getTiles().get(index-10).setTreePlantable(true);
				getPlayer().getTiles().get(index-11).setTreePlantable(true);

			}
			else {
				getPlayer().getTiles().get(index-1).setTreePlantable(true);
				getPlayer().getTiles().get(index+1).setTreePlantable(true);
				getPlayer().getTiles().get(index-9).setTreePlantable(true);
				getPlayer().getTiles().get(index-10).setTreePlantable(true);
				getPlayer().getTiles().get(index-11).setTreePlantable(true);

			}
		}

	}
	
    /**
     * gets the player of the game
     * @return Player
     */
    public Player getPlayer() {
		return this.player;
	}
	
	/** resets tile given inde
     * @param i serves as index for the tile chosen*/
	public void resetTile(int i) {
		getPlayer().getTiles().get(i).setCrop(null);
		getPlayer().getTiles().get(i).setStatus(TileStatus.GRASS);
		getPlayer().getTiles().get(i).setYield(0);
		getPlayer().getTiles().get(i).setWater(0);
		getPlayer().getTiles().get(i).setFertilizer(0);
		RESET(i);
		RESETSEEDS(i);
	}

}
