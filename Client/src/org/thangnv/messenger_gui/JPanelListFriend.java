package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.friend;
import org.thangnv.messenger_Entity.friendDAL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Created by DEV on 1/5/2017.
 */
public class JPanelListFriend extends JPanel {
    private String accountID;
    private JList<friend> listAccount;

    public JPanelListFriend(String accountID) throws HeadlessException {
        this.accountID = accountID;
        setPreferredSize(new Dimension(200,550));
        setBackground(Color.white);
        add(createMainPanel());
        setVisible(true);
    }

    public JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setBorder(new EmptyBorder(0, 10, 10, 10));
        panel.add(new JScrollPane(listAccount = createListAccount()), BorderLayout.CENTER);
        return panel;
    }

    private JList<friend> createListAccount() {
        DefaultListModel<friend> model = new DefaultListModel<>();

        List<friend> friendList = new friendDAL().getListFirend(accountID);
        for (friend friend : friendList) {
            model.addElement(friend);
        }
        JList<friend> friendJList = new JList<friend>(model);
        friendJList.setCellRenderer(new friendRenerer());
        return friendJList;
    }

}
