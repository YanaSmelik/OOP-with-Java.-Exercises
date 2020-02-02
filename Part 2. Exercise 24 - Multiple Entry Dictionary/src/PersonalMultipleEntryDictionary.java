import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> words;

    public PersonalMultipleEntryDictionary() {
        this.words = new HashMap<String, Set<String>>();
    }


    //check if a word is in the dictionary
    public boolean isInDictionary(String word) {
        if (this.words.containsKey(word)) {
            return true;
        }
        return false;
    }

    //adds a new entry to a word, maintaining the old ones
    public void add(String word, String entry) {
        if (!isInDictionary(word)) {
            this.words.put(word, new HashSet<String>());
        }
        this.words.get(word).add(entry);
    }


    //returns a Set object, with all entries of the word, or a null reference, if the word is not in the dictionary
    public Set<String> translate(String word) {
        if (isInDictionary(word)) {
            Set<String> translatedWords = this.words.get(word);
            return translatedWords;
        } else {
            return null;
        }
    }


    //removes a word and all its entries from the dictionary
    public void remove(String word) {
        if (isInDictionary(word)) {
            this.words.remove(word);
        }
    }


}
