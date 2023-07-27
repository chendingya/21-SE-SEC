package cn.nju.test9arrivalofgeneral2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrivalOfGeneralTest {

    @Test
    public void test1() {
        int[] heightArr = {21, 11, 75, 32};
        assertEquals(3, ArrivalOfGeneral.calculate(heightArr.length, heightArr));
    }

    @Test
    public void test2() {
        int[] heightArr = {21, 11};
        assertEquals(0, ArrivalOfGeneral.calculate(heightArr.length, heightArr));
    }

    @Test
    public void test3() {
        int[] heightArr = {11, 88, 33, 90, 1, 3, 44, 34, 22, 22};
        assertEquals(8, ArrivalOfGeneral.calculate(heightArr.length, heightArr));
    }

    @Test
    public void test4() {
        int[] heightArr = {23, 44, 1, 22, 34, 56, 444, 65, 21, 43, 78, 89, 5, 12, 9, 11};
        assertEquals(18, ArrivalOfGeneral.calculate(heightArr.length, heightArr));
    }

    @Test
    public void test5() {
        int[] heightArr = {6, 4, 65, 21, 43, 78, 89, 444};
        assertEquals(12, ArrivalOfGeneral.calculate(heightArr.length, heightArr));
    }
}
