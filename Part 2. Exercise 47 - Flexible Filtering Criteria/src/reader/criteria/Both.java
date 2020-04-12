package reader.criteria;

//objects of this class receive two objects as constructor parameter
//both implementing the interface Criterion
//Both objects accept the lines which comply with both the criteria received as constructor parameters.
public class Both implements Criterion {

    private Criterion criterion1;
    private Criterion criterion2;

    public Both(Criterion criterion1, Criterion criterion2) {
        this.criterion1 = criterion1;
        this.criterion2 = criterion2;
    }

    @Override
    public boolean compiles(String line) {
        if (criterion1.compiles(line) && criterion2.compiles(line)) {
            return true;
        }
        return false;
    }
}
