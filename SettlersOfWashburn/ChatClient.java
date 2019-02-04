package SettlersOfWashburn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;

public class ChatClient extends JFrame
{
  private JTextField messageField;
  private JTextArea chatTA;
  private JButton sendButton;
  private JButton quitButton;
  private JButton startButton;
  private PrintWriter out;
  private BufferedReader in;
  private JTextArea playersTA;
  private JPanel buttonPanel;
  private  GridBagConstraints gbc= new GridBagConstraints();
  public ChatClient() throws java.net.BindException
  {
    this.setLayout(new GridBagLayout());
    ActionHandler ah=new ActionHandler();
    KeyHandler kh=new KeyHandler();

    JMenuBar jmb=new JMenuBar();
    setJMenuBar(jmb);


    JPanel mainPanel=new JPanel();
    gbc.gridx=0;
    gbc.gridy=0;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.fill = GridBagConstraints.VERTICAL;
    add(mainPanel,gbc);

    chatTA=new JTextArea();
    chatTA.setPreferredSize(new Dimension(600,500));
    chatTA.setEditable(false);
    chatTA.setLineWrap(true);
    mainPanel.add(new JScrollPane(chatTA
               ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
              ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

    JPanel bottomPanel=new JPanel();
    gbc.gridx=0;
    gbc.gridy=2;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.fill = GridBagConstraints.VERTICAL;
    add(bottomPanel,gbc);
    
    messageField=new JTextField(50);
    messageField.addKeyListener(kh);
    bottomPanel.add(messageField);

    sendButton=new JButton("Send");
    sendButton.setEnabled(true);
    sendButton.addActionListener(ah);
    bottomPanel.add(sendButton);
    
    playersTA= new JTextArea();
    playersTA.setPreferredSize(new Dimension(200,200));
    playersTA.setEditable(false);
    gbc.gridx=1;
    gbc.gridy=0;
    gbc.gridwidth=1;
    gbc.gridheight=2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.PAGE_START;
    add(playersTA,gbc);

    buttonPanel= new JPanel();
    buttonPanel.add(quitButton = new JButton("Quit"));
    buttonPanel.add(quitButton = new JButton("Start"));
    gbc.gridx=1;
    gbc.gridy=1;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.PAGE_END;
    add(buttonPanel,gbc);
       
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(850,650);
    setResizable(false);
    setVisible(true);
  }
  

   public void connect(String ip, String name){
              try
        {
          Socket s=new Socket("localhost",5025);
          out=new PrintWriter(s.getOutputStream(),true);
          out.println(name);
          in=new BufferedReader(new InputStreamReader(s.getInputStream()));
          new WorkerThread().start();
        }
        catch(IOException ioe) {System.out.println(ioe);}
  }
  private class ActionHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==sendButton)
      {
        out.println(messageField.getText());
        messageField.setText("");
      }
    }
  }

  private class WorkerThread extends Thread
  {
    public void run()
    {
      try
      {
        String line;
        while((line=in.readLine())!=null)
        {
          chatTA.append("\n"+line);
        }
      }
      catch(IOException ioe) {System.out.println(ioe);}
    }
  }

  private class KeyHandler extends KeyAdapter
  {
    public void keyTyped(KeyEvent e)
    {
      if(e.getKeyChar()==KeyEvent.VK_ENTER)
      {
        out.println(messageField.getText());
        messageField.setText("");
      }
    }
  }

  public static void main(String[] args)
  {
    try{
    new ChatClient();
      }
    catch(java.net.BindException e){}
  }
}

