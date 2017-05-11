package baseproject.com.activity;

import org.junit.Test;

import baseproject.com.utils.TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by linchpin on 26/4/17.
 */

public class TestCaseJunit {

    @Test
    public void sumTest() {

        TestCases mTest = null, mTest2 = null;
        TestCases mTestNotNull = null;

        // Pass
        assertEquals(6, new TestCases().sum(2, 4));

        // Fail
//        assertEquals(7, new TestCases().sum(2, 4));

        //Pass
        assertNotEquals(7, new TestCases().sum(2, 4));

        // Fail
//        assertNotEquals(6, new TestCases().sum(2, 4));

        // Pass
        mTestNotNull = new TestCases();
        assertNotNull(mTestNotNull);

        // Fail
//        assertNotNull(mTest);

        // Pass
        assertNull(mTest);

        // Fail
//        assertNull(mTestNotNull);

        // Pass
        assertTrue(10 < 100);

        // Fail
//        assertTrue(10 > 100);

        // Pass
        assertFalse(10 > 100);

        //Fail
//        assertFalse(10 < 100);

        // Pass
        mTest = mTestNotNull;
        assertSame(mTest, mTestNotNull);

        //Fail
//        assertSame(mTest2, mTestNotNull);

        // Pass
        assertNotSame(mTest2, mTestNotNull);

        // Fail
//        assertNotSame(mTest, mTestNotNull);

        // Need to study
        //assertThat();

    }

}
