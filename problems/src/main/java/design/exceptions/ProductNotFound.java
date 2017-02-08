package design.exceptions;

/**
 * Created by fsantos on 12/21/16.
 */
public class ProductNotFound extends Throwable {
    public ProductNotFound(String s) {
        super(s);
    }
}
