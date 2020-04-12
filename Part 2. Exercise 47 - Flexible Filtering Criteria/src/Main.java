import reader.criteria.*;

public class Main {

    //program filters the lines of the books found on the Project Gutenberg pages.
    //In the following example Dostoevsky's Crime and Punishment is analyzed.
    public static void main(String[] args) {

        //Example of a program:

        String address = "https://www.gutenberg.org/files/2554/2554-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new AtLeastOne(
                new ContainsWord("beer"),
                new ContainsWord("milk"),
                new ContainsWord("bread")
        );

        Criterion rightLength = new Both(new LengthAtLeast(10), new Not(new LengthAtLeast(31)));

        Criterion wanted = new Both(criterion, rightLength);

        for (String line : book.linesWhichComplyWith(wanted)) {
            System.out.println(line);
        }

    }
}
