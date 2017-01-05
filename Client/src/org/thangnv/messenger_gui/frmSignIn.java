package org.thangnv.messenger_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DEV on 1/4/2017.
 */
public class frmSignIn extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton signIn;

    public frmSignIn(){
        setBounds(300, 100, 900, 550);
        setLayout(null);
//        try {
//            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("image\\anh-dep-hoa-bo-cong-anh(11)__93012_zoom.jpg")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        addCompoment();

        setVisible(true);
    }


    public void addCompoment() {
        username = new JTextField();
        username.setBackground(Color.BLUE);
        username.setPreferredSize(new Dimension(40, 100));

        password = new JTextField();
        password.setBackground(Color.BLUE);
        password.setPreferredSize(new Dimension(40, 100));

        signIn = new JButton();
        signIn.setBounds(350,100,50,100);
        signIn.setBackground(Color.black);
//        signIn.setPreferredSize(new Dimension(50, 100));

    }

    public static void main(String[] args) {
        new frmSignIn();
    }
}
