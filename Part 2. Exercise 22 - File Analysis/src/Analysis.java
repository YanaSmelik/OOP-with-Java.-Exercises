import java.io.*;

public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;

        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }


    public int characters() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int characters = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            characters += line.length() + 1;
        }
        return characters;
    }

}
