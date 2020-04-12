package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
import reference.domain.RatingRegister;

import java.util.*;

public class Reference {

    private RatingRegister register;


    //reference uses the ratings in the raging register to elaborate a recommendation
    public Reference(RatingRegister register) {
        this.register = register;
    }


    //the method should return null in two cases:
    // 1. if it cannot find any film to recommend
    // 2. if it finds, e.g. person1 whose film taste is appropriate to recommend films to e.g. person2, but
    //    person1 has rated BAD, MEDIOCRE, or NEUTRAL, all the films person2 hasn't watched yet
    //    also, if the person hasn't added any rating.
    // Method doesn't suggest films that already been watched
    public Film recommendFilm(Person person) {
        ArrayList<Film> films = new ArrayList<>();
        for (Map.Entry<Film, List<Rating>> entry : register.filmRatings().entrySet()) {
            films.add(entry.getKey());
        }
        if (register.getPersonalRating(person) != null) {
            return mostRatedFilmOfSimilarPerson(person, getSimilarPerson(person, films));
        } else {
            Collections.sort(films, new FilmComparator(register.filmRatings()));
            return films.get(0);
        }
    }

    //return person with the similar taste
    private Person getSimilarPerson(Person person, ArrayList<Film> films) {
        int similarityRating;
        int maxSimilarityRating = 0;
        Person similarPerson = new Person();
        for (Person person2 : register.reviewers()) {
           similarityRating = 0;
            if (!person.equals(person2)) { // check that list of reviewers excludes the person
                for (Film flm : films) {   //iterate thorough all movies, that were rated
                    //calculate the similarity rating for each person (sum of products of ratings for every movie)
                    similarityRating += register.getRating(person, flm).getValue() * register.getRating(person2, flm).getValue();
                }
            }
            //find person with the biggest similarityRating and return it.
            if (similarityRating > maxSimilarityRating) {
                maxSimilarityRating = similarityRating;
                similarPerson = person2;
            }
        }
        return similarPerson;
    }

    //select the most rated movie of similarPerson
    private Film mostRatedFilmOfSimilarPerson(Person person, Person similarPerson) {
        Film mostRated = new Film();
        int maxFilmRating = 0;
        for (Map.Entry<Film, Rating> entry : register.getPersonalRating(similarPerson).entrySet()) {
            if (entry.getValue().getValue() >= maxFilmRating  //movie has the biggest rating among already checked
                    && entry.getValue().getValue() > 2        // movie was rated either GOOD or FINE
                    && !register.getPersonalRating(person).containsKey(entry.getKey())) {  //Person haven't watched it yet
                mostRated = entry.getKey();
                maxFilmRating = entry.getValue().getValue();
            }
        }
        if (maxFilmRating < 3) { //no movie with mentioned criteria was found
            return null;
        } else {
            return mostRated;
        }
    }
}
