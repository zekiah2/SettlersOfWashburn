package settlersofwashburn;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel
{
	public PlayerPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		size.height = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Players"));
		try {
			image = ImageIO.read(new File("file_path"));
		} catch (IOException ex) {
			// handle exception...
		}
		
	}
	
		protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

}
