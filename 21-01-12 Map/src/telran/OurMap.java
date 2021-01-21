package telran;

import javafx.util.Pair;

import java.util.Iterator;

public interface OurMap<K,V> {
     V put(K key, V value);

     V get(K key);

     V remove(K key);

     int size();

     boolean containsKey(K key);

    Iterator<K> keyIterator();

    Iterator<V> valueIterator();
}
