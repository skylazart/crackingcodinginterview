package problems;

import java.util.*;

/**
 * Created by fsantos on 2/14/17.
 */
public class Prob164 {
    public static class DirectGraph {
        private Map<String, List<String>> adjList = new HashMap<>();

        public DirectGraph() {

        }

        public void connect(String s, String d) {
            addVertex(d);
            List<String> adj = addVertex(s);
            adj.add(d);
        }

        private List<String> addVertex(String v) {
            List<String> adj = adjList.get(v);
            if (adj == null) {
                adj = new ArrayList<>();
                adjList.put(v, adj);
            }
            return adj;
        }

        public List<String> getAdj(String v) {
            List<String> adj = adjList.get(v);
            if (adj == null) return null;

            // Returning a copy
            List<String> t = new ArrayList<>(adj);
            return t;
        }

        public List<String> getVertex() {
            List<String> vertexList = new ArrayList<>();
            for (String s: adjList.keySet())
                vertexList.add(s);

            return vertexList;
        }
    }

    public static class TopologicalSortOrder {
        private Stack<String> inversePostOrder = new Stack<>();

        private Set<String> visited = new HashSet<>();

        public TopologicalSortOrder(DirectGraph G) {
            List<String> vertexList = G.getVertex();
            for (String v: vertexList) {
                if (!visited.contains(v))
                    dfs(G, v);
            }
        }

        private void dfs(DirectGraph G, String v) {
            if (visited.contains(v)) return;
            visited.add(v);
            for (String w: G.getAdj(v))
                dfs(G, w);

            inversePostOrder.push(v);
        }

        public List<String> getTopologicalSortOrder() {
            List<String> l = new ArrayList<>();
            while (!inversePostOrder.isEmpty())
                l.add(inversePostOrder.pop());

            return l;
        }
    }

    public static void main(String[] args) {
        DirectGraph directGraph = new DirectGraph();
        directGraph.connect("0", "1");
        directGraph.connect("0", "5");
        directGraph.connect("0", "6");
        directGraph.connect("2", "0");
        directGraph.connect("2", "3");
        directGraph.connect("3", "5");
        directGraph.connect("5", "4");
        directGraph.connect("6", "4");
        directGraph.connect("6", "9");
        directGraph.connect("7", "6");
        directGraph.connect("8", "7");
        directGraph.connect("9", "10");
        directGraph.connect("9", "11");
        directGraph.connect("9", "12");
        directGraph.connect("11", "12");

        TopologicalSortOrder topologicalSortOrder = new TopologicalSortOrder(directGraph);
        List<String> list = topologicalSortOrder.getTopologicalSortOrder();
        for (String s: list)
            System.out.println(s);


    }
}
