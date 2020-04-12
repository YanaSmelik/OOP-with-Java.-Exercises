package reference.domain;

import java.util.*;

public class RatingRegister {

    private Map<Film, List<Rating>> filmsRatings;
    private Map<Person, Map<Film, Rating>> personalRatings;


    public RatingRegister() {
        filmsRatings = new HashMap<>();
        personalRatings = new HashMap<>();
    }


    //adds a new rating to the parameter film.
    // the same film can have various same ratings
    public void addRating(Film film, Rating rating) {
        if (filmsRatings.containsKey(film)) {
            filmsRatings.get(film).add(rating);
        } else {
            List<Rating> ratings = new ArrayList<>();
            ratings.add(rating);
            filmsRatings.put(film, ratings);
        }
    }


    //returns a list of the ratings which were added in connection to a film
    public List<Rating> getRatings(Film film) {
        for (Map.Entry<Film, List<Rating>> entry : filmsRatings.entrySet()) {
            if (entry.getKey().equals(film)) {
                return entry.getValue();
            }
        }
        return null;
    }


    //returns a map whose keys are the evaluated films.
    //each film is associated to a list containing the ratings for that film.
    public Map<Film, List<Rating>> filmRatings() {
        return filmsRatings;
    }


    //adds the rating of a specific film to the parameter person
    //the same person can recommend a specific film only once
    //the person rating has also to be added to the ratings connected to all the films
    public void addRating(Person person, Film film, Rating rating) {
        if (personalRatings.containsKey(person)) {
            if (personalRatings.get(person).containsKey(film)) {
                System.out.println("You already rated " + film + " movie.");
            } else {
                personalRatings.get(person).put(film, rating);
            }
        } else {
            Map<Film, Rating> individualRating = new HashMap<>();
            individualRating.put(film, rating);
            personalRatings.put(person, individualRating);
        }
        addRating(film, rating);
    }


    //returns the rating the parameter person has assigned to the parameter film.
    //if the person hasn't evaluated such film, the method returns Rating.NOT_WATCHED
    public Rating getRating(Person person, Film film) {
        for (Map.Entry<Person, Map<Film, Rating>> entry : personalRatings.entrySet()) {
            if (entry.getKey().equals(person)) {
                if (entry.getValue().containsKey(film)) {
                    return entry.getValue().get(film);
                }
            }
        }
        return Rating.NOT_WATCHED;
    }


    //returns a HashMap which contains the person's ratings.
    //The HashMap keys are the evaluated films, and their values are the ratings of these films
    public Map<Film, Rating> getPersonalRating(Person person) {
        for (Map.Entry<Person, Map<Film, Rating>> entry : personalRatings.entrySet()) {
            if (entry.getKey().equals(person)) {
                return entry.getValue();
            }
        }
        return null;
    }


    //returns a list of the people who have evaluated the films
    public List<Person> reviewers() {
        List reviewers = new ArrayList();
        for (Map.Entry<Person, Map<Film, Rating>> entry : personalRatings.entrySet()) {
            reviewers.add(entry.getKey());
        }
        return reviewers;
    }
}
