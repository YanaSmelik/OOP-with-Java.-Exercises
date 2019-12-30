public class Main {
    public static void main(String[] args) {
        LyyraCard pekkaCard = new LyyraCard(20);
        LyyraCard brianCard = new LyyraCard(30);

        pekkaCard.payGourment();
        brianCard.payEconomical();

        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Brian: " + brianCard);

        pekkaCard.loadMoney(20);
        brianCard.payGourment();

        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Brian: " + brianCard);

        pekkaCard.payEconomical();
        pekkaCard.payEconomical();
        brianCard.loadMoney(50);

        System.out.println("Pekka: " + pekkaCard);
        System.out.println("Brian: " + brianCard);

    }
}
