package telran;

import java.util.HashMap;
import java.util.Iterator;

public class OurHashSet<T> implements OurSet<T> {

    private OurHashMap<T, Object> source;

    private final Object stubValue = new Object();

    public OurHashSet() {
        this.source = new OurHashMap<>();
    }

    @Override
    public boolean add(T elt) {
        return (source.put(elt, stubValue) == null);
    }

    @Override
    public boolean remove(T elt) {
        return (source.remove(elt) != null);
    }

    @Override
    public boolean contains(T elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public void addAll(OurSet<T> another) {
        Iterator<T> iterator = another.iterator();
        while (iterator.hasNext()) {
            source.put(iterator.next(), stubValue);
        }
    }

    @Override
    public void retainAll(OurSet<T> another) {
        OurHashMap<T,Object> retainSource=new OurHashMap<>();
        Iterator<T> iterator = another.iterator();
        while (iterator.hasNext()) {
            T res = iterator.next();
            if (source.containsKey(res))
                retainSource.put(res,stubValue);
            //System.out.println("ret "+res);
        }
        source=retainSource;
    }

    @Override
    public void removeAll(OurSet<T> another) {
        Iterator<T> iterator = another.iterator();
        while (iterator.hasNext()) {
            source.remove(iterator.next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return source.keyIterator();
    }
}
