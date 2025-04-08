package com.generics;

import java.util.Iterator;

public class GenricsIterable<T> implements Iterable<T> {
    private T[] items;
    private int size;
    public GenricsIterable(int capacity) {
        items = (T[]) new Object[capacity];
    }
    public void add(T item) {
        items[size++] = item;
    }
    @Override
    public Iterator<T> iterator() {
        return new GenricsIterator();
    }
    private class GenricsIterator implements Iterator<T> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public T next() {
            return items[index++];
        }
    }
}
