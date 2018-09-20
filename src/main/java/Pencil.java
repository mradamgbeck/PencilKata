public class Pencil {
    private int currentSharpness;

    public Pencil(int originalSharpness){
        this.currentSharpness = originalSharpness;
    }

    public String write(String paper, String textToBeWritten) {
        currentSharpness -= textToBeWritten.length();
        paper = paper.concat(textToBeWritten);
        return paper;
    }

    public int getCurrentSharpness() {
        return currentSharpness;
    }
}
