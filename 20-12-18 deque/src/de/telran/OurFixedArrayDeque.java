package de.telran;

import java.util.Iterator;

public class OurFixedArrayDeque<T> implements OurDeque<T> {

    private int firstEltId;
    private int size;
    public Object[] source;
    private int capacity;

    public OurFixedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
    }

    void increaseCapacity() {
        capacity = source.length * 2;
        firstEltId = 0;
        int lastIndex = (firstEltId + size - 1) % capacity;
        Object[] newSource = new Object[capacity];
        System.arraycopy(source, firstEltId, newSource, 0, source.length);
        System.arraycopy(source, 0, newSource, source.length, lastIndex);
        source = newSource;
    }

    @Override
    public void addFirst(T elt) {
        if (size == capacity) {
           /* increaseCapacity();
            source[size++] = elt;*/
            throw new DequeOverflowException();
        }
     if (firstEltId > 0) {
            firstEltId--;
        } else
            firstEltId=capacity-1;

        //или firstEltId=(firstEltId+capacity-1)%capacity;
        source[firstEltId]=elt;
        size++;
    }

    @Override
    public T getFirst() {
        if (size==0)
            throw new EmptyDequeException();

        return (T) source[firstEltId];
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new EmptyDequeException();

        T res = (T) source[firstEltId];
        source[firstEltId] = null;
        firstEltId = (firstEltId + 1) % capacity;
        size--;
        return res;
    }

    @Override
    public void addLast(T elt) {
        if (size == source.length)
            throw new DequeOverflowException();

        int index = (firstEltId + size) % capacity;
        source[index] = elt;
        size++;
    }


    @Override
    public T getLast() {
        if (size==0)
            throw new EmptyDequeException();

        int lastIndex = (firstEltId + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new EmptyDequeException();

        int lastIndex = (firstEltId + size - 1) % capacity;
        T res = (T) source[lastIndex];
        source[lastIndex] = null;
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> forwardIterator() {
        Iterator<T> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

    private class ForwardIterator implements Iterator<T> {
        private int currentIndex=firstEltId;
        //private int lastIndex=(firstEltId+size-1)%capacity;
        private int sizeIterator=size;

        @Override
        public boolean hasNext() {
            //return (currentIndex<=lastIndex && size>0);
            return (sizeIterator>0);
        }

        @Override
        public T next() {
            if (currentIndex > size)
                throw new IndexOutOfBoundsException();

            T res = (T) source[currentIndex];
            currentIndex=(currentIndex+1)%capacity;
            sizeIterator--;
            return res;
        }
    }
}
