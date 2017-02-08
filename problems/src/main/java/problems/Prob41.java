package problems;

import java.util.*;

/**
 * Created by fsantos on 12/12/16.
 */
public class Prob41 {
    public static class Node implements Comparable<Node> {
        private final String id;
        private int count;

        public Node(String id, int count) {
            this.id = id;
            this.count = count;
        }

        public Node(String id) {
            this.id = id;
            this.count = 1;
        }

        public String getId() {
            return id;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }

        @Override
        public int compareTo(Node o1) {
            return count - o1.getCount();
        }

        public String toString() {
            return "id: " + id + " count: " + count;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Node> freq = new HashMap<>();

        // Reading from the "streaming"
        for (String s: Arrays.asList("a", "a", "b", "b", "c", "c", "c", "b", "b", "a", "a", "b")) {
            Node t = freq.get(s);
            if (t != null) {
                t.increment();

                // Removing possible duplicates
                pq.remove(t);
                pq.add(t);
            } else {
                t = new Node(s);
                freq.put(s, t);
                pq.add(t);
            }

            if (pq.size() > 3)
                pq.remove();
        }


        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
