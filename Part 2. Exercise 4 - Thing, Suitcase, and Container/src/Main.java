public class Main {
    public static void main(String[] args) {

    }


    public static void addSuitcasesFullOfBricks(Container container) {

        for (int i = 1; i <= 100; i++) {
            Suitcase suitcase = new Suitcase(1000);
            suitcase.addThing(new Thing("brick", i));
            container.addSuitcase(suitcase);
        }

    }
}
