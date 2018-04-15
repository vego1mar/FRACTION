package pl.fraction.operators.basics;

import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.Operands;
import pl.fraction.utils.Strings;

public class Addition implements Processable {

    private Rules rules;

    public Addition() {
        rules = new Rules(RulesType.ADDITION);
    }

    @Override
    public String process(String operand1, String operand2) {
        if (Strings.isSimpleNumeric(operand1) && Strings.isSimpleNumeric(operand2)) {
            return add(operand1, operand2);
        }

        return "";
    }

    @NotNull
    private String add(@NotNull String operand1, @NotNull String operand2) {
        Operands operands = new Operands(operand1, operand2);
        char[] result = Strings.get(operands.getOperand1().length + 1, '0');
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
}
