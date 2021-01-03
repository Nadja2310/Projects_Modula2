package de.telran;

public class OurFixedArrayDeque<T> implements OurDeque<T> {

    private int firstEltId;
    private int size;
    public Object[] source;
    private int capacity;

    public OurFixedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
        firstEltId = this.capacity / 2;
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
            source[--firstEltId] = elt;
        } else
            throw new DequeOverflowException();
        size++;
    }

    @Override
    public T getFirst() {
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
}
