package pl.fraction.operators.addition;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.basics.BasicOperation;
import pl.fraction.operators.basics.OperationType;

public class FractionAddition {

    BasicOperation adder;
    BasicOperation multiplicator;

    public FractionAddition() {
        adder = new BasicOperation(OperationType.ADDITION);
        multiplicator = new BasicOperation(OperationType.MULTIPLICATION);
    }

    public Fractionable addIntegers(Fractionable fraction1, Fractionable fraction2) {
        fraction1.shorten();
        fraction2.shorten();
        Fractionable result = addIntegersQuick(fraction1, fraction2);
        result.shorten();
        return result;
    }

    @NotNull private Fractionable addIntegersQuick(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        String numerator1 = multiplicator.process(fraction1.getNumerator(), fraction2.getDenominator());
        String numerator2 = multiplicator.process(fraction2.getNumerator(), fraction1.getDenominator());

        return new Fraction(
            adder.process(numerator1, numerator2),
            multiplicator.process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

}
