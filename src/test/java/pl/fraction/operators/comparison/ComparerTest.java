package pl.fraction.operators.comparison;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;

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

    @Test
    public void areEqualFractions1() {
        // given
        // when
        boolean result1 = Comparer.areEqualFractions(new Fraction("1", "2"), new Fraction("2", "4"), true);
        boolean result2 = Comparer.areEqualFractions(new Fraction("1", "552"), new Fraction("11", "6072"), true);
        boolean result3 = Comparer.areEqualFractions(new Fraction("5", "25"), new Fraction("25", "125"), true);
        boolean result4 = Comparer.areEqualFractions(new Fraction("10", "11"), new Fraction("110", "121"), true);

        final Fractionable fraction5 = new Fraction("23", "23");
        boolean result5 = Comparer.areEqualFractions(new Fraction("1", "1"), fraction5, false);

        // then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertTrue(result4);
        Assert.assertTrue(result5 && Comparer.areEqual(fraction5, new Fraction("23", "23")));
    }

    @Test
    public void isGreaterFractionThan1() {
        // given
        // when
        boolean result1 = Comparer.isGreaterFractionThan(new Fraction("5", "2"), new Fraction("5", "2"));
        boolean result2 = Comparer.isGreaterFractionThan(new Fraction("2", "4"), new Fraction("8", "16"));
        boolean result3 = Comparer.isGreaterFractionThan(new Fraction("7", "11"), new Fraction("8", "11"));
        boolean result4 = Comparer.isGreaterFractionThan(new Fraction("8", "12"), new Fraction("7", "12"));
        boolean result5 = Comparer.isGreaterFractionThan(new Fraction("5", "123"), new Fraction("23", "321"));
        boolean result6 = Comparer.isGreaterFractionThan(new Fraction("1", "2"), new Fraction("1", "3"));
        boolean result7 = Comparer.isGreaterFractionThan(new Fraction("1", "2"), new Fraction("2", "3"));

        // then
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertFalse(result3);
        Assert.assertTrue(result4);
        Assert.assertFalse(result5);
        Assert.assertTrue(result6);
        Assert.assertFalse(result7);
    }

}
