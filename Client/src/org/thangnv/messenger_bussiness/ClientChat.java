package org.thangnv.messenger_bussiness;

import org.thangnv.messenger_Entity.messageInfo;
import org.thangnv.messenger_gui.JPanelViewContent;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by DEV on 9/19/2016.
 */
public class ClientChat {
    private String serverName;
    private int port;
    private Socket socket;
    private ObjectOutputStream writter;
    private JPanel panelView;


    public ClientChat(String serverName, int port, JPanel panelView) {
        this.serverName = serverName;
        this.port = port;
        this.panelView = panelView;
        try {
            socket = new Socket(serverName, port);
            writter = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("Failed to connect to port " + port, e);
        }

        new receiveMesseage().start();
    }

    public void sendMessage(Object objSend) {
        try {
            writter.writeObject(objSend);
            writter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class receiveMesseage extends Thread {
        @Override
        public void run() {
            try {
                ObjectInputStream reader;

                while (true) {
                    reader = new ObjectInputStream(socket.getInputStream());
                    messageInfo obj = (messageInfo) reader.readObject();
                    if(obj.getType().equals("text")){
                        panelView.add(new JPanelViewContent(obj.getIdSender(),obj.getContent().toString(),obj.getDateSend().toString(),null));
                    }else if(obj.getType().equals("file")) {
                        File file = (File) obj.getContent();
                        panelView.add(new JPanelViewContent(obj.getIdSender(),file.getName(),obj.getDateSend().toString(),null));

                    }
//                    new HanlderQueu(queuData).start();
                    panelView.validate();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to receive Messeage!");
                e.printStackTrace();
            }
        }
    }
}
