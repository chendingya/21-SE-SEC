import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class LiteralTest {

    InputStream in = null;
    PrintStream out = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    @Before
    public void setUp() {
        in = System.in;
        out = System.out;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

    }

    @Test
    public void test1(){
        check("1","integer");
    }

    @Test
    public void test2(){
        check("1L","long");
    }

    @Test
    public void test3(){
        check("1.0","double");
    }

    @Test
    public void test4(){
        check("1.0f","float");
    }

    @Test
    public void test5(){
        check("'a'","char");
    }

    @Test
    public void test6(){
        check("true","boolean");
    }

    @Test
    public void test7(){
        check("false","boolean");
    }

    @Test
    public void test8(){
        check("'1'","char");
    }

    @After
    public void setDown() {
        System.setIn(in);
        System.setOut(out);
    }

    private void check(String input,String expect){
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Literal.main(null);
        String actual = outputStream.toString();
        actual=actual.replace(System.lineSeparator(),"");
        assertEquals(expect, actual);
    }
}
