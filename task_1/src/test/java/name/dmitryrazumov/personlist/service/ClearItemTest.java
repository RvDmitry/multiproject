package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.store.MemStore;
import name.dmitryrazumov.personlist.store.Store;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class ClearItemTest {

    @Test
    public void whenClearItem() {
        Store store = new MemStore();
        store.add(new Person("Alexov", "Alex"));
        ClearItem item = new ClearItem();
        item.execute(null, store);
        assertEquals(Collections.emptyList(), store.findAll());
    }
}