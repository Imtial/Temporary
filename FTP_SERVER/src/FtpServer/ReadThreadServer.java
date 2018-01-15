package FtpServer;

import FtpClient.ClientMessage;

public class ReadThreadServer implements Runnable{
    NetworkUtil net;
    Thread thread;

    public ReadThreadServer(NetworkUtil net) {
        this.net = net;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        if (true){
            Object obj = net.read();
            if(obj != null){
                if(obj instanceof ClientMessage){
                    ClientMessage clientMessage = (ClientMessage) obj;
                    System.out.println(clientMessage.getPath());
                    ServerResponse response = new ServerResponse(clientMessage.getPath());
//                    new WriteThreadServer(net, response);
                }
            }
        }
    }
}
