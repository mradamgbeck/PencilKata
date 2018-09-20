public class Pencil {
    private int currentEraserDurability;
    private int currentSharpness;
    private int originalSharpness;
    private int currentLength;

    Pencil(int originalSharpness, int originalEraserDurability, int originalLength) {
        this.originalSharpness = originalSharpness;
        this.currentSharpness = originalSharpness;
        this.currentEraserDurability = originalEraserDurability;
        this.currentLength = originalLength;
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
        int indexOfText = paper.lastIndexOf(textToBeErased);
        for (int i = textToBeErased.length(); i > 0; i--) {
            if (this.currentEraserDurability > 0) {
                this.currentEraserDurability -= 1;
                paper = paper.substring(
                        0, indexOfText + i - 1) +
                        " " +
                        paper.substring(indexOfText + i, paper.length());
            }
        }
        return paper;
    }

    public int getCurrentEraserDurability() {
        return this.currentEraserDurability;
    }

    public void setCurrentEraserDurability(int currentEraserDurability) {
        this.currentEraserDurability = currentEraserDurability;
    }

    public int getOriginalSharpness() {
        return this.originalSharpness;
    }

    public void setLength(int newLength){
        this.currentLength = newLength;
    }

    public int getLength(){
        return this.currentLength;
    }

    public String edit(String paper, String wordToInsertAfter, String textToInsert) {
        return null;
    }
}
