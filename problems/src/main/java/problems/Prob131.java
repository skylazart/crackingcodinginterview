package problems;

import problems.auxiliar.LinkedListNode;

import java.util.*;

/**
 * Created by fsantos on 2/6/17.
 */
public class Prob131 {
    public static class ConnectStrings {
        private Map<Character, List<String>> firstCharMapToVertex = new HashMap<>();
        private Map<Character, List<String>> lastCharMapToVertex = new HashMap<>();

        private Map<String, List<String>> adjList = new HashMap<>();

        public ConnectStrings() {

        }

        public void add(String v) {
            Character lastChar = v.charAt(v.length() - 1);
            Character firstChar = v.charAt(0);
            List<String> vertex = null;

            adjList.put(v, new ArrayList<>());

            vertex = firstCharMapToVertex.get(lastChar);
            if (vertex != null) {
                for (String d: vertex) {
                    connect(v, d);
                    connect(d, v);
                }
            }

            vertex = lastCharMapToVertex.get(firstChar);
            if (vertex != null) {
                for (String d: vertex) {
                    connect(v, d);
                    connect(d, v);
                }
            }

            addInMap(lastChar, v, lastCharMapToVertex);
            addInMap(firstChar, v, firstCharMapToVertex);
        }

        private void addInMap(Character chr, String v, Map<Character, List<String>> mapToVertex) {
            List<String> list = mapToVertex.get(chr);
            if (list == null) {
                list = new ArrayList<>();
                list.add(v);
                mapToVertex.put(chr, list);
            } else {
                list.add(v);
            }
        }

        private void connect(String v, String d) {
            //System.out.println("Connecting " + v + " with " + d);
            List<String> adj = adjList.get(v);
            if (adj == null) {
                adj = new ArrayList<>();
                adj.add(d);
                adjList.put(v, adj);
            } else {
                adj.add(d);
            }
        }

        public boolean checkChainedInCircle() {
            Set<String> keys = adjList.keySet();
            for (String k: keys) {
                if (!check(k)) return false;
            }
            return true;
        }

        private boolean check(String s) {
            Set<String> visited = new HashSet<>();
            dfs(s, visited);

            Set<String> keys = adjList.keySet();
            for (String key: keys) {
                if (!visited.contains(key)) return false;
            }
            return true;
        }

        private void dfs(String v, Set<String> visited) {
            if (visited.contains(v)) return;
            visited.add(v);
            List<String> adj = adjList.get(v);
            if (adj == null) return;

            for (String s: adj) {
                dfs(s, visited);
            }
        }
    }

    public static void test(List<String> words) {
        ConnectStrings connectStrings = new ConnectStrings();
        for (String word: words)
            connectStrings.add(word);

        System.out.println(connectStrings.checkChainedInCircle());
    }

    public static void main(String[] args) {
        test(Arrays.asList("geek", "king"));
        test(Arrays.asList("for", "geek", "rig", "kaf"));
        test(Arrays.asList("aab", "bac", "aaa", "cda"));
        test(Arrays.asList("aaa", "bbb", "baa", "aab"));
        test(Collections.singletonList("aaa"));
        test(Arrays.asList("aaa", "bbb"));
        test(Arrays.asList("abc", "efg", "cde", "ghi", "ija"));
        test(Arrays.asList("ijk", "kji", "abc", "cba"));
    }
}
