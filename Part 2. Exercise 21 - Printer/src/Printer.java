import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Printer {

    private String fileName;

    public Printer(String fileName) throws Exception{
        this.fileName = fileName;
    }

    public void printLinesWhichContain(String word) throws FileNotFoundException {
        Scanner reader = new Scanner (new File (fileName));
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            if(line.contains(word)){
                System.out.println(line);
            }
        }
        reader.close();
    }
}
