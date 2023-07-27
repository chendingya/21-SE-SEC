import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.assertEquals;


public class BadMatrixTest {

	private PrintStream console = null;
	private ByteArrayOutputStream bytes = null;
	private BadMatrix matrix;
	private String lineBreak;

	@org.junit.Before
	public void setUp() {
		int[][] data = {
				{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}
		};
		bytes = new ByteArrayOutputStream();
		console = System.out;
		matrix = new BadMatrix(data);
		lineBreak = System.getProperty("line.separator");
		System.setOut(new PrintStream(bytes));
	}

	@org.junit.After
	public void tearDown() {
		System.setOut(console);
	}

	@org.junit.Test
	public void testPlus1() {
		BadMatrix result = new BadMatrix(matrix.plus(matrix.getData()));
		result.print();
		int[][] data = {
				{2, 2, 2},
				{2, 2, 2},
				{2, 2, 2}
		};
		assertEquals(new BadMatrix(data),result);
	}

	@org.junit.Test
	public void testPlus2() {
		int data1[][] = {
				{-1, -1, -1},
				{-1, -1, -1},
				{-1, -1, -1}
		};
		int data2[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		BadMatrix result = new BadMatrix(matrix.plus(data1));
		assertEquals(new BadMatrix(data2).toString(),result.toString() );
	}

	@org.junit.Test
	public void testPlus3() {
		int data1[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		BadMatrix result = new BadMatrix(matrix.plus(data1));
		assertEquals(matrix,result);
	}

	@org.junit.Test
	public void testTimes1() {
		BadMatrix result = new BadMatrix(matrix.times(matrix.getData()));
		int[][] data = {
				{3, 3, 3}, {3, 3, 3}, {3, 3, 3}
		};
		assertEquals(new BadMatrix(data),result);
	}



	@org.junit.Test
	public void testTimes2() {
		int data1[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		BadMatrix result = new BadMatrix(matrix.times(data1));
		assertEquals(new BadMatrix(data1),result);
	}


	@org.junit.Test
	public void testTimes3() {
		int data1[][] = {
				{2, 2},
				{2, 2},
				{2, 2}
		};
		BadMatrix result = new BadMatrix(matrix.times(data1));
		int data2[][] = {
				{6, 6},
				{6, 6},
				{6, 6}
		};
		assertEquals(new BadMatrix(data2),result );
	}


	@org.junit.Test
	public void testPrint() {
		matrix.print();
		assertEquals(lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak,bytes.toString());
	}
}
