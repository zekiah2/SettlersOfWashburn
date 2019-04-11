package settlersofwashburn;

import com.sun.prism.image.ViewPort;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.*;

public class ChatPanel extends JPanel {

    
    JTextArea Chat;
    public JButton sendButton;
    public JTextField messageField;
    private BufferedImage image;
    private JScrollPane scrollPane;
    public ChatPanel() {
        this.setLayout(new BorderLayout());
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        URL chatPanelArt = getClass().getResource("chatPanel.png");
        setBorder(BorderFactory.createTitledBorder("Chat"));
        Chat= new JTextArea(220, 500);
        scrollPane= new JScrollPane(Chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(220,500));
        Chat.setEditable(false);
        Chat.setLineWrap(true);
        Chat.setWrapStyleWord(true);
        add(scrollPane,BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        sendButton = new JButton("Send");
        sendButton.setEnabled(true);
        messageField = new JTextField(13);
        bottomPanel.add(messageField);
        bottomPanel.add(sendButton);
        bottomPanel.setBackground(new Color(188,90,50));
        add(bottomPanel,BorderLayout.SOUTH);
        try {
            image = ImageIO.read(new File(chatPanelArt.getPath()));
        } catch (IOException ex) {
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
    }
}
