import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV on 12/12/2016.
 */
public class ServerChat {
    private int port;
    private List<Socket> socketList = new ArrayList<>();
    private ServerSocket serverSocket;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerChat(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException("Falied create server at port 8000",e);
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                socketList.add(socket);
                new ClientHanlde(socket,socketList).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat(8001);
        serverChat.startServer();
    }
}
