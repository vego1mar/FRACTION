package pl.fraction.functions.basic;

import org.jetbrains.annotations.NotNull;
import pl.fraction.operators.basics.BasicOperation;
import pl.fraction.operators.basics.OperationType;
import pl.fraction.operators.comparison.Comparer;
import pl.fraction.utils.Strings;

public final class Modulo {

    private Modulo() {
        // This should be a utility class.
    }

    public static String get(String dividend, String aliquot) {
        if (Strings.isZeroed(aliquot) || dividend.isEmpty() || aliquot.isEmpty()) {
            return "";
        }

        if (dividend.equals(aliquot) || (Strings.isZeroed(dividend) && Strings.isZeroed(aliquot))) {
            return "0";
        }

        if (!Comparer.isGreaterThan(dividend, aliquot)) {
            return dividend;
        }

        BasicOperation adder = new BasicOperation(OperationType.ADDITION);
        BasicOperation subtractor = new BasicOperation(OperationType.SUBTRACTION);
        String cumulatedNumber = getCumulatedNumber(dividend, aliquot);
        String raisingCumulation = cumulatedNumber;

        while (!Comparer.isGreaterThan(cumulatedNumber, dividend)) {
            cumulatedNumber = adder.process(cumulatedNumber, raisingCumulation);
        }

        cumulatedNumber = subtractor.process(cumulatedNumber, raisingCumulation);

        while (!Comparer.isGreaterThan(cumulatedNumber, dividend)) {
            cumulatedNumber = adder.process(cumulatedNumber, aliquot);
        }

        cumulatedNumber = subtractor.process(cumulatedNumber, aliquot);
        return subtractor.process(dividend, cumulatedNumber);
    }

    private static String getCumulatedNumber(String dividend, String aliquot) {
        String cumulatedNumber = Strings.getWithoutLeadingZeroes(aliquot);
        double raiseFactor = ((double) cumulatedNumber.length()) / Strings.getWithoutLeadingZeroes(dividend).length();

        if (raiseFactor <= 0.5) {
            BasicOperation multiplicator = new BasicOperation(OperationType.MULTIPLICATION);
            cumulatedNumber = multiplicator.process(cumulatedNumber, aliquot);
            cumulatedNumber = multiplicator.process(cumulatedNumber, getCumulatedNumberMultiplier(cumulatedNumber));
        }

        return cumulatedNumber;
    }

    @NotNull
    private static String getCumulatedNumberMultiplier(@NotNull String cumulatedAliquot) {
        switch (cumulatedAliquot.toCharArray()[0]) {
            case '1':
                return "27";
            case '2':
                return "11";
            case '3':
                return "6";
            case '4':
                return "4";
            case '5':
            case '6':
                return "2";
            default:
                return "1";
        }
    }

}
