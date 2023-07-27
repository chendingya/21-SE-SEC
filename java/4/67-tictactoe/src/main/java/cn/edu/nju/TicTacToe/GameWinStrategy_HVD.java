package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD {
	/**
	 * 根据需要修改获胜的方法
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

				// diagonal:
				if (cells[m][n] != '_' &&
					cells[m][n] == cells[m + 1][n + 1] && cells[m][n] == cells[m + 2][n + 2]) {
					winChar = cells[m][n];
				}
			}
		}

		for (int i = 0; i < size - 2; i++) {
			for (int j = 2; j < size; j++) {
				if (cells[i][j] != '_'
				&& cells[i][j] == cells[i + 1][j - 1] && cells[i][j] == cells[i + 2][j - 2]) {
					winChar = cells[i][j];
					break;
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