package org.thangnv.messenger_bussiness;

import org.thangnv.messenger_Entity.messageInfo;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by DEV on 1/5/2017.
 */
public class HanlderQueu extends Thread {
    private BlockingQueue<Object> queueData;
    private JPanel panelCenter;

    public HanlderQueu(BlockingQueue<Object> queueData,JPanel panelCenter) {
        this.queueData = queueData;
        this.panelCenter = panelCenter;
    }

    @Override
    public void run() {
        try {
            messageInfo obj = (messageInfo) queueData.take();

            panelCenter.add(new Label(obj.getContent().toString()),BorderLayout.EAST);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
