package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    Node<T> first;
    Node<T> last;
    int size;

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(null, last, element);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> needle = getNodeByIndex(index);
        return needle.element;
    }

    @Override
    public void set(int index, T value) {
        Node<T> needle = getNodeByIndex(index);
        needle.element = value;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node<T> res = last;
        for (int i = size; i > 0; i--) {
            res.next = res.prev = null;
            res.element = null;
        }
        first = last = null;
        size = 0;
    }

    private T removeNode(Node<T> needle) {
        Node<T> befor = needle.prev;
        Node<T> after = needle.next;


        if (befor != null) {
            befor.next = after;
        } else {
            first = after;
        }

        if (after != null) {
            after.prev = befor;
        } else {
            last = befor;
        }

        //clear the removing element
        needle.prev = needle.next = null;
        T res = needle.element;
        needle.element = null;
        size--;
        return res;
    }

    @Override
    public T removeById(int index) {

        Node<T> needle = getNodeByIndex(index);

        return removeNode(needle);
    }

    @Override
    public boolean remove(T obj) {
        Node<T> needle = findByElement(obj);
        if (needle == null)
            return false;

        removeNode(needle);
        return true;
    }

    private Node<T> findByElement(T obj) {
        Node<T> res = first;
        if (obj == null) {
            //  for (int i = 0; i < size; i++)
            while (res != null) {
                if (res.element == null)
                    return res;

                res = res.next;
            }
        } else {
            while (res != null) {
                if (res.element != null)
                    return res;

                res = res.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(T obj) {
       /* if (size == 0) {
            return false;
        }
        if (obj == null) {

            for (int i = 0; i < size; i++) {
                if (getNodeByIndex(i).element == null)
                    return true;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (getNodeByIndex(i).element.equals(obj))
                return true;
        }
        return false;*/
        return findByElement(obj) != null;
    }

    @Override
    public Iterator<T> forwardIterator() {
        Iterator<T> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<T> backwardIterator() {
        Iterator<T> iterator = new BackwardIterator();
        return iterator;
    }

  /*  @Override
    public void sort(Comparator<T> comparator) {
            Object[] copy = new Object[size];

            int i = 0;
            for (T elt : this) {
                copy[i++] = elt;
            }
            // this is going to be a sort of the copy
        int start = 0;
        int end = copy.length - 1;
        while (start <= end) {
            int count = 0;
            for (i = start; i < end; i++) {
                if (comparator.compare((T) copy[i], (T)copy[i + 1]) > 0) {
                    T temp = (T) copy[i];
                    copy[i] = copy[i+1];
                    copy[i+1] = temp;
                    count++;
                }
            }
            end--;
            for (i = end; i > start; i--) {
                if (comparator.compare((T)copy[i], (T)copy[i - 1]) < 0) {
                    T temp = (T) copy[i];
                    copy[i] = copy[i-1];
                    copy[i-1] = temp;
                    count++;
                }
            }
            start++;
            if (count == 0) break;
        }
            this.clear();
            for (Object elt : copy) {
                this.addLast((T) elt);
            }
    }

    @Override
    public T max(Comparator<T> comparator) {
        T max = this.get(0);
        for (int i = 1; i < size; i++) {
            if (comparator.compare(this.get(i),max) > 0)
                max = this.get(i);
        }
        return max;
    }

    @Override
    public T min(Comparator<T> comparator) {
        T min = this.get(0);
        for (T elt : this) {
            if (comparator.compare(min, elt) < 0)
                min = elt;
        }
        return min;
    }*/

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

    private class ForwardIterator implements Iterator<T> {

        Node<T> currentNode = first;

        @Override
        public boolean hasNext() {
            //return (first!=null?(currentNode != null || currentNode==last):false);
            return currentNode != null;
        }

        @Override
        public T next() {
             if (currentNode == null)
                  throw new IndexOutOfBoundsException();

            T res = currentNode.element;
            currentNode = currentNode.next;
            /*if (currentNode == last)
                currentNode = null;
            else
                currentNode = currentNode.next;*/
            return res;
        }
    }

    private class BackwardIterator implements Iterator<T> {

        Node<T> currentNode=last;

        @Override
        public boolean hasNext() {
           // return (last!=null?(currentNode != null || currentNode==first):false);
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();

            T res = currentNode.element;
            if (currentNode == first)
                currentNode = null;
            else
                currentNode = currentNode.prev;
            return res;
        }
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T element;

        public Node() {
        }

        public Node(Node<T> next, Node<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }

}
