package edu.nju;

//import jdk.internal.org.jline.utils.InputStreamReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int row = A.length;
		int col = B[0].length;
		int[][] result = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = A[i][j] + B[i][j];
			}
		}
		return result;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int arow = A.length;
		int acol = A[0].length;
		int brow = B.length;
		int bcol = B[0].length;
		int[][] result = new int[arow][bcol];
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				result[i][j] = 0;
			}
		}
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				for (int m = 0; m < acol; m++) {
					result[i][j] = result[i][j] + A[i][m] * B[m][j];
				}
			}
		}
		return result;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		int row = 0;
		int col = 0;
		int[][] A;
		int[][] B;

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = br.readLine();
			String[] tmp = command.split(" ");
			row = Integer.parseInt(tmp[0]);
			col = Integer.parseInt(tmp[1]);
			A = new int[row][col];
			for (int m = 0; m < row; m++) {
				command = br.readLine();
				String[] str = command.split(" ");
				for (int n = 0; n < col; n++) {
					A[m][n] = Integer.parseInt(str[n]);
				}
			}


			command = br.readLine();
			tmp = command.split(" ");
			row = Integer.parseInt(tmp[0]);
			col = Integer.parseInt(tmp[1]);

			B = new int[row][col];

			for (int m = 0; m < row; m++) {
				command = br.readLine();
				String[] str = command.split(" ");
				for (int n = 0; n < col; n++) {
					B[m][n] = Integer.parseInt(str[n]);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		int[][] result = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = A[i][j] + B[i][j];
			}
		}

		return result;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		int arow = 0;
		int acol = 0;
		int brow, bcol = 0;
		int[][] A;
		int[][] B;

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = br.readLine();
			String[] tmp = command.split(" ");
			arow = Integer.parseInt(tmp[0]);
			acol = Integer.parseInt(tmp[1]);
			A = new int[arow][acol];
			for (int m = 0; m < arow; m++) {
				command = br.readLine();
				String[] str = command.split(" ");
				for (int n = 0; n < acol; n++) {
					A[m][n] = Integer.parseInt(str[n]);
				}
			}


			command = br.readLine();
			tmp = command.split(" ");
			brow = Integer.parseInt(tmp[0]);
			bcol = Integer.parseInt(tmp[1]);

			B = new int[brow][bcol];

			for (int m = 0; m < brow; m++) {
				command = br.readLine();
				String[] str = command.split(" ");
				for (int n = 0; n < bcol; n++) {
					B[m][n] = Integer.parseInt(str[n]);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		int[][] result = new int[arow][bcol];
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				result[i][j] = 0;
			}
		}
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				for (int m = 0; m < acol; m++) {
					result[i][j] = result[i][j] + A[i][m] * B[m][j];
				}
			}
		}
		return result;
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A){
		String a = "";
		int row = A.length;
		int col = A[0].length;
		a = a + System.lineSeparator();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j != col - 1) {
					a = a + A[i][j] + " ";
				} else{
					a = a + A[i][j];
				}
			}
			a = a + System.lineSeparator();
		}
		System.out.print(a);
	}
}
