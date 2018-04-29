package pl.fraction.containers.fraction;

public interface Fractionable {

    String getNumerator();

    void setNumerator(String numerator);

    String getDenominator();

    void setDenominator(String denominator);

    boolean isShortened();

    void shorten();

}
