package pl.fraction.functions.basic;

import org.junit.Assert;
import org.junit.Test;

public class SeekersTest {

    @Test(timeout = 250)
    public void getFloorDivisor1() {
        // given
        Seeker seeker = new Seeker();

        // when
        String result1 = seeker.getFloorDivisor("1025", "2");
        String remainder1 = seeker.getRemainder();
        String result2 = seeker.getFloorDivisor("10101010", "10101010");
        String remainder2 = seeker.getRemainder();
        String result3 = seeker.getFloorDivisor("10", "11");
        String remainder3 = seeker.getRemainder();
        String result4 = seeker.getFloorDivisor("7892063541", "23");
        String remainder4 = seeker.getRemainder();
        String result5 = seeker.getFloorDivisor("7896", "23");
        String remainder5 = seeker.getRemainder();
        String result6 = seeker.getFloorDivisor("10293847566657843902106", "666");
        String remainder6 = seeker.getRemainder();
        String result7 = seeker.getFloorDivisor("11012191318141715161616151718141319101211101612", "14");
        String remainder7 = seeker.getRemainder();
        String result8 = seeker.getFloorDivisor("6", "2");
        String remainder8 = seeker.getRemainder();

        // then
        Assert.assertTrue(result1.equals("512") && remainder1.equals("1"));
        Assert.assertTrue(result2.equals("1") && remainder2.equals("0"));
        Assert.assertTrue(result3.equals("0") && remainder3.equals("10"));
        Assert.assertTrue(result4.equals("343133197") && remainder4.equals("10"));
        Assert.assertTrue(result5.equals("343") && remainder5.equals("7"));
        Assert.assertTrue(result6.equals("15456227577564330183") && remainder6.equals("228"));
        Assert.assertTrue(result7.equals("786585094152979654401153694152951364372221543") && remainder7.equals("10"));
        Assert.assertTrue(result8.equals("3") && remainder8.equals("0"));
    }

    @Test(timeout = 250)
    public void getModulo1() {
        // given
        Seeker seeker = new Seeker();

        // when
        String result1 = seeker.getModulo("21", "5");
        String result2 = seeker.getModulo("1", "2");
        String result3 = seeker.getModulo("9999", "23");
        String result4 = seeker.getModulo("999999", "901");
        String result5 = seeker.getModulo("98765432101", "123456789");
        String result6 = seeker.getModulo("1010101000101", "101010111010");
        String result7 = seeker.getModulo("666", "999");
        String result8 = seeker.getModulo("55566556587", "111");
        String result9 = seeker.getModulo("6", "2");
        String result10 = seeker.getModulo("25", "5");

        // then
        Assert.assertEquals("1", result1);
        Assert.assertEquals("1", result2);
        Assert.assertEquals("17", result3);
        Assert.assertEquals("790", result4);
        Assert.assertEquals("901", result5);
        Assert.assertEquals("101010001011", result6);
        Assert.assertEquals("666", result7);
        Assert.assertEquals("99", result8);
        Assert.assertEquals("0", result9);
        Assert.assertEquals("0", result10);
    }

    @Test(timeout = 250)
    public void getGCD1() {
        // given
        Seeker seeker = new Seeker();

        // when
        String result1 = seeker.getGCD("2", "6");
        String result2 = seeker.getGCD("2", "3");
        String result3 = seeker.getGCD("27", "11");
        String result4 = seeker.getGCD("27", "594");
        String result5 = seeker.getGCD("22222", "33333");
        String result6 = seeker.getGCD("292014", "894494");
        String result7 = seeker.getGCD("292014", "894411");
        String result8 = seeker.getGCD("23232323", "232323");
        String result9 = seeker.getGCD("0001010101010101010101010", "1010101010101010101010");

        // then
        Assert.assertEquals("2", result1);
        Assert.assertEquals("1", result2);
        Assert.assertEquals("1", result3);
        Assert.assertEquals("27", result4);
        Assert.assertEquals("11111", result5);
        Assert.assertEquals("2", result6);
        Assert.assertEquals("9", result7);
        Assert.assertEquals("23", result8);
        Assert.assertEquals("1", result9);
    }

    @Test
    public void getLCM1() {
        // given
        Seeker seeker = new Seeker();

        // when
        String result1 = seeker.getLCM("2", "3");
        String result2 = seeker.getLCM("2", "6");
        String result3 = seeker.getLCM("14", "8");
        String result4 = seeker.getLCM("2", "14");
        String result5 = seeker.getLCM("11211", "112");
        String result6 = seeker.getLCM("1020341516271819", "69");

        // then
        Assert.assertEquals("6", result1);
        Assert.assertEquals("6", result2);
        Assert.assertEquals("56", result3);
        Assert.assertEquals("14", result4);
        Assert.assertEquals("1255632", result5);
        Assert.assertEquals("23467854874251837", result6);
    }

    //@Test(timeout = 1000 * 300)
    @Test(timeout = 1000)
    public void getLCM2_Slow() {
        // given
        Seeker seeker = new Seeker();

        // when
        String result7 = seeker.getLCM("918273645545363627271818190", "156278390465466126");

        // then
        Assert.assertEquals("23917721222114229339082900658905876979271990", result7);
    }

}
