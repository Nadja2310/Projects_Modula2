package de.telran;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OurArrayList<String> strings = new OurArrayList<>();
        strings.addLast("Red");
        strings.addLast("Black");
        strings.addLast("123");
        strings.addLast("End");

        Iterator<String> iterator = strings.forwardIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
       // Iterator<String> backwardIterator = new backwardIterator<String>(strings); если класс внешний
        Iterator<String> backwardIterator = new OurArrayList.BackwardIterator<String>(strings);
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }

    }


}
