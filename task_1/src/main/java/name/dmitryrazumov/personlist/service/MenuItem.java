package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Interface MenuItem
 * Интерфейс описывает элемент меню.
 * @author Dmitry Razumov
 * @version 1
 */
public interface MenuItem {

    String name();

    boolean execute(Input input, Store store);
}
