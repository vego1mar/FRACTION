package pl.fraction.operators.basics;

import org.junit.Assert;
import org.junit.Test;
import pl.fraction.containers.Fraction;
import pl.fraction.operators.comparison.Comparer;

public class FractionBasicsTest {

    @Test
    public void addIntegers1() {
        // given
        FractionBasics operator = new FractionBasics();

        // when
        Fraction result1 = operator.addIntegers(new Fraction("1", "2"), new Fraction("1", "3"));
        Fraction result2 = operator.addIntegers(new Fraction("123", "987"), new Fraction("739", "1010101"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("5", "6")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("124971816", "996969687")));
    }

    @Test
    public void subtractIntegers1() {
        // given
        FractionBasics operator = new FractionBasics();

        // when
        Fraction result1 = operator.subtractIntegers(new Fraction("1", "2"), new Fraction("1", "3"));
        Fraction result2 = operator.subtractIntegers(new Fraction("1", "11"), new Fraction("2", "27"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("1", "6")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("5", "297")));
    }

    @Test
    public void multiplyIntegers1() {
        // given
        FractionBasics operator = new FractionBasics();

        // when
        Fraction result1 = operator.multiplyIntegers(new Fraction("1", "3"), new Fraction("1", "5"));
        Fraction result2 = operator.multiplyIntegers(new Fraction("3", "7"), new Fraction("2", "5"));
        Fraction result3 = operator.multiplyIntegers(new Fraction("2", "4"), new Fraction("3", "9"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("1", "15")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("6", "35")));
        Assert.assertTrue(Comparer.areEqual(result3, new Fraction("6", "36")));
    }

    @Test
    public void divideIntegers1() {
        // given
        FractionBasics operator = new FractionBasics();

        // when
        Fraction result1 = operator.divideIntegers(new Fraction("1", "3"), new Fraction("1", "5"));
        Fraction result2 = operator.divideIntegers(new Fraction("3", "7"), new Fraction("2", "5"));
        Fraction result3 = operator.divideIntegers(new Fraction("2", "4"), new Fraction("3", "9"));

        // then
        Assert.assertTrue(Comparer.areEqual(result1, new Fraction("5", "3")));
        Assert.assertTrue(Comparer.areEqual(result2, new Fraction("15", "14")));
        Assert.assertTrue(Comparer.areEqual(result3, new Fraction("18", "12")));
    }

}
