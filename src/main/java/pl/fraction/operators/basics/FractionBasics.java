package pl.fraction.operators.basics;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;

public class FractionBasics {

    private BasicOperation subtractor;
    private BasicOperation multiplicator;

    public FractionBasics() {
        subtractor = new BasicOperation(OperationType.SUBTRACTION);
        multiplicator = new BasicOperation(OperationType.MULTIPLICATION);
    }

    public Fraction subtractIntegers(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        String numerator1 = multiplicator.process(fraction1.getNumerator(), fraction2.getDenominator());
        String numerator2 = multiplicator.process(fraction2.getNumerator(), fraction1.getDenominator());

        return new Fraction(
            subtractor.process(numerator1, numerator2),
            multiplicator.process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

    public Fraction multiplyIntegers(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        return new Fraction(
            multiplicator.process(fraction1.getNumerator(), fraction2.getNumerator()),
            multiplicator.process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

    public Fraction divideIntegers(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        return new Fraction(
            multiplicator.process(fraction1.getNumerator(), fraction2.getDenominator()),
            multiplicator.process(fraction1.getDenominator(), fraction2.getNumerator())
        );
    }

}
