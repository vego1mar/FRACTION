package pl.fraction.containers.fraction;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.operators.comparison.Comparer;

public class FractionTest {

    @Test
    public void setNumerator() {
        // given
        Fraction fraction = new Fraction("1", "10");
        final String NUMERATOR = "9";

        // when
        fraction.setNumerator(NUMERATOR);
        String numerator = fraction.getNumerator();

        // then
        Assert.assertEquals(numerator, NUMERATOR);
    }

    @Test
    public void setDenominator() {
        // given
        Fraction fraction = new Fraction("99", "7");
        final String DENOMINATOR = "3";

        // when
        fraction.setDenominator(DENOMINATOR);
        String denominator1 = fraction.getDenominator();
        fraction.setDenominator("0");
        String denominator2 = fraction.getDenominator();

        // then
        Assert.assertEquals(denominator1, DENOMINATOR);
        Assert.assertEquals(denominator2, DENOMINATOR);
    }

    @Test
    public void shorten1() {
        // given
        final Fraction fraction1 = new Fraction("77", "77");
        final Fraction fraction2 = new Fraction("9182736450","1");
        final Fraction fraction3 = new Fraction("2","4");
        final Fraction fraction4 = new Fraction("3","9");
        final Fraction fraction5 = new Fraction("33","121");

        // when
        fraction1.shorten();
        fraction2.shorten();
        fraction3.shorten();
        fraction4.shorten();
        fraction5.shorten();

        // then
        Assert.assertTrue(Comparer.areEqual(fraction1, new Fraction("1", "1")));
        Assert.assertTrue(Comparer.areEqual(fraction2, new Fraction("9182736450", "1")));
        Assert.assertTrue(Comparer.areEqual(fraction3, new Fraction("1", "2")));
        Assert.assertTrue(Comparer.areEqual(fraction4, new Fraction("1", "3")));
        Assert.assertTrue(Comparer.areEqual(fraction5, new Fraction("3", "11")));
    }

}
