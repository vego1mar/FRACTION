package pl.fraction.operators.multiplication;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.functions.basic.Seeker;

public class FractionMultiplication {

    private Seeker seeker;

    public FractionMultiplication() {
        seeker = new Seeker();
    }

    public Fractionable multiplyIntegers(Fractionable fraction1, Fractionable fraction2) {
        fraction1.shorten();
        fraction2.shorten();
        Fractionable result = multiplyIntegersQuick(fraction1, fraction2);
        result.shorten();
        return result;
    }

    @NotNull private Fraction multiplyIntegersQuick(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        return new Fraction(
            seeker.getMultiplicator().process(fraction1.getNumerator(), fraction2.getNumerator()),
            seeker.getMultiplicator().process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

}
