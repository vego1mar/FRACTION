package pl.fraction.functions.basic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.fraction.operators.basics.BasicOperation;
import pl.fraction.operators.basics.OperationType;
import pl.fraction.operators.comparison.Comparer;
import pl.fraction.utils.Strings;

public final class Seeker {

    private BasicOperation adder;
    private BasicOperation subtractor;
    private BasicOperation multiplicator;
    private String remainder;

    public Seeker() {
        adder = new BasicOperation(OperationType.ADDITION);
        subtractor = new BasicOperation(OperationType.SUBTRACTION);
        multiplicator = new BasicOperation(OperationType.MULTIPLICATION);
        remainder = "0";
    }

    @Contract(pure = true) public String getRemainder() {
        return remainder;
    }

    @NotNull public String getFloorDivisor(String dividend, String divider) {
        if (Comparer.isLowerThan(dividend, divider)) {
            remainder = dividend;
            return "0";
        }

        if (Comparer.areEqual(dividend, divider)) {
            remainder = "0";
            return "1";
        }

        List<String> multipler = getStepperRaisingMultiple(dividend, divider);
        multipler = getStepperFallingMultiple(multipler, dividend);
        multipler = getUltimateMultiple(multipler, dividend, divider);
        remainder = multipler.get(1);
        return multipler.get(0);
    }

    @NotNull private List<String> getStepperRaisingMultiple(String dividend, String divider) {
        String multiplier = "1";
        String multiple = divider;
        String nextMultiple;
        String result = "1";

        while (Comparer.isGreaterThan(dividend, multiple)) {
            multiplier = adder.process(multiplier, "1");
            nextMultiple = multiplicator.process(multiple, multiplier);

            if (!Comparer.isGreaterThan(dividend, nextMultiple)) {
                break;
            }

            multiple = nextMultiple;
            result = multiplicator.process(result, multiplier);
        }

        return List.of(multiple, result, subtractor.process(multiplier, "1"));
    }

    @NotNull private List<String> getStepperFallingMultiple(@NotNull List<String> multipler, String dividend) {
        String multiplier = multipler.get(2);
        String currentMultiple = multipler.get(0);
        String nextMultiple;
        String result = multipler.get(1);

        while (Comparer.isGreaterThan(multiplier, "1")) {
            nextMultiple = multiplicator.process(currentMultiple, multiplier);

            if (Comparer.isGreaterThan(nextMultiple, dividend)) {
                multiplier = subtractor.process(multiplier, "1");
                continue;
            }

            currentMultiple = nextMultiple;
            result = multiplicator.process(result, multiplier);
        }

        return List.of(currentMultiple, result);
    }

    @NotNull private List<String> getUltimateMultiple(@NotNull List<String> multipler, String dividend, String divider) {
        Deque<String> addends = new LinkedList<>();
        List<String> outcome = getUpswingOfRaisingMultiple(multipler, addends, dividend, divider);
        outcome = getUpswingOfFallingMultiple(addends, outcome, dividend);
        String multiple = outcome.get(1);
        String result = outcome.get(0);

        while (Comparer.isLowerThan(multiple, dividend)) {
            multiple = adder.process(multiple, divider);
            result = adder.process(result, "1");
        }

        if (Comparer.areEqual(subtractor.process(multiple, dividend), "0")) {
            return List.of(result, "0");
        }

        multiple = subtractor.process(multiple, divider);
        return List.of(subtractor.process(result, "1"), subtractor.process(dividend, multiple));
    }

    @NotNull private List<String> getUpswingOfRaisingMultiple(@NotNull List<String> multipler, @NotNull Deque<String> addends, String dividend, String divider) {
        String multiple = multipler.get(0);
        String result = multipler.get(1);
        String previousAdjunct = "1";
        String nextAdjunct = "1";
        boolean condition;

        while (true) {
            nextAdjunct = multiplicator.process(nextAdjunct, divider);
            addends.push(nextAdjunct);
            multiple = adder.process(multiple, nextAdjunct);
            result = adder.process(result, previousAdjunct);
            condition = Comparer.isLowerThan(multiple, dividend);

            if (!condition) {
                break;
            }

            previousAdjunct = nextAdjunct;
        }

        result = subtractor.process(result, previousAdjunct);
        multiple = subtractor.process(multiple, nextAdjunct);
        return List.of(result, multiple);
    }

    @NotNull private List<String> getUpswingOfFallingMultiple(@NotNull Deque<String> addends, @NotNull List<String> outcome, String dividend) {
        String multiple = outcome.get(1);
        String result = outcome.get(0);
        String previousAdjunct = addends.pop();

        if (!addends.isEmpty()) {
            previousAdjunct = addends.pop();
        }

        String nextMultiple;
        String popCopy;

        while (!addends.isEmpty()) {
            nextMultiple = adder.process(multiple, previousAdjunct);

            if (Comparer.isGreaterThan(nextMultiple, dividend)) {
                previousAdjunct = addends.pop();
                continue;
            }

            multiple = nextMultiple;
            popCopy = addends.pop();
            result = adder.process(result, popCopy);
            addends.push(popCopy);
        }

        return List.of(result, multiple);
    }

    public String getModulo(String dividend, String aliquot) {
        if (Strings.isZeroed(aliquot) || dividend.isEmpty() || aliquot.isEmpty()) {
            return "";
        }

        if (dividend.equals(aliquot) || (Strings.isZeroed(dividend) && Strings.isZeroed(aliquot))) {
            return "0";
        }

        if (!Comparer.isGreaterThan(dividend, aliquot)) {
            return dividend;
        }

        getFloorDivisor(dividend, aliquot);
        return getRemainder();
    }

    public String getGCD(@NotNull String number1, String number2) {
        if (Comparer.areEqual(number1, number2)) {
            return "1";
        }

        String a = number1;
        String b = number2;
        String c;

        while (Comparer.isGreaterThan(b, "0")) {
            getFloorDivisor(a, b);
            c = getRemainder();
            a = b;
            b = c;
        }

        return a;
    }

    @NotNull public String getLCM(String number1, String number2) {
        return getFloorDivisor(multiplicator.process(number1, number2), getGCD(number1, number2));
    }

}
