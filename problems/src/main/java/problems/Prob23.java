package problems;

import java.util.*;

/**
 * Created by fsantos on 12/2/16.
 */
public class Prob23 {
    public static boolean findRoute(Map<Integer, List<Integer>> directGraph, int s, int d) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> adj = directGraph.get(s);
        dfs(directGraph, adj, visited);
        return visited.contains(d);
    }

    private static void dfs(Map<Integer, List<Integer>> directGraph, List<Integer> adj, Set<Integer> visited) {
        if (adj == null) return;

        for (Integer d: adj) {
            if (visited.contains(d))
                continue;

            visited.add(d);
            dfs(directGraph, directGraph.get(d), visited);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> directGraph = new HashMap<>();

        directGraph.put(0, Arrays.asList(1, 2, 3));
        directGraph.put(1, Arrays.asList(4));
        directGraph.put(2, Arrays.asList(5));
        directGraph.put(3, Arrays.asList(7, 8, 9));
        directGraph.put(4, Arrays.asList());
        directGraph.put(5, Arrays.asList());
        directGraph.put(6, Arrays.asList(7));
        directGraph.put(7, Arrays.asList(9));

        System.out.println(findRoute(directGraph, 9, 1));
    }
}
