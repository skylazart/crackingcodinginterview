package design.routers;

/**
 * Created by fsantos on 1/17/17.
 */
public interface Job {
    void changeIP(String newIp);
    void start();
    void stop();
}
