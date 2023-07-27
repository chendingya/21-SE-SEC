import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] agrs) {
        String s;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        int n = s.length();
        if (n % 2 == 1) {
            System.out.println("false");
        }

        Map<Character, Character> hash = new HashMap<>();
        hash.put(')', '(');
        hash.put(']', '[');
        hash.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (hash.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != hash.get(ch)) {
                    System.out.println("false");
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        System.out.println(stack.isEmpty());
    }
}
