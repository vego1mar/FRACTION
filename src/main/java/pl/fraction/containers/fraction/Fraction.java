package pl.fraction.containers.fraction;

import pl.fraction.functions.basic.Seeker;
import pl.fraction.operators.comparison.Comparer;
import pl.fraction.utils.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Fraction implements Fractionable {

    private String numerator;
    private String denominator;
    private boolean isShortened;

    public Fraction(@NotNull String numerator, @NotNull String denominator) {
        if (numerator.isEmpty() || denominator.isEmpty() || Strings.isZeroed(denominator)) {
            setNumerator("1");
            setDenominator("1");
            isShortened = true;
            return;
        }

        setNumerator(numerator);
        setDenominator(denominator);
        isShortened = false;
    }

    @Override @Contract(pure = true) public String getNumerator() {
        return numerator;
    }

    @Override public void setNumerator(@NotNull String numerator) {
        if (!numerator.isEmpty() && Strings.isSimpleNumeric(numerator)) {
            this.numerator = numerator;
            isShortened = false;
        }
    }

    @Override @Contract(pure = true) public String getDenominator() {
        return denominator;
    }

    @Override public void setDenominator(@NotNull String denominator) {
        if (!denominator.isEmpty() && Strings.isSimpleNumeric(denominator) && !Strings.isZeroed(denominator)) {
            this.denominator = denominator;
            isShortened = false;
        }
    }

    @Override @Contract(pure = true) public boolean isShortened() {
        return isShortened;
    }

    @Override public void shorten() {
        if (isShortened() || denominator.equals("1")) {
            return;
        }

        if (Comparer.areEqual(numerator, denominator)) {
            setNumerator("1");
            setDenominator("1");
            isShortened = true;
        }

        Seeker seeker = new Seeker();
        String gcd = seeker.getGCD(getNumerator(), getDenominator());
        setNumerator(seeker.getFloorDivisor(numerator, gcd));
        setDenominator(seeker.getFloorDivisor(denominator, gcd));
        isShortened = true;
    }

}
