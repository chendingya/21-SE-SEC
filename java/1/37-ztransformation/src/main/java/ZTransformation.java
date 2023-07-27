import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZTransformation {
    public static void main(String[] args) {
        String str;
        String tmp;
        int num = 0;


        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
            tmp = br.readLine();
            num = Integer.parseInt(tmp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int lens = str.length();

        //
        String[] table = new String[num];
        int i = 0;
        int now = 0;
        int space = 1;
        boolean direction = true;//向上为true, 向下为false
        while (i < lens) {
            if (num == 1) {

                for (int j = 0; j < lens; j++) {
                    if (j != lens - 1) {
                        System.out.print(str.charAt(j) + " ");
                    } else {
                        System.out.println(str.charAt(j));
                    }
                    i++;
                }
            } else {
                if (lens <= num) {
                    for (int j = 0; j < lens; j++) {
                        System.out.println(str.charAt(j));
                        i++;
                    }
                }
                else {
                    if (i < num) {
                        // 增加竖列数字：
                        table[now] = "" + str.charAt(i);

                        i++;
                        if (i < num) {
                            now++;
                        }
                    } else {
                        // 增加空格和数字：
                        if (direction) {
                            now = now - 1;
                        } else {
                            now++;
                        }
                        for (int j = 0; j < space; j++) {//增加空格
                            table[now] += " ";
                        }
                        table[now] += str.charAt(i);
                        space += 2;

                        //调整方向， space归1：
                        if (now == 0) {
                            space = 1;
                            direction = false;
                        }
                        if (now == num - 1) {
                            space = 1;
                            direction = true;
                        }
                        i++;
                    }

                }
            }

        }
        if (lens > num && num != 1) {
            for (int j = 0; j < num; j++) {
                System.out.println(table[j]);
            }
        }

    }
}
