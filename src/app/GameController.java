package app;
import model.*;
import model.Constants.CropStatus;
import model.Constants.TileStatus;
import java.util.*;
import javax.swing.ImageIcon;
import java.text.DecimalFormat;
/**
 * Overall Game Controller; handles from updating of icons and text, to updating the model
 */
public class GameController {
	private GameWindow window;
	private Game model;
	
	private Timer gameTimer;
	private TimerTask task;
	private int time, period, delay;
	private int count = 0;
	
    /**
     *
     * @param window
     * @param model
     */
    public GameController(GameWindow window, Game model) {
		this.window = window;
		this.model = model;
		this.time = 0;
		this.delay = 0; //delay before task starts
		this.period = 1; //period
		
		this.gameTimer = new Timer();
		this.task = new TimerTask() {
			
			@Override
			public void run() {
				count++;
				
				
				if(count%100==0) { //delays add time to make the code run faster
					addTime(); // Adds to time
			
					// Handles updating of crop status and age
					model.updateCrops();
				
				}
				
				window.cursor();
				// Handles level up
				model.levelUP();
				
				// Handles updating of tile icons
				for(int index=0;index<50;index++) {
					window.getLotPanel().updateTileIcon(index, model.getPlayer().getTiles().get(index));
				}
				
				// Handles updating information
				setText();
				
				// Handles buying of Items
				if(window.getShopPanel().getBuyChoice() != 0) {
					if(window.getShopPanel().getBuyChoice() == 13)
						model.buyFertilizer();
					else if(window.getShopPanel().getBuyChoice () == 1)
						model.buySeed("TURNIP");
					else if(window.getShopPanel().getBuyChoice () == 2)
						model.buySeed("CARROT");
					else if(window.getShopPanel().getBuyChoice () == 3)
						model.buySeed("TOMATO");
					else if(window.getShopPanel().getBuyChoice () == 4)
						model.buySeed("POTATO");
					else if(window.getShopPanel().getBuyChoice () == 5)
						model.buySeed("ROSE");
					else if(window.getShopPanel().getBuyChoice () == 6)
						model.buySeed("TULIP");
					else if(window.getShopPanel().getBuyChoice () == 7)
						model.buySeed("STARGAZER");
					else if(window.getShopPanel().getBuyChoice () == 8)
						model.buySeed("SUNFLOWER");
					else if(window.getShopPanel().getBuyChoice () == 9)
						model.buySeed("MANGO");
					else if(window.getShopPanel().getBuyChoice () == 10)
						model.buySeed("APPLE");
					else if(window.getShopPanel().getBuyChoice () == 11)
						model.buySeed("BANANA");
					else if(window.getShopPanel().getBuyChoice () == 12)
						model.buySeed("ORANGE");
					window.getShopPanel().setBuyChoice(0);
				}
				
				// Handles usage of Items
				if(window.getLotPanel().getTileChoice() != -1 && window.getInventoryPanel().getViewChoice() >= 0) {
					int index = window.getLotPanel().getTileChoice();
					int item = window.getInventoryPanel().getViewChoice();
					
					window.getPlayerPanel().setPrompt(-1);
					
					//updates model and prompt messages
					window.getPlayerPanel().setPrompt(model.useItem(item, index, window.getInventoryPanel().getHoe().getActionCommand()));
					
					// right click to plow
					if(window.getInventoryPanel().getHoe().getActionCommand().equals("right")) {
						window.getInventoryPanel().setItemChoice(3);
						if(model.getPlayer().getTiles().get(index).getStatus().equals(TileStatus.PLANTED) && 
								model.getPlayer().getTiles().get(index).getCrop() != null
								&& model.getPlayer().getTiles().get(index).getCrop().getStatus().equals(CropStatus.DEAD)) {
							
							double deduct = 0.10 * Constants.getPriceList().get(model.getPlayer().getTiles().get(index).getCrop().getName());
							model.getPlayer().subCoins(deduct);
							model.getPlayer().addXP(1.0);
							model.resetTile(index);
						}
						
					}
				
					//resets choice
					window.getLotPanel().setChoice(-1);
				}
				
				// Right click left click
				if(window.getInventoryPanel().getViewChoice() != 3 && window.getInventoryPanel().getHoe().getActionCommand().equals("right"))
					window.getInventoryPanel().getHoe().setActionCommand("nah");	
				
				// Handles buying of title
				if(window.getInventoryPanel().getBuyIndicator() != 0) {
					model.buyNextTitle();
					window.getInventoryPanel().setBuyIndicator(0);
					
					if(model.getPlayer().getTitle().equals("Honorable Farmer")) {
					ImageIcon max = new ImageIcon("sprites/invenpanel/BUYMAXED.png");
					window.getInventoryPanel().getBuyTitleButton().setIcon(max);
					window.getInventoryPanel().getBuyTitleButton().removeMouseListener(window.getInventoryPanel().getML());
					}
					
				}
				
				
			} //end of run
			
		};
		
		this.gameTimer.scheduleAtFixedRate(task, delay, period);
	}
	
    /**
     *
     */
    public void addTime() {
		this.time++;
	}
	
    /**
     *
     */
    public void setText() {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		if(window.getPlayerPanel().getPrompt() == -1)
		window.getPlayerPanel().setPromptText(" ");
		
		else if(window.getPlayerPanel().getPrompt() == 0)
			window.getPlayerPanel().setPromptText("You can't use a pick on a grass, silly");
		else if(window.getPlayerPanel().getPrompt() == 1)
			window.getPlayerPanel().setPromptText("You can't use a pick on that tile, silly");
		else if(window.getPlayerPanel().getPrompt() == 2)
			window.getPlayerPanel().setPromptText("You can't water grass, it'll only be a waste!");
		else if(window.getPlayerPanel().getPrompt() == 3)
			window.getPlayerPanel().setPromptText("You can't water a rock, silly");
		else if(window.getPlayerPanel().getPrompt() == 4)
			window.getPlayerPanel().setPromptText("Tile is already plowed");
		else if(window.getPlayerPanel().getPrompt() == 5)
			window.getPlayerPanel().setPromptText("You can't use a hoe on a rock, silly");
		else if(window.getPlayerPanel().getPrompt() == 7)
			window.getPlayerPanel().setPromptText("Tile occupied :'(");
		else if(window.getPlayerPanel().getPrompt() == 8)
			window.getPlayerPanel().setPromptText("Not enough seeds. Buy more.");
		else if(window.getPlayerPanel().getPrompt() == 9)
			window.getPlayerPanel().setPromptText("Seed already planted! Can't fertilize now.");
		else
			window.getPlayerPanel().setPromptText("You can't use that here");
		
		if(window.getInventoryPanel().getHoe().getActionCommand().equals("right"))
		window.getInventoryPanel().setModeText("<<ON REMOVE MODE>>");
		else if(window.getInventoryPanel().getHoe().getActionCommand().equals("") && 
				window.getInventoryPanel().getViewChoice() == 3)
		window.getInventoryPanel().setModeText("<<ON PLOW MODE>>");
		else
		window.getInventoryPanel().setModeText("");
		
		window.getPlayerPanel().setTitle(model.getPlayer().getTitle());
		window.getPlayerPanel().setCoins(formatter.format(model.getPlayer().getCoins()));
		window.getPlayerPanel().setLevel(model.getPlayer().getLevel());
		window.getPlayerPanel().setXP(formatter.format(model.getPlayer().getXP()), formatter.format(model.getPlayer().getXPtillNext()));
		
		if(window.getLotPanel().getTileChoice() != -1 && window.getInventoryPanel().getViewChoice() == 0)
		window.getPlayerPanel().setTileStatus(model.getPlayer().getTiles().get(window.getLotPanel().getTileChoice()).displayTileStatus());
		else if(window.getInventoryPanel().getViewChoice() != 0)
		window.getPlayerPanel().setTileStatus("Selected Tile: NONE");
		
		
		if(window.getInventoryPanel().getViewChoice() == 0) {
			window.getPlayerPanel().setCurrentinHand("<<HAND>>");
			window.getPlayerPanel().setDescription("Harvests plants; View Tile Status");
		}
		
		else if(window.getInventoryPanel().getViewChoice() == 1) {
			window.getPlayerPanel().setCurrentinHand("<<PICKAXE>>");
			window.getPlayerPanel().setDescription("Breaks rocks");
		}
		
		else if(window.getInventoryPanel().getViewChoice() == 2) {
			window.getPlayerPanel().setCurrentinHand("<<WATERING CAN>>");
			window.getPlayerPanel().setDescription("Waters plants");
		}
			
		else if(window.getInventoryPanel().getViewChoice() == 3) {
			window.getPlayerPanel().setCurrentinHand("<<HOE>>");
			window.getPlayerPanel().setDescription("Plows grass; Right Click on Hoe to remove plants");
		}
			
		else if(window.getInventoryPanel().getViewChoice() == 4) {
			window.getPlayerPanel().setCurrentinHand("<<FERTILIZER>>");
			window.getPlayerPanel().setDescription("Fertilizes land");
		}
			
		else {
			int x = window.getInventoryPanel().getViewChoice();
			double bonus = 0; //bonus
			
			if(model.getPlayer().getTitle() == "Registered Farmer")
				bonus = 2.0;
				else if(model.getPlayer().getTitle() == "Distinguished Farmer")
				bonus = 3.0;
				else if(model.getPlayer().getTitle() == "Honorable Farmer")
				bonus = 5.0;
			
			for(int i=0;i<model.getPlayer().getSeeds().size();i++)
				
				if(model.getPlayer().getSeeds().get(i).getID() == x) {
					double cost = Constants.getPriceList().get(model.getPlayer().getSeeds().get(i).getSeedName());
					window.getPlayerPanel().setCurrentinHand("<<"+ 
							model.getPlayer().getSeeds().get(i).getSeedName() + " SEED>>");
					window.getPlayerPanel().setDescription("PLANTS A " + model.getPlayer().getSeeds().get(i).getSeedName() + " SEED; COSTS " + 
							(cost - bonus));
				}	
			}	
		
		window.getInventoryPanel().setFertQuant(model.getPlayer().getFertilizer().getQuantity());
		window.getInventoryPanel().setTurnipQuant(model.getPlayer().getSeeds().get(0).getQuantity());
		window.getInventoryPanel().setCarrotQuant(model.getPlayer().getSeeds().get(1).getQuantity());
		window.getInventoryPanel().setTomatoQuant(model.getPlayer().getSeeds().get(2).getQuantity());
		window.getInventoryPanel().setPotatoQuant(model.getPlayer().getSeeds().get(3).getQuantity());
		window.getInventoryPanel().setRoseQuant(model.getPlayer().getSeeds().get(4).getQuantity());
		window.getInventoryPanel().setTulipQuant(model.getPlayer().getSeeds().get(5).getQuantity());
		window.getInventoryPanel().setStargazerQuant(model.getPlayer().getSeeds().get(6).getQuantity());
		window.getInventoryPanel().setSunflowerQuant(model.getPlayer().getSeeds().get(7).getQuantity());
		window.getInventoryPanel().setMangoQuant(model.getPlayer().getSeeds().get(8).getQuantity());
		window.getInventoryPanel().setAppleQuant(model.getPlayer().getSeeds().get(9).getQuantity());
		window.getInventoryPanel().setBananaQuant(model.getPlayer().getSeeds().get(10).getQuantity());
		window.getInventoryPanel().setOrangeQuant(model.getPlayer().getSeeds().get(11).getQuantity());
		window.getPlayerPanel().setTime(time);
	}
	
    /**
     *
     */
    public void printStatus() {
		System.out.println("Model, View, and Controller Loaded......\nENJOY THE GAME HEHEHEHEHE >:)");
	}
}
