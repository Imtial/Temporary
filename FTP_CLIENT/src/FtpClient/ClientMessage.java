package FtpClient;

import java.io.Serializable;

public class ClientMessage implements Serializable {
    private boolean download;
    private String path;

    public ClientMessage(boolean download, String path) {
        this.download = download;
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
