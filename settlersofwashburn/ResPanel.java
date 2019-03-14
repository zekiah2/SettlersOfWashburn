package settlersofwashburn;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResPanel extends JPanel
	{
		JLabel resCtr;
		int Ctr;
                String title;
		
		public ResPanel(String title)
		{
                        this.title=title;
			Ctr = 0;
			resCtr = new JLabel(title + " " + Ctr);
			this.add(resCtr);
			
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
