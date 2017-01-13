package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.messageInfo;
import org.thangnv.messenger_bussiness.ClientChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * Created by DEV on 12/10/2016.
 */
public class JPanelChat extends JPanel implements ActionListener {
    private static final int COLS = 25;
    private static final int ENTER_ROW = 3;
    private String accountId;
    private ClientChat clientChat;
    private JPanel panelNorth = new JPanel(new FlowLayout());
    private JPanel panelSouth = new JPanel(new FlowLayout());
    private JPanel panelCenter = new JPanel();
    private JTextArea contentEnter;
    private JButton sendImg;
    private JButton sendIcon;
    private JButton sendFile;
    private JButton sendLike;
    private JLabel nameChater;

    public JPanelChat(String accountId) throws HeadlessException {
        this.accountId = accountId;
        setBounds(200, 100, 555, 550);
        setLayout(new BorderLayout());

        panelSouth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelSouth.setBackground(Color.white);
        add(panelSouth, BorderLayout.SOUTH);

        panelNorth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelNorth.setBackground(Color.lightGray);
        add(panelNorth, BorderLayout.NORTH);

        panelCenter.setPreferredSize(new Dimension(555, 100000000));
        panelCenter.setBackground(Color.white);
        JScrollPane scrollPane = new JScrollPane(panelCenter, 20, 31);
        panelCenter.setLayout(new FlowLayout());
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelCenter.setBackground(Color.white);
        add(scrollPane, BorderLayout.CENTER);
        addComponent();
        keyListener();

        setVisible(true);
        clientChat = new ClientChat("localhost", 8001, panelCenter);

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
        sendImg.addActionListener(this);

        sendIcon = new JButton();
        sendIcon.setBackground(Color.white);
        sendIcon.setPreferredSize(new Dimension(50, 25));
        sendIcon.setIcon(Utils.load("image\\Happy-64.png", 50, 25));
        sendIcon.setBorder(null);
        sendIcon.addActionListener(this);

        sendFile = new JButton();
        sendFile.setBackground(Color.white);
        sendFile.setPreferredSize(new Dimension(50, 25));
        sendFile.setIcon(Utils.load("image\\Image File-52.png", 50, 25));
        sendFile.setBorder(null);
        sendFile.addActionListener(this);

        sendLike = new JButton();
        sendLike.setBackground(Color.white);
        sendLike.setPreferredSize(new Dimension(50, 26));
        sendLike.setIcon(Utils.load("image\\Like It-96.png", 50, 26));
        sendLike.setBorder(null);
        sendLike.addActionListener(this);

        //compoment of panelNorth
        nameChater = new JLabel("Chater");
        nameChater.setFont(new Font("Dialog",Font.TYPE1_FONT,13));
        nameChater.setBackground(Color.white);

        panelSouth.add(new JScrollPane(contentEnter));
        panelSouth.add(sendImg);
        panelSouth.add(sendIcon);
        panelSouth.add(sendFile);
        panelSouth.add(sendLike);
        panelNorth.add(nameChater);

    }


    public void keyListener() {
        Color backgroundJPanelViewContent = Color.lightGray;
        InputMap inputMap = contentEnter.getInputMap(WHEN_FOCUSED);
        ActionMap actionMap = contentEnter.getActionMap();
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        inputMap.put(enterStroke, enterStroke.toString());
        actionMap.put(enterStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInfo obj = new messageInfo();
                obj.setType("text");
                obj.setContent(contentEnter.getText());
                clientChat.sendMessage(obj);
                contentEnter.setText("");
                panelCenter.add(new JPanelViewContent(obj, null, backgroundJPanelViewContent));
                panelCenter.validate();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color backgroundJPanelViewContent = Color.lightGray;
        if ((JButton) e.getSource() == sendFile) {
            JFileChooser fileChooser = new JFileChooser();
            int select = fileChooser.showOpenDialog(this);
            if (select == JFileChooser.APPROVE_OPTION) {

                messageInfo messageInfo = new messageInfo();
                messageInfo.setType("file");
                messageInfo.setContent(fileChooser.getSelectedFile());
                clientChat.sendMessage(messageInfo);
                panelCenter.add(new JPanelViewContent(messageInfo, null, backgroundJPanelViewContent));
            }
        }

        if ((JButton) e.getSource() == sendIcon) {
            JFrame a = new JFrame();
            a.setBounds(sendIcon.getX() + 20, sendIcon.getY() + 330, 230, 250);
            a.add(new JpanelIcon(clientChat, panelCenter));
            a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            a.setVisible(true);

        }

        if ((JButton) e.getSource() == sendLike) {
            messageInfo messageInfo = new messageInfo();
            messageInfo.setType("icon");
            messageInfo.setContent(Utils.load("image\\Like It-96.png", 30, 30));
            clientChat.sendMessage(messageInfo);
            panelCenter.add(new JPanelViewContent(messageInfo, (ImageIcon) messageInfo.getContent(), backgroundJPanelViewContent));
        }

        if ((JButton) e.getSource() == sendImg) {
            JFileChooser fileChooser = new JFileChooser();
            int select = fileChooser.showOpenDialog(this);
            if (select == JFileChooser.APPROVE_OPTION) {
                messageInfo messageInfo = new messageInfo();
                messageInfo.setType("icon");
                messageInfo.setContent(Utils.load(fileChooser.getSelectedFile().getPath(), 400, 400));
                clientChat.sendMessage(messageInfo);
                panelCenter.add(new JPanelViewContent(messageInfo, (ImageIcon) messageInfo.getContent(), backgroundJPanelViewContent));
            }
        }

        panelCenter.validate();
    }



}
