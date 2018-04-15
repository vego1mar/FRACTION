package pl.fraction.containers;

import pl.fraction.utils.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Fraction {

    private String numerator;
    private String denominator;

    public Fraction(@NotNull String numerator, @NotNull String denominator) {
        if (numerator.isEmpty() || denominator.isEmpty() || Strings.isZeroed(denominator)) {
            setNumerator("1");
            setDenominator("1");
            return;
        }

        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Contract(pure = true)
    public String getNumerator() {
        return numerator;
    }

    public void setNumerator(@NotNull String numerator) {
        if (!numerator.isEmpty() && Strings.isSimpleNumeric(numerator)) {
            this.numerator = numerator;
        }
    }

    @Contract(pure = true)
    public String getDenominator() {
        return denominator;
    }

    public void setDenominator(@NotNull String denominator) {
        if (!denominator.isEmpty() && Strings.isSimpleNumeric(denominator) && !Strings.isZeroed(denominator)) {
            this.denominator = denominator;
        }
    }
}
