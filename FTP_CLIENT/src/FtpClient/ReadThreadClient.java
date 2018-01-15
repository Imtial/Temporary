package FtpClient;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ReadThreadClient implements Runnable {
    NetworkUtil net;
    String clientName;

    public ReadThreadClient(NetworkUtil net, String clientName) {
        this.net = net;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        if(true){
            Object obj = net.read();
            if(obj != null){
                if(obj instanceof ServerResponse)
                {
                    ServerResponse response = (ServerResponse) obj;
                    Byte [] bytes = response.getFileBytes().toArray(new Byte[response.getFileBytes().size()]);
                }
            }
        }
    }
}
