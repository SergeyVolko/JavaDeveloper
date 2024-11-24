package com.edu;

import java.util.*;
import java.util.stream.IntStream;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MULTIPLE_CAPACITY = 2;
    private Object[] data;
    private int size;
    private final int maxCapacity;
    int modCount = 0;

    public DefaultCustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = Integer.MAX_VALUE;
    }

    public DefaultCustomArrayList(int maxCapacity) {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean add(E element) {
        if (size == maxCapacity) {
            return false;
        }
        if (data.length == size) {
            data = Arrays.copyOf(data, data.length * MULTIPLE_CAPACITY);
        }
        data[size++] = element;
        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    private void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean contains(E element) {
        return getIndex(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private int getIndex(E element) {
        return IntStream.range(0, data.length)
                .filter(i -> Objects.equals(element, data[i]))
                .findFirst()
                .orElse(-1);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            Object[] data = DefaultCustomArrayList.this.data;
            return (E) data[cursor++];
        }

        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}