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
}
