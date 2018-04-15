package pl.fraction.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringsTest {

    @Test
    public void isSimpleNumeric() {
        // given
        final String NUMERIC_1 = "00000";
        final String NUMERIC_2 = "01234567890987654321";
        final String NUMERIC_3 = "+2";
        final String NUMERIC_4 = "-10";
        final String NUMERIC_5 = "0.5";
        final String NUMERIC_6 = "0,334";
        final String NUMERIC_7 = "100 000 000";

        // when
        boolean result1 = Strings.isSimpleNumeric(NUMERIC_1);
        boolean result2 = Strings.isSimpleNumeric(NUMERIC_2);
        boolean result3 = Strings.isSimpleNumeric(NUMERIC_3);
        boolean result4 = Strings.isSimpleNumeric(NUMERIC_4);
        boolean result5 = Strings.isSimpleNumeric(NUMERIC_5);
        boolean result6 = Strings.isSimpleNumeric(NUMERIC_6);
        boolean result7 = Strings.isSimpleNumeric(NUMERIC_7);

        // then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
        Assert.assertFalse(result6);
        Assert.assertFalse(result7);
    }

    @Test
    public void isZeroed() {
        // given
        final String STRING_1 = "0";
        final String STRING_2 = "0000000";
        final String STRING_3 = "0 0 0 0 0 0 0 0 0";
        final String STRING_4 = "+0";
        final String STRING_5 = "-0";
        final String STRING_6 = "0.0";
        final String STRING_7 = "0,0";
        final String STRING_8 = "010";
        final String STRING_9 = "100000000000";
        final String STRING_10 = "000000000001";
        final String STRING_11 = "000000100000";

        // when
        boolean result1 = Strings.isZeroed(STRING_1);
        boolean result2 = Strings.isZeroed(STRING_2);
        boolean result3 = Strings.isZeroed(STRING_3);
        boolean result4 = Strings.isZeroed(STRING_4);
        boolean result5 = Strings.isZeroed(STRING_5);
        boolean result6 = Strings.isZeroed(STRING_6);
        boolean result7 = Strings.isZeroed(STRING_7);
        boolean result8 = Strings.isZeroed(STRING_8);
        boolean result9 = Strings.isZeroed(STRING_9);
        boolean result10 = Strings.isZeroed(STRING_10);
        boolean result11 = Strings.isZeroed(STRING_11);

        // then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
        Assert.assertFalse(result6);
        Assert.assertFalse(result7);
        Assert.assertFalse(result8);
        Assert.assertFalse(result9);
        Assert.assertFalse(result10);
        Assert.assertFalse(result11);
    }

    @Test
    public void get() {
        // given
        final int LENGTH = 11;
        final char INITIALIZER = '0';

        // when
        char[] result1 = Strings.get(LENGTH, INITIALIZER);

        // then
        Assert.assertEquals("00000000000", new String(result1));
    }

}
