import java.util.Scanner;

public class Application {
    private static String paper = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stillWriting = true;

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
                            "Press 3 to exit."
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
                    System.out.println("What word would you like to erase?");
                    String textToErase = scanner.nextLine();
                    paper = pencil.erase(paper, textToErase);
                    break;
                case 3:
                    stillWriting = false;
                    break;
                default:
                    System.out.println(userSelection + " is not valid.");
                    break;
            }
        }
    }
}
