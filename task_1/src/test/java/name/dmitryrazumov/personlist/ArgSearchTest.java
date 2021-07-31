package name.dmitryrazumov.personlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgSearchTest {

    @Test
    public void whenValidTrue() {
        String[] args = {"-l", "A", "-f", "A"};
        ArgSearch search = new ArgSearch(args);
        assertTrue(search.valid());
    }

    @Test
    public void when3KeyThenValidFalse() {
        String[] args = {"-l", "A", "-f"};
        ArgSearch search = new ArgSearch(args);
        assertFalse(search.valid());
    }

    @Test
    public void whenNofKeyThenValidFalse() {
        String[] args = {"-l", "A", "A", "A"};
        ArgSearch search = new ArgSearch(args);
        assertFalse(search.valid());
    }

    @Test
    public void whenNlfKeyThenValidFalse() {
        String[] args = {"A", "A", "-f", "A"};
        ArgSearch search = new ArgSearch(args);
        assertFalse(search.valid());
    }

    @Test
    public void whenFirstName() {
        String[] args = {"-l", "Ivanov", "-f", "Ivan"};
        ArgSearch search = new ArgSearch(args);
        assertEquals("Ivan", search.firstName());
    }

    @Test
    public void whenLastName() {
        String[] args = {"-l", "Ivanov", "-f", "Ivan"};
        ArgSearch search = new ArgSearch(args);
        assertEquals("Ivanov", search.lastName());
    }
}