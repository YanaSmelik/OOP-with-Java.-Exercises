package reader.criteria;

public class AllLines implements Criterion {


    public AllLines() {
    }

    @Override
    public boolean compiles(String line) {
        return true;
    }
}
