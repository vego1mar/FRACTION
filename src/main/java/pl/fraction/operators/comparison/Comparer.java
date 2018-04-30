package pl.fraction.operators.comparison;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.Operands;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.functions.basic.Seeker;
import pl.fraction.utils.Strings;

public class Comparer {

    private Comparer() {
        // This should be a utility class.
    }

    public static boolean areEqual(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        if ((fraction1.getNumerator().length() != fraction2.getNumerator().length()) ||
            (fraction1.getDenominator().length() != fraction2.getDenominator().length())) {
            return false;
        }

        return fraction1.getNumerator().equals(fraction2.getNumerator()) && fraction1.getDenominator().equals(fraction2.getDenominator());
    }

    public static boolean areEqualFractions(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2, boolean isShorteningAllowed) {
        if (!isShorteningAllowed) {
            Fractionable fractionA = new Fraction(fraction1.getNumerator(), fraction1.getDenominator());
            Fractionable fractionB = new Fraction(fraction2.getNumerator(), fraction2.getDenominator());
            fractionA.shorten();
            fractionB.shorten();
            return areEqual(fractionA, fractionB);
        }

        fraction1.shorten();
        fraction2.shorten();
        return areEqual(fraction1, fraction2);
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

    public static boolean isGreaterFractionThan(@NotNull Fractionable fraction, @NotNull Fractionable comparedFraction) {
        Fractionable fraction1 = new Fraction(fraction.getNumerator(), fraction.getDenominator());
        Fractionable fraction2 = new Fraction(comparedFraction.getNumerator(), comparedFraction.getDenominator());

        if (areEqualFractions(fraction1, fraction2, true)) {
            return false;
        }

        if (areEqual(fraction1.getDenominator(), fraction2.getDenominator())) {
            return isGreaterThan(fraction1.getNumerator(), fraction2.getNumerator());
        }

        Seeker seeker = new Seeker();
        String division1 = seeker.getFloorDivisor(fraction1.getNumerator(), fraction1.getDenominator());
        String division2 = seeker.getFloorDivisor(fraction2.getNumerator(), fraction2.getDenominator());

        if (areEqual(division1, division2)) {
            String leftNumerator = seeker.getMultiplicator().process(fraction1.getNumerator(), fraction2.getDenominator());
            String rightNumerator = seeker.getMultiplicator().process(fraction2.getNumerator(), fraction1.getDenominator());
            return isGreaterThan(leftNumerator, rightNumerator);
        }

        return isGreaterThan(division1, division2);
    }

    public static boolean isLowerThan(String number, String comparedNumber) {
        if (areEqual(number, comparedNumber)) {
            return false;
        }

        return !isGreaterThan(number, comparedNumber);
    }

}
