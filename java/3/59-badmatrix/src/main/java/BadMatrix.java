

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b){
		int row = b.length;
		int col = b[0].length;
		BadMatrix result = new BadMatrix(data);
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++) {
				result.data[i][j] = result.data[i][j] + b[i][j];
			}
		}
		return result.data;
	}

        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int arow = this.data.length;
		int acol = this.data[0].length;
		int brow = b.length;
		int bcol = b[0].length;
		int[][] result = new int[arow][bcol];
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				result[i][j] = 0;
			}
		}
		for (int i = 0; i < arow; i++) {
			for (int j = 0; j < bcol; j++) {
				for (int m = 0; m < acol; m++) {
					result[i][j] = result[i][j] + this.data[i][m] * b[m][j];
				}
			}
		}
		return result;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString(){
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
		return a;
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
