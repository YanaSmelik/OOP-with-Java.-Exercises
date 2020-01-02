public class HangmanLogic {
    private String word;
    private String guessesdLetters;
    private int numberOfFaults;

    public HangmanLogic(String word) {
        this.word = word.toUpperCase();
        this.guessesdLetters = "";
        this.numberOfFaults = 0;
    }

    public int getNumberOfFaults() {
        return this.numberOfFaults;
    }

    public String getGuessesdLetters() {
        return this.guessesdLetters;
    }

    public int losingFaultAmount() {
        return 12;
    }

    public void guessesdLetters(String letter) {
        if (!guessesdLetters.contains(letter)) {
            if (!word.contains(letter)) {
                numberOfFaults++;
            }
            guessesdLetters += letter;
        }
    }

    public String hiddenWord() {
        String hiddenWord = "";
        for (int i = 0; i < this.word.length(); i++) {
            char thisLetter = this.word.charAt(i);
            String newWord = "" + thisLetter;
            if (guessesdLetters.contains(newWord)) {
                hiddenWord += newWord;
            } else {
                hiddenWord += "_";
            }
        }
        return hiddenWord;
    }
}

