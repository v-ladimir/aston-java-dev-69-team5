package customClasses;

/*
Реализовать собственный аналог ArrayList/LinkedList (листы на выбор,
но должны быть основные методы add, get, remove, addAll)
 */

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayListImpl<T> extends AbstractList<T> {
    private T[] array;
    private int capacity;
    private int filledCellsCount;

    public CustomArrayListImpl(int capacity) {
        this.capacity = capacity;
        this.filledCellsCount = 0;
        this.array = (T[]) new Object[capacity];
    }

    public CustomArrayListImpl() {
        this(10);
    }

    @Override
    public int size() {
        return filledCellsCount;
    }

    @Override
    public void add(int indexToAdd, T value) {
        if (indexToAdd >= filledCellsCount || indexToAdd < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (filledCellsCount == capacity) {
            resize();
        }

        shiftTailRight(indexToAdd);

        array[indexToAdd] = value;
        filledCellsCount++;
    }

    @Override
    public boolean add(T value) {
        if (filledCellsCount == capacity) {
            resize();
        }

        array[filledCellsCount] = value;
        filledCellsCount++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> otherList) {
        if (otherList == null) {
            return false;
        }
        int requiredCapacity = filledCellsCount + otherList.size();
        if (requiredCapacity >= capacity) {
            int newCapacity = (int) (requiredCapacity * 1.5);
            resize(newCapacity);
        }
        T[] otherListArray = (T[]) otherList.toArray();
        for (int i = 0; i < otherList.size(); i++) {
            array[filledCellsCount] = otherListArray[i];
            filledCellsCount++;
        }
        return true;
    }

    @Override
    public T get(int index) {
        if(index<0 || index >= filledCellsCount) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        if(index<0 || index >= filledCellsCount) {
            throw new IndexOutOfBoundsException();
        }
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    @Override
    public T remove(int indexToRemove) {
        if (indexToRemove >= filledCellsCount || indexToRemove < 0) {
            throw new IndexOutOfBoundsException();
        }
        T objectToRemove = array[indexToRemove];
        shiftTailLeft(indexToRemove);
        array[filledCellsCount - 1] = null;
        filledCellsCount--;
        return objectToRemove;
    }

    @Override
    public boolean isEmpty() {
        return filledCellsCount == 0;
    }

    private void shiftTailRight(int indexToAdd) {
        for (int i = filledCellsCount - 1; i >= indexToAdd; i--) {
            array[i + 1] = array[i];
        }
    }

    private void shiftTailLeft(int indexToRemove) {
        for (int i = indexToRemove + 1; i < filledCellsCount; i++) {
            array[i - 1] = array[i];
        }
    }

    private void resize(int newCapacity) {
        if (newCapacity <= capacity) {
            throw new IllegalArgumentException();
        }

        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < filledCellsCount; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;
    }

    private void resize() {
        int newCapacity;
        if (capacity == 0) {
            newCapacity = 10;
        } else {
            newCapacity = (int) (1.5 * capacity);
        }
        resize(newCapacity);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < filledCellsCount;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return array[currentIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return iterator;
    }
}
