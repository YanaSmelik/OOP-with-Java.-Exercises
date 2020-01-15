import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> wordList;


    public Dictionary() {
        this.wordList = new HashMap<String, String>();
    }

    public String translate(String word) {
        if (wordList.containsKey(word)) {
            return wordList.get(word);
        }
        return null;
    }

    public void add(String word, String translation) {
        wordList.put(word, translation);
    }

    public int amountOfWords() {
        return wordList.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translated = new ArrayList<String>();
        for (String key : wordList.keySet()) {
            translated.add(key + " = " + wordList.get(key));
        }
        return translated;
    }


}
