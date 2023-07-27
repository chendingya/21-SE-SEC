package cn.edu.nju.TicTacToe;

public class GameChessStrategyInnormal {
    public void putChess(char[][] cells, Player currentPlayer, String[] chessPos, int index)
    {
        int i = chessPos[index - 1].charAt(1) - '1';
        int j = chessPos[index - 1].charAt(0) - 'A';
        if (index > 10) {
            int m = chessPos[index - 11].charAt(1) - '1';
            int n = chessPos[index - 11].charAt(0) - 'A';
            cells[m][n] = '_';
            cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';

        } else {
            cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
        }
    }
}
