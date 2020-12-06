package de.telran;

import java.util.Iterator;

public class InverseArrayIterator implements Iterator<Integer> {
    private final int[] arrayToIterate;
    private int currentIndex;

    public InverseArrayIterator(int[] arrayToIterate) {
        this.arrayToIterate = arrayToIterate;
        currentIndex = arrayToIterate.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex > -1;
    }

    @Override
    public Integer next() {
        int res = arrayToIterate[currentIndex];
        currentIndex--;
        return res;
    }
}
