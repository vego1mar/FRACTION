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

}
