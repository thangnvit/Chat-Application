package org.thangnv.messenger_gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DEV on 12/11/2016.
 */
public class Utils {
    public static Icon load(String linkImage, int k, int m) {/*linkImage là tên icon, k kích thuoc chieu rong minh muon,m chieu dài và hàm này tra ve giá tri là 1 icon.*/
        try {
            BufferedImage image = ImageIO.read(new File(linkImage));//d?c ?nh dùng BufferedImage

            int x = k;
            int y = m;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx = 0, dy = 0;

            if (x / y > ix / iy) {
                dy = y;
                dx = dy * ix / iy;
            } else {
                dx = x;
                dy = dx * iy / ix;
            }

            return new ImageIcon(image.getScaledInstance(dx, dy,
                    image.SCALE_SMOOTH));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
}
