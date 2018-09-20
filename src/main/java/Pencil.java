public class Pencil {
    public String write(String paper, String textToBeWritten) {
        paper = paper.concat(textToBeWritten);
        return paper;
    }
}
