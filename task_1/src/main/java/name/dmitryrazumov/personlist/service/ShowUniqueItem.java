package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.store.Store;

import java.util.Comparator;

/**
 * Class ShowUniqueItem
 * Класс реализует элемент меню для вывода списка людей на консоль.
 * При этом выводятся люди только с уникальными фамилиями.
 * Также выполняется сортировка по фамилии.
 * @author Dmitry Razumov
 * @version 1
 */
public class ShowUniqueItem implements MenuItem {

    @Override
    public String name() {
        return "Show sorted unique";
    }

    @Override
    public boolean execute(Input input, Store store) {
        store.findAll().stream()
                .distinct()
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);
        return true;
    }
}
