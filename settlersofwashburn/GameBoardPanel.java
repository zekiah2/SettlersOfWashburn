package settlersofwashburn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.*;

public class GameBoardPanel extends JPanel {

    private Client client;
    public Board board;
    private BufferedImage image;

    public GameBoardPanel(Client client) {
		//Dimension size = getPreferredSize();
        //size.width = 250;
        //size.height = 300;
        //setPreferredSize(size);
        //this.setBackground(Color.BLUE);
        URL playerPanelArt = getClass().getResource("playerPanel.png");
        this.client = client;
        board = new Board(this.client);
        board.setBackground(new Color(0,128,192));
        Dimension d = new Dimension(800, 750);
        board.setPreferredSize(d);
        add(board);
        setBorder(BorderFactory.createTitledBorder("GameBoard"));
        this.setBackground(Color.WHITE);
        try {
            image = ImageIO.read(new File(playerPanelArt.getPath()));
        } catch (IOException ex) {
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
