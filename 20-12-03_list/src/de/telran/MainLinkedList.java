package de.telran;

import java.util.Iterator;

public class MainLinkedList {
    public static void main(String[] args) {

        OurLinkedList<String> strings = new OurLinkedList<String>();
        strings.addLast("Red");
        strings.addLast("Black");
        strings.addLast("123");
        strings.addLast("End");

        Iterator<String> iterator = strings.forwardIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        iterator = strings.backwardIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            System.out.println(str);
        }
    }
}
