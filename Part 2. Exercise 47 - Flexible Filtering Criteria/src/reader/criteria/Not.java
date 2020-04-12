package reader.criteria;

//accepts lines, which don't compile with the criterion received as parameter
public class Not implements Criterion {

    private Criterion criterion;

    public Not(Criterion criterion) {
        this.criterion = criterion;
    }


    @Override
    public boolean compiles(String line) {
        if (criterion.compiles(line)) {
            return false;
        }
        return true;
    }
}
