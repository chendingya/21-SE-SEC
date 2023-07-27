import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ZTest {
    InputStream in = null;
    PrintStream out = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    String ls=System.lineSeparator();
    @Before
    public void setUp() {
        in = System.in;
        out = System.out;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test1(){
        check("helloworld","3","h   o   l\n" +
                "e l w r d\n" +
                "l   o");
    }

    @Test
    public void test2(){
        check("1234567890","4","1     7\n" +
                "2   6 8\n" +
                "3 5   9\n" +
                "4     0");
    }

    @Test
    public void test3(){
        check("TempestArchitect","5","T       r\n" +
                "e     A c     t\n" +
                "m   t   h   c\n" +
                "p s     i e\n" +
                "e       t");
    }

    @After
    public void setDown() {
        System.setIn(in);
        System.setOut(out);
    }

    private void check(String input,String n,String expect){
        inputStream = new ByteArrayInputStream((input+ls+n).getBytes());
        System.setIn(inputStream);

        ZTransformation.main(null);
        String actual = outputStream.toString();
        String[] expects=expect.split("\n");
        String[] actuals=actual.split(ls);
        assertEquals(expects.length,actuals.length);
        for(int i=0;i<expects.length;i++){
            assertEquals(expects[i],actuals[i]);
        }
    }
}
