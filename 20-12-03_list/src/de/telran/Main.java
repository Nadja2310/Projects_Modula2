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

        Iterator<String> iterator = strings.forwardIterator();//если приватный и вложенный не статический
        //Iterator<String> forwardIterator = strings.new ForwardIterator(); //если итератор public внутренний и не статический
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        // Iterator<String> backwardIterator = new backwardIterator<String>(strings); если класс внешний

        // Iterator<String> backwardIterator = strings.backwardIterator();//static class
        iterator = strings.backwardIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // Iterable - перебираемое (что-то, что можно перебрать)
        for (String str : strings) {
            System.out.println(str);
        }
        // equivalent to:
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            System.out.println(str);
        }
    }
}
