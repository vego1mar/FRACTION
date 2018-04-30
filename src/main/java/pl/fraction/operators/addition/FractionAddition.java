package pl.fraction.operators.addition;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.functions.basic.Seeker;

public class FractionAddition {

    private Seeker seeker;

    public FractionAddition() {
        seeker = new Seeker();
    }

    public Fractionable addIntegers(Fractionable fraction1, Fractionable fraction2) {
        fraction1.shorten();
        fraction2.shorten();
        Fractionable result = addIntegersQuick(fraction1, fraction2);
        result.shorten();
        return result;
    }

    @NotNull private Fractionable addIntegersQuick(@NotNull Fractionable fraction1, @NotNull Fractionable fraction2) {
        String numerator1 = seeker.getMultiplicator().process(fraction1.getNumerator(), fraction2.getDenominator());
        String numerator2 = seeker.getMultiplicator().process(fraction2.getNumerator(), fraction1.getDenominator());

        return new Fraction(
            seeker.getAdder().process(numerator1, numerator2),
            seeker.getMultiplicator().process(fraction1.getDenominator(), fraction2.getDenominator())
        );
    }

}
