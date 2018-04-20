package pl.fraction.operators.addition;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.Fraction;
import pl.fraction.operators.comparison.Comparer;

public class FractionAdderTest {

    @Test
    public void addIntegers() {
        // given
        FractionAdder adder = new FractionAdder();

        // when
        Fraction result1 = adder.addIntegers(new Fraction("1", "2"), new Fraction("1", "3"));
        Fraction result2 = adder.addIntegers(new Fraction("2", "4"), new Fraction("3", "9"));
        Fraction result3 = adder.addIntegers(new Fraction("3", "7"), new Fraction("2", "1"));
        Fraction result4 = adder.addIntegers(new Fraction("123", "987"), new Fraction("739", "1010101"));

        // then
        Assert.assertTrue(Comparer.equality(result1, new Fraction("5","6")));
        Assert.assertTrue(Comparer.equality(result2, new Fraction("30","36")));
        Assert.assertTrue(Comparer.equality(result3, new Fraction("17","7")));
        Assert.assertTrue(Comparer.equality(result4, new Fraction("124971816","996969687")));
    }

}
