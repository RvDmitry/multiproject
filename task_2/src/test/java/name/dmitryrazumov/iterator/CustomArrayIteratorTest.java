package name.dmitryrazumov.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CustomArrayIteratorTest {

    @Test
    public void whenOne() {
        Integer[][] in = {
                {1}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertEquals(Integer.valueOf(1), it.next());
    }

    @Test
    public void whenFirstEmptyThenNext() {
        Integer[][] in = {
                {}, {1}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertEquals(Integer.valueOf(1), it.next());
    }

    @Test
    public void whenFirstEmptyThenHashNext() {
        Integer[][] in = {
                {}, {1}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertTrue(it.hasNext());
    }

    @Test
    public void whenRowHasDiffSize() {
        Integer[][] in = {
                {1}, {2, 3}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertEquals(Integer.valueOf(1), it.next());
        assertEquals(Integer.valueOf(2), it.next());
        assertEquals(Integer.valueOf(3), it.next());
    }

    @Test
    public void whenFewEmpty() {
        Integer[][] in = {
                {1}, {}, {}, {}, {2}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertEquals(Integer.valueOf(1), it.next());
        assertEquals(Integer.valueOf(2), it.next());
    }

    @Test
    public void whenEmpty() {
        Integer[][] in = {
                {}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        Integer[][] in = {
                {}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        it.next();
    }

    @Test
    public void whenMultiHashNext() {
        Integer[][] in = {
                {}, {1}
        };
        CustomArrayIterator<Integer> it = new CustomArrayIterator<>(in);
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
    }
}