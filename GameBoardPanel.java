import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel
{
	private BufferedImage image;
	
	public GameBoardPanel()
	{
		//Dimension size = getPreferredSize();
		//size.width = 250;
		//size.height = 300;
		//setPreferredSize(size);
		//this.setBackground(Color.BLUE);
		
		setBorder(BorderFactory.createTitledBorder("GameBoard"));
		this.setBackground(Color.WHITE);
		
	    try {                
	           image = ImageIO.read(new File("D:/Senior Year Semester 2/Capstone/Pixel Art/boardPanel.png"));
	        } catch (IOException ex) {
	             // handle exception...
	        }
		
	}
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	 }
	
	
}
