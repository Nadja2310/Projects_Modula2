package de.telran;

public interface OurDeque<T> {
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
}
