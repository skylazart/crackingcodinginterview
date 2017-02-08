package design.routers;

/**
 * Created by fsantos on 1/17/17.
 */
public abstract class Router implements Comparable<Router>, Job {
    @Override
    public int compareTo(Router o) {
        return macAddress.compareTo(o.getMacAddress());
    }

    public enum RouterType {DLINK, NETGEAR};

    private final String macAddress;
    private final String name;
    private final RouterType routerType;

    public Router(String macAddress, String name, RouterType routerType) {
        this.macAddress = macAddress;
        this.name = name;
        this.routerType = routerType;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getName() {
        return name;
    }

    public RouterType getRouterType() {
        return routerType;
    }
}
