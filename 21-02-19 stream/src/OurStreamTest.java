import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OurStreamTest {

    OurStream stream = new OurStream();

    @Test
    public void testisPrime_notPrime() {
        assertFalse(stream.isPrime(4));
        assertFalse(stream.isPrime(10));
    }
    @Test
    public void testisPrime_isPrime() {
        assertTrue(stream.isPrime(5));
        assertTrue(stream.isPrime(11));
        assertTrue(stream.isPrime(29));
    }

    @Test
    public void testSumOdd() {
       // System.out.println(Arrays.toString(stream.sumOdd(3,7)));
       assertEquals(3,stream.sumOdd(3,3));
    }
    @Test
    public void testFactorial() {
        assertEquals(6,stream.factorial(3));
        assertEquals(1,stream.factorial(1));
    }
    @Test
    public void testStreamElementsAreDividedInto3und5_res0() {
        int[] res=stream.streamElementsAreDividedInto3und5(3,6);
        assertEquals(0,res.length);
     }
    @Test
    public void testStreamElementsAreDividedInto3und5_regular() {
        int[] expected={45,60};
        int[] res=stream.streamElementsAreDividedInto3und5(14,70);
        assertEquals(2,res.length);
        assertArrayEquals(expected,res);
        //System.out.println(Arrays.toString(stream.streamElementsAreDividedInto3und5(14,70)));
    }
}