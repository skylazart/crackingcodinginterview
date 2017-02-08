package design.exceptions;

/**
 * Created by fsantos on 12/20/16.
 */
public class VendingMachineIsFull extends Throwable {
    public VendingMachineIsFull(String s) {
        super(s);
    }
}
