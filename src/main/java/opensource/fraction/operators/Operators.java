package opensource.fraction.operators;

import opensource.fraction.containers.Fraction;
import opensource.fraction.operators.comparison.Comparer;

public class Operators {

    private Operators() {
        // This should be a utility class.
    }

    public static boolean areEqual(Fraction fraction1, Fraction fraction2) {
        return Comparer.equality(fraction1, fraction2);
    }

}
