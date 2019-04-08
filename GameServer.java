package settlersofwashburn;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.JOptionPane;
import settlersofwashburn.Player;

public class GameServer {

    private ArrayList<Player> players;
    private boolean acceptingPlayers = true;

    public GameServer() {
        try {
            players = new ArrayList<Player>();
            ServerSocket ss = new ServerSocket(5025);
            while (acceptingPlayers && players.size() <= 4) {
                Socket s = ss.accept();
                System.out.println("connected");
                Worker w = new Worker(s);
                w.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private class Worker extends Thread {

        private Socket s;
        private String name;
        private PrintWriter out;
        private Player player;

        public Worker(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(s.getInputStream()));
                name = in.readLine();
                player = new Player(new PrintWriter(s.getOutputStream(), true), name);
                String line;
                synchronized (players) {
                    players.add(player);
                    for (int i = 0; i < players.size(); i++) {
                        players.get(i).getPrintWriter().println(name + " has joined the chat");
                    }
                }
                System.out.println(name + " has joined the chat");
                while ((line = in.readLine()) != null) {
                    synchronized (players) {
                        for (int i = 0; i < players.size(); i++) {
                            if (line.startsWith("/")) {
                                if (line.startsWith("/start")) {
                                    if (players.size() >= 3 && players.size() <= 4) {
                                        acceptingPlayers = false;
                                        synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).getPrintWriter().println((String)"/start "+players.size());
                                            }
                                        }
                                        synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).setColor(i);
                                            }
                                        }
                                        synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                for (int k = 0; k < players.size(); k++) {
                                                    players.get(i).getPrintWriter().println(players.get(k).getName() + " has been assigned " + players.get(k).getColorString());
                                                }
                                            }
                                        }
                                        synchronized (players){
                                            for(i=0;i < players.size();i++){
                                               if(players.get(i).getColorString().equals("white")){
                                                   players.get(i).hand.addCard(new Card(Card.WOOL));
                                                   players.get(i).getPrintWriter().println("/addCard wool");
                                                   players.get(i).hand.addCard(new Card(Card.ORE));
                                                   players.get(i).getPrintWriter().println("/addCard ore");
                                                   players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                   players.get(i).getPrintWriter().println("/addCard lumber");
                                               } 
                                               if(players.get(i).getColorString().equals("orange")){
                                                   players.get(i).hand.addCard(new Card(Card.WOOL));
                                                   players.get(i).getPrintWriter().println("/addCard wool");
                                                   players.get(i).hand.addCard(new Card(Card.GRAIN));
                                                   players.get(i).getPrintWriter().println("/addCard grain");
                                                   players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                   players.get(i).getPrintWriter().println("/addCard lumber");
                                               } 
                                               if(players.get(i).getColorString().equals("blue")){
                                                   players.get(i).hand.addCard(new Card(Card.WOOL));
                                                   players.get(i).getPrintWriter().println("/addCard wool");
                                                   players.get(i).hand.addCard(new Card(Card.ORE));
                                                   players.get(i).getPrintWriter().println("/addCard ore");
                                                   players.get(i).hand.addCard(new Card(Card.BRICK));
                                                   players.get(i).getPrintWriter().println("/addCard brick");
                                               } 
                                               if(players.get(i).getColorString().equals("red")){
                                                   players.get(i).hand.addCard(new Card(Card.WOOL));
                                                   players.get(i).getPrintWriter().println("/addCard wool");
                                                   players.get(i).hand.addCard(new Card(Card.GRAIN));
                                                   players.get(i).getPrintWriter().println("/addCard grain");
                                                   players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                   players.get(i).getPrintWriter().println("/addCard lumber");
                                               } 
                                            }
                                        }
                                    } else {
                                        players.get(i).getPrintWriter().println("You must have 3 players minumum and 4 players maximum to start a game");
                                    }
                                }
                                 else if (line.startsWith("/addCard")) 
                                {
                                    synchronized (players){
                                    String[] temp= line.split("\\s+");
                                    for(i=0;i<players.size();i++){
                                        if(players.get(i).getColorString().equals(temp[2])){
                                            players.get(i).getPrintWriter().println("/addCard "+temp[1]);
                                        }
                                    }    
                                    }
                                }
                                else if (line.equals("/help")) {
                                    players.get(i).getPrintWriter().println("/start NumOfPlayers: starts up a new game if the approperate number of players are in the lobby "
                                            + "and NumOfPlayers represents the number of players in the game");
                                    players.get(i).getPrintWriter().println("/addCard cardName playerColor: this command expects the name of the card followed by the color of the player you are adding the card to.");
                                } else {
                                    players.get(i).getPrintWriter().println(line + " Is not a recognized command type /help for a list of commands");
                                }
                            } 
                            else 
                            {
                                players.get(i).getPrintWriter().println(name + ": " + line);
                            }
                        }
                    }
                    System.out.println(name + ": " + line);
                }
                s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            synchronized (players) {
                players.remove(player);
                for (int i = 0; i < players.size(); i++) {
                    players.get(i).getPrintWriter().println(name + " has left the chat");
                }
            }
            System.out.println(name + " has left the chat");
        }
    }
}
