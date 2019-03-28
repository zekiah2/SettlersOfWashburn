import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	private BufferedImage image;

	public PlayerPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		size.height = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Players"));

		try {
			image = ImageIO.read(new File("D:/Senior Year Semester 2/Capstone/Pixel Art/playerPanel.png"));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

}
