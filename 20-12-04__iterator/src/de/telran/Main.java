package de.telran;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, -8, 0, 15};

        Iterator<Integer> simpleArrayIterator = new SimpleArrayIterator(array);

        while (simpleArrayIterator.hasNext()) {
            int current = simpleArrayIterator.next();
            System.out.println(current);
        }

        Iterator<Integer> inverseArrayIterator = new InverseArrayIterator(array);

        while (inverseArrayIterator.hasNext()) {
            int current = inverseArrayIterator.next();
            System.out.println(current);
        }
        Iterator<Integer> sortArrayIterator = new SortArrayIterator(array);
        System.out.println("Sort");
        while (sortArrayIterator.hasNext()) {
            int current = sortArrayIterator.next();
            System.out.println(current);
        }
        System.out.println(sortArrayIterator.toString());
    }
}