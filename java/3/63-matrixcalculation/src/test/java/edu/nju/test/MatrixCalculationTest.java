package edu.nju.test;

import edu.nju.*;
import org.junit.*;
import java.io.*;

public class MatrixCalculationTest {
	private static String NL = System.getProperty("line.separator");

	private ByteArrayOutputStream outputStream;
	private MatrixCalculation matrixCalculation;

	@Before
	public void setUp(){
		outputStream =new ByteArrayOutputStream();
		matrixCalculation = new MatrixCalculation();
		System.setOut(new PrintStream(outputStream));
	}

	@After
	public void tearDown(){
		System.setOut(System.out);
	}

	/**
	 * Test method for {@link MatrixCalculation#plus(int[][], int[][])}.
	 */
	@Test
	public void testPlus() {
		int[][] A = {
				{1,2,3},
				{1,2,3}
		};
		int[][] B = {
				{1,2,3},
				{1,2,3}
		};
		int[][] C = matrixCalculation.plus(A, B);
		int[][] result = {
				{2,4,6},
				{2,4,6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#times(int[][], int[][])}.
	 */
	@Test
	public void testTimes() {
		int[][] A = {
				{1,2,3},
				{1,2,3}
		};
		int[][] B = {
				{1,2},
				{1,2},
				{1,2}
		};
		int[][] C = matrixCalculation.times(A, B);
		int[][] result = {
				{6,12},
				{6,12}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plusFromConsole()}.
	 */
	@Test
	public void testPlusFromConsole() {
		String input="2 3" + NL + "1 2 3" + NL + "1 2 3" + NL + "2 3" + NL + "1 2 3" + NL + "1 2 3" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.plusFromConsole();
		int[][] result={
				{2,4,6},
				{2,4,6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#timesFromConsole()}.
	 */
	@Test
	public void testTimesFromConsole() {
		String input="2 3" + NL + "1 2 3" + NL + "1 2 3" + NL + "3 2" + NL + "1 2" + NL + "1 2" + NL + "1 2" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.timesFromConsole();
		int[][] result={
				{6,12},
				{6,12}
		};
		Assert.assertTrue(equals(C,result));
	}

	/**
	 * Test method for {@link MatrixCalculation#print(int[][] A)}.
	 */
	@Test
	public void testPrint() {
		int[][] test = {
				{1,1,1},
				{1,1,1},
				{1,1,1}
		};
		matrixCalculation.print(test);
		Assert.assertEquals(NL + "1 1 1" + NL + "1 1 1" + NL + "1 1 1" + NL , outputStream.toString());
	}

	private boolean equals(int[][] A,int[][] B){
		if(A.length != B.length){
			return false;
		}
		if(A.length >= 1){
			if(A[0].length != B[0].length)
				return false;
		}
		for(int i = 0; i < A.length; i++){
			for(int j = 0;j < A[0].length; j++){
				if(A[i][j] != B[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Test method for {@link MatrixCalculation#plus(int[][], int[][])}.
	 */
	@Test
	public void testPlus1(){
		int[][] A = {
				{1,2,3}
		};
		int[][] B = {
				{1,2,3}
		};
		int[][] C = matrixCalculation.plus(A, B);
		int[][] result = {
				{2,4,6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plus(int[][], int[][])}.
	 */
	@Test
	public void testPlus2(){
		int[][] A = {
				{1},{2},{3}
		};
		int[][] B = {
				{1},{2},{3}
		};
		int[][] C = matrixCalculation.plus(A, B);
		int[][] result = {
				{2},{4},{6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plus(int[][], int[][])}.
	 */
	@Test
	public void testPlus3(){
		int[][] A = {
				{1}
		};
		int[][] B = {
				{1}
		};
		int[][] C = matrixCalculation.plus(A, B);
		int[][] result = {
				{2}
		};
		Assert.assertTrue(equals(C, result));
	}



	/**
	 * Test method for {@link MatrixCalculation#times(int[][], int[][])}.
	 */
	@Test
	public void testTimes1(){
		int[][] A = {
				{1,2,3}
		};
		int[][] B = {
				{1},{2},{3}
		};
		int[][] C = matrixCalculation.times(A, B);
		int[][] result = {
				{14}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#times(int[][], int[][])}.
	 */
	@Test
	public void testTimes2(){
		int[][] A = {
				{1},{2},{3}
		};
		int[][] B = {
				{1,2,3}
		};
		int[][] C = matrixCalculation.times(A, B);
		int[][] result = {
				{1,2,3},
				{2,4,6},
				{3,6,9}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#times(int[][], int[][])}.
	 */
	@Test
	public void testTimes3(){
		int[][] A = {
				{1}
		};
		int[][] B = {
				{Integer.MAX_VALUE}
		};
		int[][] C = matrixCalculation.times(A, B);
		int[][] result = {
				{Integer.MAX_VALUE}
		};
		Assert.assertTrue(equals(C, result));
	}



	/**
	 * Test method for {@link MatrixCalculation#print(int[][] A)}.
	 */
	@Test
	public void testPrint1(){
		int[][] test = {
				{1,1,1}
		};
		matrixCalculation.print(test);
		Assert.assertEquals(NL + "1 1 1" + NL , outputStream.toString());
	}

	/**
	 * Test method for {@link MatrixCalculation#print(int[][] A)}.
	 */
	@Test
	public void testPrint2(){
		int[][] test = {
				{1},{1},{1}
		};
		matrixCalculation.print(test);
		Assert.assertEquals(NL + "1" + NL + "1" + NL + "1" + NL , outputStream.toString());
	}

	/**
	 * Test method for {@link MatrixCalculation#plusFromConsole()}.
	 */
	@Test
	public void testPlusFromConsole1() {
		String input="1 3" + NL + "1 2 3" + NL + "1 3" + NL + "1 2 3" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.plusFromConsole();
		int[][] result = {
				{2,4,6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plusFromConsole()}.
	 */
	@Test
	public void testPlusFromConsole2() {
		String input = "3 1" + NL + "1" + NL + "2" + NL + "3" + NL + "3 1" + NL + "1" + NL + "2" + NL + "3" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.plusFromConsole();
		int[][] result = {
				{2},{4},{6}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plusFromConsole()}.
	 */
	@Test
	public void testPlusFromConsole3() {
		String input = "1 1" + NL + "1" + NL + "1 1" + NL + "2" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.plusFromConsole();
		int[][] result = {
				{3}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#plusFromConsole()}.
	 */
	@Test
	public void testPlusFromConsole4() {
		String input = "0 0" + NL + "0 0" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.plusFromConsole();
		int[][] result = new int[0][0];
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#timesFromConsole()}.
	 */
	@Test
	public void testTimesFromConsole1() {
		String input = "1 3" + NL + "1 2 3" + NL + "3 1" + NL + "1" + NL + "2" + NL + "3" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.timesFromConsole();
		int[][] result = {
				{14}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#timesFromConsole()}.
	 */
	@Test
	public void testTimesFromConsole2() {
		String input = "3 1" + NL + "1" + NL + "2" + NL + "3" + NL + "1 3" + NL + "1 2 3" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.timesFromConsole();
		int[][] result = {
				{1,2,3},
				{2,4,6},
				{3,6,9}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#timesFromConsole()}.
	 */
	@Test
	public void testTimesFromConsole3() {
		String input = "1 1" + NL + "1" + NL + "1 1" + NL + "2147483647" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.timesFromConsole();
		int[][] result = {
				{Integer.MAX_VALUE}
		};
		Assert.assertTrue(equals(C, result));
	}

	/**
	 * Test method for {@link MatrixCalculation#timesFromConsole()}.
	 */
	@Test
	public void testTimesFromConsole4() {
		String input = "0 0" + NL + "0 0" + NL;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		int[][] C = matrixCalculation.timesFromConsole();
		int[][] result = new int[0][0];
		Assert.assertTrue(equals(C, result));
	}
}
