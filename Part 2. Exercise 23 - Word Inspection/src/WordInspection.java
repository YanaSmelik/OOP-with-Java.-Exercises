import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordInspection {

    private File file;
    private ArrayList<String> words;

    public WordInspection(File file) throws IOException {
        this.file = file;
        words = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String word;
        while ((word = reader.readLine()) != null) {
            words.add(word);
        }
        reader.close();
    }


    public int wordCount() {
        return words.size();
    }

    public List<String> worsContainingZ() {
        ArrayList<String> wordsWithZ = new ArrayList<String>();
        for (String word : words) {
            if (word.contains("z")) {
                wordsWithZ.add(word);
            }
        }
        return wordsWithZ;
    }

    public List<String> wordsEndlingInL() {
        ArrayList<String> wordsThatEndInL = new ArrayList<String>();
        for (String word : words) {
            if ((word.charAt(word.length() - 1) == 'l')) {
                wordsThatEndInL.add(word);
            }
        }
        return wordsThatEndInL;
    }

    public List<String> palindrome() {
        ArrayList<String> palindromeWord = new ArrayList<String>();
        for (String word : words) {
            String reverse = "";
            for (int i = (word.length() - 1); i > -1; i--) {
                reverse += word.charAt(i);
            }
            if (word.equals(reverse)) {
                palindromeWord.add(word);
            }
        }
        return palindromeWord;
    }

    public List<String> wordsWhichContainAllVowels() {
        ArrayList<String> wordsWithAllVowels = new ArrayList<String>();
        for (String word : words) {
            if (word.contains("a") && word.contains("e") && word.contains("i")
                    && word.contains("o") && word.contains("u") && word.contains("y")) {
                wordsWithAllVowels.add(word);
            }
        }
        return wordsWithAllVowels;
    }
}
