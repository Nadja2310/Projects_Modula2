package task5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateElementsTest {
    DuplicateElements arr=new DuplicateElements();
    @Test
    void searchElement_Value1() {

        int[] array=new int[]{8,7,2,3,4};
        HashMap<Integer,Integer> x=arr.searchElement(array);
        assertTrue(x.containsKey(8));
        assertTrue(x.containsKey(7));
        assertTrue(x.containsKey(2));
        assertTrue(x.containsKey(3));
        assertTrue(x.containsKey(4));
        assertEquals(1,x.get(8));
        assertEquals(1,x.get(7));
        assertEquals(1,x.get(2));
        assertEquals(1,x.get(3));
        assertEquals(1,x.get(4));

    }

    @Test
    void searchElement_differentValue() {

        int[] array=new int[]{8,7,2,8,7,3,3,4,4,8,4,3,4};
        HashMap<Integer,Integer> x=arr.searchElement(array);
        assertTrue(x.containsKey(8));
        assertTrue(x.containsKey(7));
        assertTrue(x.containsKey(2));
        assertTrue(x.containsKey(3));
        assertTrue(x.containsKey(4));
        assertEquals(3,x.get(8));
        assertEquals(2,x.get(7));
        assertEquals(1,x.get(2));
        assertEquals(3,x.get(3));
        assertEquals(4,x.get(4));
    }
}