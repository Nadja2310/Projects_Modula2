package de.telran;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        OurFixedArrayDeque<Integer> deque=new OurFixedArrayDeque<>(6);

       // Iterator<Integer> iterator = deque.forwardIterator();
        int[] expected = {15,3,4};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.removeFirst();
        deque.addFirst(15);
        deque.addLast(4);
        for (Integer elt:deque ) {
            System.out.println(elt);
        }
    }
}
