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
        char[] numerator1 = fraction1.getNumerator().toCharArray();
        char[] numerator2 = fraction2.getNumerator().toCharArray();
        char[] denominator1 = fraction1.getDenominator().toCharArray();
        char[] denominator2 = fraction2.getDenominator().toCharArray();

        if ((numerator1.length != numerator2.length) || (denominator1.length != denominator2.length)) {
            return false;
        }

        for (int i = 0; i < fraction1.getNumerator().toCharArray().length; i++) {
            if ((numerator1[i] != numerator2[i]) || (denominator1[i] != denominator2[i])) {
                return false;
            }
        }

        return true;
    }

}
