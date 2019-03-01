package settlersofwashburn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Client extends JFrame
{
  String gameState= "lobby";
  LobbyFrame lobby;
  GameFrame game;
  private PrintWriter out;
  private BufferedReader in;
  public Client() throws java.net.BindException
  {
    lobby = new LobbyFrame();
    lobby.messageField.addKeyListener(new KeyHandler());
    lobby.sendButton.addActionListener(new ActionHandler());
    lobby.quitButton.addActionListener(new ActionHandler());
    lobby.startButton.addActionListener(new ActionHandler());
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


  private class WorkerThread extends Thread
  {
    public void run()
    {
      try
      {
        String line;
        while((line=in.readLine())!=null)
        {
            if(line.equals("/start"))
            {
                lobby.setVisible(false);
                game= new GameFrame();
                game.messageField.addKeyListener(new KeyHandler());
                game.sendButton.addActionListener(new ActionHandler());
                //game.chatTA.append("\n"+line);
                gameState= "game";
            }
            else
            {
                if(gameState.equals("lobby"))
                {
                lobby.chatTA.append("\n"+line);
                }
                else 
                {
                game.chatTA.append("\n"+line);   
                }
            }
        }
      }
      catch(IOException ioe) {System.out.println(ioe);}
    }
  }
    private class ActionHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==lobby.sendButton)
      {
        out.println(lobby.messageField.getText());
        lobby.messageField.setText("");
      }
      if(e.getSource()== lobby.startButton)
      {
        out.println("/start");  
      }
      if(e.getSource()== lobby.quitButton)
      {
          System.exit(0);
      }
      if(e.getSource() == game.sendButton)
      {
        out.println(game.messageField.getText());
        game.messageField.setText("");
      }
    }
  }
  private class KeyHandler extends KeyAdapter
  {
    public void keyTyped(KeyEvent e)
    {
      if(e.getKeyChar()==KeyEvent.VK_ENTER)
      {
        if(gameState.equals("lobby"))
        {
        out.println(lobby.messageField.getText());
        lobby.messageField.setText("");
        }
        if(gameState.equals("game"))
        {
        out.println(game.messageField.getText());
        game.messageField.setText("");
        }
      }
    }
  }
}

