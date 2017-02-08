package design.pattern;

/**
 * Created by fsantos on 1/6/17.
 */
public class UseSingleton {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.getX() + ", " + s.getY());
    }
}
