package pl.fraction.operators.comparison;

import pl.fraction.containers.Fraction;
import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.Operands;
import pl.fraction.utils.Strings;

public class Comparer {

    private Comparer() {
        // This should be a utility class.
    }

    public static boolean areEqual(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        if ((fraction1.getNumerator().length() != fraction2.getNumerator().length()) ||
            (fraction1.getDenominator().length() != fraction2.getDenominator().length())) {
            return false;
        }

        return fraction1.getNumerator().equals(fraction2.getNumerator()) && fraction1.getDenominator().equals(fraction2.getDenominator());
    }

    public static boolean areEqual(String number1, String number2) {
        return Strings.getWithoutLeadingZeroes(number1).equals(Strings.getWithoutLeadingZeroes(number2));
    }

    public static boolean isGreaterThan(@NotNull String number, String comparedNumber) {
        if (number.equals(comparedNumber) || (Strings.isZeroed(number) && Strings.isZeroed(comparedNumber))) {
            return false;
        }

        String no1 = Strings.getWithoutLeadingZeroes(number);
        String no2 = Strings.getWithoutLeadingZeroes(comparedNumber);

        if (no1.length() != no2.length()) {
            return no1.length() > no2.length();
        }

        Operands operands = new Operands(number, comparedNumber);

        for (int i = 0; i < operands.getOperand1().length; i++) {
            if (operands.getOperand1()[i] == operands.getOperand2()[i]) {
                continue;
            }

            return operands.getOperand1()[i] > operands.getOperand2()[i];
        }

        return false;
    }

    public static boolean isLowerThan(String number, String comparedNumber) {
        if (areEqual(number, comparedNumber)) {
            return false;
        }

        return !isGreaterThan(number, comparedNumber);
    }

}
