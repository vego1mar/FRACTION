package pl.fraction.operators;

import pl.fraction.containers.Fraction;
import org.junit.Assert;
import org.junit.Test;

public class OperatorsTest {

    @Test
    public void areEqual() {
        // given
        final String NUMERATOR_1 = "2";
        final String NUMERATOR_2 = "8";
        final String NUMERATOR_3 = "908070605040302010";
        final String DENOMINATOR_1 = "8";
        final String DENOMINATOR_2 = "2";
        final String DENOMINATOR_3 = "10101010101010111001";
        Fraction fraction1 = new Fraction(NUMERATOR_1, DENOMINATOR_1);
        Fraction fraction2 = new Fraction(NUMERATOR_2, DENOMINATOR_2);
        Fraction fraction3 = new Fraction(NUMERATOR_3, DENOMINATOR_3);

        // when
        boolean result1 = Operators.areEqual(fraction1, fraction2);
        boolean result2 = Operators.areEqual(fraction1, new Fraction(NUMERATOR_1, DENOMINATOR_1));
        boolean result3 = Operators.areEqual(new Fraction(NUMERATOR_2, DENOMINATOR_2), fraction2);
        boolean result4 = Operators.areEqual(fraction2, fraction1);
        boolean result5 = Operators.areEqual(fraction1, fraction1);
        boolean result6 = Operators.areEqual(fraction2, fraction2);
        boolean result7 = Operators.areEqual(new Fraction("", ""), new Fraction("", ""));
        boolean result8 = Operators.areEqual(fraction3, new Fraction(NUMERATOR_3, DENOMINATOR_3));

        // then
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);
        Assert.assertTrue(result5);
        Assert.assertTrue(result6);
        Assert.assertTrue(result7);
        Assert.assertTrue(result8);
    }

}
