package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV {
	/**
	 * 自行实现检测获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells, int size)
	{
		char winChar = 0;

		for (int m = 0; m < size - 2; m++) {
			for (int n = 0; n < size - 2; n++) {

				//rows and cols:
				for(int i = 0; i < 3; i++){
					if(cells[i + m][0 + n] != '_'  &&
							cells[i + m][0 + n] == cells[i + m][1 + n] && cells[i + m][0 + n] == cells[i + m][2 + n]){
						winChar = cells[i + m][0 + n];
						break;
					}
				}

				for (int j = 0; j < 3; j++) {
					if(cells[0 + m][j + n] != '_'  &&
							cells[0 + m][j + n] == cells[1 + m][j + n] && cells[0 + m][j + n] == cells[2 + m][j + n]){
						winChar = cells[0 + m][j + n];
						break;
					}
				}
			}
		}

		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}

		return Result.DRAW;
	}
}