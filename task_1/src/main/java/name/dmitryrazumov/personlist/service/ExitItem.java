package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Class ExitItem
 * Класс реализует элемент меню для завершения приложения.
 * @author Dmitry Razumov
 * @version 1
 */
public class ExitItem implements MenuItem {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        return false;
    }
}
