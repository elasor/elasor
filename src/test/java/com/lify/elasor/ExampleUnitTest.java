package com.lify.elasor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test1() {

        boolean[] a = {true, false};
        boolean[] b = {true, false};
        boolean[] c = {true, false};

        for (boolean a1 : a) {
            for (boolean b1 : b) {
                for (boolean c1 : c) {
                    boolean d = a1 && (!b1 || !c1);
                    System.out.println(a1 + "+" + b1 + "+" + c1 + " = " + d);
                }
            }
        }

    }
}