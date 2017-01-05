//

//****************************************************************************************

import org.thangnv.messenger_gui.Utils;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main() throws HeadlessException {
        JLabel a = new JLabel();
        a.setIcon(Utils.load("C:\\Users\\DEV\\Pictures\\Camera Roll\\avtar.jpg",50,50));
        add(a);
        setVisible(true);
        setBounds(100,100,550,555);
    }

    public static void main(final String[] args) throws Exception {
        new Main();
    }
}