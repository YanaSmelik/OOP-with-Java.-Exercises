package reader.criteria;

//accepts all the lines whose length is equal or greater then the number received as constructor parameter
public class LengthAtLeast implements Criterion {

    private int providedLength;

    public LengthAtLeast(int providedLength) {
        this.providedLength = providedLength;
    }


    @Override
    public boolean compiles(String line) {
        if (line.length() >= providedLength) {
            return true;
        }
        return false;
    }
}
