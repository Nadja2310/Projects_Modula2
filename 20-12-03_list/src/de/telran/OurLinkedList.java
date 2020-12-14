package de.telran;

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

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

    private class ForwardIterator implements Iterator<T> {

        Node<T> currentNode = first;

        @Override
        public boolean hasNext() {
            return (first!=null?(currentNode != null || currentNode==last):false);
        }

        @Override
        public T next() {
             if (currentNode == null)
                  throw new IndexOutOfBoundsException();

            T res = currentNode.element;
            if (currentNode == last)
                currentNode = null;
            else
                currentNode = currentNode.next;
            return res;
        }
    }

    private class BackwardIterator implements Iterator<T> {

        Node<T> currentNode=last;

        @Override
        public boolean hasNext() {
            return (last!=null?(currentNode != null || currentNode==first):false);
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
