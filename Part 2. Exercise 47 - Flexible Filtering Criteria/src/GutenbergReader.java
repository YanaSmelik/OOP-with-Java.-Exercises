import reader.criteria.Criterion;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GutenbergReader {

    private List<String> lines;

    public GutenbergReader(String address) throws IllegalArgumentException {
        //the code which retrieves the book from the Internet
        lines = new ArrayList<String>();
        try {
            URL url = new URL(address);
            Scanner reader = new Scanner(url.openStream());
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<String> linesWhichComplyWith(Criterion c) {
        List<String> complyingLines = new ArrayList<>();

        for (String line : lines) {
            if (c.compiles(line)) {
                complyingLines.add(line);
            }
        }
        return complyingLines;
    }


}
