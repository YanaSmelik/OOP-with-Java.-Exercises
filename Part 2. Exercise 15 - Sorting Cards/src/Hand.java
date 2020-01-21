import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cardsSet;

    public Hand() {
        this.cardsSet = new ArrayList<Card>();
    }

    public void add(Card card) {
        cardsSet.add(card);
    }

    public void print() {
        for (Card card : cardsSet) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cardsSet);
    }

    public int cardsValueSum() {
        int sum = 0;
        for (Card card : cardsSet) {
            sum += card.getValue();
        }
        return sum;
    }

    @Override
    public int compareTo(Hand hand) {
        return this.cardsValueSum() - hand.cardsValueSum();
    }

    public void sortAgainstSuit() {
        Collections.sort(this.cardsSet, new SortAgainstSuitAndValue());
    }
}
