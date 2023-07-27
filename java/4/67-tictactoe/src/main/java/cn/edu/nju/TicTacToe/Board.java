package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategyNormal chessStrategy0;
	protected GameChessStrategyInnormal chessStrategy1;
	protected GameWinStrategy_HVD winStrategy0;
	protected GameWinStrategy_HV winStrategy1;
	protected Player player = Player.X;

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */

	// 00:
	public Board(int boardSize, GameChessStrategyNormal chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				cells[i][j] = '_';
			}
		}
		
		this.chessStrategy0 = chessStrategy;
		this.winStrategy0 = winStrategy;
	}
	// 01 :
	public Board(int boardSize, GameChessStrategyNormal chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy0 = chessStrategy;
		this.winStrategy1 = winStrategy;
	}
	// 10:
	public Board(int boardSize, GameChessStrategyInnormal chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy1 = chessStrategy;
		this.winStrategy0 = winStrategy;
	}
	//11:
	public Board(int boardSize, GameChessStrategyInnormal chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy1 = chessStrategy;
		this.winStrategy1 = winStrategy;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String[] move, char mod1, char mod2, int size, int index) {
		if (mod1 ==  '0') {
			chessStrategy0.putChess(cells, nextPlay(), move, index);

		} else if (mod1 == '1') {
			chessStrategy1.putChess(cells, nextPlay(), move, index);

		}
		if (mod2 == '0') {
			return winStrategy0.check(cells, size);

		} else {
			return winStrategy1.check(cells, size);

		}

	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(int size){
		StringBuffer str = new StringBuffer();
		str.append(" ");
		for (int i = 0; i < size; i++) {
			str.append(" " + (char)('A' + i));
		}

		System.out.println(str);
		for(int i=0 ;i < size; i++){
			System.out.print(i + 1);
			for(int j= 0; j < size; j++){
				System.out.print(" " + cells[i][j]);
			}
			System.out.println();
		}
	}
}