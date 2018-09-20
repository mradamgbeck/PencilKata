public class Pencil {
    private int currentSharpness;

    public String write(String paper, String textToBeWritten) {
        paper = paper.concat(textToBeWritten);
        return paper;
    }

    public int getCurrentSharpness() {
        return currentSharpness;
    }
}
