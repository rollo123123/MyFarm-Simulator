package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * JPanel for the inventory
 */

public class InventoryPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1;
	
	private final Image background = new ImageIcon("sprites/invenpanel/woosh.gif").getImage();
	private ImageIcon buyFrame = new ImageIcon("sprites/invenpanel/BUYNEXT.png");
	private ImageIcon buyFrameHov = new ImageIcon("sprites/invenpanel/HOVEREDBUYNEXT.png");
	private JButton buyTitle;
	private int boughtTitle;
	private MouseListener ml;

	
	private final ImageIcon pickIcon = new ImageIcon("sprites/invenpanel/PickaxeB.png");
	private final ImageIcon waterIcon = new ImageIcon("sprites/invenpanel/WateringCan.png");
	private final ImageIcon hoeIcon = new ImageIcon("sprites/invenpanel/HoeB.png");
	private final ImageIcon fertIcon = new ImageIcon("sprites/invenpanel/FertilizerB.png");
	private final ImageIcon handIcon = new ImageIcon("sprites/invenpanel/HandB.png");
	
	private final ImageIcon turnipIcon = new ImageIcon("sprites/invenpanel/turnipFrame.png");
	private final ImageIcon carrotIcon = new ImageIcon("sprites/invenpanel/carrotFrame.png");
	private final ImageIcon tomatoIcon = new ImageIcon("sprites/invenpanel/tomatoFrame.png");
	private final ImageIcon potatoIcon = new ImageIcon("sprites/invenpanel/potatoFrame.png");
	private final ImageIcon roseIcon = new ImageIcon("sprites/invenpanel/roseFrame.png");
	private final ImageIcon tulipIcon = new ImageIcon("sprites/invenpanel/tulipFrame.png");
	private final ImageIcon sgIcon = new ImageIcon("sprites/invenpanel/stargazerFrame.png");
	private final ImageIcon sunflowerIcon = new ImageIcon("sprites/invenpanel/sunflowerFrame.png");
	private final ImageIcon mangoIcon = new ImageIcon("sprites/invenpanel/mangoFrame.png");
	private final ImageIcon appleIcon = new ImageIcon("sprites/invenpanel/appleFrame.png");
	private final ImageIcon bananaIcon = new ImageIcon("sprites/invenpanel/bananaFrame.png");
	private final ImageIcon orangeIcon = new ImageIcon("sprites/invenpanel/orangeFrame.png");
	
	private final ImageIcon pickIconhov = new ImageIcon("sprites/invenpanel/PickaxeBhov.png");
	private final ImageIcon waterIconhov = new ImageIcon("sprites/invenpanel/WateringCanhov.png");
	private final ImageIcon hoeIconhov = new ImageIcon("sprites/invenpanel/HoeBhov.png");
	private final ImageIcon fertIconhov = new ImageIcon("sprites/invenpanel/FertilizerBhov.png");
	private final ImageIcon handIconhov = new ImageIcon("sprites/invenpanel/HandBhov.png");
	
	private final ImageIcon turnipIconhov = new ImageIcon("sprites/invenpanel/turnipFramehov.png");
	private final ImageIcon carrotIconhov = new ImageIcon("sprites/invenpanel/carrotFramehov.png");
	private final ImageIcon tomatoIconhov = new ImageIcon("sprites/invenpanel/tomatoFramehov.png");
	private final ImageIcon potatoIconhov = new ImageIcon("sprites/invenpanel/potatoFramehov.png");
	private final ImageIcon roseIconhov = new ImageIcon("sprites/invenpanel/roseFramehov.png");
	private final ImageIcon tulipIconhov = new ImageIcon("sprites/invenpanel/tulipFramehov.png");
	private final ImageIcon sgIconhov = new ImageIcon("sprites/invenpanel/stargazerFramehov.png");
	private final ImageIcon sunflowerIconhov = new ImageIcon("sprites/invenpanel/sunflowerFramehov.png");
	private final ImageIcon mangoIconhov = new ImageIcon("sprites/invenpanel/mangoFramehov.png");
	private final ImageIcon appleIconhov = new ImageIcon("sprites/invenpanel/appleFramehov.png");
	private final ImageIcon bananaIconhov = new ImageIcon("sprites/invenpanel/bananaFramehov.png");
	private final ImageIcon orangeIconhov = new ImageIcon("sprites/invenpanel/orangeFramehov.png");
	
	private JButton usePick;
	private JButton useWater;
	private JButton useHoe;
	private JButton useHand;
	private JButton turnip;
	private JButton carrot;
	private JButton tomato;
	private JButton potato;
	private JButton rose;
	private JButton tulip;
	private JButton stargazer;
	private JButton sunflower;
	private JButton mango;
	private JButton apple;
	private JButton banana;
	private JButton orange;
	private JButton fertilizer;
	
	private JLabel fertQuant;
	private JLabel turnipQuant;
	private JLabel carrotQuant;
	private JLabel tomatoQuant;
	private JLabel potatoQuant;
	private JLabel roseQuant;
	private JLabel tulipQuant;
	private JLabel stargazerQuant;
	private JLabel sunflowerQuant;
	private JLabel mangoQuant;
	private JLabel appleQuant;
	private JLabel bananaQuant;
	private JLabel orangeQuant;
	
	private JLabel mode;
	
		
	private int itemChoice;
	
	@Override
    public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
	
    /**
     *
     */
    public InventoryPanel(){
		this.boughtTitle = 0;
		this.itemChoice = 0;
		
		setLayout(null);
		setPreferredSize(new Dimension(1280, 100));
		setMinimumSize(new Dimension(1280, 100));
		setMaximumSize(new Dimension(1280, 100));
		this.setOpaque(false);
		
		this.mode = new JLabel();
		this.mode.setFont(new Font("Pixellari", Font.PLAIN, 25));
		this.mode.setForeground(Color.black);
		this.mode.setBounds(693+90+45, 29, 400, 100);
		
		buyTitle = new JButton();
		buyTitle.addActionListener(this);
		buyTitle.setIcon(buyFrame);
		buyTitle.setOpaque(false);
		buyTitle.setContentAreaFilled(false); 
		buyTitle.setBorderPainted(false); //does not paint border
		buyTitle.setFocusPainted(false); //removes the dotted lines when clicked
		buyTitle.setBounds(16, 13, 82, 48);
		
		this.ml = new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buyTitle.setIcon(buyFrameHov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buyTitle.setIcon(buyFrame);
		    }
		};
		
		
			
		buyTitle.addMouseListener(ml);
		
		
		usePick = new JButton();
		usePick.addActionListener(this);
		usePick.setIcon(pickIcon);
		usePick.setOpaque(false);
		usePick.setContentAreaFilled(false); 
		usePick.setBorderPainted(false); //does not paint border
		usePick.setFocusPainted(false); //removes the dotted lines when clicked
		usePick.setBounds(90, -12, 125, 125);
		usePick.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	usePick.setIcon(pickIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	usePick.setIcon(pickIcon);
		    }
		}
		);
		
		useWater = new JButton();
		useWater.addActionListener(this);
		useWater.setIcon(waterIcon);
		useWater.setOpaque(false);
		useWater.setContentAreaFilled(false); 
		useWater.setBorderPainted(false); //does not paint border
		useWater.setFocusPainted(false); //removes the dotted lines when clicked
		useWater.setBounds(180, -12, 125, 125);
		useWater.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	useWater.setIcon(waterIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	useWater.setIcon(waterIcon);
		    }
		}
		);
		
		useHoe = new JButton();
		useHoe.addActionListener(this);
		useHoe.setIcon(hoeIcon);
		useHoe.setOpaque(false);
		useHoe.setContentAreaFilled(false); 
		useHoe.setBorderPainted(false); //does not paint border
		useHoe.setFocusPainted(false); //removes the dotted lines when clicked
		useHoe.setBounds(270, -12, 125, 125);
		useHoe.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	useHoe.setIcon(hoeIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	useHoe.setIcon(hoeIcon);
		    }
		}
		);
		
		useHoe.addMouseListener(new java.awt.event.MouseListener() {
	        public void mousePressed(MouseEvent me) { }
	        public void mouseReleased(MouseEvent me) { }
	        public void mouseEntered(MouseEvent me) { }
	        public void mouseExited(MouseEvent me) { }
	        public void mouseClicked(MouseEvent me) { 
	        	
	        	if(me.getButton() == MouseEvent.BUTTON3) 
	        		useHoe.setActionCommand("right");
	        	else 
	        		useHoe.setActionCommand("");
	        	
	        	}
		});
		
		
		fertilizer = new JButton();
		fertilizer.addActionListener(this);
		fertilizer.setIcon(fertIcon);
		fertilizer.setOpaque(false);
		fertilizer.setContentAreaFilled(false); 
		fertilizer.setBorderPainted(false); //does not paint border
		fertilizer.setFocusPainted(false); //removes the dotted lines when clicked
		fertilizer.setBounds(377+90, 5, 90, 90);
		fertilizer.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	fertilizer.setIcon(fertIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	fertilizer.setIcon(fertIcon);
		    }
		}
		);
		fertQuant = new JLabel();
		fertQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		fertQuant.setForeground(Color.white);
		fertQuant.setBounds(475, 22, 125, 125);
		
		useHand = new JButton();
		useHand.addActionListener(this);
		useHand.setIcon(handIcon);
		useHand.setOpaque(false);
		useHand.setContentAreaFilled(false); 
		useHand.setBorderPainted(false); //does not paint border
		useHand.setFocusPainted(false); //removes the dotted lines when clicked
		useHand.setBounds(467-90, 5, 90, 90);
		useHand.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	useHand.setIcon(handIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	useHand.setIcon(handIcon);
		    }
		}
		);
		
		turnip = new JButton();
		turnip.addActionListener(this);
		turnip.setIcon(turnipIcon);
		turnip.setOpaque(false);
		turnip.setContentAreaFilled(false); 
		turnip.setBorderPainted(false); //does not paint border
		turnip.setFocusPainted(false); //removes the dotted lines when clicked
		turnip.setBounds(467+90, 5, 45, 45);
		turnip.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	turnip.setIcon(turnipIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	turnip.setIcon(turnipIcon);
		    }
		}
		);
		turnipQuant = new JLabel();
		turnipQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		turnipQuant.setForeground(Color.white);
		turnipQuant.setBounds(470+90, -20, 125, 125);
			
		carrot = new JButton();
		carrot.addActionListener(this);
		carrot.setIcon(carrotIcon);
		carrot.setOpaque(false);
		carrot.setContentAreaFilled(false); 
		carrot.setBorderPainted(false); //does not paint border
		carrot.setFocusPainted(false); //removes the dotted lines when clicked
		carrot.setBounds(512+90, 5, 45, 45);
		carrot.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	carrot.setIcon(carrotIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	carrot.setIcon(carrotIcon);
		    }
		}
		);
		carrotQuant = new JLabel();
		carrotQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		carrotQuant.setForeground(Color.white);
		carrotQuant.setBounds(516+90, -20, 125, 125);
		
		tomato = new JButton();
		tomato.addActionListener(this);
		tomato.setIcon(tomatoIcon);
		tomato.setOpaque(false);
		tomato.setContentAreaFilled(false); 
		tomato.setBorderPainted(false); //does not paint border
		tomato.setFocusPainted(false); //removes the dotted lines when clicked
		tomato.setBounds(554+90, 2, 50, 50);
		tomato.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	tomato.setIcon(tomatoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	tomato.setIcon(tomatoIcon);
		    }
		}
		);
		tomatoQuant = new JLabel();
		tomatoQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		tomatoQuant.setForeground(Color.white);
		tomatoQuant.setBounds(558+90, -20, 125, 125);
		
		potato = new JButton();
		potato.addActionListener(this);
		potato.setIcon(potatoIcon);
		potato.setOpaque(false);
		potato.setContentAreaFilled(false); 
		potato.setBorderPainted(false); //does not paint border
		potato.setFocusPainted(false); //removes the dotted lines when clicked
		potato.setBounds(554+45+90, 2, 50, 50);
		potato.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	potato.setIcon(potatoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	potato.setIcon(potatoIcon);
		    }
		}
		);
		potatoQuant = new JLabel();
		potatoQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		potatoQuant.setForeground(Color.white);
		potatoQuant.setBounds(605+90, -20, 125, 125);
		
		rose = new JButton();
		rose.addActionListener(this);
		rose.setIcon(roseIcon);
		rose.setOpaque(false);
		rose.setContentAreaFilled(false); 
		rose.setBorderPainted(false); //does not paint border
		rose.setFocusPainted(false); //removes the dotted lines when clicked
		rose.setBounds(554+45+45+90, 2, 50, 50);
		rose.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	rose.setIcon(roseIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	rose.setIcon(roseIcon);
		    }
		}
		);
		roseQuant = new JLabel();
		roseQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		roseQuant.setForeground(Color.white);
		roseQuant.setBounds(650+90, -20, 125, 125);
		
		tulip = new JButton();
		tulip.addActionListener(this);
		tulip.setIcon(tulipIcon);
		tulip.setOpaque(false);
		tulip.setContentAreaFilled(false); 
		tulip.setBorderPainted(false); //does not paint border
		tulip.setFocusPainted(false); //removes the dotted lines when clicked
		tulip.setBounds(554+45+45+45+90, 2, 50, 50);
		tulip.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	tulip.setIcon(tulipIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	tulip.setIcon(tulipIcon);
		    }
		}
		);
		tulipQuant = new JLabel();
		tulipQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		tulipQuant.setForeground(Color.white);
		tulipQuant.setBounds(693+90, -20, 125, 125);
		
		stargazer = new JButton();
		stargazer.addActionListener(this);
		stargazer.setIcon(sgIcon);
		stargazer.setOpaque(false);
		stargazer.setContentAreaFilled(false); 
		stargazer.setBorderPainted(false); //does not paint border
		stargazer.setFocusPainted(false); //removes the dotted lines when clicked
		stargazer.setBounds(464+90, 47, 50,50);
		stargazer.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	stargazer.setIcon(sgIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	stargazer.setIcon(sgIcon);
		    }
		}
		);
		stargazerQuant = new JLabel();
		stargazerQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		stargazerQuant.setForeground(Color.white);
		stargazerQuant.setBounds(469+90, 24, 125, 125);
		
		sunflower = new JButton();
		sunflower.addActionListener(this);
		sunflower.setIcon(sunflowerIcon);
		sunflower.setOpaque(false);
		sunflower.setContentAreaFilled(false); 
		sunflower.setBorderPainted(false); //does not paint border
		sunflower.setFocusPainted(false); //removes the dotted lines when clicked
		sunflower.setBounds(464+45+90, 47, 50,50);
		sunflower.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	sunflower.setIcon(sunflowerIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	sunflower.setIcon(sunflowerIcon);
		    }
		}
		);
		sunflowerQuant = new JLabel();
		sunflowerQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		sunflowerQuant.setForeground(Color.white);
		sunflowerQuant.setBounds(515+90, 24, 125, 125);
		
		mango = new JButton();
		mango.addActionListener(this);
		mango.setIcon(mangoIcon);
		mango.setOpaque(false);
		mango.setContentAreaFilled(false); 
		mango.setBorderPainted(false); //does not paint border
		mango.setFocusPainted(false); //removes the dotted lines when clicked
		mango.setBounds(464+45+45+90, 47, 50,50);
		mango.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mango.setIcon(mangoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mango.setIcon(mangoIcon);
		    }
		}
		);
		mangoQuant = new JLabel();
		mangoQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		mangoQuant.setForeground(Color.white);
		mangoQuant.setBounds(559+90, 24, 125, 125);
		
		apple = new JButton();
		apple.addActionListener(this);
		apple.setIcon(appleIcon);
		apple.setOpaque(false);
		apple.setContentAreaFilled(false); 
		apple.setBorderPainted(false); //does not paint border
		apple.setFocusPainted(false); //removes the dotted lines when clicked
		apple.setBounds(464+45+45+45+90, 47, 50,50);
		apple.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	apple.setIcon(appleIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	apple.setIcon(appleIcon);
		    }
		}
		);
		appleQuant = new JLabel();
		appleQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		appleQuant.setForeground(Color.white);
		appleQuant.setBounds(606+90, 24, 125, 125);
		
		banana = new JButton();
		banana.addActionListener(this);
		banana.setIcon(bananaIcon);
		banana.setOpaque(false);
		banana.setContentAreaFilled(false); 
		banana.setBorderPainted(false); //does not paint border
		banana.setFocusPainted(false); //removes the dotted lines when clicked
		banana.setBounds(464+45+45+45+45+90, 47, 50,50);
		banana.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	banana.setIcon(bananaIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	banana.setIcon(bananaIcon);
		    }
		}
		);
		bananaQuant = new JLabel();
		bananaQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		bananaQuant.setForeground(Color.white);
		bananaQuant.setBounds(649+90, 24, 125, 125);
		
		orange = new JButton();
		orange.addActionListener(this);
		orange.setIcon(orangeIcon);
		orange.setOpaque(false);
		orange.setContentAreaFilled(false); 
		orange.setBorderPainted(false); //does not paint border
		orange.setFocusPainted(false); //removes the dotted lines when clicked
		orange.setBounds(464+45+45+45+45+45+90, 47, 50,50);
		orange.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	orange.setIcon(orangeIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	orange.setIcon(orangeIcon);
		    }
		}
		);
		orangeQuant = new JLabel();
		orangeQuant.setFont(new Font("Pixellari", Font.PLAIN, 20));
		orangeQuant.setForeground(Color.white);
		orangeQuant.setBounds(693+90, 24, 125, 125);
		
		add(mode);
		add(buyTitle);
		add(usePick);
		add(useWater);
		add(useHoe);
		add(fertQuant);
		add(useHand);
		
		add(turnipQuant);
		add(carrotQuant);
		add(tomatoQuant);
		add(potatoQuant);
		add(roseQuant);
		add(tulipQuant);
		add(stargazerQuant);
		add(sunflowerQuant);
		add(mangoQuant);
		add(appleQuant);
		add(bananaQuant);
		add(orangeQuant);
		
		add(fertilizer);
		add(turnip);
		add(carrot);
		add(tomato);
		add(potato);
		add(rose);
		add(tulip);
		add(stargazer);
		add(sunflower);
		add(mango);
		add(apple);
		add(banana);
		add(orange);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == useHand) {
			this.itemChoice = 0;
		}
		else if((JButton)e.getSource() == buyTitle)
			this.boughtTitle = 1;
		else if((JButton)e.getSource() == usePick) {
			this.itemChoice = 1;
		}
		else if((JButton)e.getSource() == useWater) {
			this.itemChoice = 2;
		}
		else if((JButton)e.getSource() == useHoe) {
			this.itemChoice = 3;
		}
		else if((JButton)e.getSource() == fertilizer) {
			this.itemChoice = 4;
		}
		else if((JButton)e.getSource() == turnip) {
			this.itemChoice = 5;
		}
		else if((JButton)e.getSource() == carrot) {
			this.itemChoice = 6;
		}
		else if((JButton)e.getSource() == tomato) {
			this.itemChoice = 7;
		}
		else if((JButton)e.getSource() == potato) {
			this.itemChoice = 8;
		}
		else if((JButton)e.getSource() == rose) {
			this.itemChoice = 9;
		}
		else if((JButton)e.getSource() == tulip) {
			this.itemChoice = 10;
		}
		else if((JButton)e.getSource() == stargazer) {
			this.itemChoice = 11;
		}
		else if((JButton)e.getSource() == sunflower) {
			this.itemChoice = 12;
		}
		else if((JButton)e.getSource() == mango) {
			this.itemChoice = 13;
		}
		else if((JButton)e.getSource() == apple) {
			this.itemChoice = 14;
		}
		else if((JButton)e.getSource() == banana) {
			this.itemChoice = 15;
		}
		else if((JButton)e.getSource() == orange) {
			this.itemChoice = 16;
		}		
	}
	
    /**
     *
     * @return
     */
    public JButton getBuyTitleButton() {
		return this.buyTitle;
	}
	
    /**
     *
     * @return
     */
    public MouseListener getML() {
		return this.ml;
	}
	
    /**
     *
     * @return
     */
    public int getBuyIndicator() {
		return this.boughtTitle;
	}
	
    /**
     *
     * @param a
     */
    public void setBuyIndicator(int a) {
		this.boughtTitle = a;
	}
	
    /**
     *
     * @return
     */
    public int getViewChoice() {
		return this.itemChoice;
	}
	
    /**
     *
     * @param text
     */
    public void setModeText(String text) {
		this.mode.setText(text);
	}
	
    /**
     *
     * @param choice
     */
    public void setItemChoice(int choice) {
		this.itemChoice = choice;
	}
	
    /**
     *
     * @param quant
     */
    public void setFertQuant(int quant) {
		this.fertQuant.setText(Integer.toString(quant));
	}
	
    /**
     *
     * @param quant
     */
    public void setTurnipQuant(int quant) {
		this.turnipQuant.setText(Integer.toString(quant));
	}
	
    /**
     *
     * @param quant
     */
    public void setCarrotQuant(int quant) {
		this.carrotQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setTomatoQuant(int quant) {
		this.tomatoQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setPotatoQuant(int quant) {
		this.potatoQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setRoseQuant(int quant) {
		this.roseQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setTulipQuant(int quant) {
		this.tulipQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setStargazerQuant(int quant) {
		this.stargazerQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setSunflowerQuant(int quant) {
		this.sunflowerQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setMangoQuant(int quant) {
		this.mangoQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setAppleQuant(int quant) {
		this.appleQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setBananaQuant(int quant) {
		this.bananaQuant.setText(Integer.toString(quant));
	}

    /**
     *
     * @param quant
     */
    public void setOrangeQuant(int quant) {
		this.orangeQuant.setText(Integer.toString(quant));
	}
	
    /**
     *
     * @return
     */
    public JButton getHoe() {
		return this.useHoe;
	}
	
}