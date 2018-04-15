package pl.fraction.operators.basics;

import org.junit.Assert;
import org.junit.Test;

public class RulesTest {

    @Test
    public void getRule() {
        // given
        Rules rules = new Rules(RulesType.ADDITION);

        // when
        char result1 = rules.getRule('9', '9', '0');
        char result2 = rules.getRule('9', '9', '1');
        char result3 = rules.getRule('A', 'B', '0');
        char result4 = rules.getRule('\n', '\b', '\t');

        // then
        Assert.assertEquals('8', result1);
        Assert.assertEquals('1', result2);
        Assert.assertEquals('0', result3);
        Assert.assertEquals('0', result4);
    }

}
