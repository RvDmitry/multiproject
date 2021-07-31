package name.dmitryrazumov.personlist.store;

import name.dmitryrazumov.personlist.model.Person;

import java.util.List;

/**
 * Interface Store
 * Интерфейс описывает хранилище людей.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {

    void add(Person person);

    List<Person> findAll();

    void save(String name);

    void read(String name);

    void clear();
}
