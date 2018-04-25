package pl.fraction.functions.basic;

import org.junit.Assert;
import org.junit.Test;

public class SeekersTest {

    @Test(timeout = 2500)
    public void getGCD1() {
        // given
        // when
        String result1 = Seeker.getGCD("2", "6");
        String result2 = Seeker.getGCD("2", "3");
        String result3 = Seeker.getGCD("27", "11");
        String result4 = Seeker.getGCD("27", "594");
        String result5 = Seeker.getGCD("22222", "33333");
        String result6 = Seeker.getGCD("292014", "894494");
        String result7 = Seeker.getGCD("292014", "894411");
        String result8 = Seeker.getGCD("23232323", "232323");
        String result9 = Seeker.getGCD("0001010101010101010101010", "1010101010101010101010");

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
        String result5 = seeker.getFloorDivisor("7896","23");
        String remainder5 = seeker.getRemainder();

        // then
        Assert.assertTrue(result1.equals("512") && remainder1.equals("1"));
        Assert.assertTrue(result2.equals("1") && remainder2.equals("0"));
        Assert.assertTrue(result3.equals("0") && remainder3.equals("10"));
        Assert.assertTrue(result4.equals("343133197") && remainder4.equals("10"));
        Assert.assertTrue(result5.equals("343") && remainder5.equals("7"));
    }

}
