package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
import model.*;

/**
 * Main Menu and the Main driver of the game. Very important.
 */

public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ImageIcon startGame;
	private ImageIcon exit;
	private ImageIcon hovS;
	private ImageIcon hovE;
	private ImageIcon img = new ImageIcon("sprites/icon.png");
	private Clip clip;
	
	private final ImageIcon weIcon = new ImageIcon("sprites/we.png");
	private final JLabel we = new JLabel(weIcon);
	
	private final ImageIcon logoIcon = new ImageIcon("sprites/label.png");
	private final JLabel logo = new JLabel(logoIcon);
	
	private final ImageIcon bgIcon = new ImageIcon("sprites/menu.gif");
	private final JLabel bg = new JLabel(bgIcon);
	
	private JButton startBtn;
	private JButton extBtn;
	
    /**
     *
     */
    public Menu() {
		super("MyFarm Simulator");
		setSize(1200, 720);
		setContentPane(bg);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setIconImage(img.getImage());
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(30,0,0,0);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startBtn = new JButton();
		startGame = new ImageIcon("sprites/start.png");
		startBtn.setIcon(startGame);
		startBtn.addActionListener(this); //event
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false); 
		startBtn.setBorderPainted(false); //does not paint border
		startBtn.setFocusPainted(false); //removes the dotted lines when clicked
		startBtn.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	hovS = new ImageIcon("sprites/hoveredS.png");
		    	startBtn.setIcon(hovS);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	startBtn.setIcon(startGame);
		    }
		});
		
		extBtn = new JButton();
		exit = new ImageIcon("sprites/exit.png");
		extBtn.setIcon(exit);
		extBtn.addActionListener(this);
		extBtn.setOpaque(false);
		extBtn.setContentAreaFilled(false);
		extBtn.setBorderPainted(false);
		extBtn.setFocusPainted(false);
		extBtn.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	hovE = new ImageIcon("sprites/hoveredE.png");
		    	extBtn.setIcon(hovE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	extBtn.setIcon(exit);
		    }
		});
		
		add(logo, gbc);
		add(startBtn, gbc);
		add(extBtn, gbc);
		add(we);
		
		setVisible(true);
		
		playMenuMusic();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if((JButton)e.getSource() == extBtn) {
		System.exit(69);
		}
	
	else if((JButton)e.getSource() == startBtn) {
		Game model = new Game(); //MODEL
		GameWindow view = new GameWindow(); //VIEW
		GameController controller = new GameController(view, model); //CONTROLLER
		controller.printStatus();
		this.dispose();
		this.clip.close();
		}
	}
	
    /**
     *
     */
    public void printMenu() {
		System.out.println("Main Menu Loaded......");
	}
	
    /**
     *
     */
    public void playMenuMusic() {
		try { //BGM
			File soundFile = new File("sounds/menu.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         // Get a sound clip resource.
	         this.clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         this.clip.open(audioIn);
	         this.clip.start();
	         this.clip.loop(Clip.LOOP_CONTINUOUSLY);
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
     * @param args
     */
    public static void main(String[] args) {
		Menu menu = new Menu();
		menu.printMenu();
	}

}
