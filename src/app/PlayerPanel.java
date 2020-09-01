package app;
import java.awt.*;
import javax.swing.*;

/**
 * JPanel for the Player details
 */

public class PlayerPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private final Image background = new ImageIcon("sprites/playerpanel/sway.gif").getImage();
	private final ImageIcon icon = new ImageIcon("sprites/playerpanel/Coins.gif");
	private final ImageIcon divideIcon = new ImageIcon("sprites/playerpanel/divide.png");
	
	private JLabel time;
	private JLabel title;
	private JLabel coins;
	private JLabel level;
	private JLabel xp;
	private JLabel item;
	private JLabel description;
	private JLabel tileStatus;
	private JLabel promptText;
	
	private JLabel coinIcon;
	private JLabel divide;
	
	private int prompt;
	
    /**
     *
     */
    public PlayerPanel() {
		this.setOpaque(false);
		
		this.prompt = -1;
		
		this.promptText = new JLabel();
		this.promptText.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.promptText.setForeground(new Color(255,0,51));
		this.promptText.setBounds(823, -25, 4000, 100);
		
		this.time = new JLabel();
		this.time.setFont(new Font("Pixellari", Font.PLAIN, 35));
		this.time.setText("Time: 0");
		this.time.setForeground(Color.white);
		this.time.setBounds(1086, 7, 400, 100);
		
		this.title = new JLabel();
		this.title.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.title.setForeground(Color.white);
		this.title.setBounds(125, -25, 400, 100);
				
		this.level = new JLabel();
		this.level.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.level.setForeground(Color.white);
		this.level.setBounds(125, 30, 400, 100);
		
		this.xp = new JLabel();
		this.xp.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.xp.setForeground(Color.white);
		this.xp.setBounds(235, 30, 400, 100);
		
		this.coins = new JLabel();
		this.coins.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.coins.setForeground(Color.white);
		this.coins.setBounds(125, 4, 400, 100);
		
		this.divide = new JLabel(divideIcon);
		this.divide.setBounds(435, 5, 6, 90);
		
		this.coinIcon = new JLabel(icon);
		this.coinIcon.setBounds(-90, 2, 400, 100);
		
		this.item = new JLabel();
		this.item.setFont(new Font("Pixellari", Font.PLAIN, 23));
		this.item.setForeground(Color.white);
		this.item.setText("Current Item: ");
		this.item.setBounds(420+30, -25, 800, 100);
		
		this.description = new JLabel();
		this.description.setFont(new Font("Pixellari", Font.PLAIN, 20));
		this.description.setForeground(Color.white);
		this.description.setText("DESCRIPTION: ");
		this.description.setBounds(420+30, 4, 1000, 100);
		
		this.tileStatus = new JLabel();
		this.tileStatus.setFont(new Font("Pixellari", Font.PLAIN, 18));
		this.tileStatus.setText("Selected Tile: NONE");
		this.tileStatus.setForeground(Color.white);
		this.tileStatus.setBounds(420+30, 30, 800, 100);
		
		setLayout(null);
		setPreferredSize(new Dimension(1280, 100));
		setMinimumSize(new Dimension(1280, 100));
		setMaximumSize(new Dimension(1280, 100));
		
		add(promptText);
		add(time);
		add(title);
		add(coins);
		add(level);
		add(coinIcon);
		add(xp);
		add(item);
		add(description);
		add(tileStatus);
		add(divide);
	}
	
    /**
     *
     * @return
     */
    public int getPrompt() {
		return this.prompt;
	}
	
    /**
     *
     * @param prompt
     */
    public void setPrompt(int prompt) {
		this.prompt = prompt;
	}

    /**
     *
     * @param text
     */
    public void setPromptText(String text) {
		this.promptText.setText(text);
	}

    /**
     *
     * @param text
     */
    public void setTileStatus(String text) {
		this.tileStatus.setText(text);
	}
	
    /**
     *
     * @param text
     */
    public void setDescription(String text) {
		this.description.setText("Description: " + text);
	}
	
    /**
     *
     * @param xp
     * @param til
     */
    public void setXP(String xp, String til) {
		this.xp.setText("XP: " + xp + "/" + til);
	}
	
    /**
     *
     * @param time
     */
    public void setTime(int time) {
		this.time.setText("Time: " + Integer.toString(time));
	}
	
    /**
     *
     * @param text
     */
    public void setTitle(String text) {
		this.title.setText("Title: " + text);
	}
	
    /**
     *
     * @param coins
     */
    public void setCoins(String coins) {
		this.coins.setText("Coins: " + coins);
	}
	
    /**
     *
     * @param lvl
     */
    public void setLevel(int lvl) {
		this.level.setText("Level: " + Integer.toString(lvl));
	}
	
    /**
     *
     * @param text
     */
    public void setCurrentinHand(String text) {
		this.item.setText("Current Item: " + text);
	}
	
	@Override
    public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
	
	
}
