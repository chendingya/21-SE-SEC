import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class RotateTest {

    InputStream in = null;
    PrintStream out = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    static final int[][] matrixA={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    static final int[][] expect1={{9,5,1},{10,6,2},{11,7,3},{12,8,4}};
    static final int[][] expect2={{12,11,10,9},{8,7,6,5},{4,3,2,1}};
    static final int[][] expect3={{4,8,12},{3,7,11},{2,6,10},{1,5,9}};

    @Before
    public void setUp() {
        in = System.in;
        out = System.out;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test1(){
        check(matrixA,90,expect1);
    }

    @Test
    public void test2(){
        check(matrixA,180,expect2);
    }

    @Test
    public void test3(){
        check(matrixA,270,expect3);
    }

    @After
    public void setDown() {
        System.setIn(in);
        System.setOut(out);
    }

    private void check(int[][] matrix,int t,int[][] expect){
        StringBuilder stringBuilder=new StringBuilder();
        String ls=System.lineSeparator();
        stringBuilder.append(matrix.length).append(" ").append(matrix[0].length).append(ls);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append(ls);
        }
        stringBuilder.append(t).append(ls);
        inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(inputStream);

        MatrixRotate.main(null);
        String actual = outputStream.toString();
        String[] actuals=actual.split(ls);
        assertEquals(expect.length,actuals.length);
        for (int i=0;i<expect.length;i++) {
            String[] ints=actuals[i].split(" ");
            assertEquals(expect[0].length,ints.length);
            for(int j=0;j<ints.length;j++){
                assertEquals(String.valueOf(expect[i][j]),ints[j]);
            }
        }
    }
}
