package design.vendingmachine;

import design.exceptions.CreditDenied;

/**
 * Created by fsantos on 12/21/16.
 */
public interface Payment {
    void purchase(Product p) throws CreditDenied;
}
