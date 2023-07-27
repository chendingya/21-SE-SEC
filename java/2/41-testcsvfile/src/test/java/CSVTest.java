import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class CSVTest {

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
        check("select *","Last_name    First_name    Salary    Department    Employee_id\n" +
                "Ling    Mai    55900    Research    1\n" +
                "Johnson    Jim    56500    Finance    2\n" +
                "Zarnecki    Sabrina    51500    Affair    3","src/test/java/test1.csv");
    }

    @Test
    public void test2(){
        check("select Salary,Employee_id order by Salary","Salary    Employee_id\n" +
                "56500    2\n" +
                "55900    1\n" +
                "51500    3","src/test/java/test1.csv");
    }

    @Test
    public void test3(){
        check("select Salary,Employee_id order by Employee_id","Salary    Employee_id\n" +
                "5000    5\n" +
                "10000    4\n" +
                "20000    3\n" +
                "12500    2\n" +
                "15000    1","src/test/java/test2.csv");
    }

    @Test
    public void test4(){
        check("select * limit 4","Last_name    First_name    Salary    Department    Employee_id\n" +
                "Morales    Jose    5000    Customer Service    5\n" +
                "Christina    Morgan    20000    Finance    3\n" +
                "Pietz    Nathaniel    10000    Research    4\n" +
                "Sagar    Thakker    15000    Research    1","src/test/java/test2.csv");
    }


    @After
    public void setDown() {
        System.setIn(in);
        System.setOut(out);
    }

    private void check(String input,String expect,String file){
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        testCSVFile.main(new String[]{file});
        String actual = outputStream.toString();
        String[] actuals= actual.split(System.lineSeparator());
        for (int i = 0; i < actuals.length; i++) {
            actuals[i]=actuals[i].trim();
        }
        assertEquals(expect, String.join("\n",actuals));
    }
}
