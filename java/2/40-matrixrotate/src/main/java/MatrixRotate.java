import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixRotate {
    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        int angle = 0;
        int[][] table = new int[1000][1000];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tmp = br.readLine();
            String[] rowsandcols = tmp.split(" ");
            row = Integer.parseInt(rowsandcols[0]);
            col = Integer.parseInt(rowsandcols[1]);

            for (int i = 0; i < row; i++) {
                String[] str = (br.readLine().split(" "));
                for (int j = 0; j < col; j++) {
                    table[i][j] = Integer.parseInt(str[j]);
                }
            }
            angle = Integer.parseInt(br.readLine());
            angle = angle / 90;
            angle = angle % 4;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //address:
        if(angle == 1) {
            for (int j = 0; j < col; j++){
                for (int i = row - 1; i >= 0; i--) {
                    if (i == 0) {
                        System.out.print(table[i][j]);
                    } else {
                        System.out.print(table[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

        if(angle == 2) {
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    if (j == 0) {
                        System.out.print(table[i][j]);
                    } else {
                        System.out.print(table[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        if(angle == 3) {
            for (int j = col - 1; j >= 0; j--) {
                for (int i = 0; i < row; i++) {
                    if (i == row - 1) {
                        System.out.print(table[i][j]);
                    } else {
                        System.out.print(table[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        if(angle == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j == col -1) {
                        System.out.print(table[i][j]);
                    } else {
                        System.out.print(table[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
