package de.telran;

import java.util.Arrays;
import java.util.Iterator;

public class SortArrayIterator implements Iterator<Integer> {
    private final int[] arrayToIterate;
    private int currentIndex = 0;

    public SortArrayIterator(int[] arrayToIterate) {
        this.arrayToIterate = arrayToIterate;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < arrayToIterate.length;
    }

    @Override
    public Integer next() {
        int[] arrayCopy = Arrays.copyOf(arrayToIterate, arrayToIterate.length);
        sort(arrayCopy);
        int res = arrayCopy[currentIndex];
        currentIndex++;
        return res;
    }

    private int[] sort(int[] arrayCopy) {

        for (int i = 0; i < arrayCopy.length; i++) {
            for (int j = 0; j < arrayCopy.length; j++) {
                if (arrayCopy[i] < arrayCopy[j]) {
                    int temp = arrayCopy[i];
                    arrayCopy[i] = arrayCopy[j];
                    arrayCopy[j] = temp;
                }
            }
        }
        return arrayCopy;
    }

    @Override
    public String toString() {
        return "SortArrayIterator{" +
                "arrayToIterate=" + Arrays.toString(arrayToIterate) +
                '}';
    }
}
