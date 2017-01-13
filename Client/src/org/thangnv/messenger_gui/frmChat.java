package org.thangnv.messenger_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DEV on 1/5/2017.
 */
public class frmChat extends JFrame {
    private JPanel panelListFriend;
    private JPanel panelChat;
    private String accountId;

    public frmChat(String accountId) throws HeadlessException {
        this.accountId = accountId;

        setBounds(200, 100, 800, 550);
        setLayout(new BorderLayout());
        panelChat = new JPanelChat(accountId);

        panelListFriend = new JPanel(new BorderLayout());
        panelListFriend.setBackground(Color.white);
        panelListFriend.setBorder(BorderFactory.createLineBorder(Color.gray));

        addCompoment();
        add(panelListFriend, BorderLayout.WEST);
        add(panelChat, BorderLayout.CENTER);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addCompoment() {
        JPanel panelTitle = new JPanel();
        panelTitle.setPreferredSize(new Dimension(200,30));
        panelTitle.add(new JLabel("Home", SwingConstants.CENTER));
        panelTitle.setBackground(Color.lightGray);

        panelListFriend.add(new JPanelListFriend(accountId), BorderLayout.CENTER);
        panelListFriend.add(panelTitle, BorderLayout.NORTH);
    }

}
