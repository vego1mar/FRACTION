package pl.fraction.operators.basics;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.Operands;
import pl.fraction.utils.Strings;

public class BasicOperation {

    private Rules rules;
    private OperationType operation;

    public BasicOperation(OperationType operation) {
        rules = new Rules(operation);
        this.operation = operation;
    }

    @NotNull
    private String processAdditionOrSubtraction(@NotNull String operand1, @NotNull String operand2) {
        Operands operands = new Operands(operand1, operand2);
        char[] result = Strings.getArray(operands.getOperand1().length + 1, '0');
        char offset;

        int j = operands.getOperand1().length - 1;
        result[result.length - 1] = rules.getRule(operands.getOperand1()[j], operands.getOperand2()[j], '0');
        char carriage = rules.getRule(operands.getOperand1()[j], operands.getOperand2()[j], '1');
        j = result.length - 1;

        for (int i = operands.getOperand1().length - 2; i >= 0; i--) {
            j--;
            offset = (char) ((operands.getOperand2()[i] - '0' + carriage - '0') + '0');

            if (offset <= '9') {
                result[j] = rules.getRule(operands.getOperand1()[i], offset, '0');
                carriage = rules.getRule(operands.getOperand1()[i], offset, '1');
                continue;
            }

            result[j] = operands.getOperand1()[i];
            carriage = '1';
        }

        if (carriage == '1') {
            j--;
            result[j] = carriage;
        }

        if (result[0] == '0') {
            return (new String(result)).substring(1);
        }

        return new String(result);
    }

    @NotNull
    private String processLongMultiplication(String multiplicand, String multiplier) {
        Operands operands = new Operands(multiplicand, multiplier);
        List<StringBuilder> results = new ArrayList<>();
        int currentResultIndex = 0;
        int currentIteration = -1;
        char carriage = '0';
        char digitRule;
        char carriageRule;
        DigitsAdder adder = new DigitsAdder();

        for (int i = operands.getOperand2().length - 1; i >= 0; i--) {
            currentIteration++;

            if (operands.getOperand2()[i] == '0') {
                continue;
            }

            results.add(new StringBuilder());
            results.get(currentResultIndex).append(Strings.getString(currentIteration, '0'));

            for (int j = operands.getOperand1().length - 1; j >= 0; j--) {
                digitRule = rules.getRule(operands.getOperand2()[i], operands.getOperand1()[j], '0');
                carriageRule = rules.getRule(operands.getOperand2()[i], operands.getOperand1()[j], '1');
                adder.add(digitRule, carriage);
                results.get(currentResultIndex).insert(0, adder.getDigit());
                adder.add(adder.getCarriage(), carriageRule);
                carriage = adder.getDigit();
            }

            if (carriage != '0') {
                results.get(currentResultIndex).insert(0, carriage);
            }

            carriage = '0';
            currentResultIndex++;
        }

        List<String> partialResults = Strings.getShortenedNumbers(results);
        BasicOperation addition = new BasicOperation(OperationType.ADDITION);
        String sum = "0";

        for (String number : partialResults) {
            sum = addition.process(sum, number);
        }

        return sum;
    }

    public String process(String operand1, String operand2) {
        if (Strings.isSimpleNumeric(operand1) && Strings.isSimpleNumeric(operand2)) {
            return switchOperationType(operand1, operand2);
        }

        return "";
    }

    @NotNull
    private String switchOperationType(String operand1, String operand2) {
        switch (operation) {
            case ADDITION:
            case SUBTRACTION:
                return processAdditionOrSubtraction(operand1, operand2);
            case MULTIPLICATION:
                return processLongMultiplication(operand1, operand2);
        }

        return "";
    }

}
