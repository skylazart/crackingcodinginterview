package design.vendingmachine;

import design.exceptions.CreditDenied;
import design.exceptions.ProductNotFound;
import design.exceptions.VendingMachineIsFull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fsantos on 12/20/16.
 */
public class MyVendingMachine implements VendingMachine {
    private final int max;
    private int tot = 0;
    private Map<Product, Integer> products = new HashMap<>();

    public MyVendingMachine(int max) {
        this.max = max;
    }

    public Iterable<Product> listProducts() {
        // Returning a copy of the elements to keep internal data protected from external changes
        List<Product> productList = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            productList.add(entry.getKey());
        }

        return productList;
    }

    public int countFreeSlots() {
        return max - tot;
    }

    public void addProduct(Product p) throws VendingMachineIsFull {
        if (tot == max)
            throw new VendingMachineIsFull("Vending machine is full of products");

        Integer cnt = products.get(p);
        if (cnt != null) {
            products.put(p, cnt + 1);
        } else {
            products.put(p, 1);
        }

        tot++;
    }

    public void sell(Product desired) throws ProductNotFound, CreditDenied {
        Integer count = products.get(desired);
        if (count == null || count == 0)
            throw new ProductNotFound("Product not found");

        if (count == 0)
            throw new ProductNotFound("Product not found");

        Payment payment = PaymentFactory.makePayment("creditcard");

        payment.purchase(desired);

        products.put(desired, count - 1);
        tot--;
    }
}

