package pl.fraction.containers;

import org.junit.Assert;
import org.junit.Test;

public class OperandsTest {

    @Test
    public void getOperand() {
        // given
        final String OPERAND_1 = "13";
        final String OPERAND_2 = "9";
        Operands operands = new Operands(OPERAND_1, OPERAND_2);

        // when
        String result1 = new String(operands.getOperand1());
        String result2 = new String(operands.getOperand2());

        // then
        Assert.assertEquals("13", result1);
        Assert.assertEquals("09", result2);
    }

}
