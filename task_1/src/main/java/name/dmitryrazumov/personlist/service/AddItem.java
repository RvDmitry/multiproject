package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.store.Store;

/**
 * Class AddItem
 * Класс реализует элемент меню для добавления нового человека.
 * @author Dmitry Razumov
 * @version 1
 */
public class AddItem implements MenuItem {

    @Override
    public String name() {
        return "Add";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String lastName = input.askStr("Enter lastName: ");
        String firstName = input.askStr("Enter firstName: ");
        Person person = new Person(lastName, firstName);
        store.add(person);
        return true;
    }
}
