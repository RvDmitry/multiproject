package name.dmitryrazumov.personlist.store;

import name.dmitryrazumov.personlist.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void whenFindAll() {
        Person first = new Person("Ivanov", "Ivan");
        Person second = new Person("Petrov", "Petr");
        MemStore store = new MemStore();
        store.add(first);
        store.add(second);
        assertEquals(Arrays.asList(first, second), store.findAll());
    }

    @Test
    public void whenClear() {
        Person first = new Person("Ivanov", "Ivan");
        Person second = new Person("Petrov", "Petr");
        MemStore store = new MemStore();
        store.add(first);
        store.add(second);
        store.clear();
        assertEquals(Collections.emptyList(), store.findAll());
    }
}