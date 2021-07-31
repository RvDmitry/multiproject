package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.MemStore;
import name.dmitryrazumov.personlist.store.Store;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddItemTest {

    @Test
    public void whenAddItem() {
        Store store = new MemStore();
        String[] answers = {"Ivanov", "Ivan"};
        StubInput input = new StubInput(answers);
        AddItem item = new AddItem();
        item.execute(input, store);
        assertEquals("Ivanov Ivan", store.findAll().get(0).toString());
    }
}