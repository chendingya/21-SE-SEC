import java.util.ArrayList;
import java.util.List;
public class helloworld {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("0000");
        StringBuilder b = a;
        b = b.append('1');
        System.out.println("a is " + a);
        System.out.println("b is " + a);
    }
}