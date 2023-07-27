package cn.edu.nju.TicTacToe;
/**
 * Created with IntelliJ IDEA.
 * User: qinliu
 * Date: 14-4-16
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeTest {  
    Game game = null;
    Result result = null;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String lineBreak = null;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        lineBreak = System.getProperty( "line.separator" );
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
    
    /**
     * 测试3*3时01模式X行获胜
     */
    @Test
    public void test3by3_01_X_WIN_by_row() throws Exception {
        result = game.playGame("01","A1,C2,B1,B3,C1",3);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ O"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X X _"+lineBreak
                +"2 _ _ O"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X X _"+lineBreak
                +"2 _ _ O"+lineBreak
                +"3 _ O _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X X X"+lineBreak
                +"2 _ _ O"+lineBreak
                +"3 _ O _"+lineBreak,bytes.toString());
    }
	
	/**
     * 测试3*3时01模式O列获胜
     */
    @Test
    public void test3by3_01_O_WIN_by_column() throws Exception {
        result = game.playGame("01","A1,C2,B2,C1,A3,C3",3);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ O"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ X O"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 _ X O"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 _ X O"+lineBreak
                +"3 X _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 _ X O"+lineBreak
                +"3 X _ O"+lineBreak,bytes.toString());
    }
    
    /**
     * 测试3*3时00模式双方打平
     */
    @Test
    public void test3by3_00_DRAW() throws Exception {
        result = game.playGame("00","C1,A2,C2,C3,B2,A3,A1,B1,B3",3);
        assertEquals(Result.DRAW,result);
        assertEquals(
                 "  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 O _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 O _ X"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 O _ X"+lineBreak
                +"3 _ _ O"+lineBreak
                +"  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 O X X"+lineBreak
                +"3 _ _ O"+lineBreak
                +"  A B C"+lineBreak
                +"1 _ _ X"+lineBreak
                +"2 O X X"+lineBreak
                +"3 O _ O"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ X"+lineBreak
                +"2 O X X"+lineBreak
                +"3 O _ O"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O X"+lineBreak
                +"2 O X X"+lineBreak
                +"3 O _ O"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O X"+lineBreak
                +"2 O X X"+lineBreak
                +"3 O X O"+lineBreak,bytes.toString());
    }
	
	/**
     * 测试3*3时00模式X对角线获胜
     */
    @Test
    public void test3by3_00_X_WIN_by_diagonal() throws Exception {
        result = game.playGame("00",("A1,B1,B2,B3,C3"),3);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O _"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O _"+lineBreak
                +"2 _ X _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O _"+lineBreak
                +"2 _ X _"+lineBreak
                +"3 _ O _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X O _"+lineBreak
                +"2 _ X _"+lineBreak
                +"3 _ O X"+lineBreak,bytes.toString());
    }
	
	/**
     * 测试3*3时00模式O反对角线获胜
     */
    @Test
    public void test3by3_00_O_WIN_by_backDiagonal() throws Exception {
        result = game.playGame("00","A1,C1,A2,B2,B1,A3",3);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C"+lineBreak
                +"1 X _ _"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 _ _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 X _ _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X _ O"+lineBreak
                +"2 X O _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X X O"+lineBreak
                +"2 X O _"+lineBreak
                +"3 _ _ _"+lineBreak
                +"  A B C"+lineBreak
                +"1 X X O"+lineBreak
                +"2 X O _"+lineBreak
                +"3 O _ _"+lineBreak,bytes.toString());
    }
    
    /**
     * 测试4*4时11模式X行获胜
     */
    @Test
    public void test4by4_11_X_WIN_by_row() throws Exception {
        result = game.playGame("11","C2,B3,D3,B1,B2,D2,A3,C1,B4,C4,A2,A4,C2",4);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ O _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X _"+lineBreak
                +"3 _ O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 _ O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 X O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 X O _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 X O _ X"+lineBreak
                +"4 _ X _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 X O _ X"+lineBreak
                +"4 _ X O _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 X X _ O"+lineBreak
                +"3 X O _ X"+lineBreak
                +"4 _ X O _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 X X _ O"+lineBreak
                +"3 X _ _ X"+lineBreak
                +"4 O X O _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O O _"+lineBreak
                +"2 X X X O"+lineBreak
                +"3 X _ _ _"+lineBreak
                +"4 O X O _"+lineBreak
                ,bytes.toString());
    }
    
    /*
     * 测试4*4时11模式O列获胜
     */
    @Test
    public void test4by4_11_O_WIN_by_column() throws Exception {
        result = game.playGame("11","C2,A4,D3,B1,B2,D2,C4,A2,B4,A1,C3,A3",4);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 O _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ _ _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ _ X _"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X _"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 _ X X O"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 O X X O"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O _ X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 _ O _ _"+lineBreak
                +"2 O X X O"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O X X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 O O _ _"+lineBreak
                +"2 O X X O"+lineBreak
                +"3 _ _ _ X"+lineBreak
                +"4 O X X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 O O _ _"+lineBreak
                +"2 O X _ O"+lineBreak
                +"3 _ _ X X"+lineBreak
                +"4 O X X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 O O _ _"+lineBreak
                +"2 O X _ O"+lineBreak
                +"3 O _ X X"+lineBreak
                +"4 _ X X _"+lineBreak
                ,bytes.toString());
    }
    
    /*
     * 测试4*4时00模式DRAW
     */
    @Test
    public void test4by4_00_DRAW() throws Exception {
        result = game.playGame("00","A1,B1,C1,D1,B2,A2,D2,C2,B3,A3,D3,C3,C4,B4,A4,D4",4);
        assertEquals(Result.DRAW,result);
        assertEquals(
                 "  A B C D"+lineBreak
                +"1 X _ _ _"+lineBreak
                +"2 _ _ _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O _ _"+lineBreak
                +"2 _ _ _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X _"+lineBreak
                +"2 _ _ _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 _ _ _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 _ X _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X _ _"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X _ X"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 _ _ _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 _ X _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X _ _"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X _ X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X O X"+lineBreak
                +"4 _ _ _ _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X O X"+lineBreak
                +"4 _ _ X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X O X"+lineBreak
                +"4 _ O X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X O X"+lineBreak
                +"4 X O X _"+lineBreak
                +"  A B C D"+lineBreak
                +"1 X O X O"+lineBreak
                +"2 O X O X"+lineBreak
                +"3 O X O X"+lineBreak
                +"4 X O X O"+lineBreak
                ,bytes.toString());
    }
    
    /**
     * 测试5*5时10模式X获胜
     */
    @Test
    public void test5by5_10_X_WIN_by_row() throws Exception {
        result = game.playGame("10","C3,D4,B4,D2,B2,B3,C5,C4,B5,A5,D5",5);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ _ _ _ _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ _ _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ O _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ X _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O X _ _"+lineBreak
                +"4 _ X O O _"+lineBreak
                +"5 _ _ X _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O X _ _"+lineBreak
                +"4 _ X O O _"+lineBreak
                +"5 _ X X _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O X _ _"+lineBreak
                +"4 _ X O O _"+lineBreak
                +"5 O X X _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ X _ O _"+lineBreak
                +"3 _ O _ _ _"+lineBreak
                +"4 _ X O O _"+lineBreak
                +"5 O X X X _"+lineBreak
                ,bytes.toString());
    }
	
	/**
     * 测试5*5时10模式X对角获胜
     */
    @Test
    public void test5by5_10_X_WIN_by_dianogal() throws Exception {
        result = game.playGame("10","C3,D4,B4,D2,A5",5);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ _ _ _ _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ _ _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ O _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 _ _ _ _ _"+lineBreak
                +"  A B C D E"+lineBreak
                +"1 _ _ _ _ _"+lineBreak
                +"2 _ _ _ O _"+lineBreak
                +"3 _ _ X _ _"+lineBreak
                +"4 _ X _ O _"+lineBreak
                +"5 X _ _ _ _"+lineBreak
                ,bytes.toString());
    }
    
    /**
     * 测试6*6时00模式X获胜
     */
    @Test
    public void test6by6_00_X_WIN_by_diagonal() throws Exception {
        result = game.playGame("00","C3,C4,B2,D4,A1",6);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ _ _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O O _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 X _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O O _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
	
	/**
     * 测试6*6时00模式O反对角获胜
     */
    @Test
    public void test6by6_00_O_WIN_by_backDiagonal() throws Exception {
        result = game.playGame("00","C3,C4,B2,D3,B4,E2",6);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ _ _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _"+lineBreak
                +"4 _ _ O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X O _ _"+lineBreak
                +"4 _ _ O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ _ _"+lineBreak
                +"3 _ _ X O _ _"+lineBreak
                +"4 _ X O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                +"  A B C D E F"+lineBreak
                +"1 _ _ _ _ _ _"+lineBreak
                +"2 _ X _ _ O _"+lineBreak
                +"3 _ _ X O _ _"+lineBreak
                +"4 _ X O _ _ _"+lineBreak
                +"5 _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
    
    /**
     * 测试7*7时10模式O获胜
     */
    @Test
    public void test7by7_10_O_WIN_by_backDiagonal() throws Exception {
        result = game.playGame("10","C5,C4,D5,B5,C6,D3",7);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ _ X X _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ O _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
	
	/**
     * 测试7*7时10模式O行获胜
     */
    @Test
    public void test7by7_10_O_WIN_by_row() throws Exception {
        result = game.playGame("10","C5,C4,D5,B5,C6,D4,B6,E4",7);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ _ X X _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O _ _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O O _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O O _ _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ X X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G"+lineBreak
                +"1 _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O O O _ _"+lineBreak
                +"5 _ O X X _ _ _"+lineBreak
                +"6 _ X X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
    
    /**
     * 测试8*8时01模式X获胜
     */
    @Test
    public void test8by8_01_X_WIN_by_row() throws Exception {
        result = game.playGame("01","C5,D5,D4,E5,E4,D6,F4",8);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ X _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ X _ _ _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ X X _ _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ X X _ _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ O _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ X X X _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ O _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
	
	/**
     * 测试8*8时01模式X列获胜
     */
    @Test
    public void test8by8_01_X_WIN_by_column() throws Exception {
        result = game.playGame("01","C5,D5,C4,E5,C3",8);
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ X _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ X _ _ _ _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H"+lineBreak
                +"1 _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ X _ _ _ _ _"+lineBreak
                +"4 _ _ X _ _ _ _ _"+lineBreak
                +"5 _ _ X O O _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
    
    /**
     * 测试9*9时11模式O列获胜
     */
    @Test
    public void test9by9_11_O_WIN_by_column() throws Exception {
        result = game.playGame("11","C5,D5,E6,D4,B6,D6",9);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ O X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
	
	/**
     * 测试9*9时11模式O行获胜
     */
    @Test
    public void test9by9_11_O_WIN_by_row() throws Exception {
        result = game.playGame("11","C5,D5,E6,D4,B6,E4,D6,C4",9);
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X _ _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ _ _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ _ _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ _ _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O _ _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O O _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ _ X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ _ O O _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ X X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                +"  A B C D E F G H I"+lineBreak
                +"1 _ _ _ _ _ _ _ _ _"+lineBreak
                +"2 _ _ _ _ _ _ _ _ _"+lineBreak
                +"3 _ _ _ _ _ _ _ _ _"+lineBreak
                +"4 _ _ O O O _ _ _ _"+lineBreak
                +"5 _ _ X O _ _ _ _ _"+lineBreak
                +"6 _ X _ X X _ _ _ _"+lineBreak
                +"7 _ _ _ _ _ _ _ _ _"+lineBreak
                +"8 _ _ _ _ _ _ _ _ _"+lineBreak
                +"9 _ _ _ _ _ _ _ _ _"+lineBreak
                ,bytes.toString());
    }
}
