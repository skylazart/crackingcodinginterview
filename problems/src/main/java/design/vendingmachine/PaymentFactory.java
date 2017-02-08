package design.vendingmachine;

/**
 * Created by fsantos on 12/21/16.
 */
public class PaymentFactory {
    public static Payment makePayment(String op) {
        switch(op) {
            case "creditcard": return new CreditCardPayment();
            default: return new CreditCardPayment();
        }
    }
}
