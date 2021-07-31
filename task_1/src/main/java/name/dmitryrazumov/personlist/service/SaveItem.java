package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Class SaveItem
 * Класс реализует элемент меню для сохранения списка людей в файл.
 * @author Dmitry Razumov
 * @version 1
 */
public class SaveItem implements MenuItem {

    @Override
    public String name() {
        return "Save to file";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Enter file name: ");
        store.save(name);
        return true;
    }
}
