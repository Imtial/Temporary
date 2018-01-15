package FtpServer;

public class WriteThreadServer implements Runnable {
    Thread thread;
    NetworkUtil net;
    ServerResponse response;

    WriteThreadServer(NetworkUtil net, ServerResponse response) {
        this.net = net;
        this.response = response;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        net.write(response);
    }
}
