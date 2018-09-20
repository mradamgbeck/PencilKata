public class Pencil {
    private final int currentEraserDurability;
    private int currentSharpness;

    Pencil(int originalSharpness, int originalEraserDurability) {
        this.currentSharpness = originalSharpness;
        this.currentEraserDurability = originalEraserDurability;
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
        else if (Character.isSpaceChar(character) ||
                !String.valueOf(character).matches("."))
            return 0;
        return 1;
    }

    public int getCurrentSharpness() {
        return currentSharpness;
    }

    public void setCurrentSharpness(int currentSharpness) {
        this.currentSharpness = currentSharpness;
    }

    public String erase(String paper, String textToBeErased) {
        String spaces = "";
        for (int i = 0; i < textToBeErased.length(); i++) {
            spaces = spaces.concat(" ");
        }

        int index = paper.lastIndexOf(textToBeErased);
        return paper.substring(
                0, index) +
                spaces +
                paper.substring(index + textToBeErased.length());
    }

    public int getCurrentEraserDurability() {
        return this.currentEraserDurability;
    }
}
