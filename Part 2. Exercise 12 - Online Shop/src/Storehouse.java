import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> productsPrices;
    private Map<String, Integer> productStocks;

    public Storehouse() {
        this.productsPrices = new HashMap<String, Integer>();
        this.productStocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        productsPrices.put(product, price);
        productStocks.put(product, stock);
    }

    public int price(String product) {
        for (String key : productsPrices.keySet()) {
            if (key.equals(product)) {
                return productsPrices.get(key);
            }
        }
        return -99;
    }

    public int stock(String product) {
        for (String key : productStocks.keySet()) {
            if (key.equals(product)) {
                return productStocks.get(key);
            }
        }
        return 0;
    }

    public boolean take(String product) {
        if (stock(product) > 0) {
            productStocks.put(product, productStocks.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return productStocks.keySet();
    }


}
