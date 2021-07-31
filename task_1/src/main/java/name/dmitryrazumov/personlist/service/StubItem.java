package name.dmitryrazumov.personlist.service;

import name.dmitryrazumov.personlist.store.Store;

/**
 * Class StubItem
 * Класс имитирует некоторый пункт меню и выполнение некоторого действия при его выборе.
 * @author Dmitry Razumov
 * @version 1
 */
public class StubItem implements MenuItem {

    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        call = true;
        return false;
    }
    
    public boolean isCall() {
        return call;
    }
}
