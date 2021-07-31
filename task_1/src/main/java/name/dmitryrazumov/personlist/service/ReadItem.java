package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Class ReadItem
 * Класс реализует элемент меню для считывания списка людей из файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class ReadItem implements MenuItem {

    @Override
    public String name() {
        return "Read from file";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name =  input.askStr("Enter file name: ");
        store.read(name);
        return true;
    }
}
