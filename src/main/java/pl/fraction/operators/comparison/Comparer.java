package pl.fraction.operators.comparison;

import pl.fraction.containers.Fraction;
import org.jetbrains.annotations.NotNull;

public class Comparer {

    private Comparer() {
        // This should be a utility class.
    }

    // TODO: include sign of the fraction
    // TODO: use shortened version for comparison in the overloaded function method
    public static boolean equality(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        if ((fraction1.getNumerator().length() != fraction2.getNumerator().length()) ||
            (fraction1.getDenominator().length() != fraction2.getDenominator().length())) {
            return false;
        }

        return fraction1.getNumerator().equals(fraction2.getNumerator()) && fraction1.getDenominator().equals(fraction2.getDenominator());
    }

}
