package name.dmitryrazumov.personlist.service;

/**
 * Class StubInput
 * Класс имитирует взаимодействие пользователя с объектом Scanner.
 * @author Dmitry Razumov
 * @version 1
 */
public class StubInput implements Input {
    /**
     * Массив ответов пользователя.
     */
    private final String[] answers;

    /**
     * Счетчик элементов массива.
     */
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String message) {
        return answers[position++];
    }

    @Override
    public int askInt(String message) {
        return Integer.parseInt(askStr(message));
    }

    @Override
    public int askInt(String message, int max) {
        int select = askInt(message);
        if (select < 1 || select > max) {
            throw new IllegalStateException("Invalid item. Re-enter.");
        }
        return select;
    }
}