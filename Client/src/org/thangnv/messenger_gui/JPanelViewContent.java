package org.thangnv.messenger_gui;

import org.thangnv.messenger_Entity.messageInfo;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by DEV on 1/5/2017.
 */
public class JPanelViewContent extends JPanel {
    private JTextArea txtContent = new JTextArea("  ");
    private JLabel contentIcon = new JLabel();
    private JLabel dateSend = new JLabel("", SwingConstants.CENTER);


    public JPanelViewContent(messageInfo inputObj, ImageIcon icon,Color backgournd) {

        setLayout(new BorderLayout());

        if (icon == null) {
            try {
                File file = (File)inputObj.getContent();
                txtContent.append(file.getName());
            } catch (ClassCastException e) {
                txtContent.append(inputObj.getContent().toString());
            }

            txtContent.setWrapStyleWord(true);
            txtContent.setLineWrap(true);
            txtContent.setEditable(false);
            txtContent.setBackground(backgournd);

            add(txtContent, BorderLayout.CENTER);
            setPreferredSize(new Dimension(550, 50));
        } else {
            contentIcon.setIcon(icon);

            add(contentIcon, BorderLayout.CENTER);
            if (icon.getIconHeight() > 50) {
                setPreferredSize(new Dimension(550, icon.getIconHeight() + 10));
            } else {
                setPreferredSize(new Dimension(550, 50));
            }
        }

        dateSend.setText(inputObj.getDateSend().toString());
        dateSend.setForeground(Color.gray);
        add(dateSend, BorderLayout.SOUTH);

        setBackground(backgournd);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setVisible(true);


    }


}
