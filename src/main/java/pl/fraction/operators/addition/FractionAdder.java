package pl.fraction.operators.addition;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.Fraction;
import pl.fraction.operators.basics.BasicOperation;
import pl.fraction.operators.basics.OperationType;

public final class FractionAdder {

    private BasicOperation multiplicator;
    private BasicOperation adder;
    private Fraction result;

    public FractionAdder() {
        multiplicator = new BasicOperation(OperationType.MULTIPLICATION);
        adder = new BasicOperation(OperationType.ADDITION);
        result = new Fraction("1", "1");
    }

    @NotNull
    public Fraction addIntegers(@NotNull Fraction fraction1, @NotNull Fraction fraction2) {
        // TODO: shorten the fractions
        // TODO: get the Least Common Multiple for them
        // provide fields for partial results

        String numerator1 = multiplicator.process(fraction1.getNumerator(), fraction2.getDenominator());
        String numerator2 = multiplicator.process(fraction2.getNumerator(), fraction1.getDenominator());
        result.setNumerator(adder.process(numerator1, numerator2));
        result.setDenominator(multiplicator.process(fraction1.getDenominator(), fraction2.getDenominator()));
        return new Fraction(result.getNumerator(), result.getDenominator());
    }
}
