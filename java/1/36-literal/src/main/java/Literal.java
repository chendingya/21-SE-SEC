import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Literal {

    public static void main(String[] args) {
        String judge = null;
        int num = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            judge = br.readLine();
            num = judge.length();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (judge.endsWith("f")) {
            System.out.println("float");}
        if (judge.endsWith("L")) {
            System.out.println("long");}
        if (!judge.endsWith("f") && !judge.endsWith("L") && judge.contains(".") && !judge.endsWith("'")) {
            System.out.println("double");}
        if (judge.endsWith("'") && judge.startsWith("'")) {
            System.out.println("char");}
        if (judge.compareTo("false") == 0 || judge.compareTo("true") == 0) {
            System.out.println("boolean");}
        if (!judge.endsWith("f") && !judge.endsWith("L") && !judge.contains(".") && !judge.endsWith("'") && judge.compareTo("false") != 0 && judge.compareTo("true") != 0) {
            System.out.println("integer");
        }
    }
}
