package reader.criteria;

public class ContainsWord implements Criterion {

    String word;

    public ContainsWord(String word) {
        this.word = word;
    }


    @Override
    public boolean compiles(String line) {
        return line.contains(word);
    }
}
