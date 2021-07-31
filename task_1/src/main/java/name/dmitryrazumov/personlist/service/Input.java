package name.dmitryrazumov.personlist.service;

/**
 * Interface Input
 * Интерфейс описывает методы запросов для пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Input {

    String askStr(String message);

    int askInt(String message);

    int askInt(String message, int max);
}
