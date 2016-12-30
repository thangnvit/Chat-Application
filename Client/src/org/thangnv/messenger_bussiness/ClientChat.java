package org.thangnv.messenger_bussiness;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

import static javax.swing.JComponent.WHEN_FOCUSED;

/**
 * Created by DEV on 9/19/2016.
 */
public class ClientChat {
    private String serverName;
    private int port;
    private Socket socket;
    private JTextArea contentMsg;
    private JTextArea contentChat;
    private InputMap inputMap;
    private ActionMap actionMap;

    public ClientChat(String serverName, int port, JTextArea contentMsg, JTextArea contentChat) {
        this.serverName = serverName;
        this.contentMsg = contentMsg;
        this.contentChat = contentChat;
        this.port = port;
        try {
            socket = new Socket(serverName, port);
        } catch (IOException e) {
            throw new RuntimeException("Failed to connect to port " + port, e);
        }
    }

    public void startClient() {
        new receiveMesseage().start();

        sendMessage();
    }

    public void sendMessage() {
        int condition = WHEN_FOCUSED;
        inputMap = contentMsg.getInputMap(condition);
        actionMap = contentMsg.getActionMap();

        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterStroke, enterStroke.toString());

        actionMap.put(enterStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writter.write("textsystem/" + contentMsg.getText());
                    writter.newLine();
                    writter.flush();
                    contentMsg.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public class receiveMesseage extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {

                    contentChat.append(reader.readLine()+ "\n");
                }
            } catch (IOException e) {
                System.out.println("Failed to receive Messeage!");
                e.printStackTrace();
            }
        }
    }
}
