package name.dmitryrazumov.personlist;

import name.dmitryrazumov.personlist.model.Person;
import name.dmitryrazumov.personlist.service.*;
import name.dmitryrazumov.personlist.store.*;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Class Main
 * Класс запускает работу приложения.
 * @author Dmitry Razumov
 * @version 1
 */
public class Main {

    public void init(Input input, Store store, List<MenuItem> items) {
        boolean run = true;
        while (run) {
            this.showMenu(items);
            int select = input.askInt("Select: ", items.size());
            MenuItem item = items.get(select - 1);
            run = item.execute(input, store);
        }
    }

    private void showMenu(List<MenuItem> items) {
        System.out.println(System.lineSeparator() + "Menu:");
        for (int index = 0; index < items.size(); index++) {
            System.out.println((index + 1) + ". " + items.get(index).name());
        }
    }

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Количество заданных ключей неверное.");
        joiner.add("Проверьте наличие ключей -l и -f, и их значений "
                + "либо не указывайте ключи, будет вызвано меню.");
        joiner.add("-l \"Фамилия\"");
        joiner.add("-f \"Имя\"");
        ArgSearch arg = new ArgSearch(args);
        if (args.length != 0 && !arg.valid()) {
            throw new IllegalArgumentException(joiner.toString());
        } else if (args.length != 0) {
            System.out.println(new Person(arg.lastName(), arg.firstName()));
        } else {
            Input input = new ValidateInput(new ConsoleInput());
            Store store = new MemStore();
            List<MenuItem> items = Arrays.asList(
                    new AddItem(),
                    new ShowItem(),
                    new ShowUniqueItem(),
                    new SaveItem(),
                    new ReadItem(),
                    new ClearItem(),
                    new ExitItem()
            );
            new Main().init(input, store, items);
        }
    }
}
