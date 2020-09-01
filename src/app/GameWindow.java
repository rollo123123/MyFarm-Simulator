package app;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;

/**
 * Overall Game window; contains panels
 */

public class GameWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private PlayerPanel player;
	private LotPanel lot;
	private InventoryPanel inventory;
	private ShopPanel shop;
	
	private final ImageIcon bgIcon = new ImageIcon("sprites/Map2.png");
	private final JLabel bg = new JLabel(bgIcon);
	private ImageIcon img = new ImageIcon("sprites/icon.png");
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Image cursorimage;
	private Cursor cursor;
	
    /**
     *
     */
    public GameWindow() {
		super("MyFarm Simulator");
		addFont();
		playMusic();
		this.setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(bg);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false); //not resizable
		setVisible(true);
		
		initGame();
		
	}
	
    /**
     *
     */
    public void initGame() { //show all panels
		this.player = new PlayerPanel();
		this.inventory = new InventoryPanel();
		this.lot = new LotPanel();
		this.shop = new ShopPanel();
		
		Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(lot);
        box.add(Box.createVerticalGlue());
		
        Box box2 = new Box(BoxLayout.Y_AXIS);
        box2.add(Box.createVerticalGlue());
        box2.add(shop);
        
		add(inventory, BorderLayout.NORTH);
		add(box, BorderLayout.CENTER);
		add(player, BorderLayout.SOUTH);
		add(box2, BorderLayout.EAST);
	}
	
    /**
     *
     */
    public void playMusic() {
		try { //BGM
			File soundFile = new File("sounds/game.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	
    /**
     *
     */
    public void addFont() {
		try { //adds game font
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/Pixellari.ttf")));
		} catch (IOException|FontFormatException e) {
		     System.out.println(e);
		}
	}
	
    /**
     *
     * @return
     */
    public PlayerPanel getPlayerPanel() {
		return this.player;
	}
	
    /**
     *
     * @return
     */
    public InventoryPanel getInventoryPanel() {
		return this.inventory;
	}
	
    /**
     *
     * @return
     */
    public LotPanel getLotPanel() {
		return this.lot;
	}
	
    /**
     *
     * @return
     */
    public ShopPanel getShopPanel() {
		return this.shop;
	}
	
    /**
     *
     */
    public void cursor() {
		 if(inventory.getViewChoice() == 0) {
			this.cursorimage = toolkit.getImage("sprites/handCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() == 1) {
			this.cursorimage = toolkit.getImage("sprites/pickCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		
		else if(inventory.getViewChoice() == 2) {
			this.cursorimage = toolkit.getImage("sprites/bucketCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() == 3) {
			this.cursorimage = toolkit.getImage("sprites/hoeCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() == 4) {
			this.cursorimage = toolkit.getImage("sprites/fertCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() >= 5 && inventory.getViewChoice() <= 8) {
			this.cursorimage = toolkit.getImage("sprites/vegetableCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() >= 9 && inventory.getViewChoice() <= 12) {
			this.cursorimage = toolkit.getImage("sprites/flowerCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		else if(inventory.getViewChoice() >= 13 && inventory.getViewChoice() <= 16) {
			this.cursorimage = toolkit.getImage("sprites/fruitTreeCursor.png");
			this.cursor = toolkit.createCustomCursor(this.cursorimage , new Point(0,0) , "img");
			this.setCursor(this.cursor);
		}
		
	}
}

