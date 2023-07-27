import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData()  {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int row = this.data.length;
		int col = B.data[0].length;

		MyMatrix plusResult = new MyMatrix(this.data);
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++) {
				plusResult.data[i][j] = plusResult.data[i][j] + B.data[i][j];
			}
		}
		return plusResult;
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int arow = this.data.length;
		int acol = this.data[0].length;
		int brow = B.data.length;
		int bcol = B.data[0].length;
		int[][] r = new int[arow][bcol];
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				r[i][j] = 0;
			}
		}
		MyMatrix timesResult = new MyMatrix(r);

		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				for (int m = 0; m < acol; m++) {
					timesResult.data[i][j] = timesResult.data[i][j] + this.data[i][m] * B.data[m][j];
				}
			}
		}
		return timesResult;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int arow = this.data.length;
		int acol = this.data[0].length;
		MyMatrix timesResult = new MyMatrix(this.data);
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < acol; j++) {
				timesResult.data[i][j] = timesResult.data[i][j] * b;
			}
		}
		return timesResult;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int arow = this.data.length;
		int acol = this.data[0].length;
		int[][] result = new int[acol][arow];

		for (int i = 0; i < acol; i++) {
			for (int j = 0; j < arow; j++) {
				result[i][j] = this.data[j][i];
			}
		}
		MyMatrix result1 = new MyMatrix(result);
		return result1;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		int row = 0;
		int col = 0;
		int[][] A;

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



		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		int[][] result = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = A[i][j] + this.data[i][j];
			}
		}
		MyMatrix result1 = new MyMatrix(result);
		return result1;
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		int arow = this.data.length;
		int acol = this.data[0].length;
		int brow, bcol = 0;

		int[][] B;

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = br.readLine();
			String[] tmp = command.split(" ");

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
					result[i][j] = result[i][j] + this.data[i][m] * B[m][j];
				}
			}
		}
		MyMatrix result1 = new MyMatrix(result);
		return result1;
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
	public void print(){
		String a = "";
		int row = data.length;
		int col = data[0].length;
		a = a + System.lineSeparator();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j != col - 1) {
					a = a + data[i][j] + " ";
				} else{
					a = a + data[i][j];
				}
			}
			a = a + System.lineSeparator();
		}
		a = a + System.lineSeparator();
		System.out.print(a);
	}
}
