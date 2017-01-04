package org.thangnv.messenger_bussiness;

import org.thangnv.messenger_Entity.messageInfo;

import javax.swing.*;
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
    private JTextArea contentView;


    public ClientChat(String serverName, int port, JTextArea contentView) {
        this.serverName = serverName;
        this.port = port;
        this.contentView = contentView;
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
                    contentView.append(obj.getContent() + "\n");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to receive Messeage!");
                e.printStackTrace();
            }
        }
    }
}
