import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PlayerHandPanel extends JPanel
{
	private FlowLayout phlayout;
	private ResPanel buildPanel;
	
	private ResPanel wheatPanel;
	private ResPanel brickPanel;
	private ResPanel orePanel;
	private ResPanel sheepPanel;
	private ResPanel treePanel;
	
	private ResPanel vpPanel;
	
	private BufferedImage image;
	
	
	public PlayerHandPanel()
	{
		
		

		
		Dimension size = getPreferredSize();
		Dimension psize = new Dimension();
		size.height = 150;
		setPreferredSize(size);
		setBackground(Color.LIGHT_GRAY);

		phlayout = new FlowLayout(FlowLayout.LEFT);
		this.setLayout(phlayout);
		//setBorder(new EmptyBorder(0,0,10,0));
		
		//this.setAlignment(FlowLayout.LEFT);
		
		
		
	
////////////////////BUILD PANEL CONFIGURATION/////////////////////////////////
		
		Dimension bsize = new Dimension();
		buildPanel = new ResPanel("","D:/Senior Year Semester 2/Capstone/Pixel Art/Build_Button.png");
		buildPanel.hideLabel();
		bsize.height = 150;
		bsize.width = 300;
		buildPanel.setPreferredSize(bsize);
		buildPanel.setBackground(Color.MAGENTA);
		
		this.add(buildPanel);
		 
/////////////////////RESOURCE CONFIGURATIONS//////////////////////////////////
		
		size.height = 150;
		size.width = 150;
		
		vpPanel = new ResPanel("VP","D:/Senior Year Semester 2/Capstone/Pixel Art/vicPoints.png");
		wheatPanel = new ResPanel("Wheat","D:/Senior Year Semester 2/Capstone/Pixel Art/wheat.png");
		brickPanel = new ResPanel("Brick","D:/Senior Year Semester 2/Capstone/Pixel Art/brick.png");
		orePanel = new ResPanel("Ore","D:/Senior Year Semester 2/Capstone/Pixel Art/Ore.png");
		sheepPanel = new ResPanel("Sheep","D:/Senior Year Semester 2/Capstone/Pixel Art/sheep.png");
		treePanel = new ResPanel("Wood","D:/Senior Year Semester 2/Capstone/Pixel Art/wood.png");
		
		wheatPanel.setBackground(Color.YELLOW);
		brickPanel.setBackground(Color.RED);
		orePanel.setBackground(Color.CYAN);
		sheepPanel.setBackground(Color.WHITE);
		treePanel.setBackground(Color.GREEN);
		
		vpPanel.setPreferredSize(size);
		wheatPanel.setPreferredSize(size);;
		brickPanel.setPreferredSize(size);
		orePanel.setPreferredSize(size);
		sheepPanel.setPreferredSize(size);
		treePanel.setPreferredSize(size);
		
				
		this.add(vpPanel);
		this.add(wheatPanel);
		this.add(brickPanel);
		this.add(orePanel);
		this.add(sheepPanel);
		this.add(treePanel);
		
		setBorder(new EmptyBorder(0,0,10,0));
		//setBorder(BorderFactory.createTitledBorder("Player Hand"));
		
	       try {                
	           image = ImageIO.read(new File("D:/Senior Year Semester 2/Capstone/Pixel Art/phand.png"));
	        } catch (IOException ex) {
	             // handle exception...
	        }
	     }
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	 }
	
}
	 

