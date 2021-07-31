package name.dmitryrazumov.personlist;

import name.dmitryrazumov.personlist.service.StubInput;
import name.dmitryrazumov.personlist.service.StubItem;
import name.dmitryrazumov.personlist.store.MemStore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongArgThenException() {
        String[] args = {"A", "A"};
        Main.main(args);
    }

    @Test
    public void whenArgValidThenPrintName() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] args = {"-l", "Ivanov", "-f", "Ivan"};
        Main.main(args);
        String expected = new StringJoiner(" ", "", System.lineSeparator())
                .add("Ivanov")
                .add("Ivan")
                .toString();
        System.setOut(out);
        assertEquals(expected, mem.toString());
    }

    @Test
    public void whenPrintMenu() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        StubInput input = new StubInput(
                new String[] {"1"}
        );
        StubItem item = new StubItem();
        new Main().init(input, new MemStore(), Arrays.asList(item));
        String expected = new StringJoiner(
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator())
                .add("Menu:")
                .add("1. Stub action")
                .toString();
        System.setOut(out);
        assertEquals(expected, mem.toString());
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"1"}
        );
        StubItem item = new StubItem();
        new Main().init(input, new MemStore(), Arrays.asList(item));
       assertTrue(item.isCall());
    }
}