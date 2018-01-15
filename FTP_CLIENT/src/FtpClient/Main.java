package FtpClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        NetworkUtil net = new NetworkUtil("localhost",9999);
        String clientName = "Enan";
        ClientMessage msg = new ClientMessage(true,"F:\\Books\\R44101.pdf");
//        net.write(msg);
        /*Thread t = new Thread(){
            @Override
            public void run(){
                net.write(msg);
            }
        };
        t.start();
        if (t.isAlive()) t.join();
*/
//        new ReadThreadClient(net, clientName);
        System.out.println(net.read());
    }
}
