package baseproject.com.activity.util;

import org.junit.Test;

import baseproject.com.utils.TestCases;

import static org.junit.Assert.assertEquals;

/**
 * Created by linchpin on 26/4/17.
 */

public class TestCaseJunit {

    @Test
    public void sumTest() {
        assertEquals(6, new TestCases().sum(2, 4));
    }

}
