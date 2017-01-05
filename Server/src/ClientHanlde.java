import org.thangnv.messenger_Entity.messageInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 * Created by DEV on 9/25/2016.
 */
public class ClientHanlde extends Thread {
    private Socket socket;
    private List<Socket> socketList;

    public ClientHanlde(Socket socket, List<Socket> socketList) {
        this.socket = socket;
        this.socketList = socketList;
    }

    @Override
    public void run() {
        try {

            ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
            while (true) {

                messageInfo messageInfo = (messageInfo) reader.readObject();
                for (Socket socket1 : socketList) {
                    if(socket1.equals(socket) == false){
                        ObjectOutputStream writter = new ObjectOutputStream(socket1.getOutputStream());
                        writter.writeObject(messageInfo);
                        writter.flush();
                    }
                }
            }
        } catch (ClassNotFoundException | SocketException e) {
            System.out.println("A socket disconnect");
            socketList.remove(socket);
        } catch (IOException e) {
            System.out.println("A socket disconnect");
            socketList.remove(socket);
        }
    }
}
