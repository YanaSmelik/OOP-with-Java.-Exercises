package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private int numberOfDuplicates;
    private Set<String> characterStrings;

    public PersonalDuplicateRemover() {
        this.numberOfDuplicates = 0;
        this.characterStrings = new HashSet<String>();
    }


    // stores a characterString if it's not a duplicate
    public void add(String characterString) {
        if (characterStrings.contains(characterString)) {
            numberOfDuplicates++;
        } else {
            characterStrings.add(characterString);
        }

    }


    //returns the number of detected duplicates
    public int getNumberOfDetectedDuplicates() {
        return numberOfDuplicates;
    }


    //returns an object which implements the interface Set<String>. Object has all unique characterStrings.
    //if there are no unique characterStrings, method returns empty set.
    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniqueCharacterStrings = characterStrings;
        return uniqueCharacterStrings;
    }


    //removes stored characterStrings and resets the amount of detected duplicates
    @Override
    public void empty() {
        characterStrings.clear();
        numberOfDuplicates = 0;
    }
}
