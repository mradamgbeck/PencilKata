import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {
    private String paper;
    private Pencil pencil;
    int originalSharpness;

    @Before
    public void setup() {
        paper = "";
        originalSharpness = 100;
        pencil = new Pencil(originalSharpness);
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
        String textToBeWritten = "abc";
        pencil.write(paper, textToBeWritten);
        assertEquals(originalSharpness - textToBeWritten.length(), pencil.getCurrentSharpness());
    }

    @Test
    public void writeDecrementsSharpnessByTwoForCapitals() {
        String textToBeWritten = "ABC";
        pencil.write(paper, textToBeWritten);
        assertEquals(originalSharpness - textToBeWritten.length() * 2, pencil.getCurrentSharpness());
    }

    @Test
    public void writeWritesSpacesWhenCompletelyDull() {
        String textToBeWritten = "abcdef";
        pencil.setCurrentSharpness(3);
        paper = pencil.write(paper, textToBeWritten);
        assertEquals("abc   ", paper);
    }
}
