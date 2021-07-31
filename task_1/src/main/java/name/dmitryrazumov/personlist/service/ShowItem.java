package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.store.Store;

import java.util.Comparator;

/**
 * Class ShowItem
 * Класс реализует элемент меню для вывода списка людей на консоль.
 * При этом выполняется сортировка по фамилии.
 * @author Dmitry Razumov
 * @version 1
 */
public class ShowItem implements MenuItem {

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Store store) {
        store.findAll().stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);
        return true;
    }
}
