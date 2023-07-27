public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String moveStr) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        String[] moves = moveStr.split(",");
        Result res = null;
        int count = 0;
        for (String move : moves) {
            count++;
            res = nextMove(board, move, count);
            Game.print(board);
            // 游戏结束
            if (!res.equals(Result.GAMING)) {
                break;
            }
        }
        return res;
    }

    public Result nextMove(char[][] board, String move, int count) {
        char tmp = 'N';
        switch (count % 2) {
            case 1: tmp = 'X'; break;
            case 0: tmp = 'O'; break;
        }
        switch (move) {
            case "A1":
                board[0][0] = tmp; break;
            case "A2":
                board[1][0] = tmp; break;
            case "A3":
                board[2][0] = tmp; break;
            case "B1":
                board[0][1] = tmp; break;
            case "B2":
                board[1][1] = tmp; break;
            case "B3":
                board[2][1] = tmp; break;
            case "C1":
                board[0][2] = tmp; break;
            case "C2":
                board[1][2] = tmp; break;
            case "C3":
                board[2][2] = tmp; break;
        }
        Boolean xwin = false;
        Boolean owin = false;
        Boolean draw = false;
        Boolean gaming = false;

        //xwin or owin:
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '_') {
                switch (board[i][0]) {
                    case 'X': xwin = true; break;
                    case 'O': owin = true; break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '_') {
                switch (board[0][i]) {
                    case 'X': xwin = true; break;
                    case 'O': owin = true; break;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[2][2] != '_') {
            switch (board[0][0]) {
                case 'X': xwin = true; break;
                case 'O': owin = true; break;
            }
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[2][0] != '_') {
            switch (board[0][2]) {
                case 'X': xwin = true; break;
                case 'O': owin = true; break;
            }
        }

        //gaming or draw:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    gaming = true;
                    break;
                }
            }
        }
        if (xwin) {

            return Result.X_WIN;
        } else {
            if (owin) {
                return Result.O_WIN;
            } else {
                if (gaming) {
                    return Result.GAMING;
                } else {
                    return Result.DRAW;
                }
            }
        }

    }
    public static void print(char[][] board){
        System.out.println("  A B C");
        for(int i = 0 ;i < 3; i++){
            System.out.print(i + 1);
            for(int j = 0; j < 3; j++){
                System.out.print(" "+ board[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("C1,A2,C2,A1,B2,A3");
        System.out.println(result);
    }
}
