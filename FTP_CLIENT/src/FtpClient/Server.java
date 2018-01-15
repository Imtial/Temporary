package FtpClient;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        NetworkUtil net = new NetworkUtil(socket);
        if(net.socket.isConnected()) System.out.println("Connection Established");
        Object obj = net.read();
        if(obj != null){
            System.out.println("2");
            if(obj instanceof ClientMessage){
                System.out.println("3");
                ClientMessage clientMessage = (ClientMessage) obj;
                System.out.println(clientMessage.getPath());
            }
        }

        //new ReadThreadServer(net);

    }
}
