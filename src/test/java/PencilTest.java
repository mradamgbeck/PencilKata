import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {
    private String paper;
    private Pencil pencil;

    @Before
    public void setup() {
        paper = "";
        pencil = new Pencil();
    }

    @Test
    public void writeCanWriteAString() {
        String textToBeWritten = "abc";
        paper = pencil.write(paper, textToBeWritten);
        assertEquals(textToBeWritten, paper);
    }

    @Test
    public void writeDoesNotOverwritePreviousText() {
        String textToBeWrittenFirst = "abc";
        String textToBeWrittenSecond = " def";
        String concatenatedTexts = textToBeWrittenFirst + textToBeWrittenSecond;

        paper = pencil.write(paper, textToBeWrittenFirst);
        paper = pencil.write(paper, textToBeWrittenSecond);

        assertEquals(concatenatedTexts, paper);
    }

    @Test
    public void writeDecrementsSharpness() {
        int originalSharpness = 100;
        String textToBeWritten = "abc";
        pencil.write(paper, textToBeWritten);
        assertEquals(originalSharpness - textToBeWritten.length(), pencil.getCurrentSharpness());
    }
}
