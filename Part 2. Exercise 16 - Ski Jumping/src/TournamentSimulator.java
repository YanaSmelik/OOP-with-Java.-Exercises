import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TournamentSimulator {

    private Scanner reader;
    private ArrayList<Jumper> participants;


    public TournamentSimulator() {
        this.reader = new Scanner(System.in);
        this.participants = new ArrayList<Jumper>();
    }


    public void start() {
        printProgramIntro();
        askParticipantName();
        jumpingSection();
    }


    public void printProgramIntro() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time; " +
                "an empty string brings you to the jumping phase.");
    }


    public void askParticipantName() {
        while (true) {
            System.out.print("Participant name: ");
            String name = reader.nextLine();
            if (!name.equals("")) {
                participants.add(new Jumper(name));
            } else {
                System.out.println();
                break;
            }
        }
    }


    public void jumpingSection() {
        System.out.println("The tournament begins!");
        System.out.println();
        doRound();
    }


    public void doRound() {
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if (command.equals("jump")) {
                doJumpRound();
            } else {
                printResults();
                break;
            }
        }
    }


    public void doJumpRound() {
        int count = 1;
        System.out.println();
        System.out.println("Round " + count);
        jumpingProcess();
        System.out.println("Results of round " + count);
        printRoundResults();
        System.out.println();
        count++;
    }


    public void jumpingProcess() {
        System.out.println();
        System.out.println("Jumping order: ");
        printParticipants();
        doOneJumpEach();
        System.out.println();
    }


    public void printParticipants() {
        Collections.sort(participants);
        int count = 1;
        for (Jumper jumper : participants) {
            System.out.println(" " + count + ". " + jumper);
            count++;
        }
    }


    public void doOneJumpEach() {
        Collections.sort(participants);
        for (Jumper jumper : participants) {
            jumper.makeJump();
            jumper.addJumpLenght();
        }
    }


    public void printRoundResults() {

        for (Jumper jumper : participants) {
            ArrayList<Integer> judgesPoints = jumper.judgesPointsList();
            System.out.println(" " + jumper.getName() + "\n"
                    + "  length: " + jumper.getJumpLenght() + "\n"
                    + "  judge votes: " + judgesPoints.toString());
            jumper.totalJudgesPoints(judgesPoints);
            jumper.totalPointsForJump();
        }
    }


    public void printResults() {
        printResultsHead();
        printResultsList();
    }


    private void printResultsHead() {
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results:\n" +
                "Position    Name");
    }


    private void printResultsList() {
        Collections.sort(participants, Collections.reverseOrder());
        int counter = 1;
        for (Jumper jumper : participants) {
            System.out.println(counter + "           " + jumper);
            jumper.printJumpLengths();
            System.out.println();
            counter++;
        }
    }


}



