package pl.fraction.operators;

import pl.fraction.containers.Fraction;
import pl.fraction.operators.comparison.Comparer;

public class Operators {

    private Operators() {
        // This should be a utility class.
    }

    public static boolean areEqual(Fraction fraction1, Fraction fraction2) {
        return Comparer.equality(fraction1, fraction2);
    }

    // TODO: addition(Fraction, Fraction) using LCM (Least Common Multiple)
    // TODO: subtraction(Fraction, Fraction) using LCM
    // TODO: multiplication(Fraction, Fraction)
    // TODO: division(Fraction, Fraction) using multiplication inversion
    // TODO: shortening(Fraction) using GCD (Greatest Common Divisor)

}
