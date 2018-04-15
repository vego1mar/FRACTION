package pl.fraction.operators.basics;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {

    @Test
    public void process1() {
        // given
        Addition adder = new Addition();

        // when
        String result1 = adder.process("98", "9");
        String result2 = adder.process("99", "91");
        String result3 = adder.process("999", "999");
        String result4 = adder.process("1234567890", "987654321");
        String result5 = adder.process("1029384756", "1029384756");
        String result6 = adder.process("19873327643298541987123984375554001871100", "101847234334890876194882001111101347874739");

        // then
        Assert.assertEquals("107", result1);
        Assert.assertEquals("190", result2);
        Assert.assertEquals("1998", result3);
        Assert.assertEquals("2222222211", result4);
        Assert.assertEquals("2058769512", result5);
        Assert.assertEquals("121720561978189418182005985486655349745839", result6);
    }

    @Test
    public void process2() {
        // given
        Addition adder = new Addition();
        final int MINIMUM = 0;
        final int MAXIMUM = Integer.MAX_VALUE - 2;

        // when
        long value1 = ThreadLocalRandom.current().nextInt(MINIMUM, MAXIMUM + 1);
        long value2 = ThreadLocalRandom.current().nextInt(MINIMUM, MAXIMUM + 1);
        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);
        String result1 = adder.process(string1, string2);

        // then
        Assert.assertEquals(String.valueOf(value1 + value2), result1);
    }

}
