package FtpServer;

import FtpClient.ClientMessage;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        NetworkUtil net = new NetworkUtil(socket);
        if(net.socket.isConnected()) System.out.println("Connection Established");

//        new ReadThreadServer(net);
        net.write(new ServerResponse("F:\\Books\\R44101.pdf"));
    }
}
