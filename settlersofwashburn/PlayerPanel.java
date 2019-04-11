package settlersofwashburn;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

    private BufferedImage image;
    URL playerPanelArt = getClass().getResource("playerPanel.png");
    public PlayerPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        size.height = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Players"));
        try {
            image = ImageIO.read(new File(playerPanelArt.getPath()));
        } catch (IOException ex) {
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
    }

}
