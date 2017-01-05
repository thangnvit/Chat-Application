package org.thangnv.messenger_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DEV on 1/5/2017.
 */
public class frmChat extends JFrame{
    private JPanel panelListFriend;
    private JPanel panelChat;

    public frmChat() throws HeadlessException {
        setBounds(200, 100, 850, 550);
        setLayout(new BorderLayout());

        panelChat = new JPanelChat();
        panelListFriend = new JPanel();
        panelListFriend.setPreferredSize(new Dimension(295,550));

        addCompoment();
        add(panelChat,BorderLayout.CENTER);
        add(panelListFriend,BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addCompoment(){




    }

    public static void main(String[] args) {
        new frmChat();
    }
}
