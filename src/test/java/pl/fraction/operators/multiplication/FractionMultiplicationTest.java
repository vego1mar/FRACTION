package pl.fraction.operators.multiplication;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.comparison.Comparer;

public class FractionMultiplicationTest {

    @Test
    public void multiplyIntegers1() {
        // given
        FractionMultiplication multiplicator = new FractionMultiplication();

        // when
        Fractionable result1 = multiplicator.multiplyIntegers(new Fraction("1", "2"), new Fraction("3", "4"));
        Fractionable result2 = multiplicator.multiplyIntegers(new Fraction("8", "11"), new Fraction("616", "617"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("3", "8")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("448", "617")));
    }

}
