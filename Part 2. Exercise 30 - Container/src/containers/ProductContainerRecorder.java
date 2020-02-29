package containers;

public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory serviceForContainerHistory;

    public ProductContainerRecorder(String productName, double originalCapacity, double initialVolume) {
        super(productName, originalCapacity);
        serviceForContainerHistory = new ContainerHistory();

        setProductVolume(initialVolume);   //The initial volume is both the stored product original volume
        serviceForContainerHistory.add(initialVolume);  //and the first value of the container history
    }


    //returns the container history in the form [0.0, 119.2, 25.5]
    public String history() {
        return serviceForContainerHistory.toString();
    }


    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        serviceForContainerHistory.add(getProductVolume());   //new product volume record is added to the container history
    }


    @Override
    public double takeFromTheContainer(double amount) {
        double productVolumeAfterOperation = super.takeFromTheContainer(amount);
        serviceForContainerHistory.add(productVolumeAfterOperation); //record (add to ArrayList) the product volume in the container after the operation
        return productVolumeAfterOperation;
    }


    public void reset() {
        serviceForContainerHistory.reset();
    }

    //prints the product history
    public void printAnalysis() {
        System.out.println("Product: " + getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + serviceForContainerHistory.maxValue());
        System.out.println("Smallest product amount: " + serviceForContainerHistory.minValue());
        System.out.println("Average: " + serviceForContainerHistory.average());
        System.out.println("Greatest change: " + serviceForContainerHistory.greatestChange());
        System.out.println("Variance: " + serviceForContainerHistory.variance());
    }
}
