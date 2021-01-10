package de.telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurArrayList<Type> implements OurList<Type> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

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

    //O(n) where n is size
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
    //O[1]- the  number of operations is never dependant on the number of element in the list
    public void set(int index, Type value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Object oldValue = source[index];
        source[index] = value;
    }

    @Override
    //O(n) where n is size
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
    //O(1)
    public int size() {
        return size;
    }

    @Override
    //O(1)
    public void clear() {
        source = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    //O(n)-
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
    //O(n)
    public Iterator<Type> forwardIterator() {
        Iterator<Type> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<Type> backwardIterator() {
        Iterator<Type> iterator = new BackwardIterator<>((Type[]) source, size);
        return iterator;
    }

    @Override
    public String toString() {
        return "OurArrayList{" +
                "source=" + Arrays.toString(source) +
                '}';
    }

   /* @Override
    public void sort(Comparator<Type> comparator) {
        Type[] copy = (Type[]) new Object[size];

        int i = 0;
        for (Type elt : this) {
            copy[i++] = elt;
        }
        //copy: {15, -8, 3}

        Arrays.sort(copy, comparator);

        // copy:{-8, 3, 15}
        this.clear();
        for (Type elt : copy) {
            this.addLast(elt);
        }
    }

    @Override
    public Type max(Comparator<Type> comparator) {//video 08/01/2021
        if(size==0)
            throw new NoSuchElementException();

        Type max = this.get(0);
        for (Type elt : this)  {
            if (comparator.compare(elt,max) > 0)
                max = elt;
        }
        return max;
    }

    @Override
    public Type min(Comparator<Type> comparator) {

        return max(comparator.reversed());
    }
*/
    @Override
    public Iterator<Type> iterator() {
        return forwardIterator();
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

    private static class BackwardIterator<O> implements Iterator<O> {

        O[] source;
        int currentIndex = 0;


        public BackwardIterator(O[] source, int size) {
            //this.source= Arrays.copyOf(ourArrayList.source,ourArrayList.size());
            this.source = source;
            currentIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex > -1;
        }

        @Override
        public O next() {
            if (currentIndex < 0)
                throw new IndexOutOfBoundsException();

            O res = source[currentIndex];
            currentIndex--;
            return res;
        }


    }
}

