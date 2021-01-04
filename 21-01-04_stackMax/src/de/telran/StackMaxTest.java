package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMaxTest {
    StackMax stackMax = new StackMax();

    @Test
    void addLast_getMax() {
        stackMax.addLast(12);
        stackMax.addLast(222);
        stackMax.addLast(2);
        stackMax.addLast(32);
        stackMax.addLast(222);
        stackMax.addLast(221);
        stackMax.removeLast();
        assertEquals(222,stackMax.getMax());
    }
    @Test
    void getMax_EmptySource() {
    assertThrows(NullPointerException.class, ()-> {
        stackMax.getMax();
        });
    }
    @Test
    void getMax_RemoveLast_repeatedly() {
        stackMax.addLast(12);
        stackMax.addLast(222);
        stackMax.removeLast();
        stackMax.addLast(2);
        stackMax.addLast(32);

        assertEquals(32,stackMax.getMax());

        stackMax.addLast(222);
        stackMax.addLast(221);
        stackMax.removeLast();

        assertEquals(222,stackMax.getMax());
    }
}