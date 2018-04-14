package opensource.fraction.containers;

import org.junit.Assert;
import org.junit.Test;

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

}
