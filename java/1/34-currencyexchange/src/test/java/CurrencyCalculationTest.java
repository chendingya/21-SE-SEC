import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Formatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CurrencyCalculationTest {

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

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Test
	public void test1() {
		check(81, 137.51, 111.3831);
	}

	@Test
	public void test2() {
		check(13, 37.51, 4.8763);
	}

	@Test
	public void test3() {
		check(61, 137.51, 83.8811);
	}

	@Test
	public void test4() {
		check(90, 60, 54);
	}

	@Test
	public void test5() {
		check(41, 17.15, 7.0315);
	}

	@Test
	public void test6() {
		check(76, 69.85, 53.086);
	}

	@Test
	public void test7() {
		check(12, .51, 0.0612);
	}

	@Test
	public void test8() {
		check(65, 70, 45.5);
	}

	@Test
	public void test9() {
		check(60, 89.6, 53.76);
	}

	@Test
	public void test10() {
		check(152, 139.51, 212.0552);
	}

	private void check(double eruos, double exchangeRate, double result) {
		String input = eruos + System.lineSeparator() + exchangeRate;
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		CurrencyCalculation.main(null);
		Formatter formatter = new Formatter();
		formatter.format("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", eruos, exchangeRate, result);
		String expected = formatter.toString();
		formatter.close();
		String actual = outputStream.toString().split(System.lineSeparator())[2];
		assertEquals(expected, actual);
	}

}
