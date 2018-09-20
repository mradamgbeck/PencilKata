public class Pencil {
    private int currentSharpness;

    public Pencil(int originalSharpness) {
        this.currentSharpness = originalSharpness;
    }

    public String write(String paper, String textToBeWritten) {
        char[] characters = textToBeWritten.toCharArray();
        for (char character : characters) {
            this.currentSharpness -= Character.isUpperCase(character) ? 2 : 1;
            paper = paper.concat("" + character);
        }
        return paper;
    }

    public int getCurrentSharpness() {
        return currentSharpness;
    }
}
