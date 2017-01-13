package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.friend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DEV on 1/5/2017.
 */
public class friendRenerer extends JPanel implements ListCellRenderer<friend> {
    private JLabel lblAvatar = new JLabel();
    private JLabel lblUsername = new JLabel();
    private JLabel lblContent = new JLabel();

    public friendRenerer() {

        setLayout(new BorderLayout(5,5));
        JPanel panelText = new JPanel(new GridLayout(0,1));
        panelText.add(lblUsername);
        panelText.add(lblContent);

        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        add(panelText,BorderLayout.CENTER);
        add(lblAvatar,BorderLayout.WEST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends friend> list, friend value, int index, boolean isSelected, boolean cellHasFocus) {
        lblAvatar.setIcon(Utils.load(value.getImage(),60,60));
        lblUsername.setText(value.getUsername());
        lblContent.setText(value.getLastContent());

        lblAvatar.setOpaque(true);
        lblUsername.setOpaque(true);
        lblContent.setOpaque(true);

        if(isSelected){
            lblAvatar.setBackground(list.getSelectionBackground());
            lblContent.setBackground(list.getSelectionBackground());
            lblUsername.setBackground(list.getSelectionBackground());
        }else {
            lblUsername.setBackground(list.getBackground());
            lblContent.setBackground(list.getBackground());
            lblAvatar.setBackground(list.getBackground());
        }
        return this;
    }

}
