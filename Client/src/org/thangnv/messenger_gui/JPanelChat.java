package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.messageInfo;
import org.thangnv.messenger_bussiness.ClientChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static javax.swing.JComponent.WHEN_FOCUSED;


/**
 * Created by DEV on 12/10/2016.
 */
public class JPanelChat extends JFrame implements ActionListener {
    private static final int COLS = 25;
    private static final int ENTER_ROW = 3;
    private ClientChat clientChat;
    private JPanel panelNorth = new JPanel(new FlowLayout());
    private JPanel panelSouth = new JPanel(new FlowLayout());
    private JPanel panelCenter = new JPanel();
    private JTextArea contentEnter;
    private JTextArea contentView;
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
        keyListener();

        setVisible(true);
        clientChat = new ClientChat("localhost", 8000, contentView);

    }

    public void addComponent() {
        //component of panelSouth
        contentEnter = new JTextArea(ENTER_ROW, COLS);
        contentEnter.setLineWrap(true);
        contentEnter.setWrapStyleWord(true);
        contentEnter.setBackground(Color.white);

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
        sendFile.addActionListener(this);

        btnLike = new JButton();
        btnLike.setBackground(Color.white);
        btnLike.setPreferredSize(new Dimension(50, 26));
        btnLike.setIcon(Utils.load("image\\Like It-96.png", 50, 26));
        btnLike.setBorder(null);

        //compoment of panelNorth
        nameChater = new JLabel("Chater");
        nameChater.setBackground(Color.white);

        //compoment of panelCenter
        contentView = new JTextArea();
        JScrollPane scrollPanelChat = new JScrollPane(contentView);
        scrollPanelChat.setBounds(0, 0, 540, 450);
        contentView.setBackground(Color.white);
        contentView.setLineWrap(true);
        contentView.setWrapStyleWord(true);
        contentView.setEnabled(false);

        panelSouth.add(new JScrollPane(contentEnter));
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


    public void keyListener(){
        InputMap inputMap = contentEnter.getInputMap(WHEN_FOCUSED);
        ActionMap actionMap = contentEnter.getActionMap();
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);

        inputMap.put(enterStroke,enterStroke.toString());
        actionMap.put(enterStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInfo messageInfo = new messageInfo();
                messageInfo.setContent(contentEnter.getText());
                clientChat.sendMessage(messageInfo);
                contentEnter.setText("");
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == sendFile) {
            JFileChooser fileChooser = new JFileChooser();
            int select = fileChooser.showOpenDialog(this);
            if(select == JFileChooser.APPROVE_OPTION){
                messageInfo messageInfo = new messageInfo();
                messageInfo.setContent(fileChooser.getSelectedFile());
                clientChat.sendMessage(messageInfo);
            }
        }

    }

}
