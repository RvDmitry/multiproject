package name.dmitryrazumov.personlist.service;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenAskString() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"Five"})
        );
        assertEquals("Five", input.askStr(""));
    }

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"one", "1"})
        );
        input.askInt("");
        System.setOut(out);
        assertEquals(String.format("Not a number. Re-enter.%n"), mem.toString());
    }

    @Test
    public void whenMaxErrorInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"4", "1"})
        );
        input.askInt("", 2);
        System.setOut(out);
        assertEquals(String.format("Invalid item. Re-enter.%n"), mem.toString());
    }
}