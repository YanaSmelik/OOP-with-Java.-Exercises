import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WordInspection wordInspection = new WordInspection(new File("src/wordList.txt"));
        System.out.println(wordInspection.wordCount());
        System.out.println(wordInspection.worsContainingZ().toString());
        System.out.println(wordInspection.wordsEndlingInL().toString());
        System.out.println(wordInspection.palindrome().toString());
        System.out.println(wordInspection.wordsWhichContainAllVowels().toString());
    }
}
