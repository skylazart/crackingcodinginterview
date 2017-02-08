package design.reservation;

/**
 * Created by fsantos on 2/6/17.
 */
public class Customer implements Comparable<Customer> {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Customer o) {
        return id.compareTo(o.getId());
    }
}
