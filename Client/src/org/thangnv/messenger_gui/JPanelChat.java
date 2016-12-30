package org.thangnv.messenger_gui;

import org.thangnv.messenger_bussiness.ClientChat;
import org.thangnv.messenger_bussiness.ClientSendFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by DEV on 12/10/2016.
 */
public class JPanelChat extends JFrame implements ActionListener {
    private static final int COLS = 25;
    private static final int VIEW_ROW = 12;
    private static final int ENTER_ROW = 3;
    private JPanel panelNorth = new JPanel(new FlowLayout());
    private JPanel panelSouth = new JPanel(new FlowLayout());
    private JPanel panelCenter = new JPanel();
    private JTextArea contentMsg;
    private JTextArea contentChat;
    private JButton sendImg;
    private JButton sendIcon;
    private JButton sendFile;
    private JButton btnLike;
    private JLabel nameChater;

    public JPanelChat() throws HeadlessException {
        setBounds(200, 100, 555, 550);
        setLayout(new BorderLayout());

        panelSouth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelSouth.setBackground(Color.white);
        add(panelSouth, BorderLayout.SOUTH);

        panelNorth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelNorth.setBackground(Color.white);
        add(panelNorth, BorderLayout.NORTH);

        panelCenter.setLayout(null);
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelCenter.setBackground(Color.white);
        add(panelCenter, BorderLayout.CENTER);

        addComponent();

        setVisible(true);
        ClientChat clientChat = new ClientChat("localhost", 8000,contentMsg,contentChat);
        clientChat.startClient();


    }

    public void addComponent() {
        //component of panelSouth
        contentMsg = new JTextArea(ENTER_ROW,COLS);
        contentMsg.setLineWrap(true);
        contentMsg.setWrapStyleWord(true);
        contentMsg.setBackground(Color.white);

        sendImg = new JButton();
        sendImg.setBackground(Color.white);
        sendImg.setPreferredSize(new Dimension(50, 25));
        sendImg.setIcon(Utils.load("image\\Picture-64.png", 50, 25));
        sendImg.setBorder(null);

        sendIcon = new JButton();
        sendIcon.setBackground(Color.white);
        sendIcon.setPreferredSize(new Dimension(50, 25));
        sendIcon.setIcon(Utils.load("image\\Happy-64.png", 50, 25));
        sendIcon.setBorder(null);

        sendFile = new JButton();
        sendFile.setBackground(Color.white);
        sendFile.setPreferredSize(new Dimension(50, 25));
        sendFile.setIcon(Utils.load("image\\Image File-52.png", 50, 25));
        sendFile.setBorder(null);

        btnLike = new JButton();
        btnLike.setBackground(Color.white);
        btnLike.setPreferredSize(new Dimension(50, 26));
        btnLike.setIcon(Utils.load("image\\Like It-96.png", 50, 26));
        btnLike.setBorder(null);

        //compoment of panelNorth
        nameChater = new JLabel("Chater");
        nameChater.setBackground(Color.white);

        //compoment of panelCenter
        contentChat = new JTextArea();
        JScrollPane scrollPanelChat = new JScrollPane(contentChat);
        scrollPanelChat.setBounds(0,0,540,450);
        contentChat.setBackground(Color.white);
        contentChat.setLineWrap(true);
        contentChat.setWrapStyleWord(true);
        contentChat.setEnabled(false);

        panelSouth.add(new JScrollPane(contentMsg));
        panelSouth.add(sendImg);
        panelSouth.add(sendIcon);
        panelSouth.add(sendFile);
        panelSouth.add(btnLike);

        panelNorth.add(nameChater);
        panelCenter.add(scrollPanelChat);

    }

    public static void main(String[] args) {
        new JPanelChat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == btnLike){
            new ClientSendFile("localtion",8000);
        }
    }
}
