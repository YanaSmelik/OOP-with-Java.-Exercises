package containers;

public class ProductContainer extends Container {

    private String productName;

    public ProductContainer(String productName, double originalCapacity) {
        super(originalCapacity);
        this.productName = productName;

    }

    public String getName() {
        return productName;
    }

    @Override
    public String toString() {
        return productName + ": " + super.toString(); //add product name to the parent class method
    }

}
