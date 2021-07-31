package name.dmitryrazumov.duplicate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DuplicatesSearchTest {

    private List<Integer> expected;
    private DuplicatesSearch<Integer> search;

    @Before
    public void init() {
        List<Integer> first = Arrays.asList(1, 1, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> second = Arrays.asList(3, 4, 5, 10, 10, 12);
        expected = Arrays.asList(3, 4, 5);
        search = new DuplicatesSearch<>(first, second);
    }

    @Test
    public void whenFindOne() {
        Collection<Integer> rsl = search.findOne();
        assertEquals(expected, rsl);
    }

    @Test
    public void whenFindTwo() {
        Collection<Integer> rsl = search.findTwo();
        assertEquals(expected, rsl);
    }

    @Test
    public void whenFindThree() {
        Collection<Integer> rsl = search.findThree();
        assertEquals(expected, rsl);
    }
}