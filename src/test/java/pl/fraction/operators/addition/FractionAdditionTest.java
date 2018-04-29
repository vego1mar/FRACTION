package pl.fraction.operators.addition;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.comparison.Comparer;

public class FractionAdditionTest {

    @Test
    public void addIntegers1() {
        // given
        FractionAddition adder = new FractionAddition();

        // when
        Fractionable result1 = adder.addIntegers(new Fraction("2", "4"), new Fraction("3", "9"));
        Fractionable result2 = adder.addIntegers(new Fraction("1", "14"), new Fraction("1", "12"));
        Fractionable result3 = adder.addIntegers(new Fraction("1", "27"), new Fraction("27", "25"));
        Fractionable result4 = adder.addIntegers(new Fraction("5", "33"), new Fraction("23", "121"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("5", "6")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("13", "84")));
        Assert.assertTrue(Comparer.areEqual(result3, new Fraction("754", "675")));
        Assert.assertTrue(Comparer.areEqual(result4, new Fraction("124", "363")));
    }

}
