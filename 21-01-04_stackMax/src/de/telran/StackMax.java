package de.telran;

import java.util.ArrayDeque;

public class StackMax {
    private ArrayDeque<Integer> source;

    public StackMax() {
    }

    public void addLast(int elt) {
        source.addLast(elt);
    }

    public int getLast() {
        return source.getLast();
    }

    public int removeLast() {
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
        int max = source.getFirst();
        for (Integer element : source) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
