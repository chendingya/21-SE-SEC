import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyMatrixTest {

	private PrintStream console = null;
	private ByteArrayOutputStream bytes = null;
	private MyMatrix matrix;
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
		matrix = new MyMatrix(data);
		lineBreak = System.getProperty("line.separator");
		System.setOut(new PrintStream(bytes));
	}

	@org.junit.After
	public void tearDown() {
		System.setOut(console);
	}

	@org.junit.Test
	public void testPlus1() {
		MyMatrix result = matrix.plus(matrix);
		result.print();
		int[][] data = {
				{2, 2, 2},
				{2, 2, 2},
				{2, 2, 2}
		};
		assertTrue(equals(result, new MyMatrix(data)));
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
		MyMatrix result = matrix.plus(new MyMatrix(data1));
		assertTrue(equals(result, new MyMatrix(data2)));
	}

	@org.junit.Test
	public void testPlus3() {
		int data1[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		MyMatrix result = matrix.plus(new MyMatrix(data1));
		assertTrue(equals(result, matrix));
	}

	@org.junit.Test
	public void testTimes1() {
		MyMatrix result = matrix.times(matrix);
		int[][] data = {
				{3, 3, 3}, {3, 3, 3}, {3, 3, 3}
		};
		assertTrue(equals(result, new MyMatrix(data)));
	}

	@org.junit.Test
	public void testTimes2() {
		MyMatrix result = matrix.times(3);
		int[][] data = {
				{3, 3, 3}, {3, 3, 3}, {3, 3, 3}
		};
		assertTrue(equals(result, new MyMatrix(data)));
	}

	@org.junit.Test
	public void testTimes3() {
		int data1[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		MyMatrix result = matrix.times(new MyMatrix(data1));
		assertTrue(equals(result, new MyMatrix(data1)));
	}

	@org.junit.Test
	public void testTimes4() {
		int data1[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		MyMatrix result = matrix.times(0);
		assertTrue(equals(result, new MyMatrix(data1)));
	}

	@org.junit.Test
	public void testTimes5() {
		int data1[][] = {
				{2, 2},
				{2, 2},
				{2, 2}
		};
		MyMatrix result = matrix.times(new MyMatrix(data1));
		int data2[][] = {
				{6, 6},
				{6, 6},
				{6, 6}
		};
		assertTrue(equals(result, new MyMatrix(data2)));
	}

	@org.junit.Test
	public void testPlusFromConsole1() {
		String input = "3 3" + lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak + "1 1 1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		MyMatrix result = matrix.plusFromConsole();
		int[][] data = {
				{2, 2, 2},
				{2, 2, 2},
				{2, 2, 2}
		};
		assertTrue(equals(result, new MyMatrix(data)));
	}

	@org.junit.Test
	public void testPlusFromConsole2() {
		String input = "3 3" + lineBreak + "-1 -1 -1" + lineBreak + "0 0 0" + lineBreak + "1 1 1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		MyMatrix result = matrix.plusFromConsole();
		int[][] data = {
				{0, 0, 0},
				{1, 1, 1},
				{2, 2, 2}
		};
		assertTrue(equals(result, new MyMatrix(data)));
	}

	@org.junit.Test
	public void testTimesFromConsole1() {
		String input = "3 3" + lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak + "1 1 1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		MyMatrix result = matrix.timesFromConsole();
		int[][] data = {
				{3, 3, 3}, {3, 3, 3}, {3, 3, 3}
		};
		assertTrue(equals(result, new MyMatrix(data)));
	}

	@org.junit.Test
	public void testTimesFromConsole2() {
		String input = "4 4" + lineBreak + "0 2 3 4" + lineBreak + "2 2 4 5" + lineBreak + "3 4 4 6" + lineBreak + "4 5 6 6";
		int data[][] = {
				{1, 0, 0, 0},
				{0, 1, 0, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 1}
		};
		int[][] dataRes = new int[][]{{0, 2, 3, 4}, {2, 2, 4, 5}, {3, 4, 4, 6}, {4, 5, 6, 6}};
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		MyMatrix result = new MyMatrix(data).timesFromConsole();
		assertTrue(equals(result, new MyMatrix(dataRes)));
	}

	@org.junit.Test
	public void testTranspose1() {
		MyMatrix result = matrix.transpose();
		assertTrue(equals(result, matrix));
	}

	@org.junit.Test
	public void testTranspose2() {
		int data1[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		MyMatrix result = new MyMatrix(data1).transpose();
		int data2[][] = {
				{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}
		};
		assertTrue(equals(result, new MyMatrix(data2)));
	}

	@org.junit.Test
	public void testPrint() {
		matrix.print();
		assertEquals("" + lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak + "1 1 1" + lineBreak + "" + lineBreak + "", bytes.toString());
	}

	private boolean equals(MyMatrix a, MyMatrix b){
		if(a.getData().length != b.getData().length){
			return false;
		}
		for(int i=0 ; i< a.getData().length ; ++i){
			if(!Arrays.equals(a.getData()[i], b.getData()[i])){
				return false;
			}
		}
		return true;
	}
}
