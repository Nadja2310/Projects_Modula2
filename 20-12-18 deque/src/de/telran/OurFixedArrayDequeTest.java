package de.telran;

import org.junit.jupiter.api.Test;

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
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        assertEquals(deque.size(), 2);
        assertEquals(deque.getFirst(), 2);
        deque.addLast(1);
        assertEquals(deque.getFirst(), 2);
        for (int i = 0; i < deque.size(); i++) {
            assertEquals(deque.source[i], i + 1);
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
        deque.addFirst(12);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.addLast(1);
        deque.removeLast();
        assertEquals(deque.size(), 2);
        for (int i = 1; i < deque.size(); i++) {
            assertEquals(deque.source[i], i + 1);
        }
        assertNull(deque.source[0]);
    }

    @Test
    void testAddFirst_RemoveFirst_sizeNull() {
        deque.addFirst(1);
        deque.removeFirst();
        assertEquals(deque.size(), 0);
    }

    @Test
    void testAddFirst_AddLast_AddFirst_RemoveFirst() {
        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(6);
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(deque.size(), 3);
        deque.removeLast();
        deque.addFirst(6);
        assertEquals(deque.size(), 3);
        deque.addFirst(68);
        assertThrows(RuntimeException.class, () -> deque.addFirst(69));
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
}