package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * JPanel for the Shop
 */

public class ShopPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final Image background = new ImageIcon("sprites/shoppanel/ShopPanel.png").getImage();
	
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
	private final ImageIcon fertilizerIcon = new ImageIcon("sprites/shoppanel/shopfert.png");
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
	private final ImageIcon fertilizerIconhov = new ImageIcon("sprites/shoppanel/shopferthov.png");
	
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
	
	private int buyChoice;
	
    /**
     *
     */
    public ShopPanel() {
	this.buyChoice = 0;
	
	this.turnip = new JButton();
	turnip.addActionListener(this);
	turnip.setIcon(turnipIcon);
	turnip.setOpaque(false);
	turnip.setContentAreaFilled(false); 
	turnip.setBorderPainted(false); //does not paint border
	turnip.setFocusPainted(false); //removes the dotted lines when clicked
	turnip.setBounds(27, 20, 45, 45);
	
	this.carrot = new JButton();
	carrot.setIcon(carrotIcon);
	carrot.addActionListener(this);
	carrot.setOpaque(false);
	carrot.setContentAreaFilled(false); 
	carrot.setBorderPainted(false); //does not paint border
	carrot.setFocusPainted(false); //removes the dotted lines when clicked
	carrot.setBounds(76, 20, 45, 45);
	
	this.tomato = new JButton();
	tomato.addActionListener(this);
	tomato.setIcon(tomatoIcon);
	tomato.setOpaque(false);
	tomato.setContentAreaFilled(false); 
	tomato.setBorderPainted(false); //does not paint border
	tomato.setFocusPainted(false); //removes the dotted lines when clicked
	tomato.setBounds(128, 20, 45, 45);
	
	this.potato = new JButton();
	potato.addActionListener(this);
	potato.setIcon(potatoIcon);
	potato.setOpaque(false);
	potato.setContentAreaFilled(false); 
	potato.setBorderPainted(false); //does not paint border
	potato.setFocusPainted(false); //removes the dotted lines when clicked
	potato.setBounds(180, 20, 45, 45);
	
	this.rose = new JButton();
	rose.setIcon(roseIcon);
	rose.addActionListener(this);
	rose.setOpaque(false);
	rose.setContentAreaFilled(false); 
	rose.setBorderPainted(false); //does not paint border
	rose.setFocusPainted(false); //removes the dotted lines when clicked
	rose.setBounds(230, 20, 45, 45);
	
	
	this.tulip = new JButton();
	tulip.addActionListener(this);
	tulip.setIcon(tulipIcon);
	tulip.setOpaque(false);
	tulip.setContentAreaFilled(false); 
	tulip.setBorderPainted(false); //does not paint border
	tulip.setFocusPainted(false); //removes the dotted lines when clicked
	tulip.setBounds(27, 70, 45, 45);
	
	this.stargazer = new JButton();
	stargazer.addActionListener(this);
	stargazer.setIcon(sgIcon);
	stargazer.setOpaque(false);
	stargazer.setContentAreaFilled(false); 
	stargazer.setBorderPainted(false); //does not paint border
	stargazer.setFocusPainted(false); //removes the dotted lines when clicked
	stargazer.setBounds(76, 70, 45, 45);
	
	this.sunflower = new JButton();
	sunflower.addActionListener(this);
	sunflower.setIcon(sunflowerIcon);
	sunflower.setOpaque(false);
	sunflower.setContentAreaFilled(false); 
	sunflower.setBorderPainted(false); //does not paint border
	sunflower.setFocusPainted(false); //removes the dotted lines when clicked
	sunflower.setBounds(128, 70, 45, 45);
	
	this.mango = new JButton();
	mango.addActionListener(this);
	mango.setIcon(mangoIcon);
	mango.setOpaque(false);
	mango.setContentAreaFilled(false); 
	mango.setBorderPainted(false); //does not paint border
	mango.setFocusPainted(false); //removes the dotted lines when clicked
	mango.setBounds(180, 70, 45, 45);
	
	this.apple = new JButton();
	apple.setIcon(appleIcon);
	apple.addActionListener(this);
	apple.setOpaque(false);
	apple.setContentAreaFilled(false); 
	apple.setBorderPainted(false); //does not paint border
	apple.setFocusPainted(false); //removes the dotted lines when clicked
	apple.setBounds(230, 70, 45, 45);
	
	this.banana = new JButton();
	banana.addActionListener(this);
	banana.setIcon(bananaIcon);
	banana.setOpaque(false);
	banana.setContentAreaFilled(false); 
	banana.setBorderPainted(false); //does not paint border
	banana.setFocusPainted(false); //removes the dotted lines when clicked
	banana.setBounds(27, 120, 45, 45);
	
	this.orange = new JButton();
	orange.addActionListener(this);
	orange.setIcon(orangeIcon);
	orange.setOpaque(false);
	orange.setContentAreaFilled(false); 
	orange.setBorderPainted(false); //does not paint border
	orange.setFocusPainted(false); //removes the dotted lines when clicked
	orange.setBounds(76, 120, 45, 45);
	
	this.fertilizer = new JButton();
	fertilizer.addActionListener(this);
	fertilizer.setIcon(fertilizerIcon);
	fertilizer.setOpaque(false);
	fertilizer.setContentAreaFilled(false); 
	fertilizer.setBorderPainted(false); //does not paint border
	fertilizer.setFocusPainted(false); //removes the dotted lines when clicked
	fertilizer.setBounds(125, 120, 45, 45);
	
	addMouseListeners();
	
	setLayout(null);
	setPreferredSize(new Dimension(300,201));
	setMinimumSize(new Dimension(300, 201));
	setMaximumSize(new Dimension(300, 201));
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
	add(fertilizer);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == turnip) 
			this.buyChoice = 1;
		else if((JButton)e.getSource() == carrot) 
			this.buyChoice = 2;
		else if((JButton)e.getSource() == tomato) 
			this.buyChoice = 3;
		else if((JButton)e.getSource() == potato) 
			this.buyChoice = 4;
		else if((JButton)e.getSource() == rose) 
			this.buyChoice = 5;
		else if((JButton)e.getSource() == tulip) 
			this.buyChoice = 6;
		else if((JButton)e.getSource() == stargazer) 
			this.buyChoice = 7;
		else if((JButton)e.getSource() == sunflower) 
			this.buyChoice = 8;
		else if((JButton)e.getSource() == mango) 
			this.buyChoice = 9;
		else if((JButton)e.getSource() == apple) 
			this.buyChoice = 10;
		else if((JButton)e.getSource() == banana) 
			this.buyChoice = 11;
		else if((JButton)e.getSource() == orange) 
			this.buyChoice = 12;
		else if((JButton)e.getSource() == fertilizer) 
			this.buyChoice = 13;
		
	}
	
	@Override
    public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
	
    /**
     *
     * @param choice
     */
    public void setBuyChoice(int choice) {
		this.buyChoice = choice;
	}
	
    /**
     *
     * @return
     */
    public int getBuyChoice() {
		return this.buyChoice;
	}
	
    /**
     *
     */
    public void addMouseListeners() {
		turnip.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	turnip.setIcon(turnipIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	turnip.setIcon(turnipIcon);
		    }
		}
		);

carrot.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	carrot.setIcon(carrotIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	carrot.setIcon(carrotIcon);
		    }
		}
		);

tomato.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	tomato.setIcon(tomatoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	tomato.setIcon(tomatoIcon);
		    }
		}
		);

potato.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	potato.setIcon(potatoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	potato.setIcon(potatoIcon);
		    }
		}
		);
rose.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	rose.setIcon(roseIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	rose.setIcon(roseIcon);
		    }
		}
		);
tulip.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	tulip.setIcon(tulipIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	tulip.setIcon(tulipIcon);
		    }
		}
		);
stargazer.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	stargazer.setIcon(sgIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	stargazer.setIcon(sgIcon);
		    }
		}
		);
sunflower.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	sunflower.setIcon(sunflowerIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	sunflower.setIcon(sunflowerIcon);
		    }
		}
		);
mango.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mango.setIcon(mangoIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mango.setIcon(mangoIcon);
		    }
		}
		);
apple.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	apple.setIcon(appleIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	apple.setIcon(appleIcon);
		    }
		}
		);
banana.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	banana.setIcon(bananaIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	banana.setIcon(bananaIcon);
		    }
		}
		);
orange.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	orange.setIcon(orangeIconhov);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	orange.setIcon(orangeIcon);
		    }
		}
		);
fertilizer.addMouseListener(new java.awt.event.MouseAdapter() { //hover "animation"
    public void mouseEntered(java.awt.event.MouseEvent evt) {
    	fertilizer.setIcon(fertilizerIconhov);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
    	fertilizer.setIcon(fertilizerIcon);
    }
}
);

	}
}
