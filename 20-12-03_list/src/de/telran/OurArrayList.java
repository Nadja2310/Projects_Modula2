package de.telran;

import java.util.Arrays;
import java.util.Iterator;

public class OurArrayList<Type> implements OurList<Type> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(Type element) {
        if (size == source.length)
            increaseCapacity();

        source[size++] = element;
        //   source[size] = element;
        //   size++;
    }

    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public Type get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (Type) source[index];
    }

    @Override
    public void set(int index, Type value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Object oldValue = source[index];
        source[index] = value;
    }

    @Override
    public Type removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

      /*  Type res = (Type) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[--size] = null;
        return res;
        */

        Object oldValue = source[index];
        if (index == size - 1) {
            size--;
            source[size - 1] = 0;
            return (Type) oldValue;
        }

        for (int i = index; i < size - 1; i++) {
            source[i] = source[i + 1];
        }
        source[size - 1] = null;
        size--;

        return (Type) oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        source = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean remove(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (source[i].equals(obj)) {
             //   System.arraycopy(source, i + 1, source, i, size - i - 1);
             //   source[--size] = null;
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null)
                    return true;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (source[i].equals(obj))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Type> forwardIterator() {
        Iterator<Type> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<Type> backwardIterator() {
        return null;
    }

    private class ForwardIterator implements Iterator<Type> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Type next() {
            if (currentIndex >= size)
                throw new IndexOutOfBoundsException();

            Type res = (Type) source[currentIndex];
            currentIndex++;
            return res;
        }
    }
   static class BackwardIterator<Type> implements Iterator<Type> {

        Object[] source;
        int currentIndex = 0;
        private int size;


        public BackwardIterator(OurArrayList ourArrayList) {
            this.source= Arrays.copyOf(ourArrayList.source,ourArrayList.size());
            this.size=ourArrayList.size();
            currentIndex=size-1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >-1;
        }

        @Override
        public Type next() {
            if (currentIndex >= size)
                throw new IndexOutOfBoundsException();

            Type res = (Type) source[currentIndex];
            currentIndex--;
            return res;
        }
    }
}

 /*class backwardIterator<Type> implements Iterator<Type> {

    Object[] source;
    int currentIndex = 0;
    private int size;


    public backwardIterator(OurArrayList ourArrayList) {
        this.source= Arrays.copyOf(ourArrayList.source,ourArrayList.size());
        this.size=ourArrayList.size();
        currentIndex=size-1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >-1;
    }

    @Override
    public Type next() {
        if (currentIndex >= size)
            throw new IndexOutOfBoundsException();

        Type res = (Type) source[currentIndex];
        currentIndex--;
        return res;
    }
}*/
