package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Constants.CropStatus;
import model.Constants.TileStatus;
import model.Tile;

/**
 * JPanel for the lot
 */

public class LotPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final ImageIcon grass = new ImageIcon("sprites/Grass.gif");
	private final ImageIcon plowed = new ImageIcon("sprites/Plowed.png");
	private final ImageIcon plowedWithSeed = new ImageIcon("sprites/PlowedWithSeed.png");
	private final ImageIcon rock = new ImageIcon("sprites/bato.png");
	private final ImageIcon max = new ImageIcon("sprites/grown.gif");
	private final ImageIcon deads = new ImageIcon("sprites/DEDZ.gif");
	private final ImageIcon watered = new ImageIcon("sprites/Watered.png");
	private final ImageIcon wateredSeed = new ImageIcon("sprites/WateredWithSeed.png");
	
	private ArrayList<JButton> tiles = new ArrayList<JButton>();
	private int tileChoice = -1;
	
    /**
     *
     */
    public LotPanel() {
		
		setLayout(new GridLayout(5, 10));
		setPreferredSize(new Dimension(500,250));
		setMinimumSize(new Dimension(500,250));
		setMaximumSize(new Dimension(500,250));
		setOpaque(false);
		
		for(int i=0;i<50;i++) {
				this.tiles.add(new JButton());
				this.tiles.get(i).addActionListener(this);
				this.tiles.get(i).setOpaque(false);
				this.tiles.get(i).setContentAreaFilled(false); 
				this.tiles.get(i).setBorderPainted(false); //does not paint border
				this.tiles.get(i).setFocusPainted(false); //removes the dotted lines when clicked
				
				add(tiles.get(i));
				
			}
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<this.tiles.size();i++)
			if((JButton)e.getSource() == this.tiles.get(i)) {
				this.tileChoice = i;
			}
	}
	
    /**
     *
     * @return
     */
    public int getTileChoice() {
		return this.tileChoice;
	}
	 
    /**
     *
     * @param choice
     */
    public void setChoice(int choice) {
		this.tileChoice = choice;
	}
	
    /**
     *
     * @param index
     * @param tile
     */
    public void updateTileIcon(int index, Tile tile) {
		if(tile.getStatus().equals(TileStatus.GRASS))
			this.tiles.get(index).setIcon(grass);
		else if(tile.getStatus().equals(TileStatus.ROCK))
			this.tiles.get(index).setIcon(rock);
		else if(tile.getStatus().equals(TileStatus.PLANTED) && tile.getCrop() != null && tile.getWater()==0 && tile.getCrop().getStatus().equals(CropStatus.WAITING))
			this.tiles.get(index).setIcon(plowedWithSeed);
		else if(tile.getStatus().equals(TileStatus.PLANTED) && tile.getCrop() != null && tile.getCrop().getStatus().equals(CropStatus.READY))
			this.tiles.get(index).setIcon(max);
		else if(tile.getStatus().equals(TileStatus.PLANTED) && tile.getCrop() != null && tile.getCrop().getStatus().equals(CropStatus.DEAD))
			this.tiles.get(index).setIcon(deads);
		else if(tile.getStatus().equals(TileStatus.EMPTY) && tile.getWater()>0 )
			this.tiles.get(index).setIcon(watered);
		else if(tile.getStatus().equals(TileStatus.EMPTY))
			this.tiles.get(index).setIcon(plowed);
		else if(tile.getStatus().equals(TileStatus.PLANTED)&& tile.getCrop() != null && tile.getCrop().getStatus().equals(CropStatus.WAITING))
			this.tiles.get(index).setIcon(wateredSeed);
	}
	
	
}