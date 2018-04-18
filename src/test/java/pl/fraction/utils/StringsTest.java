package pl.fraction.utils;

import java.util.ArrayList;
import java.util.List;
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
    public void getArray() {
        // given
        final int LENGTH = 11;
        final char INITIALIZER = '0';

        // when
        char[] result1 = Strings.getArray(LENGTH, INITIALIZER);

        // then
        Assert.assertEquals("00000000000", new String(result1));
    }

    @Test
    public void getString() {
        // given
        final int LENGTH1 = 0;
        final int LENGTH2 = 1;
        final int LENGTH3 = 2;
        final int LENGTH4 = 9;

        // when
        String result1 = Strings.getString(LENGTH1, 'A');
        String result2 = Strings.getString(LENGTH2, '\n');
        String result3 = Strings.getString(LENGTH3, '!');
        String result4 = Strings.getString(LENGTH4, '0');

        // then
        Assert.assertEquals("", result1);
        Assert.assertEquals("\n", result2);
        Assert.assertEquals("!!", result3);
        Assert.assertEquals("000000000", result4);
    }

    @Test
    public void getIndexOfLastLeadingZero() {
        // given
        final String STRING_1 = "";
        final String STRING_2 = "0";
        final String STRING_3 = "q";
        final String STRING_4 = "1\n0";
        final String STRING_5 = "0000CIRHTOL&NAIROL";

        // when
        int index1 = Strings.getIndexOfLastLeadingZero(STRING_1);
        int index2 = Strings.getIndexOfLastLeadingZero(STRING_2);
        int index3 = Strings.getIndexOfLastLeadingZero(STRING_3);
        int index4 = Strings.getIndexOfLastLeadingZero(STRING_4);
        int index5 = Strings.getIndexOfLastLeadingZero(STRING_5);

        // then
        Assert.assertEquals(-1, index1);
        Assert.assertEquals(-1, index2);
        Assert.assertEquals(-1, index3);
        Assert.assertEquals(-1, index4);
        Assert.assertEquals(3, index5);
    }

    @Test
    public void getWithoutLeadingZeroes() {
        // given
        final String STRING_1 = "";
        final String STRING_2 = "A";
        final String STRING_3 = "z00457";
        final String STRING_4 = "98364000";
        final String STRING_5 = "73403434034000340";
        final String STRING_6 = "0567";
        final String STRING_7 = "0000004545000045000040000";

        // when
        String result1 = Strings.getWithoutLeadingZeroes(STRING_1);
        String result2 = Strings.getWithoutLeadingZeroes(STRING_2);
        String result3 = Strings.getWithoutLeadingZeroes(STRING_3);
        String result4 = Strings.getWithoutLeadingZeroes(STRING_4);
        String result5 = Strings.getWithoutLeadingZeroes(STRING_5);
        String result6 = Strings.getWithoutLeadingZeroes(STRING_6);
        String result7 = Strings.getWithoutLeadingZeroes(STRING_7);

        // then
        Assert.assertEquals(STRING_1, result1);
        Assert.assertEquals(STRING_2, result2);
        Assert.assertEquals(STRING_3, result3);
        Assert.assertEquals(STRING_4, result4);
        Assert.assertEquals(STRING_5, result5);
        Assert.assertEquals("567", result6);
        Assert.assertEquals("4545000045000040000", result7);
    }

    @Test
    public void getShortenedNumbers() {
        // given
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        list.add(new StringBuilder());
        list.add(new StringBuilder());
        list.get(0).append("70");
        list.get(1).append("0210");
        list.get(2).append("003500");

        // when
        List<String> result = Strings.getShortenedNumbers(list);

        // then
        Assert.assertEquals("70", result.get(0));
        Assert.assertEquals("210", result.get(1));
        Assert.assertEquals("3500", result.get(2));
    }

}
