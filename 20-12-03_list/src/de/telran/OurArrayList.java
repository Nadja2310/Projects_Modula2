package de.telran;

public class OurArrayList<Type> implements OurList<Type>{

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
        size--;
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
            source[size - 1] = 0;
            size--;

        return (Type) oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            source[i] = 0;

        size = 0;
    }
}
