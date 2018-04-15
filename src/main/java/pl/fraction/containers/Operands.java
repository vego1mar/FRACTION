package pl.fraction.containers;

import org.jetbrains.annotations.NotNull;
import pl.fraction.utils.Strings;

public class Operands {

    private char[] operand1;
    private char[] operand2;

    public Operands(@NotNull String operand1, @NotNull String operand2) {
        if (Strings.isSimpleNumeric(operand1) && Strings.isSimpleNumeric(operand2)) {
            gainSameLengthOperands(operand1, operand2);
            return;
        }

        this.operand1 = new char[]{'0'};
        this.operand2 = this.operand1;
    }

    private void gainSameLengthOperands(@NotNull String operand1, @NotNull String operand2) {
        int length = (operand1.length() > operand2.length()) ? operand1.length() : operand2.length();
        this.operand1 = getSameLengthOperand(operand1, length);
        this.operand2 = getSameLengthOperand(operand2, length);
    }

    private char[] getSameLengthOperand(@NotNull String operand, int length) {
        char[] newOperand = new char[length];
        int j = newOperand.length - 1;

        for (int i = operand.length() - 1; i >= 0; i--) {
            newOperand[j] = operand.toCharArray()[i];
            j--;
        }

        for (int i = j; i >= 0; i--) {
            newOperand[i] = '0';
        }

        return newOperand;
    }

    public char[] getOperand1() {
        return operand1;
    }

    public char[] getOperand2() {
        return operand2;
    }
}
