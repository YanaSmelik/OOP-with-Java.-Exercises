import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements:");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quits the text user interface");
        System.out.println();

        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (command.equals("add")) {
                add();
                System.out.println();
            } else if (command.equals("translate")) {
                translate();
                System.out.println();
            } else {
                System.out.println("Unknown statement");
                System.out.println();
            }
        }
    }

    public void add() {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
    }

    public void translate() {
        System.out.print("Give a word: ");
        System.out.println("Translation: " + dictionary.translate(reader.nextLine()));
    }


}
