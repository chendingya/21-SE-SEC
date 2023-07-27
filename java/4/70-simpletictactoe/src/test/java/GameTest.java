
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class GameTest {
    
    Game game = null;
    Result result = null;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String lineSeparator = System.getProperty("line.separator"); 

    @org.junit.Before
    public void setUp() throws Exception {
        game = new Game();

        bytes = new ByteArrayOutputStream();
        console = System.out;

        System.setOut(new PrintStream(bytes));


    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @org.junit.Test
    public void test1() throws Exception {
        result = game.playGame("A1,B1,B2,B3,C3");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O _"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O _"+lineSeparator
                +"2 _ X _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O _"+lineSeparator
                +"2 _ X _"+lineSeparator
                +"3 _ O _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O _"+lineSeparator
                +"2 _ X _"+lineSeparator
                +"3 _ O X"+lineSeparator,bytes.toString());
    }
    @org.junit.Test
    public void test2() throws Exception {
        result = game.playGame("A1,A2,B1,B2,C1");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O O _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X X"+lineSeparator
                +"2 O O _"+lineSeparator
                +"3 _ _ _"+lineSeparator,bytes.toString());
    }
    @org.junit.Test
    public void test3() throws Exception {
        result = game.playGame("C1,A2,C2,B2,C3");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O O X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O O X"+lineSeparator
                +"3 _ _ X"+lineSeparator,bytes.toString());
    }
    @org.junit.Test
    public void test4() throws Exception {
        result = game.playGame("C1,A2,C2,C3,B2,A3,A1,B1,B3");
        assertEquals(Result.DRAW,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ X"+lineSeparator
                +"3 _ _ O"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 _ _ O"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 O _ O"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 O _ O"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 O _ O"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X O X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 O X O"+lineSeparator,bytes.toString());
    }
        @org.junit.Test
    public void test5() throws Exception {
        result = game.playGame("A1,C1,A2,B2,B1,A3");
        boolean b = result.equals(Result.O_WIN);
        assertEquals(b,true);
        //assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ O"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ O"+lineSeparator
                +"2 X _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ O"+lineSeparator
                +"2 X O _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X O"+lineSeparator
                +"2 X O _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X O"+lineSeparator
                +"2 X O _"+lineSeparator
                +"3 O _ _"+lineSeparator,bytes.toString());
    }
    @org.junit.Test
    public void test6() throws Exception {
        result = game.playGame("A1,A2,B1,B2,C3,C2");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X _ _"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O O _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O O _"+lineSeparator
                +"3 _ _ X"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 X X _"+lineSeparator
                +"2 O O O"+lineSeparator
                +"3 _ _ X"+lineSeparator,bytes.toString());
    }
    @org.junit.Test
    public void test7() throws Exception {
        result = game.playGame("C1,A2,C2,A1,B2,A3");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 _ _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ _"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 _ _ X"+lineSeparator
                +"2 O _ X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 O _ X"+lineSeparator
                +"2 O _ X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 O _ X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 _ _ _"+lineSeparator
                +"  A B C"+lineSeparator
                +"1 O _ X"+lineSeparator
                +"2 O X X"+lineSeparator
                +"3 O _ _"+lineSeparator,bytes.toString());
    }

}
