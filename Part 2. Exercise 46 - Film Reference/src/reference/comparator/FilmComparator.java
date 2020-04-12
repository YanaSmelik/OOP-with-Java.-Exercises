package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;


    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.ratings = ratings;
    }


    @Override
    public int compare(Film f1, Film f2) {
        int rating1 = 0;
        int rating2 = 0;
        for (Map.Entry<Film, List<Rating>>entry:ratings.entrySet()) {
            if(entry.getKey().equals(f1)){
                for (Rating thisRating: ratings.get(f1)) {
                    rating1 += thisRating.getValue();
                }
            }
            if (entry.getKey().equals(f2)) {
                for (Rating thisRating: ratings.get(f2)) {
                    rating2 += thisRating.getValue();
                }
            }
        }
        return rating2 - rating1;
    }
}
