package name.dmitryrazumov.personlist.service;

/**
 * Class ValidateInput
 * Класс осуществляет валидацию данных вводимых пользователем.
 * @author Dmitry Razumov
 * @version 1
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Not a number. Re-enter.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Not a number. Re-enter.");
            }
        } while (invalid);
        return value;
    }
}
