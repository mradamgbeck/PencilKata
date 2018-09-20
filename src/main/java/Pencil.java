public class Pencil {
    private int currentSharpness;

    public Pencil(int originalSharpness) {
        this.currentSharpness = originalSharpness;
    }

    public String write(String paper, String textToBeWritten) {
        char[] characters = textToBeWritten.toCharArray();
        for (char character : characters) {
            int amountToDullen = calculateAmountToDullen(character);
            if (this.currentSharpness - amountToDullen >= 0) {
                this.currentSharpness -= amountToDullen;
                paper = paper.concat("" + character);
            } else
                paper = paper.concat(" ");
        }
        return paper;
    }

    private int calculateAmountToDullen(char character) {
        if (Character.isUpperCase(character))
            return 2;
        return 1;
    }

    public int getCurrentSharpness() {
        return currentSharpness;
    }

    public void setCurrentSharpness(int currentSharpness) {
        this.currentSharpness = currentSharpness;
    }
}
