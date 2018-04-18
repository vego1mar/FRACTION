package pl.fraction.operators.basics;

import org.jetbrains.annotations.Contract;

public final class DigitsAdder {

    private Rules additionRules;
    private char digit;
    private char carriage;

    public DigitsAdder() {
        additionRules = new Rules(OperationType.ADDITION);
        digit = '0';
        carriage = '0';
    }

    public void add(char augend, char addend) {
        digit = additionRules.getRule(augend, addend, '0');
        carriage = additionRules.getRule(augend, addend, '1');
    }

    @Contract(pure = true)
    public char getDigit() {
        return digit;
    }

    @Contract(pure = true)
    public char getCarriage() {
        return carriage;
    }
}
