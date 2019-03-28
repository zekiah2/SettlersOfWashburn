import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ChatPanel extends JPanel
{
	private BufferedImage image;
	public ChatPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Chat"));
		
		
	    try {                
	           image = ImageIO.read(new File("D:/Senior Year Semester 2/Capstone/Pixel Art/chatPanel.png"));
	        } catch (IOException ex) {
	             // handle exception...
	        }

	}
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	 }
	
}
