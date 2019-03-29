package settlersofwashburn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlayerHandPanel extends JPanel
{
	private FlowLayout phlayout;
	private JPanel buildPanel;
	private Client client;
	public ResPanel grainPanel;
	public ResPanel brickPanel;
	public ResPanel orePanel;
	public ResPanel woolPanel;
	public ResPanel lumberPanel;
        public JPanel buttonPanel;
	
	private ResPanel vpPanel;
        public JButton nextTurn;
	
	
	public PlayerHandPanel()
	{
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
		
		Dimension bsize = new Dimension();
		buildPanel = new JPanel();
		bsize.height = 150;
		bsize.width = 300;
		buildPanel.setPreferredSize(bsize);
		buildPanel.setBackground(Color.MAGENTA);
		
		this.add(buildPanel);
		
/////////////////////RESOURCE CONFIGURATIONS//////////////////////////////////
		
		size.height = 150;
		size.width = 150;
		
		vpPanel = new ResPanel("VP");
		grainPanel = new ResPanel("Grain");
		brickPanel = new ResPanel("Brick");
		orePanel = new ResPanel("Ore");
		woolPanel = new ResPanel("Wool");
		lumberPanel = new ResPanel("Lumber");
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
		this.add(vpPanel);
		this.add(grainPanel);
		this.add(brickPanel);
		this.add(orePanel);
		this.add(woolPanel);
		this.add(lumberPanel);
                this.add(buttonPanel);
		
                
		setBorder(new EmptyBorder(0,0,10,0));
		//setBorder(BorderFactory.createTitledBorder("Player Hand"));
	}
}
