package name.dmitryrazumov.personlist.store;

import name.dmitryrazumov.personlist.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class MemStore
 * Класс реализует хранилище людей, которое хранится в памяти.
 * @author Dmitry Razumov
 * @version 1
 */
public class MemStore implements Store {

    private final List<Person> personList = new ArrayList<>();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public void save(String name) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(name)))) {
            for (Person person : personList) {
                out.write(person.toString() + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(String name) {
        try (BufferedReader in = new BufferedReader(new FileReader(name))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] str = s.split("\\s");
                if (str.length == 2) {
                    personList.add(new Person(str[0], str[1]));
                }
            }
            System.out.println("File uploaded successfully.");
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    @Override
    public void clear() {
        personList.clear();
    }
}
