package pl.fraction.operators.subtraction;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.functions.basic.Seeker;
import pl.fraction.operators.comparison.Comparer;

public class FractionSubtraction {

    private Seeker seeker;

    public FractionSubtraction() {
        seeker = new Seeker();
    }

    public Fractionable subtractIntegers(Fractionable fraction1, Fractionable fraction2) {
        fraction1.shorten();
        fraction2.shorten();

        if (Comparer.areEqualFractions(fraction1, fraction2, true)) {
            return new Fraction("0", "1");
        }

        if (Comparer.isGreaterFractionThan(fraction1, fraction2)) {
            Fractionable result = subtractIntegersQuick(fraction1, fraction2);
            result.shorten();
            return result;
        }

        Fractionable result = subtractIntegersQuick(fraction2, fraction1);
        result.shorten();
        return result;
    }

    @NotNull private Fractionable subtractIntegersQuick(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        String numerator1 = seeker.getMultiplicator().process(fraction1.getNumerator(), fraction2.getDenominator());
        String numerator2 = seeker.getMultiplicator().process(fraction2.getNumerator(), fraction1.getDenominator());

        return new Fraction(
            seeker.getSubtractor().process(numerator1, numerator2),
            seeker.getMultiplicator().process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

}
