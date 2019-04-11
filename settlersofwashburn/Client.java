package settlersofwashburn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Client extends JFrame {

    int n;
    int currentPlayer ;
    Client thisClient = this;
    String gameState = "lobby";
    LobbyFrame lobby;
    private cFrame game;
    private PrintWriter out;
    private BufferedReader in;
    boolean gamestarted=false;

    public Client() throws java.net.BindException {
        lobby = new LobbyFrame();
        lobby.messageField.addKeyListener(new KeyHandler());
        lobby.sendButton.addActionListener(new ActionHandler());
        lobby.quitButton.addActionListener(new ActionHandler());
        lobby.startButton.addActionListener(new ActionHandler());
    }

    public void connect(String ip, String name) {
        try {
            Socket s = new Socket("localhost", 5025);
            System.out.println("Client Connected");
            out = new PrintWriter(s.getOutputStream(), true);
            out.println(name);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            new WorkerThread().start();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private class WorkerThread extends Thread {

        public void run() {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                  //  if(gamestarted==true){game.chatPanel.Chat.append("\n Command Received: "+line);}
                    if (line.startsWith("/start")) {
                        lobby.setVisible(false);
                        gamestarted=true;
                        game = new cFrame("Settlers Of Washburn", thisClient);
                        game.chatPanel.messageField.addKeyListener(new KeyHandler());
                        game.chatPanel.sendButton.addActionListener(new ActionHandler());
                        game.phPanel.nextTurn.addActionListener(new ActionHandler());
                        //game.chatTA.append("\n"+line);
                        gameState = "game";
                        game.gbPanel.board.pointArray[12].setSettlementColor(Color.WHITE);
                        game.gbPanel.board.pointArray[12].setOwner(Player.WHITE);
                        game.gbPanel.board.sideArray[12].setColor(Color.WHITE);
                        game.gbPanel.board.sideArray[12].setOwner(Player.WHITE);
                        game.gbPanel.board.pointArray[41].setSettlementColor(Color.WHITE);
                        game.gbPanel.board.pointArray[41].setOwner(Player.WHITE);
                        game.gbPanel.board.sideArray[59].setColor(Color.WHITE);
                         game.gbPanel.board.sideArray[59].setOwner(Player.WHITE);
                        game.gbPanel.board.pointArray[10].setSettlementColor(Color.ORANGE);
                        game.gbPanel.board.pointArray[10].setOwner(Player.ORANGE);
                        game.gbPanel.board.sideArray[16].setColor(Color.ORANGE);
                         game.gbPanel.board.sideArray[16].setOwner(Player.ORANGE);
                        game.gbPanel.board.pointArray[25].setSettlementColor(Color.ORANGE);
                        game.gbPanel.board.pointArray[25].setOwner(Player.ORANGE);
                        game.gbPanel.board.sideArray[37].setColor(Color.ORANGE);
                         game.gbPanel.board.sideArray[37].setOwner(Player.ORANGE);
                        game.gbPanel.board.pointArray[39].setSettlementColor(Color.BLUE);
                        game.gbPanel.board.pointArray[39].setOwner(Player.BLUE);
                        game.gbPanel.board.sideArray[50].setColor(Color.BLUE);
                         game.gbPanel.board.sideArray[50].setOwner(Player.BLUE);
                        game.gbPanel.board.pointArray[49].setSettlementColor(Color.BLUE);
                        game.gbPanel.board.pointArray[49].setOwner(Player.BLUE);
                        game.gbPanel.board.sideArray[69].setColor(Color.BLUE);
                         game.gbPanel.board.sideArray[69].setOwner(Player.BLUE);
                        game.phPanel.vpPanel.addCtr();
                        game.phPanel.vpPanel.addCtr();
                        String[] temp = line.split("\\s+");
                        if (temp[1].equals("4")) {
                            game.gbPanel.board.pointArray[18].setSettlementColor(Color.RED);
                            game.gbPanel.board.pointArray[18].setOwner(Player.RED);
                            game.gbPanel.board.sideArray[20].setColor(Color.RED);
                             game.gbPanel.board.sideArray[20].setOwner(Player.RED);
                            game.gbPanel.board.pointArray[30].setSettlementColor(Color.RED);
                            game.gbPanel.board.pointArray[30].setOwner(Player.RED);
                            game.gbPanel.board.sideArray[36].setColor(Color.RED);
                             game.gbPanel.board.sideArray[36].setOwner(Player.RED);
                        }
                        currentPlayer = Integer.parseInt(temp[2]);
                        game.phPanel.nextTurn.setEnabled(false);
                        if (temp[3].equals("true")) {
                            game.phPanel.nextTurn.setEnabled(true);
                        }
                        game.chatPanel.Chat.append("current players is " + temp[2]);
                    } else if (line.startsWith("/addCard ")) {
                        System.out.println(line);
                        String[] temp = line.split("\\s+");
                        if (temp[1].equals("wool")) {
                            game.phPanel.woolPanel.addCtr();
                        }
                        if (temp[1].equals("brick")) {
                            game.phPanel.brickPanel.addCtr();
                        }
                        if (temp[1].equals("grain")) {
                            game.phPanel.grainPanel.addCtr();
                        }
                        if (temp[1].equals("lumber")) {
                            game.phPanel.lumberPanel.addCtr();
                        }
                        if (temp[1].equals("ore")) {
                            game.phPanel.orePanel.addCtr();
                        }
                    } else if (line.startsWith("/nextTurn")) {
                        String[] temp = line.split("\\s+");
                        currentPlayer = Integer.parseInt(temp[1]);
                        game.phPanel.nextTurn.setEnabled(false);
                        if (temp[3].equals("true")) {
                            game.phPanel.nextTurn.setEnabled(true);
                        }
                    } else if (line.startsWith("/assignResources")) {
                        String[] temp = line.split("\\s+");
                        for (int i = 0; i < 19; i++) {
                            if (game.gbPanel.board.tileArray[i].getDiceNumber() == Integer.parseInt(temp[1])) {
                                for (int k = 0; k < 6; k++) {
                                    if (game.gbPanel.board.tileArray[i].tileSettlements[k].getOwner() != -1) {
                                        if (game.gbPanel.board.tileArray[i].tileSettlements[k].getOwner() == 0) {
                                            out.println("/addCard " + game.gbPanel.board.tileArray[i].getTileName() + " white");
                                        }
                                        if (game.gbPanel.board.tileArray[i].tileSettlements[k].getOwner() == 1) {
                                            out.println("/addCard " + game.gbPanel.board.tileArray[i].getTileName() + " orange");
                                        }
                                        if (game.gbPanel.board.tileArray[i].tileSettlements[k].getOwner() == 2) {
                                            out.println("/addCard " + game.gbPanel.board.tileArray[i].getTileName() + " blue");
                                        }
                                        if (game.gbPanel.board.tileArray[i].tileSettlements[k].getOwner() == 3) {
                                            out.println("/addCard " + game.gbPanel.board.tileArray[i].getTileName() + " red");
                                        }
                                    }
                                }
                            }
                        }
                    } else if (line.startsWith("/purchaseSettlement")) {
                        String[] temp = line.split("\\s+");
                        if (temp[2].equals("white")) {
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setOwner(Player.WHITE);
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setSettlementColor(Color.WHITE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("orange")) {
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setOwner(Player.ORANGE);
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setSettlementColor(Color.ORANGE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("blue")) {
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setOwner(Player.BLUE);
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setSettlementColor(Color.BLUE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("red")) {
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setOwner(Player.RED);
                            game.gbPanel.board.pointArray[Integer.parseInt(temp[1])].setSettlementColor(Color.RED);
                            game.gbPanel.board.repaint();
                        }
                    } else if (line.startsWith("/purchaseRoad")) {
                        String[] temp = line.split("\\s+");
                       
                        if (temp[2].equals("white")) {
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setOwner(Player.WHITE);
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setColor(Color.WHITE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("orange")) {
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setOwner(Player.ORANGE);
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setColor(Color.ORANGE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("blue")) {
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setOwner(Player.BLUE);
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setColor(Color.BLUE);
                            game.gbPanel.board.repaint();
                        }
                        if (temp[2].equals("red")) {
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setOwner(Player.RED);
                            game.gbPanel.board.sideArray[Integer.parseInt(temp[1])].setColor(Color.RED);
                            game.gbPanel.board.repaint();
                        }
                    } else if (line.startsWith("/removeResource")) {
                        String[] temp = line.split("\\s+");
                        if (temp[1].equals("brick")) {
                            game.phPanel.brickPanel.subCtr();
                        }
                        if (temp[1].equals("wool")) {
                            game.phPanel.woolPanel.subCtr();
                        }
                        if (temp[1].equals("grain")) {
                            game.phPanel.grainPanel.subCtr();
                        }
                        if (temp[1].equals("lumber")) {
                            game.phPanel.lumberPanel.subCtr();
                        }
                        if (temp[1].equals("ore")) {
                            game.phPanel.orePanel.subCtr();
                        }
                    } else if (line.startsWith("/addVictoryPoint")) {
                        game.phPanel.vpPanel.addCtr();
                    } else if (line.startsWith("/endGame")) {
                        String[] temp = line.split("\\s+");
                        game.phPanel.nextTurn.setEnabled(false);
                        game.gbPanel.board.makeJOptionPane("Congratulation, " + temp[1] + " you have won!!!");
                        //JOptionPane.showMessageDialog(game.gbPanel.board, "Congratulation, " + temp[1] + " you have won!!!");
                    } else if (line.equals("/cantBuildSettlement")) {
                        game.gbPanel.board.makeJOptionPane("You must have 1 grain, wool, lumber and brick in order to build a settlement");
                      //  JOptionPane.showMessageDialog(game.gbPanel.board, "You must have 1 grain, wool, lumber and brick in order to build a settlement");
                    } else if (line.equals("/cantBuildRoad")) {
                        game.gbPanel.board.makeJOptionPane("You must have 1 lumber and brick in order to build a road");
                     //   JOptionPane.showMessageDialog(game.gbPanel.board, "You must have 1 lumber and brick in order to build a road");
                    } else if (line.equals("/tradeDeclined")) {
                        game.gbPanel.board.makeJOptionPane("The trade request was declined");
                       // JOptionPane.showMessageDialog(game.gbPanel.board, "The trade request was declined");
                    } else if (line.equals("/tradeFailed")) {
                        game.gbPanel.board.makeJOptionPane("both players do not possess the neccessary resources to complete this trade");
                       // JOptionPane.showMessageDialog(game.gbPanel.board, "both players do not possess the neccessary resources to complete this trade");
                    } else if (line.startsWith("/trade")) {
                        System.out.println(line);
                        String[] temp = line.split("\\~+");
                        String player1 = temp[0];
                        String player2 = temp[1];
                        String[] player1Split = player1.split("\\s+");
                        String[] player2Split = player2.split("\\s+");
                        StringBuilder P1Offer = new StringBuilder();
                        StringBuilder P2Offer = new StringBuilder();
                        for (int x = 2; x < player1Split.length; x = x + 2) {
                            P1Offer.append(player1Split[x + 1] + " " + player1Split[x]);
                        }
                        for (int x = 1; x < player2Split.length; x = x + 2) {
                            P2Offer.append(player2Split[x + 1] + " " + player2Split[x]);
                        }
                        Object[] options = {"Yes",
                            "No",};
                        game.gbPanel.board.makeJOptionPane("Received Trade");
                        /*n = game.gbPanel.board.makeJOptionDialog(
                                player2Split[0] + " would you like to trade your " + P1Offer
                                + " for their " + P2Offer + ". Do you Accept?",
                                "Trade Request",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);
                        if (n == JOptionPane.YES_OPTION) {
                            out.println(line.replace("/trade", "/tradeAccepted"));
                            System.out.println(line.replace("/trade", "/tradeAccepted"));
                        } else {
                            out.println(line.replace("/trade", "/tradeDeclined"));
                            System.out.println(line.replace("/trade", "/tradeDeclined"));
                        }*/
                    }
                    else if(line.startsWith("/addToPlayerList")){
                        String[] temp = line.split("\\s+");
                        game.playerPanel.playersList.append(temp[1]+"               "+temp[2]+"\n");
                    }
                    else {
                        if (gameState.equals("lobby")) {
                            lobby.chatTA.append("\n" + line);
                        } else {
                            game.chatPanel.Chat.append("\n" + line);
                        }
                    }
                }
            } catch (IOException ioe) {

                System.out.println("Client Issue" + ioe);
            }
        }
    }

    private class ActionHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == lobby.sendButton) {
                out.println(lobby.messageField.getText());
                lobby.messageField.setText("");
            }
            if (e.getSource() == lobby.startButton) {
                out.println("/start");
            }
            if (e.getSource() == lobby.quitButton) {
                System.exit(0);
            }
            if (e.getSource() == game.chatPanel.sendButton) {
                out.println(game.chatPanel.messageField.getText());
                game.chatPanel.messageField.setText("");
            }
            if (e.getSource() == game.phPanel.nextTurn) {
                if (4 <= game.phPanel.vpPanel.getCtr()) {
                    out.println("/endGame " + currentPlayer);

                } else {
                    out.println("/nextTurn");
                }
            }
        }
    }

    public void writeOutput(String buildCommand) {
        out.println(buildCommand);
    }

    private class KeyHandler extends KeyAdapter {

        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                if (gameState.equals("lobby")) {
                    out.println(lobby.messageField.getText());
                    lobby.messageField.setText("");
                }
                if (gameState.equals("game")) {
                    out.println(game.chatPanel.messageField.getText());
                    game.chatPanel.messageField.setText("");
                }
            }
        }
    }
}
