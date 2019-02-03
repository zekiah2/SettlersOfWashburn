package SettlersOfWashburn;


import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ChatServer
{
  private ArrayList<PrintWriter> writers;

  public ChatServer()
  {
    try
    {
      writers=new ArrayList<PrintWriter>();
      ServerSocket ss=new ServerSocket(5025);
      while(true)
      {
        Socket s=ss.accept();
        System.out.println("connected");
        Worker w=new Worker(s);
        w.start();
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }

  private class Worker extends Thread
  {
    private Socket s;
    private String name;
    private PrintWriter out;

    public Worker(Socket s)
    {
      this.s=s;
    }

    public void run()
    {
      try
      {
        BufferedReader in=new BufferedReader(
               new InputStreamReader(s.getInputStream()));
        out=new PrintWriter(s.getOutputStream(),true);
        String line;
        name=in.readLine();
        synchronized(writers)
        {
          writers.add(out);
          for(int i=0;i<writers.size();i++)
          {
            writers.get(i).println(name+" has joined the chat");
          }
        }
        System.out.println(name+" has joined the chat");
        while((line=in.readLine())!=null)
        {
          synchronized(writers)
          {
            for(int i=0;i<writers.size();i++)
            {
              writers.get(i).println(name+": "+line);
            }
          }
          System.out.println(name+": "+line);
        }
        s.close();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
      synchronized(writers)
      {
        writers.remove(out);
        for(int i=0;i<writers.size();i++)
        {
          writers.get(i).println(name+" has left the chat");
        }
      }
      System.out.println(name+" has left the chat");
    }
  }
}

