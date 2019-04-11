package settlersofwashburn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlayerHandPanel extends JPanel
{
	private FlowLayout phlayout;
	private ResPanel buildPanel;
	private Client client;
	public ResPanel grainPanel;
	public ResPanel brickPanel;
	public ResPanel orePanel;
	public ResPanel woolPanel;
	public ResPanel lumberPanel;
        public JPanel buttonPanel;	
	public ResPanel vpPanel;
        public JButton nextTurn;
        private BufferedImage image;
	
	
	public PlayerHandPanel()
	{
                URL buildButtonArt = getClass().getResource("Build_Button.png");
                URL VPArt = getClass().getResource("vicPoints.png");
                URL wheatPanelArt = getClass().getResource("wheat.png");
                URL brickPanelArt = getClass().getResource("brick.png");
                URL orePanelArt = getClass().getResource("Ore.png");
                URL woolPanelArt = getClass().getResource("sheep.png");
                URL lumberPanelArt = getClass().getResource("wood.png");
                URL playerHandPanelArt = getClass().getResource("phand.png");
                this.client = client;
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
		
                buildPanel = new ResPanel("",buildButtonArt.getPath());
                buildPanel.hideLabel();
		Dimension bsize = new Dimension();
		bsize.height = 150;
		bsize.width = 300;
		buildPanel.setPreferredSize(bsize);
		buildPanel.setBackground(Color.MAGENTA);
		
		this.add(buildPanel);
		
/////////////////////RESOURCE CONFIGURATIONS//////////////////////////////////
		
		size.height = 150;
		size.width = 150;
		
                vpPanel = new ResPanel("VP",VPArt.getPath());
		grainPanel = new ResPanel("Grain",wheatPanelArt.getPath());
		brickPanel = new ResPanel("Brick",brickPanelArt.getPath());
		orePanel = new ResPanel("Ore",orePanelArt.getPath());
		woolPanel = new ResPanel("Wool",woolPanelArt.getPath());
		lumberPanel = new ResPanel("Lumber",lumberPanelArt.getPath());
                
		//vpPanel = new ResPanel("VP");
		//grainPanel = new ResPanel("Grain");
		//brickPanel = new ResPanel("Brick");
		//orePanel = new ResPanel("Ore");
		//woolPanel = new ResPanel("Wool");
		//lumberPanel = new ResPanel("Lumber");
                buttonPanel = new JPanel();
		nextTurn = new JButton("End Turn");
                
		grainPanel.setBackground(Color.YELLOW);
		brickPanel.setBackground(Color.ORANGE.darker());
		orePanel.setBackground(Color.GRAY);
		woolPanel.setBackground(Color.GREEN);
		lumberPanel.setBackground(Color.GREEN.darker().darker());
		
		vpPanel.setPreferredSize(size);
		grainPanel.setPreferredSize(size);
		brickPanel.setPreferredSize(size);
		orePanel.setPreferredSize(size);
		woolPanel.setPreferredSize(size);
		lumberPanel.setPreferredSize(size);
		
		buttonPanel.add(nextTurn);
                buttonPanel.setBackground(new Color(188,90,50));
		this.add(vpPanel);
		this.add(grainPanel);
		this.add(brickPanel);
		this.add(orePanel);
		this.add(woolPanel);
		this.add(lumberPanel);
                this.add(buttonPanel);
		
                
		setBorder(new EmptyBorder(0,0,10,0));
		//setBorder(BorderFactory.createTitledBorder("Player Hand"));
                try {                
	           image = ImageIO.read(new File(playerHandPanelArt.getPath()));
	        } catch (IOException ex) {
	             // handle exception...
	        }
        }
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
	 }
         
	}
