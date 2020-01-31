import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Analysis analysis = new Analysis(new File("src/analysis.txt"));
        System.out.println(analysis.lines());
        System.out.println(analysis.characters());
    }
}
