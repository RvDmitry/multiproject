package name.dmitryrazumov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class CustomArrayIterator
 * Класс реализует итератор по двухмерному массиву.
 * @author Dmitry Razumov
 * @version 1
 */
public class CustomArrayIterator<T> implements Iterator<T> {
    /**
     * Массив данных.
     */
    private final T[][] data;
    /**
     * Строка массива.
     */
    private int row = 0;
    /**
     * Столбец массива.
     */
    private int column = 0;

    public CustomArrayIterator(T[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
