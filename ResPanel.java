package settlersofwashburn;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResPanel extends JPanel
	{
		JLabel resCtr;
		int Ctr;
                String title;
		
		public ResPanel(String title, String path)
		{
                        this.title=title;
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
			resCtr.setText(title+" "+Ctr);
		}
		
		public void subCtr()
		{
			Ctr--;
			resCtr.setText(title+" "+Ctr);
		}
			
	}
