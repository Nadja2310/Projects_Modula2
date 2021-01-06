package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class OurLinkedListTest extends OurListTest{

    @BeforeEach
    public void init(){
        // list=new OurArrayList<>();
        list=new OurLinkedList<String>();

    }
    @Test
    public void testForwardIterator_emptyList() {
        Iterator<String> iterator = list.forwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        list.addLast("Evgeny Borisovich");

        Iterator<String> iterator = list.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_severalElements() {
        String[] expected = {"Evgeny", "Borisovich", "Vladislava", "Evgenievna"};

        list.addLast("Evgeny");
        list.addLast("Borisovich");
        list.addLast("Vladislava");
        list.addLast("Evgenievna");

        Iterator<String> iterator = list.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }
    @Test
    public void testBackwardIterator_emptyList() {

        Iterator<String> iterator = list.backwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        list.addLast("Evgeny Borisovich");

        Iterator<String> iterator = list.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }
        assertEquals(1, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_severalElements() {
        String[] expected = {"Evgenievna", "Vladislava", "Borisovich", "Evgeny"};

        OurList<String> strings = new OurArrayList<>();
        strings.addLast("Evgeny");
        strings.addLast("Borisovich");
        strings.addLast("Vladislava");
        strings.addLast("Evgenievna");

        Iterator<String> iterator = strings.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void test_Sort_Integer() {

        OurList<Integer> arr = new OurLinkedList<>();
        arr.addLast(5);
        arr.addLast(15);
        arr.addLast(1);
        arr.addLast(0);
        arr.addLast(102);
        arr.addLast(1102);
        arr.sort(new IntegerBasicComparator());

        int[] arrtest={0,1,5,15,102,1102};
        for (int i = 0; i < arrtest.length; i++) {
            assertEquals(arr.get(i),arrtest[i]);
            System.out.println(arr.get(i));
        }

    }
}
