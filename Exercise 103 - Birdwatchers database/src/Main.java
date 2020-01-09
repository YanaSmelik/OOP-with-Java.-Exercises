import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BirdsDataBase birdsDataBase = new BirdsDataBase();

        System.out.print("List of available commands: \n" +
                "Add - adds a bird\n" +
                "Observation - adds an observation\n" +
                "Statistics - prints all the birds\n" +
                "Show - prints one bird\n" +
                "Quit - terminates the program\n");

        askForInput();

        while (true) {
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("add")) {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Latin name: ");
                String latinName = scanner.nextLine();

                birdsDataBase.add(new Bird(name, latinName));
                askForInput();
            } else if (command.equals("observation")) {
                System.out.print("What was observed: ");
                String name = scanner.nextLine();
                if (birdsDataBase.containsBird(name) == null) {
                    System.out.println("Is not a bird!");
                } else {
                    birdsDataBase.observation(birdsDataBase.containsBird(name));
                }
                askForInput();
            } else if (command.equals("statistics")) {
                birdsDataBase.statistics();
                askForInput();
            } else if (command.equals("show")) {
                System.out.print("What? ");
                birdsDataBase.show(scanner.nextLine());
                askForInput();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Unknown command!");
                askForInput();
            }
        }

    }


    public static void askForInput() {
        System.out.print("Type your command: ");
    }

}
