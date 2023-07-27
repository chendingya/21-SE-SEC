import java.io.*;

public class FileReader {
    public String readFile(String filePath) throws IOException{
        String str = null;
        try {
            BufferedInputStream bio = new BufferedInputStream(new FileInputStream(filePath));
            int len = bio.available();//字节数
            byte[] bytes = new byte[len];
            bio.read(bytes, 0, len);
            str = new String(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return str;
    }
}
