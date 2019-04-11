package settlersofwashburn;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.JOptionPane;
import settlersofwashburn.Player;

public class GameServer {

    private ArrayList<Player> players;
    private boolean acceptingPlayers = true;
    private int firstPlayer;
    private Dice dice;

    public GameServer() {
        try {
            players = new ArrayList<Player>();
            ServerSocket ss = new ServerSocket(5025);
            System.out.println("Server Created");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client Accepted");
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
                                        dice = new Dice();                                  
                                       // synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).setColor(i);
                                            }
                                     //   }
                                       // synchronized (players) {
                                            Random r = new Random();
                                            firstPlayer = r.nextInt((players.size() - 1) + 0) + 0;
                                            for (i = 0; i < players.size(); i++) {
                                                if (players.get(i).getColorInt() == firstPlayer) {
                                                    players.get(i).getPrintWriter().println((String) "/start " + players.size() + " " + firstPlayer + " true");
                                                } else {
                                                    players.get(i).getPrintWriter().println((String) "/start " + players.size() + " " + firstPlayer + " false");
                                                }
                                            }
                                       // }

                                      //  synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                for (int k = 0; k < players.size(); k++) {
                                                    players.get(i).getPrintWriter().println(players.get(k).getName() + " has been assigned " + players.get(k).getColorString());
                                                    players.get(i).getPrintWriter().println("/addToPlayerList "+players.get(k).getName() + " " + players.get(k).getColorString());
                                                }
                                            }
                                            
                                      //  }
                                     //   synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).getPrintWriter().println("The first player will be " + players.get(firstPlayer).getName());
                                            }
                                       // }
                                       // synchronized (players) {
                                            for (i = 0; i < players.size(); i++) {
                                                if (players.get(i).getColorString().equals("white")) {
                                                    players.get(i).hand.addCard(new Card(Card.WOOL));
                                                    players.get(i).getPrintWriter().println("/addCard wool");
                                                    players.get(i).hand.addCard(new Card(Card.ORE));
                                                    players.get(i).getPrintWriter().println("/addCard ore");
                                                    players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                    players.get(i).getPrintWriter().println("/addCard lumber");
                                                }
                                                if (players.get(i).getColorString().equals("orange")) {
                                                    players.get(i).hand.addCard(new Card(Card.WOOL));
                                                    players.get(i).getPrintWriter().println("/addCard wool");
                                                    players.get(i).hand.addCard(new Card(Card.GRAIN));
                                                    players.get(i).getPrintWriter().println("/addCard grain");
                                                    players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                    players.get(i).getPrintWriter().println("/addCard lumber");
                                                }
                                                if (players.get(i).getColorString().equals("blue")) {
                                                    players.get(i).hand.addCard(new Card(Card.WOOL));
                                                    players.get(i).getPrintWriter().println("/addCard wool");
                                                    players.get(i).hand.addCard(new Card(Card.ORE));
                                                    players.get(i).getPrintWriter().println("/addCard ore");
                                                    players.get(i).hand.addCard(new Card(Card.BRICK));
                                                    players.get(i).getPrintWriter().println("/addCard brick");
                                                }
                                                if (players.get(i).getColorString().equals("red")) {
                                                    players.get(i).hand.addCard(new Card(Card.WOOL));
                                                    players.get(i).getPrintWriter().println("/addCard wool");
                                                    players.get(i).hand.addCard(new Card(Card.GRAIN));
                                                    players.get(i).getPrintWriter().println("/addCard grain");
                                                    players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                    players.get(i).getPrintWriter().println("/addCard lumber");
                                                }
                                            }
                                      //  }
                                    } else {
                                        players.get(i).getPrintWriter().println("You must have 3 players minumum and 4 players maximum to start a game");
                                    }
                                } else if (line.startsWith("/addCard")) {
                                  //  synchronized (players) {
                                        String[] temp = line.split("\\s+");
                                        for (i = 0; i < players.size(); i++) {
                                            if (players.get(i).getColorString().equals(temp[2])) {
                                                if (temp[1].equals("wool")) {
                                                    players.get(i).hand.addCard(new Card(Card.WOOL));
                                                }
                                                if (temp[1].equals("brick")) {
                                                    players.get(i).hand.addCard(new Card(Card.BRICK));
                                                }
                                                if (temp[1].equals("grain")) {
                                                    players.get(i).hand.addCard(new Card(Card.GRAIN));
                                                }
                                                if (temp[1].equals("lumber")) {
                                                    players.get(i).hand.addCard(new Card(Card.LUMBER));
                                                }
                                                if (temp[1].equals("ore")) {
                                                    players.get(i).hand.addCard(new Card(Card.ORE));
                                                }
                                                System.out.println("/addCard " + temp[1]);
                                                players.get(i).getPrintWriter().println("/addCard " + temp[1]);
                                            }
                                        }
                                   // }
                                } else if (line.equals("/nextTurn")) {
                                    if (firstPlayer != players.size() - 1) {
                                        firstPlayer++;
                                    } else {
                                        firstPlayer = 0;
                                    }
                                    int diceRoll = dice.roll();
                                  //  synchronized (players) {
                                        for (i = 0; i < players.size(); i++) {
                                            players.get(i).getPrintWriter().println("A " + diceRoll + " was rolled");
                                            if (players.get(i).getColorInt() == firstPlayer) {
                                                players.get(i).getPrintWriter().println((String) "/nextTurn " + firstPlayer + " " + diceRoll + " true");
                                            } else {
                                                players.get(i).getPrintWriter().println((String) "/nextTurn " + firstPlayer + " " + diceRoll + " false");
                                            }
                                        }
                                  //  }
                                  //  synchronized (players) {
                                        players.get(firstPlayer).getPrintWriter().println("/assignResources " + diceRoll);
                                  //  }
                                } else if (line.startsWith("/purchaseSettlement")) {
                                    boolean canBuild = false;
                                    String[] temp = line.split("\\s+");
                                   // synchronized (players) {
                                        if (temp[2].equals("white")) {
                                            if (players.get(0).hand.canBuildSettlement()) {
                                                canBuild = true;
                                                players.get(0).hand.removeCard(new Card(Card.BRICK));
                                                players.get(0).getPrintWriter().println("/removeResource brick");
                                                players.get(0).hand.removeCard(new Card(Card.WOOL));
                                                players.get(0).getPrintWriter().println("/removeResource wool");
                                                players.get(0).hand.removeCard(new Card(Card.GRAIN));
                                                players.get(0).getPrintWriter().println("/removeResource grain");
                                                players.get(0).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(0).getPrintWriter().println("/removeResource lumber");
                                                players.get(0).getPrintWriter().println("/addVictoryPoint");
                                            } else {
                                                players.get(0).getPrintWriter().println("/cantBuildSettlement");
                                            }
                                        }
                                        if (temp[2].equals("orange")) {
                                            if (players.get(1).hand.canBuildSettlement()) {
                                                canBuild = true;
                                                players.get(1).hand.removeCard(new Card(Card.BRICK));
                                                players.get(1).getPrintWriter().println("/removeResource brick");
                                                players.get(1).hand.removeCard(new Card(Card.WOOL));
                                                players.get(1).getPrintWriter().println("/removeResource wool");
                                                players.get(1).hand.removeCard(new Card(Card.GRAIN));
                                                players.get(1).getPrintWriter().println("/removeResource grain");
                                                players.get(1).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(1).getPrintWriter().println("/removeResource lumber");
                                                players.get(1).getPrintWriter().println("/addVictoryPoint");
                                            } else {
                                                players.get(1).getPrintWriter().println("/cantBuildSettlement");
                                            }
                                        }
                                        if (temp[2].equals("blue")) {
                                            if (players.get(2).hand.canBuildSettlement()) {
                                                canBuild = true;
                                                players.get(2).hand.removeCard(new Card(Card.BRICK));
                                                players.get(2).getPrintWriter().println("/removeResource brick");
                                                players.get(2).hand.removeCard(new Card(Card.WOOL));
                                                players.get(2).getPrintWriter().println("/removeResource wool");
                                                players.get(2).hand.removeCard(new Card(Card.GRAIN));
                                                players.get(2).getPrintWriter().println("/removeResource grain");
                                                players.get(2).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(2).getPrintWriter().println("/removeResource lumber");
                                                players.get(2).getPrintWriter().println("/addVictoryPoint");
                                            } else {
                                                players.get(2).getPrintWriter().println("/cantBuildSettlement");
                                            }
                                        }
                                        if (temp[2].equals("red")) {
                                            if (players.get(3).hand.canBuildSettlement()) {
                                                canBuild = true;
                                                players.get(3).hand.removeCard(new Card(Card.BRICK));
                                                players.get(3).getPrintWriter().println("/removeResource brick");
                                                players.get(3).hand.removeCard(new Card(Card.WOOL));
                                                players.get(3).getPrintWriter().println("/removeResource wool");
                                                players.get(3).hand.removeCard(new Card(Card.GRAIN));
                                                players.get(3).getPrintWriter().println("/removeResource grain");
                                                players.get(3).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(3).getPrintWriter().println("/removeResource lumber");
                                                players.get(3).getPrintWriter().println("/addVictoryPoint");
                                            } else {
                                                players.get(3).getPrintWriter().println("/cantBuildSettlement");
                                            }
                                        }
                                        if (canBuild) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).getPrintWriter().println(line);
                                            }
                                        }
                                  //  }
                                } else if (line.startsWith("/purchaseRoad")) {
                                    boolean canBuild = false;
                                    String[] temp = line.split("\\s+");
                                //    synchronized (players) {
                                        if (temp[2].equals("white")) {
                                            if (players.get(0).hand.canBuildRoad()) {
                                                canBuild = true;
                                                players.get(0).hand.removeCard(new Card(Card.BRICK));
                                                
                                                players.get(0).getPrintWriter().println("/removeResource brick");
                                                players.get(0).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(0).getPrintWriter().println("/removeResource lumber");
                                            } else {
                                                
                                                players.get(0).getPrintWriter().println("/cantBuildRoad");
                                            }
                                        }
                                        if (temp[2].equals("orange")) {
                                            if (players.get(1).hand.canBuildRoad()) {
                                                canBuild = true;
                                                players.get(1).hand.removeCard(new Card(Card.BRICK));
                                                players.get(1).getPrintWriter().println("/removeResource brick");
                                                players.get(1).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(1).getPrintWriter().println("/removeResource lumber");
                                            } else {
                                                players.get(1).getPrintWriter().println("/cantBuildRoad");
                                            }
                                        }
                                        if (temp[2].equals("blue")) {
                                            if (players.get(2).hand.canBuildRoad()) {
                                                canBuild = true;
                                                players.get(2).hand.removeCard(new Card(Card.BRICK));
                                                players.get(2).getPrintWriter().println("/removeResource brick");
                                                players.get(2).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(2).getPrintWriter().println("/removeResource lumber");
                                            } else {  
                                                players.get(2).getPrintWriter().println("/cantBuildRoad");
                                            }
                                        }
                                        if (temp[2].equals("red")) {
                                            canBuild = true;
                                            if (players.get(3).hand.canBuildRoad()) {
                                                players.get(3).hand.removeCard(new Card(Card.BRICK));
                                                players.get(3).getPrintWriter().println("/removeResource brick");
                                                players.get(3).hand.removeCard(new Card(Card.LUMBER));
                                                players.get(3).getPrintWriter().println("/removeResource lumber");
                                            } else {
                                                players.get(3).getPrintWriter().println("/cantBuildRoad");
                                            }
                                        }
                                        if (canBuild) {
                                            for (i = 0; i < players.size(); i++) {
                                                players.get(i).getPrintWriter().println(line);
                                            }
                                        }
                            //        }
                                } else if (line.startsWith("/endGame")) {
                                    String[] temp = line.split("\\s+");
                                    for (i = 0; i < players.size(); i++) {
                                        players.get(i).getPrintWriter().println("/endGame " + players.get(Integer.parseInt(temp[1])).getName());
                                    }
                                } else if (line.startsWith("/tradeAccepted")) {
                                    String[] temp = line.split("\\~+");
                                    String player1 = temp[0];
                                    String player2 = temp[1];
                                    String[] player1Split = player1.split("\\s+");
                                    String[] player2Split = player2.split("\\s+");
                                 //   synchronized (players) {
                                        for (int x = 2; x < player1Split.length; x = x + 2) {
                                            for (int y = 0; y < Integer.parseInt(player1Split[x + 1]); y++) {
                                                if (player1Split[x].equals("grain")) {
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.removeCard(new Card(Card.GRAIN));
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.addCard(new Card(Card.GRAIN));
                                                }
                                                if (player1Split[x].equals("brick")) {
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.removeCard(new Card(Card.BRICK));
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.addCard(new Card(Card.BRICK));
                                                }
                                                if (player1Split[x].equals("lumber")) {
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.removeCard(new Card(Card.LUMBER));
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.addCard(new Card(Card.LUMBER));
                                                }
                                                if (player1Split[x].equals("ore")) {
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.removeCard(new Card(Card.ORE));
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.addCard(new Card(Card.ORE));
                                                }
                                                if (player1Split[x].equals("wool")) {
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.removeCard(new Card(Card.WOOL));
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.addCard(new Card(Card.WOOL));
                                                }
                                                players.get(player.colorStringToInt(player1Split[1])).getPrintWriter().println("/removeResource " + player1Split[x]);
                                                players.get(player.colorStringToInt(player2Split[0])).getPrintWriter().println("/addCard " + player1Split[x]);
                                            }
                                        }

                                        for (int x = 1; x < player2Split.length; x = x + 2) {
                                            for (int y = 0; y < Integer.parseInt(player2Split[x + 1]); y++) {
                                                if (player1Split[x].equals("grain")) {
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.removeCard(new Card(Card.GRAIN));
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.addCard(new Card(Card.GRAIN));
                                                }
                                                if (player1Split[x].equals("brick")) {
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.removeCard(new Card(Card.BRICK));
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.addCard(new Card(Card.BRICK));
                                                }
                                                if (player1Split[x].equals("lumber")) {
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.removeCard(new Card(Card.LUMBER));
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.addCard(new Card(Card.LUMBER));
                                                }
                                                if (player1Split[x].equals("ore")) {
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.removeCard(new Card(Card.ORE));
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.addCard(new Card(Card.ORE));
                                                }
                                                if (player1Split[x].equals("wool")) {
                                                    players.get(player.colorStringToInt(player2Split[0])).hand.removeCard(new Card(Card.WOOL));
                                                    players.get(player.colorStringToInt(player1Split[1])).hand.addCard(new Card(Card.WOOL));
                                                }
                                                players.get(player.colorStringToInt(player2Split[0])).getPrintWriter().println("/removeResource " + player1Split[x]);
                                                players.get(player.colorStringToInt(player1Split[1])).getPrintWriter().println("/addCard " + player1Split[x]);
                                            }
                                        }
                                  //  }

                                } else if (line.startsWith("/tradeDeclined")) {
                                    String[] temp = line.split("\\~+");
                                    String player1 = temp[0];
                                    String player2 = temp[1];
                                    String[] player1Split = player1.split("\\s+");
                                    String[] player2Split = player2.split("\\s+");
                                    players.get(player.colorStringToInt(player1Split[1])).getPrintWriter().println("/tradeDeclined");
                                } else if (line.startsWith("/trade")) {
                                    boolean tradePossible = true;
                                    String[] temp = line.split("\\~+");
                                    String player1 = temp[0];
                                    String player2 = temp[1];
                                    String[] player1Split = player1.split("\\s+");
                                    String[] player2Split = player2.split("\\s+");
                                  //  synchronized (players) {
                                        for (int x = 2; x < player1Split.length; x = x + 2) {
                                            System.out.println("player "+player1Split[1]);
                                            System.out.println("player int "+player.colorStringToInt(player1Split[1]));
                                            System.out.println("resource needed "+player1Split[x]+" ammount needed "+player1Split[x+1]);
                                            System.out.println("The player has the resource "+players.get(player.colorStringToInt(player1Split[1])).hand.hasResources(player1Split[x], Integer.parseInt(player1Split[x + 1])));
                                                if (!players.get(player.colorStringToInt(player1Split[1])).hand.hasResources(player1Split[x], Integer.parseInt(player1Split[x + 1]))) {
                                                    tradePossible = false;
                                                }
                                            System.out.println("Trade Possible? "+tradePossible);
                                        }
                                        for (int x = 1; x < player2Split.length; x = x + 2) {
                                            System.out.println("player "+player2Split[0]);
                                            System.out.println("player int "+player.colorStringToInt(player2Split[0]));
                                            System.out.println("resource needed "+player2Split[x]+" ammount needed "+player2Split[x+1]);
                                            System.out.println("The player has the resource "+players.get(player.colorStringToInt(player2Split[0])).hand.hasResources(player2Split[x], Integer.parseInt(player2Split[x + 1])));             
                                                if (!players.get(player.colorStringToInt(player2Split[0])).hand.hasResources(player2Split[x], Integer.parseInt(player2Split[x + 1]))) {
                                                    tradePossible = false;
                                                }
                                            System.out.println("Trade Possible? "+tradePossible);
                                        }
                                        if (tradePossible == true) {
                                                System.out.println(line);
                                                System.out.println("player getting trade "+player.colorStringToInt(player2Split[0]));
                                                players.get(player.colorStringToInt(player2Split[0])).getPrintWriter().println(line);                                           
                                        } else {
                                                players.get(player.colorStringToInt(player1Split[1])).getPrintWriter().println("/tradeFailed");
                                            }                                        
                                      //  }                                   
                                } else if (line.equals("/help")) {
                                    players.get(i).getPrintWriter().println("/start NumOfPlayers: starts up a new game if the approperate number of players are in the lobby "
                                            + "and NumOfPlayers represents the number of players in the game");
                                    players.get(i).getPrintWriter().println("/addCard cardName playerColor: this command expects the name of the card followed by the color of the player you are adding the card to.");
                                } else {
                                    players.get(i).getPrintWriter().println(line + " Is not a recognized command type /help for a list of commands");
                                }
                            } else {
                                players.get(i).getPrintWriter().println(name + ": " + line);
                            }
                        }
                    }
                    System.out.println(name + ": " + line);
                }
                s.close();
            } catch (Exception e) {
                System.out.println("Server Issue \n" +e+"\n"+ e.getCause());
                e.printStackTrace();
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
