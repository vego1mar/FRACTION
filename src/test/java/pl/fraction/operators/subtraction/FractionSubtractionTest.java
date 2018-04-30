package pl.fraction.operators.subtraction;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.comparison.Comparer;

public class FractionSubtractionTest {

    @Test
    public void subtractIntegers1() {
        // given
        FractionSubtraction subtractor = new FractionSubtraction();

        // when
        Fractionable result1 = subtractor.subtractIntegers(new Fraction("1", "6"), new Fraction("3", "32"));
        Fractionable result2 = subtractor.subtractIntegers(new Fraction("7", "33"), new Fraction("12", "121"));
        Fractionable result3 = subtractor.subtractIntegers(new Fraction("23", "210"), new Fraction("661", "966"));
        Fractionable result4 = subtractor.subtractIntegers(new Fraction("66", "15"), new Fraction("66", "15"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("7", "96")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("41", "363")));
        Assert.assertTrue(Comparer.areEqual(result3, new Fraction("1388", "2415")));
        Assert.assertTrue(Comparer.areEqual(result4, new Fraction("0", "1")));
    }

}
