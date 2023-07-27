import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class ReaderTest {

    @Test
    public void test1(){
        check("test1","abc");
    }

    @Test
    public void test2(){
        check("test2","java/lang/object");
    }


    private void check(String fileName,String expect){
        String path="src/test/java/"+fileName;
        FileReader fileReader=new FileReader();
        String actual=null;
        try {
            actual=fileReader.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expect,actual);
    }
}
