package de.telran;

import java.util.Iterator;

public interface OurDeque<T> extends Iterable<T>{
    /**
     * @param elt
     * @throws DequeOverflowException if the implementation may contain limited number of elements, than the method throws
     */
    void addFirst(T elt);

    T getFirst();

    T removeFirst();

    void addLast(T elt);

    T getLast();

    T removeLast();

    int size();

    Iterator<T> forwardIterator();

}
