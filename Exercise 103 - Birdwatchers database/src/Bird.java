public class Bird {
    private String name;
    private String latinName;
    private int counter;


    public Bird (String name, String latinName){
        this.name = name;
        this.latinName = latinName;
        this.counter = 0;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    @Override
    public String toString() {
        return name + " (" + latinName + "): " + counter + " observations";
    }
}
