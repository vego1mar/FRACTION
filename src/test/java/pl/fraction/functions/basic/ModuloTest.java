package pl.fraction.functions.basic;

import org.junit.Assert;
import org.junit.Test;

public class ModuloTest {

    @Test
    public void get1() {
        // given
        // when
        String result1 = Modulo.get("21", "5");
        String result2 = Modulo.get("1", "2");
        String result3 = Modulo.get("9999", "23");
        String result4 = Modulo.get("999999", "901");
        String result5 = Modulo.get("98765432101", "123456789");
        String result6 = Modulo.get("1010101000101", "101010111010");
        String result7 = Modulo.get("666", "999");
        String result8 = Modulo.get("55566556587", "111");

        // then
        Assert.assertEquals("1", result1);
        Assert.assertEquals("1", result2);
        Assert.assertEquals("17", result3);
        Assert.assertEquals("790", result4);
        Assert.assertEquals("901", result5);
        Assert.assertEquals("101010001011", result6);
        Assert.assertEquals("666", result7);
        Assert.assertEquals("99", result8);
    }

}
