package problems;

import java.util.*;

/**
 * Created by fsantos on 2/14/17.
 */
public class Prob163 {
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
    }

    public static class PathTo {
        private Set<String> visited = new HashSet<>();

        public PathTo(DirectGraph g, String s) {
            dfs(g, s);
        }

        public boolean hasPathTo(String d) {
            return visited.contains(d);
        }

        private void dfs(DirectGraph g, String s) {
            if (visited.contains(s)) return;
            visited.add(s);

            List<String> adj = g.getAdj(s);
            for (String v: adj)
                dfs(g, v);
        }
    }

    public static void main(String[] args) {
        DirectGraph g = new DirectGraph();
        g.connect("felipe", "larissa");
        g.connect("felipe", "larissaxx");
        g.connect("larissaxx", "larissayy");
        g.connect("larissayy", "gael");
        g.connect("larissayy", "vvv");
        g.connect("larissa", "breno");
        g.connect("larissa", "gael");

        PathTo path = new PathTo(g, "felipe");

        System.out.println(path.hasPathTo("gael"));
        System.out.println(path.hasPathTo("larissa"));
        System.out.println(path.hasPathTo("vvv"));
        System.out.println(path.hasPathTo("yyy"));
    }
}
