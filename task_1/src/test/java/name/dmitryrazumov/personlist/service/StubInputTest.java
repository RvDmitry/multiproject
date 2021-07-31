package name.dmitryrazumov.personlist.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class StubInputTest {

    @Test
    public void whenOneAskStr() {
        String[] answers = {"fileName"};
        StubInput input = new StubInput(answers);
        assertEquals(answers[0], input.askStr(""));
    }

    @Test
    public void whenTwoAskStr() {
        String[] answers = {"0", "fileName"};
        StubInput input = new StubInput(answers);
        assertEquals(answers[0], input.askStr(""));
        assertEquals(answers[1], input.askStr(""));
    }

    @Test
    public void whenAskInt() {
        String[] answers = {"1"};
        StubInput input = new StubInput(answers);
        assertEquals(answers[0], Integer.toString(input.askInt("")));
    }

    @Test
    public void whenAskIntWithMax() {
        String[] answers = {"1"};
        StubInput input = new StubInput(answers);
        assertEquals(answers[0], Integer.toString(input.askInt("", 1)));
    }

    @Test(expected = IllegalStateException.class)
    public void whenAskIntWithMaxThenException() {
        String[] answers = {"2"};
        StubInput input = new StubInput(answers);
        input.askInt("", 1);
    }
}