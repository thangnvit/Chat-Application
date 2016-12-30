package org.thangnv.messenger_bussiness;

import java.io.*;
import java.net.Socket;

/**
 * Created by DEV on 9/19/2016.
 */
public class ClientSendFile {
    private String serverName;
    private int port;
    private File file;

    public ClientSendFile(String serverName, int port) {
        this.serverName = serverName;
        this.port = port;
    }


    public void startClient() {
        BufferedInputStream writter = null;
        BufferedInputStream reader = null;
        try {
            reader = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Socket socket = new Socket(serverName, port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(file.getName());
            output.flush();
            if (input.readUTF() != "false") {
                byte[] buffer = new byte[1024];
                while (reader.read(buffer) != -1) {
                    output.write(buffer);
                    output.flush();
                }
                output.flush();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String filePath = bufferedReader.readLine();
            System.out.println("Path" + filePath);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        ClientSendFile client = new ClientSendFile("localhost", 6969);
        File file = new File("D:\\dev\\project\\activestudy\\JB11\\Day7_jc4.zip");
        client.setFile(file);
        client.startClient();
    }
}
