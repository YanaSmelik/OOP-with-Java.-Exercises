package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MindfulDictionary {

    HashMap<String, String> dictionary;
    private String file;

    public MindfulDictionary() {
        dictionary = new HashMap<>();
    }


    public MindfulDictionary(String file) {
        this.file = file;
        dictionary = new HashMap<>();
    }


    //add a word to the dictionary. Each word has only one translation;
    //if the same word is added twice, nothing happens.
    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
        }
    }


    //returns the word translation
    //if the word isn't recognized, it returns null.
    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }

        for (String entry : dictionary.keySet()) {
            if (dictionary.get(entry).equals(word)) {
                return entry;
            }
        }
        return null;
    }


    //removes the given word and its translation from the dictionary
    public void remove(String word) {
        Iterator<String> iterator = dictionary.keySet().iterator();
        while (iterator.hasNext()) {
            String wrd = iterator.next();
            if (wrd.equals(word) || dictionary.get(wrd).equals(word)) { //check for key-word and value-word
                iterator.remove();
            }
        }
    }


    //loads a file whose name is given as parameter in the dictionary constructor.
    //Each line of the dictionary file contains a word and its translation, divided by the character ":"
    public boolean load() {
        try {
            Files.lines(Paths.get(file));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(":");  // the line is split at :
                add(parts[0], parts[1]);
                line = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }


    //dictionary contents are written into the file whose name was given as parameter to the constructor
    //the method returns false if the file can't be saved;
    public boolean save() {
        try {
            List words = new ArrayList<>();
            for (String key : dictionary.keySet()) {
                String line = key + ":" + dictionary.get(key);
                words.add(line);
            }
            Files.write(Paths.get(file), words);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
