package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.messageInfo;
import org.thangnv.messenger_bussiness.ClientChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by DEV on 1/4/2017.
 */
public class JpanelIcon extends JPanel {
    private String pathIcon;
    private ClientChat clientChat;
    private JPanel panelView;

    public JpanelIcon(ClientChat clientChat, JPanel panelView) {
        this.panelView = panelView;
        this.clientChat = clientChat;
        setLayout(new FlowLayout());
        setVisible(true);
        setPreferredSize(new Dimension(250, 250));

        addCompoments();
    }

    public void addCompoments() {
        MyActionListener actionListener = new MyActionListener();
        File file = new File("image/icon");
        File[] listFile = file.listFiles();

        for (File file1 : listFile) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(30, 30));
            btn.setIcon(Utils.load(file1.getPath(), 30, 30));
            btn.addActionListener(actionListener);
            add(btn);
        }
    }

    class MyActionListener implements ActionListener {
        Color backgroundJPanelViewContent = Color.lightGray;

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            messageInfo messageInfo = new messageInfo();
            messageInfo.setType("icon");
            messageInfo.setContent(button.getIcon());
            clientChat.sendMessage(messageInfo);
            panelView.add(new JPanelViewContent(messageInfo, (ImageIcon) messageInfo.getContent(), backgroundJPanelViewContent));
            panelView.validate();
        }
    }


}
