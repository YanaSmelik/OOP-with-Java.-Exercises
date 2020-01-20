import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> products;


    public ShoppingBasket() {
        this.products = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (products.containsKey(product)) {
            products.get(product).increaseAmount();
        }else{
            products.put(product, new Purchase(product, 1, price));
        }

    }

    public int price() {
        int initPrice = 0;
        for (String product : products.keySet()) {
            initPrice += products.get(product).price();
        }
        return initPrice;
    }

    public void print() {
        for (String product : products.keySet()) {
            System.out.println(products.get(product));
        }
    }
}
