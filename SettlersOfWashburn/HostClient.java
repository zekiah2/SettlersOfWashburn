package SettlersOfWashburn;


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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class HostClient 
{
    ChatClient s;
    JFrame loginFrame;
    JTextField nameField;
    public HostClient()
    {
    loginFrame= new JFrame("Login");
    JPanel loginPanel= new JPanel();
    JPanel fieldsPanel= new JPanel();
    JPanel buttonPanel= new JPanel();
    JButton loginButton= new JButton("Create Game");
    JLabel nameLabel= new JLabel("Name");
    nameField= new JTextField(1);
    loginPanel.setLayout(new GridLayout(2,1));
    fieldsPanel.setLayout(new GridLayout(2,2));
    loginFrame.add(loginPanel);
    loginPanel.add(fieldsPanel);
    loginPanel.add(buttonPanel);
    fieldsPanel.add(nameLabel);
    fieldsPanel.add(nameField);
    buttonPanel.add(loginButton);
    loginFrame.setSize(300,150);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.setVisible(true);
    loginButton.addActionListener(new buttonListener());
    }
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) 
        {
            new serverThread().start();
            loginFrame.setVisible(false);
            try {
                s= new ChatClient();
            } catch (BindException ex) {
                System.out.println(ex);
            }
            s.connect("localhost",nameField.getText());
        }
    }
    class serverThread extends Thread
    {
        public void run()
        {
            new ChatServer();
        }
    }
    public static void main(String args[])
    {
        new HostClient();
    }
}
    
