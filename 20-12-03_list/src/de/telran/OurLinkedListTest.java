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
}
