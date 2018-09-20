import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {
    private String paper;
    private Pencil pencil;
    int originalSharpness;
    private int originalEraserDurability;

    @Before
    public void setup() {
        paper = "";
        originalSharpness = 100;
        originalEraserDurability = 100;
        pencil = new Pencil(originalSharpness, originalEraserDurability);
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

    @Test
    public void writeStopsWritingIfSharpnessWillBeLessThanZero() {
        String textToBeWritten = "abC";
        pencil.setCurrentSharpness(3);
        paper = pencil.write(paper, textToBeWritten);
        assertEquals("ab ", paper);
    }

    @Test
    public void writeDoesNotCountSpacesWhenDulleningPencil() {
        String textToBeWritten = "  b  ";
        pencil.setCurrentSharpness(3);
        paper = pencil.write(paper, textToBeWritten);
        assertEquals(2, pencil.getCurrentSharpness());
    }

    @Test
    public void writeDoesNotCountNewLinesWhenDulleningPencil() {
        String textToBeWritten = "\nb\n";
        pencil.setCurrentSharpness(3);
        paper = pencil.write(paper, textToBeWritten);
        assertEquals(2, pencil.getCurrentSharpness());
    }

    @Test
    public void eraseCanEraseAWord() {
        paper = "one two three four five";
        String textToBeErased = "four";
        paper = pencil.erase(paper, textToBeErased);
        assertEquals("one two three      five", paper);
    }

    @Test
    public void eraseErasesOnlyLastInstanceOfAWord() {
        paper = "one two three four four five";
        String textToBeErased = "four";
        paper = pencil.erase(paper, textToBeErased);
        assertEquals("one two three four      five", paper);
    }

    @Test
    public void eraseDegradesEraserDurability() {
        paper = "some text";
        String textToBeErased = "some";
        paper = pencil.erase(paper, textToBeErased);
        assertEquals(originalEraserDurability - textToBeErased.length(),
                pencil.getCurrentEraserDurability());
    }
}
