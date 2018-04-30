package pl.fraction.operators.division;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.comparison.Comparer;

public class FractionDivisionTest {

    @Test
    public void divideIntegers1() {
        // given
        FractionDivision divisioner = new FractionDivision();

        // when
        Fractionable result1 = divisioner.divideIntegers(new Fraction("1", "2"), new Fraction("1", "3"));
        Fractionable result2 = divisioner.divideIntegers(new Fraction("11", "315567"), new Fraction("5", "7182"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("3", "2")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("1254", "25045")));
    }

}
