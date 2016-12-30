import java.io.*;
import java.net.Socket;
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String[] data = reader.readLine().split("system/");
                if (data[0].equals("text")){
                    for (Socket socket1 : socketList) {
                        BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                        writter.write(data[1]);
                        writter.newLine();
                        writter.flush();
                    }
                }else{
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    String nameFile = input.readUTF();
                    if(!checkNameFile(nameFile)){
                        output.writeUTF("true");
                        output.flush();
                        File file = new File("D:\\test\\" + nameFile);
                        BufferedOutputStream writter = new BufferedOutputStream(new FileOutputStream(file));
                        byte[] buffer = new byte[1024];
                        while (input.read(buffer) != -1){
                            writter.write(buffer);
                        }
                        writter.flush();
                        writter.close();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        bufferedWriter.write(file.getPath());
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }
                }
            }
        } catch (IOException e) {
            try {
                System.out.println("A socket disconnect");
                socketList.remove(socket);
                socket.close();
            } catch (IOException e1) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkNameFile(String nameFile) {
        String[] check = {"\\", "\"", ":", "*", "?", ">", "<", "/", "|"};
        for (String s : check) {
            if (nameFile.contains(s))
                return true;
        }
        return false;
    }
}
