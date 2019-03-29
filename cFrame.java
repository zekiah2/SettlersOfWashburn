package settlersofwashburn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
 * 
 * Main frame for the game
 * 
 * 
 * 
 */
public class cFrame extends JFrame
{
	//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JPanel redPanel = new JPanel();
	JPanel bluePanel = new JPanel();
	JPanel greenPanel= new JPanel();
	BorderLayout layout = new BorderLayout();
	
	public PlayerPanel playerPanel;
	public ChatPanel chatPanel;
	public GameBoardPanel gbPanel;
	public PlayerHandPanel phPanel;
	
	public cFrame(String title)
	{
		
		playerPanel = new PlayerPanel();
		chatPanel = new ChatPanel();
		gbPanel = new GameBoardPanel();
		phPanel = new PlayerHandPanel();
		
		//Dimension bsize = getPreferredSize();
		//bsize.width = 250;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(title);
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		
		
		Dimension screenSize = new Dimension();
		screenSize.height=1025;
		screenSize.width=1400;
		this.setSize(screenSize);
		this.setLayout(layout);
		this.setResizable(false);
		
		redPanel.setBackground(Color.RED);
		bluePanel.setBackground(Color.BLUE);
		greenPanel.setBackground(Color.GREEN);
		
		this.add(gbPanel, layout.CENTER);
		
		
		JPanel subWestPanel = new JPanel();
		subWestPanel.setLayout(new BorderLayout());
			subWestPanel.add(playerPanel, BorderLayout.NORTH);
			subWestPanel.add(chatPanel, BorderLayout.CENTER);
			this.add(subWestPanel, layout.WEST);
			
		this.add(phPanel, layout.SOUTH);
		
		
		/*TODO Custom Panels for each of the different components of the game 
		 	*--Player Panel (UPPER LEFT)
		 	*--Chat Panel (LEFT)
		 	*--Build Menu button + Popout panel (BOTTOM LEFT for the button)
		 	* --Player Hand Panel (BOTTOM)
		 	* --Game Board Panel (CENTER)
		 */
		
		
		this.show();
	}
}