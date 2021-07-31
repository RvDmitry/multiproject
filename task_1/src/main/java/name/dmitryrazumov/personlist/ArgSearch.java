package name.dmitryrazumov.personlist;

import java.util.Arrays;
import java.util.List;

/**
 * Class ArgSearch
 * Класс реализует поиск и верификацию ключей вводимых пользователем
 * при запуске приложения в консоли.
 * @author Dmitry Razumov
 * @version 1
 */
public class ArgSearch {
    /**
     * Список аргументов.
     */
    private final List<String> args;

    public ArgSearch(String[] args) {
        this.args = Arrays.asList(args);
    }

    /**
     * Метод осуществляет валидацию переданных аргументов.
     * @return true, если количество параметров соответствует требуемому значению, иначе false
     */
    public boolean valid() {
        if (!(args.contains("-f") && args.contains("-l"))) {
            return false;
        }
        return args.size() == 4;
    }

    public String firstName() {
        int i = args.indexOf("-f");
        return args.get(i + 1);
    }

    public String lastName() {
        int i = args.indexOf("-l");
        return args.get(i + 1);
    }
}
