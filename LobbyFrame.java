package settlersofwashburn;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LobbyFrame extends JFrame {

    JTextField messageField;
    JTextArea chatTA;
    JButton sendButton;
    JButton quitButton;
    JButton startButton;
    private JTextArea playersTA;
    private JPanel buttonPanel;
    private GridBagConstraints gbc = new GridBagConstraints();

    public LobbyFrame() {
        this.setLayout(new GridBagLayout());

        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);

        JPanel mainPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(mainPanel, gbc);

        chatTA = new JTextArea();
        chatTA.setPreferredSize(new Dimension(600, 500));
        chatTA.setEditable(false);
        chatTA.setLineWrap(true);
        mainPanel.add(new JScrollPane(chatTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        JPanel bottomPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(bottomPanel, gbc);

        messageField = new JTextField(50);
        bottomPanel.add(messageField);

        sendButton = new JButton("Send");
        sendButton.setEnabled(true);
        bottomPanel.add(sendButton);

        playersTA = new JTextArea();
        playersTA.setPreferredSize(new Dimension(200, 200));
        playersTA.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(playersTA, gbc);

        buttonPanel = new JPanel();
        buttonPanel.add(quitButton = new JButton("Quit"));
        buttonPanel.add(startButton = new JButton("Start"));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;
        add(buttonPanel, gbc);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 650);
        setResizable(false);
        setVisible(true);
    }
}
