package design.vendingmachine;

/**
 * Created by fsantos on 12/20/16.
 */
public class Product implements Comparable<Product> {
    private final String productId;
    private final String name;
    private final String description;
    private final double price;

    public Product(String productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public int compareTo(Product o) {
        return productId.compareTo(o.getProductId());
    }
}
