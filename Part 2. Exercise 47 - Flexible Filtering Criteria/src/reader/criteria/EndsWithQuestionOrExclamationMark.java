package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {


    public EndsWithQuestionOrExclamationMark() {

    }


    @Override
    public boolean compiles(String line) {
        if (line.length() > 0) {
            if (line.charAt(line.length() - 1) == '!' || line.charAt(line.length() - 1) == '?') {
                return true;
            }
        }
        return false;
    }
}
