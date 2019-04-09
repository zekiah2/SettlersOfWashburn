package settlersofwashburn;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartupMenu {

    JFrame menuFrame;
    JButton hostButton;
    JButton joinButton;

    public StartupMenu() {
        menuFrame = new JFrame("Settlers Of Washburn");
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 1));
        hostButton = new JButton("Host Game");
        joinButton = new JButton("Join Game");
        menuFrame.add(menuPanel);
        menuPanel.add(hostButton);
        menuPanel.add(joinButton);
        menuFrame.setSize(300, 150);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
        joinButton.addActionListener(new buttonListener());
        hostButton.addActionListener(new buttonListener());
    }

    class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == joinButton) {
                menuFrame.setVisible(false);
                new JoinGameMenu();
            }
            if (e.getSource() == hostButton) {
                menuFrame.setVisible(false);
                new HostingGameMenu();
            }
        }
    }

    public static void main(String args[]) {
        new StartupMenu();
    }
}
