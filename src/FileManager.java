import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileManager {


    /*
    Method returns the lines of the parameter file in ArrayList form,
    each file line being a String contained by the ArrayList.
     */
    public ArrayList<String> read(String file) throws IOException {
        ArrayList<String> fileContent = new ArrayList<String>();
        try {
            fileContent = (ArrayList<String>) Files.readAllLines(Paths.get(file));
        } catch (IIOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }


    /*
    The method writes the string of the second argument into the file of the first argument.
    If the file already exists, the string is written over the old version.
     */
    public void save(String file, String text) throws IOException {
        Path path = Paths.get(file);
        Files.write(path, text.getBytes());
    }


    /*
    The method writes the strings of the second argument into the file of the first argument;
    each string of the array list goes to its own line.
    If the file already exists, the strings are written over the old version.
     */
    public void save(String file, ArrayList<String> texts) throws IOException {
        for (String line : texts) {
            String textWithNewLine = line + System.lineSeparator();
            if (texts.get(0).equals(line)) {
                Files.write(Paths.get(file), textWithNewLine.getBytes());
            } else {
                Files.write(Paths.get(file), textWithNewLine.getBytes(), StandardOpenOption.APPEND);
            }
        }
    }

}
