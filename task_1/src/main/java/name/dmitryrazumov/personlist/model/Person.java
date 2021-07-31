package name.dmitryrazumov.personlist.model;

import java.util.Objects;

/**
 * Class City
 * Класс характеризует человека.
 * @author Dmitry Razumov
 * @version 1
 */
public class Person {
    /**
     * Имя
     */
    private String firstName;
    /**
     * Фамилия
     */
    private String lastName;

    public Person(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
