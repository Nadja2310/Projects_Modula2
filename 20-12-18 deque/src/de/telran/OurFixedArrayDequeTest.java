package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class OurFixedArrayDequeTest {

    OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(3);

    @Test
    void testAddFirst_addLast() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(deque.size(), 3);

    }

    @Test
    void testGetFirst_RemoveFirst() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(deque.size(), 3);
        deque.removeFirst();
        assertEquals(deque.size(), 2);
        assertEquals(deque.getFirst(), 2);
    }

    @Test
    void testGetFirst_RemoveFirst_addFirst() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(deque.size(), 3);
        deque.removeFirst();
        assertEquals(deque.size(), 2);
        assertEquals(deque.getFirst(), 2);
        deque.addFirst(0);
        assertEquals(deque.size(), 3);
        assertEquals(deque.getFirst(), 0);
    }

    @Test
    void testGetFirst_RemoveFirst_addLast() {
        int[] arr={2,3,1};
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        assertEquals(deque.size(), 2);
        assertEquals(deque.getFirst(), 2);
        deque.addLast(1);
        assertEquals(deque.getFirst(), 2);
        for (int i = 0; i < deque.size(); i++) {
            assertEquals(deque.source[i], arr[i]);
        }
    }

    @Test
    void testRemoveLast_lastIndex() {
        deque.addFirst(1);
        deque.addLast(3);
        deque.removeLast();
        assertEquals(deque.size(), 1);

    }

    @Test
    void testRemoveLast_FromTheMiddle() {
        int[] arr={2,3};
        deque.addFirst(12);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.addLast(1);
        deque.removeLast();
        assertEquals(deque.size(), 2);
        for (int i = 0; i < deque.size(); i++) {
            assertEquals(deque.source[i], arr[i]);
        }
    }

    @Test
    void testAddFirst_RemoveFirst_sizeNull() {
        deque.addFirst(1);
        deque.removeFirst();
        assertEquals(deque.size(), 0);
    }

    @Test
    void testAddFirst_AddLast_AddFirst_RemoveFirst() {
        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(5);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(deque.size(), 3);
        deque.removeLast();
        deque.addFirst(6);
        assertEquals(deque.size(), 3);
        deque.addFirst(68);
        deque.addFirst(67);
        assertThrows(DequeOverflowException.class, () -> deque.addFirst(69));
    }

    @Test
    void testAddLast_exception() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertThrows(RuntimeException.class, () -> deque.addLast(3));
    }

    @Test
    void testAddFirst_exception() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertThrows(RuntimeException.class, () -> deque.addFirst(4));
    }


    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, deque.size());
    }

    @Test
    public void testForwardIterator_severalElements() {
        Integer[] expected = {1, 2, 3};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Iterator<Integer> iterator = deque.forwardIterator();

        int i = 1;
        while (iterator.hasNext()) {
           assertEquals(i, iterator.next());

            i++;
        }

        assertEquals(4, i);
    }

    @Test
    public void testForwardIterator_emptyList() {
        Iterator<Integer> iterator = deque.forwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_oneElement() {
        int[] expected = {10};

        deque.addLast(10);

        Iterator<Integer> iterator = deque.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }
    }

    @Test
    public void testForwardIterator_FirstIndexIsNotZero_FirstIndexOne() {
        Integer[] expected = {15,2,3};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.addFirst(15);

        Iterator<Integer> iterator = deque.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i], iterator.next());
            i++;
        }

        assertEquals(3, i);

    }

    @Test
    public void testForwardIterator_FirstIndexIsNotZero_FirstIndexLastElement() {
        Integer[] expected = {2,3,100};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.addLast(100);

        Iterator<Integer> iterator = deque.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i], iterator.next());
            System.out.println(expected[i]);
            i++;
        }

       // assertEquals(2, i);
    }

    @Test
    public void testIterable() {
        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(6);
        Integer[] expected = {15,3,4};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.removeFirst();
        deque.addFirst(15);
        deque.addLast(4);

        int i=0;
        for (Integer elt:deque ) {
            System.out.println(elt);
            assertEquals(expected[i], elt);
            i++;
        }
    }
}