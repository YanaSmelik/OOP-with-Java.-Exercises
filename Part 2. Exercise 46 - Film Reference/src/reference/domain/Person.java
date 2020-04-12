package reference.domain;

public class Person {

    private String name;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Person person = (Person) obj;
        return name.equals(person.getName());
    }
}
