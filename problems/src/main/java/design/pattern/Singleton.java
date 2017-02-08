package design.pattern;

/**
 * Created by fsantos on 1/6/17.
 */
public class Singleton {
    private static final Singleton instance = new Singleton();

    private int x = 0;
    private int y = 10;

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

    public int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }
}
