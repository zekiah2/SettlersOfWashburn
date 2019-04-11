package settlersofwashburn;

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
                String title;
                BufferedImage image;
		
		public ResPanel(String title,String path)
		{
                        this.title=title;
			Ctr = 0;
			resCtr = new JLabel(title + " " + Ctr);
			this.add(resCtr);
                        try{
	                image = ImageIO.read(new File(path));	
                        }
                        catch(Exception e){}
			
		}
                protected void paintComponent(Graphics g) 	
		    	{	                
			        super.paintComponent(g);		
			        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);				
			}
		public int getCtr(){
                    return Ctr;
                }
		public void addCtr()
		{
			Ctr++;
			resCtr.setText(title+" "+Ctr);
		}
		
		public void subCtr()
		{
			Ctr--;
			resCtr.setText(title+" "+Ctr);
		}
		public void hideLabel()		
			{		
				resCtr.setVisible(false);
			}
	}
