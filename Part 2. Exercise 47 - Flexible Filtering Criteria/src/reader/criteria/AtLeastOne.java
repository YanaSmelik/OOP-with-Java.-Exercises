package reader.criteria;

import java.util.ArrayList;
import java.util.List;

//The objects of this class receive as parameter an optional amount of objects with implement the interface Criterion
//the constructor receives a list of variable length as parameter
//AtLeastOne objects accept the lines which comply with at least one of the criteria received as constructor parameter.
public class AtLeastOne implements Criterion {

    private List<Criterion> listOfCriteria;

    public AtLeastOne(Criterion... criterias) {
        listOfCriteria = new ArrayList<>();
        for (Criterion criterion : criterias) {
            listOfCriteria.add(criterion);
        }

    }

    @Override
    public boolean compiles(String line) {
        for (Criterion criteria : listOfCriteria) {
            if (criteria.compiles(line)) {
                return true;
            }
        }
        return false;
    }
}
