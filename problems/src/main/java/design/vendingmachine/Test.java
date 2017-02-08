package design.vendingmachine;

import design.exceptions.CreditDenied;
import design.exceptions.ProductNotFound;
import design.exceptions.VendingMachineIsFull;

import java.util.List;

/**
 * Created by fsantos on 12/21/16.
 */
public class Test {
    public static void main(String[] args) {
        new Test().run();
    }

    private void run() {
        VendingMachine vendingMachine = new MyVendingMachine(10);
        System.out.println(vendingMachine.countFreeSlots());


        try {
            Product coke = new Product("12345", "Coke", "Diet coke", 2.20);
            vendingMachine.addProduct(coke);
            System.out.println(vendingMachine.countFreeSlots());

            for (Product p: vendingMachine.listProducts()) {
                System.out.println(p.getName());
            }

            vendingMachine.sell(coke);
            System.out.println(vendingMachine.countFreeSlots());

        } catch (VendingMachineIsFull|CreditDenied|ProductNotFound e) {
            e.printStackTrace();
        }
    }
}
