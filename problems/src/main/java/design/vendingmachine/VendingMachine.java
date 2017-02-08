package design.vendingmachine;

import design.exceptions.CreditDenied;
import design.exceptions.ProductNotFound;
import design.exceptions.VendingMachineIsFull;

/**
 * Created by fsantos on 12/21/16.
 */
public interface VendingMachine {
    Iterable<Product> listProducts();
    int countFreeSlots();
    void addProduct(Product p) throws VendingMachineIsFull;
    void sell(Product desired) throws ProductNotFound, CreditDenied;
}
