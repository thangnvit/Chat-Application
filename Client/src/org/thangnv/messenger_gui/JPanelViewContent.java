package org.thangnv.messenger_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DEV on 1/5/2017.
 */
public class JPanelViewContent extends JPanel{
    private JLabel lblName = new JLabel();
    private JTextArea txtContent = new JTextArea();
    private JLabel contentIcon = new JLabel();
    private JLabel dateSend = new JLabel("",SwingConstants.CENTER);


    public JPanelViewContent(String name,String content,String date,String pathIcon) {

        setLayout(new BorderLayout());

        if(pathIcon !=null){
            contentIcon.setIcon(Utils.load(pathIcon,50,50));
        }
        lblName.setText(name);
        txtContent.setText(content);
        dateSend.setText(date);

        txtContent.setWrapStyleWord(true);
        txtContent.setLineWrap(true);
        txtContent.setEditable(false);
        txtContent.setBackground(Color.lightGray);

        lblName.setForeground(Color.gray);
        dateSend.setForeground(Color.gray);

        add(lblName,BorderLayout.NORTH);
        add(txtContent, BorderLayout.CENTER);
        add(dateSend,BorderLayout.SOUTH);

        setPreferredSize(new Dimension(550,50));
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setVisible(true);

    }
}
