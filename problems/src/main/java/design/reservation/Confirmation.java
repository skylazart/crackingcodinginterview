package design.reservation;

import java.util.Date;

/**
 * Created by fsantos on 2/6/17.
 */
public class Confirmation implements Comparable<Confirmation> {
    private final String uuid;
    private final Customer customer;
    private final Date date;
    private final int totalOfCustomers;

    public Confirmation(String uuid, Customer customer, Date date, int totalOfCustomers) {
        this.uuid = uuid;
        this.customer = customer;
        this.date = date;
        this.totalOfCustomers = totalOfCustomers;
    }

    @Override
    public int compareTo(Confirmation o) {
        int cmp = uuid.compareTo(o.uuid);
        if (cmp != 0) return cmp;
        return customer.compareTo(o.customer);
    }

    public String getUuid() {
        return uuid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public int getTotalOfCustomers() {
        return totalOfCustomers;
    }
}
