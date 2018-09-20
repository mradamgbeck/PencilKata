import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {

    @Test
    public void writeCanWriteASingleLetter() {
        Pencil pencil = new Pencil();
        String paper = "";

        String textToBeWritten = "a";
        paper = pencil.write(paper, textToBeWritten);
        assertEquals(textToBeWritten, paper);
    }
}
