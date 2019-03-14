package settlersofwashburn;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class GameBoardPanel extends JPanel
{
    public Board board;
	public GameBoardPanel()
	{
		//Dimension size = getPreferredSize();
		//size.width = 250;
		//size.height = 300;
		//setPreferredSize(size);
		//this.setBackground(Color.BLUE);
		board = new Board();
		Dimension d = new Dimension(800, 750);
		board.setPreferredSize(d);
		add(board);
		setBorder(BorderFactory.createTitledBorder("GameBoard"));
		this.setBackground(Color.WHITE);
		
	}
}
