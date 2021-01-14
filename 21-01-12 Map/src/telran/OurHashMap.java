package telran;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;

    public OurHashMap() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    static int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    public OurHashMap(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity)
            resize();

        Pair<K, V> pair = find(key);

        if (pair != null) {
            V res = pair.value;
            pair.value = value;
            return res;
        }

        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;
        size++;
        return null;
    }

    private void resize() {
        capacity = capacity * 2;
        int chekSize = size;
        Pair[] newSource = new Pair[capacity];

        for (int i = 0; i < source.length; i++) {

            Pair<K, V> current = source[i];

            while (current != null) {
                int index = hash(current.key) % capacity;
                Pair<K, V> newPair = new Pair<>(current.key, current.value, newSource[index]);
                newSource[index] = newPair;
                current = current.next;
                chekSize--;
            }
        }
        source = newSource;
        if (chekSize == 0)
            System.out.println("copying is complete");
    }

    private Pair<K, V> find(K key) {
        int index = hash(key) % capacity;

        Pair<K, V> current = source[index];
        while (current != null) {
            if (key.equals(current.key))
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        if (find(key) == null)
            throw new NoSuchElementException();

        return find(key).value;
    }

    @Override
    public V remove(K key) {

        if (find(key) == null)
            throw new NoSuchElementException();

        Pair<K, V> pair = find(key);
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];

        //если удаляем первый лежащий снизу элемент
        if (current == pair)
            source[index] = current.next;
        else {
            while (current != null) {
                // Pair<K, V> subsequentElement = pair.next;
                if (current.next != null && key.equals(current.next.key)) {
                    current.next = pair.next;
                    break;
                }
                current = current.next;
            }
        }
        size--;
        V value = pair.value;
        pair.value = null;
        pair.key = null;

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        Iterator<K> iterator = new KeyIterator();
        return iterator;
    }

    @Override
    public Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    static private class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Pair<K, V> getNext() {
            return next;
        }
    }

    private class KeyIterator implements Iterator<K> {
        ArrayList<K> keySource;
        int currentIndex = 0;

        public KeyIterator() {
            keySource=new ArrayList<K>();
            for (int i = 0; i < source.length; i++) {
                Pair<K, V> current = source[i];
                while (current != null) {
                    keySource.add(current.key);
                    current = current.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public K next() {
            if (currentIndex >= size)
                throw new IndexOutOfBoundsException();

            K res = keySource.get(currentIndex);
            currentIndex++;
            return res;
        }
    }

    private class ValueIterator implements Iterator<V> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        public V next() {

           /* Pair<K, V> currentV = source[currentIndex];
            while (currentV != null) {
                int index = hash(currentV.key) % capacity;
                keySource.add(currentV.key);
                currentV = currentV.next;

            }
            currentIndex++;
            return currentV.value;*/
        }
    }
}