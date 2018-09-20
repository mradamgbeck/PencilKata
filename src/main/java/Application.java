import java.util.Scanner;

public class Application {
    private static String paper = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stillWriting = true;
        PencilSharpener sharpener = new PencilSharpener();

        System.out.println(
                "Welcome to Pencil Simulator\n" +
                        "Enter a value for your pencil's sharpness.\n"
        );
        int sharpness = scanner.nextInt();

        System.out.println(
                "Welcome to Pencil Simulator\n" +
                        "Enter a value for your pencil's eraser durability.\n"
        );
        int eraserDurability = scanner.nextInt();

        System.out.println(
                "Thank you.\n" +
                        "Enter a value for your pencil's length.\n"
        );
        int length = scanner.nextInt();
        Pencil pencil = new Pencil(sharpness, length, eraserDurability);

        while (stillWriting) {
            System.out.println(
                    "Pencil sharpness: " + pencil.getCurrentSharpness() + ".\n" +
                            "Pencil length: " + pencil.getLength() + ".\n" +
                            "The page says: \n\n" +
                            paper + "\n\n" +
                            "Press 1 to write something,\n" +
                            "Press 2 to erase something,\n" +
                            "Press 3 to insert a word,\n" +
                            "Press 4 to sharpen your pencil.\n" +
                            "Press 5 to exit."
            );

            int userSelection = scanner.nextInt();
            switch (userSelection) {
                case 1:
                    scanner = new Scanner(System.in);
                    System.out.println("Enter text to be written: ");
                    String textToWrite = scanner.nextLine();
                    paper = pencil.write(paper, textToWrite);
                    break;
                case 2:
                    scanner = new Scanner(System.in);
                    System.out.println("Which word would you like to erase?");
                    String textToErase = scanner.nextLine();
                    paper = pencil.erase(paper, textToErase);
                    break;
                case 3:
                    scanner = new Scanner(System.in);
                    System.out.println("Which word would you like to insert?");
                    String newWord = scanner.nextLine();
                    System.out.println("After which word would you like to insert?");
                    String wordToInsertAfter = scanner.nextLine();
                    paper = pencil.edit(paper, wordToInsertAfter, newWord);
                    break;
                case 4:
                    System.out.println("Attempting to sharpen pencil");
                    pencil = sharpener.sharpen(pencil);
                    break;
                case 5:
                    stillWriting = false;
                    break;
                default:
                    System.out.println(userSelection + " is not valid.");
                    break;
            }
        }
    }
}
