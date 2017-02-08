package design.routers;

import problems.auxiliar.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsantos on 1/17/17.
 */
public class TestRouters {
    public static void main(String[] args) {
        List<Router> list = new ArrayList<>();
        list.add(new Dlink("00:01", "Dlink1"));
        list.add(new Netgear("00:02", "Netgear2"));

        for (Router r: list) {
            r.changeIP("10.0.0.2");
        }
    }
}
