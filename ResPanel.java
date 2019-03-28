import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResPanel extends JPanel
{
		JLabel resCtr;
		int Ctr;
		private BufferedImage image;
		
		public ResPanel(String title, String path)
		{
			Ctr = 0;
			resCtr = new JLabel(title + " " + Ctr);
			this.add(resCtr);
			
		   
		   try {                
		          image = ImageIO.read(new File(path));
		       } catch (IOException ex) {
		            // handle exception...
		       }
		}


	    protected void paintComponent(Graphics g) 
	    {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this);
			
		}
		
		public void addCtr()
		{
			Ctr++;
			resCtr.setText(""+Ctr);
		}
		
		public void subCtr()
		{
			Ctr--;
			resCtr.setText(""+Ctr);
		}
		
		public void hideLabel()
		{
			resCtr.hide();
		}
}
