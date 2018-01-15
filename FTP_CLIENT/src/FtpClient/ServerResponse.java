package FtpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerResponse implements Serializable {
    private long fileSize;
    private String filename;
    private List<Byte> fileBytes;

    public ServerResponse(String filename) {
        this.filename = filename;
        File file = new File(filename);
        fileSize = file.length();
        fileBytes = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(file);
            byte [] bytes = new byte[1024];
            int noOfByte;
            while((noOfByte = fis.read(bytes))!= -1){
                for (int i=0; i<noOfByte; ++i)
                    fileBytes.add(bytes[i]);
            }
        }catch (IOException e){
            System.out.println("In ServerResponse(): ");
            e.printStackTrace();
        }


    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilename() {
        return filename;
    }

    public List<Byte> getFileBytes() {
        return fileBytes;
    }
}
