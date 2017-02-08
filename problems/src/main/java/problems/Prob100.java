package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob100 {
    public static class Graph {
        private Map<Integer, List<Integer>> adjList = new HashMap<>();

        public Graph() {

        }

        public void addNode(int v) {
            adjList.put(v, new ArrayList<>());
        }

        public void connect(int s, int d) {
            List<Integer> list = adjList.get(s);
            list.add(d);
        }

        public List<Integer> getAdj(int s) {
            List<Integer> list = adjList.get(s);
            if (list == null) return null;

            List<Integer> copy = new ArrayList<>(list);
            return copy;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        for (int v = 1; v <= 5; v++)
            g.addNode(v);

        g.connect(1, 2);
        g.connect(1, 3);
        g.connect(1, 4);

        g.connect(2, 3);
        g.connect(3, 2);

        g.connect(4, 5);

        List<Integer> adj = g.getAdj(1);
        for (Integer x: adj) {
            System.out.println(x);
        }
    }
}
