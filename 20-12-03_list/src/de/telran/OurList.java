package de.telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface OurList<Type> extends Iterable<Type>{

    /**
     * Adds the element to the 'this' instance
     *
     * @param element - to add
     */
    void addLast(Type element);

    /**
     * @param index - index of the element to return. It must be in the range between 0 and (size-1).
     * @return returns the element by the index
     */
    Type get(int index);

    /**
     * sets the value to the index place in the 'this' instance
     *
     * @param index the place to set
     * @param value the value to set
     */
    void set(int index, Type value);

    /**
     * removes the element by the index
     *
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    Type removeById(int index);

    /**
     * @return the size of 'this'
     */
    int size();

    /**
     * makes 'this' empty
     */
    void clear();

    /**
     * remove the obj if there is a element in the list which 'equals' to the obj.
     * the method must remove only first such element.
     *
     * @param obj to remove
     * @return true if the obj was found and removed, false otherwise
     */
    boolean remove(Type obj);

    /**
     * @param obj
     * @return
     */
    boolean contains(Type obj);

    /**
     * @return iterator object which iterates from the beginning to the end of the list
     */
    Iterator<Type> forwardIterator();

    /**
     * @return iterator object which iterates from the end to the beginning of the list
     */
    Iterator<Type> backwardIterator();

    /**
     * sorts the list according to the 'comparator' rule
     * @param comparator the rule to sort the list
     */
   /* void sort(Comparator<Type> comparator);

    Type max(Comparator<Type> comparator);

    Type min(Comparator<Type> comparator);*/
    /**
     * sorts the list according to the 'comparator' rule
     *
     * @param comparator the rule to sort the list
     */
    default void sort(Comparator<Type> comparator) {
        Type[] copy = (Type[]) new Object[size()];

        int i = 0;
        for (Type elt : this) {
            copy[i++] = elt;
        }//copy: {15, -8, 3}

        for (int j = 0; j < this.size(); j++) {
            int minId = j;
           for (int k = j + 1; k < this.size(); k++) {
               Comparable<Type> compCurrentElement=(Comparable<Type>) copy[k];
                if (compCurrentElement.compareTo(copy[minId]) < 0) {
                   minId = k;
               }
           }

            Type temp = copy[j];
            copy[j] = copy[minId];
            copy[minId] = temp;
        }

        this.clear();
        for (Type elt : copy) {
            this.addLast(elt);
        }
    }

    default Type maxComparator(Comparator<Type> comparator) {
        if (size() == 0)
            throw new NoSuchElementException();

//        Iterator<Type> iterator = iterator();
//        Type max = iterator.next();
//
//        while (iterator.hasNext()) {
//            Type currentElt = iterator.next();
//            if (comparator.compare(currentElt, max) > 0)
//                max = currentElt;
//        }

        Type max = this.get(0);

        for (Type currentElt : this) {
            if (comparator.compare(currentElt, max) > 0)
                max = currentElt;
        }

        return max;
    }

    /**
     * The method uses the natural ordering of the elements inside the list.
     * Meaning the elements must be Comparable
     *
     * @return max according to the natural ordering
     * @param integerBasicComparator
     */
    default Type max() {
        if (size() == 0)
            throw new NoSuchElementException();

        Type max = this.get(0);

        for (Type currentElt : this) {
            Comparable<Type> compCurrentElement = (Comparable<Type>) currentElt;
            if (compCurrentElement.compareTo(max) > 0)
                max = currentElt;
        }

        return max;
    }

    default Type minComparator(Comparator<Type> comparator) {
        return maxComparator(comparator.reversed());
    }

    default Type min() {
        if (size() == 0)
            throw new NoSuchElementException();

        Type min = this.get(0);

        for (Type currentElt : this) {
            Comparable<Type> compCurrentElement = (Comparable<Type>) currentElt;
            if (compCurrentElement.compareTo(min) < 0)
                min = currentElt;
        }

        return min;
    }
}
