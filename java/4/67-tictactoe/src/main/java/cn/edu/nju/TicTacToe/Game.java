package cn.edu.nju.TicTacToe;
public class Game {
    /**
     * Game的接口方法，我们会通过该方法进行测试
     * @param gameMode 游戏模式,有四种可能，00,01,10,11
     * @param moveStr 落子序列
     * @param size 棋盘大小，size最小为3， 最大为9
     * @return 游戏结果
     * 
     * 根据需要改写方法，参数，返回结果类型不可修改
     */

	public Board createBoard(String gameMode, int size) {
		if (gameMode == "00") {
			GameChessStrategyNormal chessStrategy0 = new GameChessStrategyNormal();
			GameWinStrategy_HVD  winStrategy0 = new GameWinStrategy_HVD();
			return new Board(size, chessStrategy0, winStrategy0);
		} else {
			if (gameMode == "01") {
				GameChessStrategyNormal chessStrategy0 = new GameChessStrategyNormal();
				GameWinStrategy_HV  winStrategy1 = new GameWinStrategy_HV();
				return new Board(size, chessStrategy0, winStrategy1);
			} else {
				if (gameMode == "10") {
					GameChessStrategyInnormal chessStrategy1 = new GameChessStrategyInnormal();
					GameWinStrategy_HVD  winStrategy0 = new GameWinStrategy_HVD();
					return new Board(size, chessStrategy1, winStrategy0);
				} else {
						GameChessStrategyInnormal chessStrategy1 = new GameChessStrategyInnormal();
						GameWinStrategy_HV  winStrategy1 = new GameWinStrategy_HV();
						return new Board(size, chessStrategy1, winStrategy1);
				}
			}
		}
	}

    public Result playGame(String gameMode, String moveStr, int size){
		Board board = createBoard(gameMode, size);
		char mod1 = gameMode.charAt(0);
		char mod2 = gameMode.charAt(1);

    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;
		int index = 0;
    	for(String move: moves){
			index++;
    		res = board.nextMove(moves, mod1, mod2, size, index);
    		board.print(size);
    		// 游戏结束
    		if( !res.equals(Result.GAMING) )
    			break;
    	}
    	return res;
    }

	public static void main(String[] args){
		Game game = new Game();
		Result result = game.playGame("10","C5,C4,D5,B5,C6,D3",7);
		System.out.println(result);
	}
}