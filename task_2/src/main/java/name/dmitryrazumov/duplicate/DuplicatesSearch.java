package name.dmitryrazumov.duplicate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class DuplicatesSearch
 * Класс осуществляет поиск дубликатов в двух коллекциях.
 * @author Dmitry Razumov
 * @version 1
 */
public class DuplicatesSearch<E> {

    private final Collection<E> first;
    private final Collection<E> second;

    public DuplicatesSearch(Collection<E> first, Collection<E> second) {
        this.first = first;
        this.second = second;
    }

    public Collection<E> findOne() {
        Collection<E> col = new ArrayList<>(first);
        col.retainAll(second);
        return col;
    }

    public Collection<E> findTwo() {
        Collection<E> col = new ArrayList<>();
        Set<E> one = new HashSet<>(first);
        Set<E> two = new HashSet<>(second);
        for (E item : two) {
            if (!one.add(item)) {
                col.add(item);
            }
        }
        return col;
    }

    public Collection<E> findThree() {
        return Stream
                .concat(new HashSet<>(first).stream(), new HashSet<>(second).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
