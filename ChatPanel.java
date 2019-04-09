package settlersofwashburn;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class ChatPanel extends JPanel
{
    JTextArea Chat= new JTextArea(); 
    public JButton sendButton;
    public JTextField messageField;
	public ChatPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Chat"));
        Chat.setPreferredSize(new Dimension(220, 500));
        Chat.setEditable(false);
        Chat.setLineWrap(true);
        add(new JScrollPane(Chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        JPanel bottomPanel = new JPanel();
        sendButton = new JButton("Send");
        sendButton.setEnabled(true);
        messageField = new JTextField(15);
        bottomPanel.add(messageField);
        bottomPanel.add(sendButton);
        add(bottomPanel);

	    try {                
	           image = ImageIO.read(new File("File_Path"));
	        } catch (IOException ex) {
	             // handle exception...
	        }

	}
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	 }
	
}
