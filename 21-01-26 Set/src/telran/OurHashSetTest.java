package telran;


import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OurHashSetTest {

    // @Before
    //void init(){
    OurHashSet<String> ourHashSetString = new OurHashSet();
    OurHashSet<Integer> ourHashSetInt = new OurHashSet<>();

    // }


    @Test
    public void testSizePut_emptyObject_newElements() {
        ourHashSetInt.add(1);
        ourHashSetInt.add(2);
        ourHashSetInt.add(3);
        assertEquals(3, ourHashSetInt.size());
    }

    @Test
    void testAddAll_EmptySet_addAll_EmptySet() {

        OurHashSet<Integer> ourHashSet2 = new OurHashSet<>();

        ourHashSetInt.addAll(ourHashSet2);

        assertEquals(0, ourHashSetInt.size());
        //Integer[] expected = {};
        //checkAllElements(ourHashSetInt, expected);

    }


    @Test
    void testAddAll_oneIdenticalElement() {
        ourHashSetInt.add(1);
        ourHashSetInt.add(25);
        ourHashSetInt.add(3);

        OurHashSet<Integer> ourHashSet2 = new OurHashSet<>();
        ourHashSet2.add(55);
        ourHashSet2.add(25);
        ourHashSet2.add(5);
        ourHashSet2.add(94);
        ourHashSet2.add(21);
        ourHashSetInt.addAll(ourHashSet2);

        assertEquals(7, ourHashSetInt.size());
        Integer[] expected = {55, 25, 5, 94, 21, 1, 3};
        checkAllElements(ourHashSetInt, expected);

    }

    void checkAllElements(OurHashSet<Integer> mapCheck, Integer[] array) {
        for (Integer elm : array) {

            assertTrue(mapCheck.contains(elm));
        }
    }

}