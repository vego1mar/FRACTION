package pl.fraction.operators.division;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.functions.basic.Seeker;

public class FractionDivision {

    private Seeker seeker;

    public FractionDivision() {
        seeker = new Seeker();
    }

    public Fractionable divideIntegers(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        fraction1.shorten();
        fraction2.shorten();
        Fractionable result = divideIntegersQuick(fraction1, fraction2);
        result.shorten();
        return result;
    }

    @NotNull private Fractionable divideIntegersQuick(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        return new Fraction(
            seeker.getMultiplicator().process(fraction1.getNumerator(), fraction2.getDenominator()),
            seeker.getMultiplicator().process(fraction1.getDenominator(), fraction2.getNumerator())
        );
    }

}
