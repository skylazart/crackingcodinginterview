package design.routers;

/**
 * Created by fsantos on 1/17/17.
 */
public class Dlink extends Router {
    public Dlink(String macAddress, String name) {
        super(macAddress, name, RouterType.DLINK);
    }

    @Override
    public void changeIP(String newIp) {
        System.out.println("Custom DLINK way to change IP");
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
