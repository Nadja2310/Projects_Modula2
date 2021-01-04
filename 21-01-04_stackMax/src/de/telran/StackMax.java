package de.telran;

import java.util.ArrayDeque;

public class StackMax {
    private ArrayDeque<Integer> source;
    private ArrayDeque<Integer> currentMax;

    public StackMax() {
        source = new ArrayDeque<Integer>();
        currentMax = new ArrayDeque<>();
    }

    public void addLast(int elt) {

        source.addLast(elt);
        if (currentMax.isEmpty() || currentMax.getLast() <= elt)
            currentMax.addLast(elt);
    }

    public int getLast() {
        if (source.size() == 0)
            throw new NullPointerException();

        return source.getLast();
    }

    public int removeLast() {
        if (source.size() == 0)
            throw new NullPointerException();
//if ((int)currentMax.getLast()== (int)source.getLast())
        if (source.getLast().equals(currentMax.getLast()))
        currentMax.removeLast();

        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
        if (source.size() == 0)
            throw new NullPointerException();

        return currentMax.getLast();
    }
}
