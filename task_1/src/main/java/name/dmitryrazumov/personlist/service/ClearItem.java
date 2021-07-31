package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Class ClearItem
 * Класс реализует элемент меню для очистки списка людей.
 * @author Dmitry Razumov
 * @version 1
 */
public class ClearItem implements MenuItem {

    @Override
    public String name() {
        return "Clear data in memory";
    }

    @Override
    public boolean execute(Input input, Store store) {
        store.clear();
        return true;
    }
}
