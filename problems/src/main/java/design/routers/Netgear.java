package design.routers;

/**
 * Created by fsantos on 1/17/17.
 */
public class Netgear extends Router {
    public Netgear(String macAddress, String name) {
        super(macAddress, name, RouterType.NETGEAR);
    }

    @Override
    public void changeIP(String newIp) {
        System.out.println("Custom Netgear way to change IP");
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
