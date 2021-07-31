package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.store.MemStore;
import name.dmitryrazumov.personlist.store.Store;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class ShowItemTest {

    @Test
    public void whenShowItem() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store store = new MemStore();
        Person first = new Person("Ivanov", "Ivan");
        Person second = new Person("Petrov", "Petr");
        store.add(first);
        store.add(second);
        ShowItem item = new ShowItem();
        item.execute(new StubInput(new String[] {}), store);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(first.toString())
                .add(second.toString())
                .toString();
        System.setOut(out);
        assertEquals(expected, mem.toString());
    }
}