package reference.domain;

public class Film {

    private String name;

    public Film() {

    }

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }


    //equivalence is checked according to the object variable name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Film film = (Film) obj;
        return name.equals(film.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
