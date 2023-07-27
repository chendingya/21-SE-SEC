import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

public class sumOfTwoNUmbers {

    public static void main(String[] args) {
        String str;
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String command = br.readLine();
            str = command;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int lens = str.length();
        System.out.println("lens is " + lens);
        if (lens % 2 != 0) {
            System.out.println("false1");
        } else {
            for (int i = 0; i < lens / 2; i++) {
                System.out.println(str.charAt(i));
                System.out.println(str.charAt(lens - i - 1));
                if (str.charAt(i) != str.charAt(lens - i - 1)) {
                    System.out.println("false2");
                    break;
                }
            }
            System.out.println("true");
        }

    }
}
