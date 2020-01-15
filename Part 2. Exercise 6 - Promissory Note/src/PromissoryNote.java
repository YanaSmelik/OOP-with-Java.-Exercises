import java.util.HashMap;

public class PromissoryNote {

    private HashMap<String, Double> loan;

    public PromissoryNote() {
        this.loan = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        this.loan.put(toWhom, value);

    }

    public double howMuchIsTheDebt(String whose) {
        if (this.loan.containsKey(whose)) {
            return loan.get(whose);
        }
        return 0;
    }


}
