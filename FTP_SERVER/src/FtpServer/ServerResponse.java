package FtpServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ServerResponse implements Serializable {
    private long fileSize;
    private String filename;
    private byte [] fileBytes = null;

    public ServerResponse(String filename) {
        this.filename = filename;
        File file = new File(filename);
        fileSize = file.length();
        try{
            FileInputStream fis = new FileInputStream(file);
            byte [] bytes = new byte[1024];
            int noOfByte;
            while((noOfByte = fis.read(bytes))!= -1){
                if (fileBytes==null)
                    fileBytes =new byte[noOfByte];
                else {
                    byte[] tempBytes = new byte[fileBytes.length];
                    for (int i=0; i<fileBytes.length; ++i)
                        tempBytes[i] = fileBytes[i];
                    fileBytes = new byte[tempBytes.length+noOfByte];
                    for (int i=0; i<fileBytes.length; ++i)
                        fileBytes[i] = tempBytes[i];
                }
                for (int i=0; i<noOfByte; ++i) fileBytes[i] = bytes[i];
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

    public byte[] getFileBytes() {
        return fileBytes;
    }
}
