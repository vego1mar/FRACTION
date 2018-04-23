package pl.fraction.operators.comparison;

import org.junit.Assert;
import org.junit.Test;

public class ComparerTest {

    @Test
    public void isGreaterThan1() {
        // given
        // when
        boolean result1 = Comparer.isGreaterThan("1", "1");
        boolean result2 = Comparer.isGreaterThan("00000", "00000");
        boolean result3 = Comparer.isGreaterThan("00000", "000");
        boolean result4 = Comparer.isGreaterThan("666", "66");
        boolean result5 = Comparer.isGreaterThan("666", "665");
        boolean result6 = Comparer.isGreaterThan("666", "667");
        boolean result7 = Comparer.isGreaterThan("123987", "123012");

        // then
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertFalse(result3);
        Assert.assertTrue(result4);
        Assert.assertTrue(result5);
        Assert.assertFalse(result6);
        Assert.assertTrue(result7);
    }

}
